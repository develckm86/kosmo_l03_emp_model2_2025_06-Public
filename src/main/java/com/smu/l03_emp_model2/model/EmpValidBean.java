package com.smu.l03_emp_model2.model;

import java.sql.Date;

public class EmpValidBean {
    private int empno; //Pk
    private String ename; //not Null
    private String job;
    private Integer mgr; //fk Emp.empno
    private Double sal;
    private Double comm;
    private Integer deptno;//fk Dept.deptno
    private Date hiredate;
    //유효성 검사 추가는 setter에서만 진행!
    public int getEmpno() {
        return empno;
    }
    public void setEmpno(String empnoStr) throws IllegalArgumentException {
        int empno=-1;
        try {
            empno = Integer.parseInt(empnoStr);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("사번의 형식은 0보다 큰 수입니다.");
        }
        if (empno<0) throw new IllegalArgumentException("사번은 꼭 0보다 커야합니다.");
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        if (ename==null ||ename.isEmpty()) throw new IllegalArgumentException("이름은 꼭 입력해야합니다.");
        this.ename = ename;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        //null 일수도 있는 필드인데 null이면 공백  ""
        //"",  "  111" , "    "
        if(job!=null && job.isEmpty()) job=null;
        this.job = job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(String mgrStr) throws IllegalArgumentException {
        Integer mgr = null;
        if ( mgrStr!=null && !mgrStr.isEmpty()){ //null이 아니고  ""이 아님 =>  "2221"
            try{
                mgr=Integer.parseInt(mgrStr);
            }catch (NumberFormatException e){
                e.printStackTrace();
                throw new IllegalArgumentException("상사번호의 형식은 수입니다.");
            }
        }
        this.mgr = mgr;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(String salStr)throws IllegalArgumentException {
        Double sal = null;
        if(salStr!=null && !salStr.isEmpty()){
            //"13","십삼" ,"13.0 ", " 13", " 13 "
            salStr=salStr.trim();
            try {
                sal=Double.parseDouble(salStr);
            }catch (NumberFormatException e){
                throw new IllegalArgumentException("급여는 실수로 입력해야합니다.");
            }
        }
        this.sal = sal;
    }

    public Double getComm() {
        return comm;
    }

    public void setComm(String commStr) throws IllegalArgumentException {
        Double comm=null; //기본값==else
        if(commStr!=null && !commStr.isEmpty()){
            try {
                comm=Double.parseDouble(commStr);
            }catch (NumberFormatException e){
                e.printStackTrace();
                throw new IllegalArgumentException("커미션은 실수입니다.");
            }
        }

        this.comm = comm;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptnoStr)throws IllegalArgumentException {
        Integer deptno=null;
        if(deptnoStr!=null && !deptnoStr.isEmpty()){
            try {
                deptno=Integer.parseInt(deptnoStr);
            }catch (NumberFormatException e){
                e.printStackTrace();
                throw new IllegalArgumentException("부서번호는 수입니다.");
            }
        }
        this.deptno = deptno;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredateStr) throws IllegalArgumentException {
        java.sql.Date hiredate = null;
        if(hiredateStr!=null && !hiredateStr.isEmpty()){
            try {
                hiredate=java.sql.Date.valueOf(hiredateStr);
            }catch (IllegalArgumentException e){
                e.printStackTrace();
                throw new IllegalArgumentException("입사일 형식이 잘못되었습니다.(2025-01-01[yyyy-MM-dd])");
            }
        }
        this.hiredate = hiredate;
    }
}
