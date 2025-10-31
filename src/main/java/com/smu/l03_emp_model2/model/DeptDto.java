package com.smu.l03_emp_model2.model;

public class DeptDto {
    //DEPTNO
    //DNAME
    //LOC
    private int deptno;
    private String dname;
    private String loc;

    @Override
    public String toString() {
        return "{" +
                "deptno:" + deptno +
                ", dname:'" + dname + '\'' +
                ", loc:'" + loc + '\'' +
                "}\n";
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
