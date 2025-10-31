package com.smu.l03_emp_model2.model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class EmpDaoImpTest {

    private static EmpDao empDao=null; //테스트함수에 해당 필드를 사용불가 static으로 고유자원등록
    @BeforeAll
    static void init() throws Exception{
        empDao=new EmpDaoImp(DBFactory.getConn());
    }

    @Test
    void findAllOrderEmpno() throws Exception{
        System.out.println(empDao.findAllOrderEmpno());
    }

    @Test
    void findById() throws Exception {
        System.out.println(empDao.findById(7788));
    }

    @Test
    void insert() throws Exception {
        EmpDto emp=new EmpDto();
        emp.setEmpno(355);
        emp.setEname("테스트");//10
        emp.setJob("tester");
        emp.setDeptno(10);
        emp.setMgr(7900);
        emp.setSal(555.55);
        emp.setComm(55.55);
        emp.setHiredate(java.sql.Date.valueOf("2025-05-05"));
        int insert=empDao.insert(emp);
//        System.out.println(insert);
        Assertions.assertEquals(1,insert);
        //오류가 뜨지 않고 결과 1일때만 테스트 성공!
        EmpDto insertEmp=empDao.findById(emp.getEmpno());
        System.out.println(insertEmp);
    }

    @Test
    void update() throws Exception {
        EmpDto emp=new EmpDto();
        emp.setEmpno(355);
        emp.setEname("수정");//10
        emp.setJob("Utester"); //10
        emp.setDeptno(20);
        emp.setMgr(null);
        emp.setSal(333.55);
        emp.setComm(33.55);
        emp.setHiredate(java.sql.Date.valueOf("2025-03-03"));
        int excute=empDao.update(emp);
        Assertions.assertEquals(1,excute);  //0 : 내가 수정하려는 레코를 삭제했을때
        System.out.println(empDao.findById(emp.getEmpno()));
    }
    @Test// 함수는 순서가 없음!
    void delete() throws Exception {
        int excute=empDao.delete(355);
        Assertions.assertEquals(1,excute);
    }

    @Test
    void updateMgrSetNullByMgr() throws Exception {
        System.out.println(empDao.findById(355)); //상사 null 전
        int empno=7900; //이 상사를 지울건데 이사번을 참조(mgr)하는 사원의 상사번호를 null;
        int excute=empDao.updateMgrSetNullByMgr(empno);
        Assertions.assertTrue(excute>0); //상사는 복수가 참조할 수 있어서
        System.out.println(empDao.findById(355));//상사 null 후

    }
}