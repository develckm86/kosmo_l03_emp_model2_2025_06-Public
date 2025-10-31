package com.smu.l03_emp_model2.model;

import java.util.List;
//최종사용자 서블릿 controller
public interface EmpService {
    List<EmpDto> readAll() throws Exception; //select 전체
    EmpDto readById(int empno) throws Exception; //select By Id
    boolean register(EmpDto emp)throws Exception; //Insert, selecById,selectDeptById =>dao
    boolean modify(EmpDto emp)throws Exception;//Update, selecById,selectDeptById =>dao
    boolean remove(int empno)throws Exception; // Delete, updateMgrNullByMgr
}
