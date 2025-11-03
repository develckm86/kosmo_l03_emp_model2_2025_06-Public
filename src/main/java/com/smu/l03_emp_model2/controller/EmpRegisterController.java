package com.smu.l03_emp_model2.controller;

import com.smu.l03_emp_model2.model.EmpValidBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/emp/register.do")
public class EmpRegisterController extends HttpServlet {
    //get : 등록폼 (view)
    //post : 등록 액션 (처리)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/emp/register.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empnoStr=req.getParameter("empno");
        String ename=req.getParameter("ename");
        String job=req.getParameter("job");
        String mgrStr=req.getParameter("mgr");
        String hiredateStr=req.getParameter("hiredate");
        String salStr=req.getParameter("sal");
        String commStr=req.getParameter("comm");
        String deptnoStr=req.getParameter("deptno");
        try {
            //dto(저장전용) bean(저장+유효성) : 객체에 필드를 저장
            EmpValidBean empValidBean=new EmpValidBean();
            empValidBean.setEmpno(empnoStr);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            //resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            //등록 양식으로 다시 이동후 오류 내역으로 안내
            //1.?errorMsg= : 파라미터에 오류가 보임
            //2. session.set("error",) => 뷰에서 지움
            String errorMsg=e.getMessage(); //사번은 꼭 0보다 커야합니다.
            //파라미터가 한글인 경유 URL 인코딩 변경
            HttpSession session=req.getSession();
            session.setAttribute("errorMsg",errorMsg);
            resp.sendRedirect("./register.do");

            //1.파라미터로 전달
            //errorMsg=URLEncoder.encode(errorMsg,"UTF-8");
            //resp.sendRedirect("./register.do?errorMsg="+errorMsg);
        }

    }
}
