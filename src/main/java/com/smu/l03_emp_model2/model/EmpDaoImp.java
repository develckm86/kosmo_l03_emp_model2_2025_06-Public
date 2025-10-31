package com.smu.l03_emp_model2.model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImp implements EmpDao{

    private final Connection conn;
    //필드에  final :1. 절대바뀔일이없어서, 2. 생성자 정의를 강제하기 위해!
    public EmpDaoImp(Connection conn){
        this.conn = conn;
    }
    private EmpDto mapRow(ResultSet rs) throws Exception{
        EmpDto emp = new EmpDto();
        int empno=rs.getInt("EMPNO");
        String ename=rs.getString("ENAME");
        String job=rs.getString("JOB");
        java.sql.Date hiredate=rs.getDate("HIREDATE");
        //기본형인데 null허용 데이터
        //Integer mgr=(Integer) rs.getObject("MGR"); //오류???
        BigDecimal mgrDec=rs.getBigDecimal("MGR");
        BigDecimal commDec=rs.getBigDecimal("COMM");
        BigDecimal salDec=rs.getBigDecimal("SAL");
        BigDecimal deptnoDec=rs.getBigDecimal("DEPTNO");
        emp.setEmpno(empno);
        emp.setEname(ename);
        emp.setJob(job);
        emp.setHiredate(hiredate);
//                    emp.setMgr(mgrDec!=null?mgrDec.intValue():null);
        if(mgrDec!=null) emp.setMgr(mgrDec.intValue());
        if(commDec!=null) emp.setComm(commDec.doubleValue());
        if(salDec!=null) emp.setSal(salDec.doubleValue());
        if(deptnoDec!=null) emp.setDeptno(deptnoDec.intValue());
        return emp;
    }


    //Statement,PrepareStatement 는 함수단위 닫는다.
    @Override
    public List<EmpDto> findAllOrderEmpno() throws Exception {
        List<EmpDto> emps=null;
        String sql="SELECT * FROM EMP ORDER BY EMPNO ASC";
        try(PreparedStatement ps=conn.prepareStatement(sql)){
            try (ResultSet rs=ps.executeQuery()){
                emps=new ArrayList<>();
                while (rs.next()){
                    EmpDto emp=mapRow(rs);
                    emps.add(emp);
                }
            }
        }
        return emps;
    }
    @Override
    public EmpDto findById(int empno) throws Exception {
        EmpDto emp=null;
        String sql="SELECT * FROM EMP WHERE EMPNO=?";
        try (PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setInt(1,empno);
            try (ResultSet rs=ps.executeQuery()){
                if(rs.next()){
                    emp=mapRow(rs);
                }
            }
        }
        return emp;
    }

    @Override
    public int insert(EmpDto emp) throws Exception {
        int insert=0;
        String sql="INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps=conn.prepareStatement(sql)){
            //수데이터(기본형) not null,pk
            ps.setInt(1,emp.getEmpno());
            ps.setString(2,emp.getEname());
            ps.setString(3,emp.getJob());
            //수데이터 null 허용 =>setObject
            ps.setObject(4,emp.getMgr());
            ps.setDate(5,emp.getHiredate());
            ps.setObject(6,emp.getSal());
            ps.setObject(7,emp.getComm());
            ps.setObject(8,emp.getDeptno());
            insert=ps.executeUpdate();
        }
        return insert;
    }

    @Override
    public int update(EmpDto emp) throws Exception {
        return 0;
    }

    @Override
    public int delete(int empno) throws Exception {
        return 0;
    }

    @Override
    public int updateMgrSetNullByMgr(int empno) throws Exception {
        return 0;
    }
}
