package com.smu.l03_emp_model2.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmpServiceImp implements EmpService{
    private final Connection conn;
    private final EmpDao empDao;
    public EmpServiceImp(Connection conn){
        this.conn = conn;
        this.empDao=new EmpDaoImp(conn);
    }

    @Override
    public List<EmpDto> readAll() throws Exception {
        return empDao.findAllOrderEmpno();
    }

    @Override
    public EmpDto readById(int empno) throws Exception {
        return empDao.findById(empno);
    }

    @Override
    public boolean register(EmpDto emp) throws Exception {
        //EmpValidBean 유효성 검사(서블릿,컨트롤로서 생성)
        //if(emp.getEmpno()<=0) throw new IllegalArgumentException("사번은 0보다 커야합니다/");
        //empno=7788; 이미저장되었는지확인
        //mgr=4444;  해당 사번의 사원이 있는지
        //deptno=11; 해당 부서 번호가 있는지(구현x DeptDao.findId)
        //없으며 오류
        EmpDto existEmp=empDao.findById(emp.getEmpno());
        if(existEmp!=null) throw new IllegalArgumentException("이미 등록된 사번입니다."); //1
        if(emp.getMgr()!=null){
            EmpDto existMgr=empDao.findById(emp.getMgr());
            if(existMgr==null)throw new IllegalArgumentException("존재하지 않는 상사 사번입니다.");
        }
        int excute=empDao.insert(emp);
        return excute==1;
    }

    @Override
    public boolean modify(EmpDto emp) throws Exception {
        //empno=7788; 해당 사원이 있는지
        //mgr=4444;  해당 사번의 사원이 있는지
        //deptno=11; 해당 부서 번호가 있는지(구현x DeptDao.findId)
        EmpDto existEmp=empDao.findById(emp.getEmpno());
        if(existEmp==null)throw new IllegalArgumentException("존재하지 않는 사원입니다.");
        if(emp.getMgr()!=null){//상사번호를 바꾸려한다.
            EmpDto existMgr=empDao.findById(emp.getMgr());
            if(existMgr==null) throw  new IllegalArgumentException("존재하지 않는 상사입니다.");
        }
        int excute=empDao.update(emp);
        return excute==1;
    }

    @Override
    public boolean remove(int empno) throws Exception {
        //삭제하려는 row가 누가 참조중이다. => 참조의 무결성
        //1.참조 중인 레코드 삭제
        //2.참조 중인 레코드의 참조값을 null
        try {
            conn.setAutoCommit(false);
            conn.commit();
            int excuteSetNull=empDao.updateMgrSetNullByMgr(empno);
            System.out.println("상사를 null한 사원 수 :"+excuteSetNull);
            int excute=empDao.delete(empno);
            return excute==1;
        }catch (SQLException e){
            conn.rollback();
            throw e;
        }finally {
            conn.commit();
            conn.setAutoCommit(true);
        }
    }
}
