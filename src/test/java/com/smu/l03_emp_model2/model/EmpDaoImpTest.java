package com.smu.l03_emp_model2.model;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class EmpDaoImpTest {

    @Test
    void findAllOrderEmpno() throws Exception{
        EmpDao empDao=new EmpDaoImp(DBFactory.getConn());
        System.out.println(empDao.findAllOrderEmpno());
    }

    @Test
    void findById() throws Exception {
        EmpDao empDao=new EmpDaoImp(DBFactory.getConn());
        System.out.println(empDao.findById(7788));
    }

    @Test
    void insert() throws Exception {
        EmpDto emp=new EmpDto();
        emp.setEmpno(555);
        emp.setEname("테스트");//10
        emp.setJob("tester");
        emp.setDeptno(10);
        emp.setMgr(7900);
        emp.setSal(555.55);
        emp.setComm(55.55);
        emp.setHiredate(java.sql.Date.valueOf("2025-05-05"));
        EmpDao empDao=new EmpDaoImp(DBFactory.getConn());
        int insert=empDao.insert(emp);
        System.out.println(insert);
        EmpDto insertEmp=empDao.findById(emp.getEmpno());
        System.out.println(insertEmp);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void updateMgrSetNullByMgr() {
    }
}