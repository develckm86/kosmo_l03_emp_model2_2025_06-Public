<%@ page import="com.smu.l03_emp_model2.model.EmpDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>사원 상세 (model2)</title>
</head>
<body>
    <h1>사원 상세 (model2)</h1>
    <% EmpDto emp=(EmpDto) request.getAttribute("emp");%>
    <hr>
    <p>
        사번 : <strong><%=emp.getEmpno()%></strong>
    </p>
    <p>
        이름 : <strong><%=emp.getEname()%></strong>
    </p>
    <p>
        상사 : <strong><%=emp.getMgr()%></strong>
    </p>
    <p>
        부서 : <strong><%=emp.getDeptno()%></strong>
    </p>
    <p>
        급여 : <strong><%=emp.getSal()%></strong>
    </p>
    <p>
        상여급  : <strong><%=emp.getComm()%></strong>
    </p>
    <p>
        직채 : <strong><%=emp.getJob()%></strong>
    </p>
    <p>
        입사일 : <strong><%=emp.getHiredate()%></strong>
    </p>
</body>
</html>
