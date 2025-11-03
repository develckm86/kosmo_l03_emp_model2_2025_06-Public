package com.smu.l03_emp_model2.controller;

import com.smu.l03_emp_model2.model.DBFactory;
import com.smu.l03_emp_model2.model.EmpDto;
import com.smu.l03_emp_model2.model.EmpService;
import com.smu.l03_emp_model2.model.EmpServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

// page=2
// search=경민&field=ename
@WebServlet("/emp/read.do")
public class EmpReadController extends HttpServlet {
//a 클릭 => GET
//form[method=post] submit => POST
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //controller : model과 view 를 중간에서 연결, 요청처리!
        try(Connection conn=DBFactory.getConn()){
            //Model : 실제로 데이터를 조회
            EmpService empService=new EmpServiceImp(conn);
            List<EmpDto> emps=empService.readAll();
            //System.out.println(emps);

            //View : 출력될 내역
            req.setAttribute("emps",emps);
            //forward: html 렌더링을 jsp에게 위임 (jsp가 요청 응답을 마무리할거야)
            // /WEB-INF/views/emp/readAll.jsp
            req.getRequestDispatcher("/WEB-INF/views/emp/readAll.jsp")
                    .forward(req,resp);

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
