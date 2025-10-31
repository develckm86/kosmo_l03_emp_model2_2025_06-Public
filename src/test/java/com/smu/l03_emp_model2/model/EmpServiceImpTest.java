package com.smu.l03_emp_model2.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmpServiceImpTest {
    private static EmpService empService;
    @BeforeAll
    static void init() throws Exception{
        empService=new EmpServiceImp(DBFactory.getConn());
    }
    @Test
    void register()throws Exception {
        EmpDto emp=new EmpDto();
        emp.setEmpno(55);
        emp.setEname("serviceT");
        emp.setSal(100.11);
        emp.setComm(10.11);
        emp.setMgr(7788);
        emp.setJob("testerS");
        emp.setDeptno(30);
        emp.setHiredate(java.sql.Date.valueOf("2025-08-08"));
        boolean excute=empService.register(emp);
        Assertions.assertTrue(excute);
    }
    @Test
    void modify() throws Exception{
        //오류 테스트!
        EmpDto emp=new EmpDto();
        emp.setEmpno(55);
        emp.setEname("service2");
        emp.setSal(200.11);
        emp.setComm(20.11);
        emp.setMgr(7900);
        emp.setJob("tester2");
        emp.setDeptno(20);
        emp.setHiredate(java.sql.Date.valueOf("2025-07-07"));
        boolean result=empService.modify(emp);
        assertTrue(result);
        System.out.println(empService.readById(emp.getEmpno()));
    }

    @Test
    void remove() throws Exception{
        boolean result=empService.remove(455);
        assertTrue(result);
    }
}