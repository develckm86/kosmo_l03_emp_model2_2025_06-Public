package com.smu.l03_emp_model2.model;

import java.util.List;

public interface EmpDao{//DB에 접속해서 쿼리를 실행
    //select find
    List<EmpDto> findAllOrderEmpno() throws Exception;
    EmpDto findById(int empno) throws Exception; //id==pk(대표키)
    int insert(EmpDto emp) throws Exception;// EmpDto emp form 데이터
    int update(EmpDto emp) throws Exception;
    int delete(int empno) throws Exception;
    int updateMgrSetNullByMgr(int empno) throws Exception;
    //해당 사번을 상사로 하는 사원의 상사번호를 null로 만들겠다. (상사를 삭제하기 전에)
}
