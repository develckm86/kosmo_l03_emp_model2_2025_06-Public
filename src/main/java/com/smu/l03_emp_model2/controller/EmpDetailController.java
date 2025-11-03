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

@WebServlet("/emp/detail.do")
public class EmpDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id=Integer.parseInt(req.getParameter("id"));//요청처리

            try(Connection conn= DBFactory.getConn()){
                EmpService empService=new EmpServiceImp(conn);
                EmpDto emp=empService.readById(id);
                //System.out.println(emp);
                req.setAttribute("emp",emp);
                req.getRequestDispatcher("/WEB-INF/views/emp/detail.jsp")
                        .forward(req,resp);

            }catch (ClassNotFoundException | SQLException  e){
                e.printStackTrace();
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);//500
            }catch (Exception e){
                e.printStackTrace();
                resp.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED);
            }
        }catch (NumberFormatException  e){//요청오류 처리
            //req.getParameter("id")  null "" "십" -> 파싱불가 ->오류
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
