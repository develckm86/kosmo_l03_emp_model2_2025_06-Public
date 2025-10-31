package com.smu.l03_emp_model2.model;

import java.sql.Date;

public class EmpDto {
//EMPNO
//ENAME
//JOB
//MGR
//HIREDATE
//SAL
    private int empno; //Pk
    private String ename; //not Null
    private String job;
    private Integer mgr; //fk Emp.empno
    private Double sal;
    private Double comm;
    private Integer deptno;//fk Dept.deptno
    private java.sql.Date hiredate;
    //생성자 필드초기화, setter, builder


    @Override
    public String toString() {
        return "{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", sal=" + sal +
                ", comm=" + comm +
                ", deptno=" + deptno +
                ", hiredate=" + hiredate +
                "}\n";
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Double getComm() {
        return comm;
    }

    public void setComm(Double comm) {
        this.comm = comm;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }
}
