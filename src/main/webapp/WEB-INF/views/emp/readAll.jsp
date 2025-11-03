<%@ page import="java.util.List" %>
<%@ page import="com.smu.l03_emp_model2.model.EmpDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>사원 관리 웹 앱 전체조회</title>
</head>
<body>
    <h1>사원 관리 웹 앱 전체조회</h1>
    <%
        Object empsObj=request.getAttribute("emps");
        List<EmpDto> emps=(List<EmpDto>) empsObj;
    %>
    <hr>
    <table>
        <thead>
        <tr>
            <th>사번</th>
            <th>이름</th>
            <th>지책</th>
            <th>입사일</th>
            <th>부서</th>
            <th>상세</th>
        </tr>
        </thead>
        <tbody>
            <%for(EmpDto emp : emps){   %>
                <tr>
                    <td><%=emp.getEmpno()%></td>
                    <td><%=emp.getEname()%></td>
                    <td><%=emp.getJob()%></td>
                    <td><%=emp.getHiredate()%></td>
                    <td><%=emp.getDeptno()%></td>
                    <td><a href="./detail.do?id=<%=emp.getEmpno()%>">상세</a></td>
                    <%-- /emp/detail.do?empno= --%>
                </tr>
            <%}%>
        </tbody>
    </table>

</body>
</html>
