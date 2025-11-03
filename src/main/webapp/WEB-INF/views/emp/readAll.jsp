<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>사원 관리 웹 앱 전체조회</title>
</head>
<body>
    <h1>사원 관리 웹 앱 전체조회</h1>
    <%
        Object empsObj=request.getAttribute("emps");
    %>
    <hr>
    <%=empsObj%>
</body>
</html>
