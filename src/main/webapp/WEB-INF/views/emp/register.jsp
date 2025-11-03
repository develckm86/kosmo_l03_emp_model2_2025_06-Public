<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>사원 등록 양식</title>
</head>
<body>
    <%
        //Object errorMsg=request.getParameter("errorMsg");
        Object errorMsg=session.getAttribute("errorMsg"); //30분 동안 유지
        session.removeAttribute("errorMsg");

        if(errorMsg!=null){ //양식 데이터에 에러가 존재
    %>
    <script>alert("<%=errorMsg%>")</script>
    <%}%>
    <h1>사원 등록 양식</h1>
<%--    400 : 파라미터가없음 잘못됨, 404 : 리소스가없음, 405 : 리소스는 있는데 메소드가 구현안됨--%>
    <hr>
    <form method="post" action="./register.do">
        <p><label for="empno">사번 : </label><input id="empno" type="text" name="empno"></p>
        <p><label> 이름 : <input name="ename" type="text"></label></p>
        <p><label> 직책 : <input name="job" type="text"></label></p>
        <p><label> 상사 : <input name="mgr" type="text"></label></p>
        <p><label> 급여 : <input name="sal" type="text"></label></p>
        <p><label> 상여급 : <input name="comm" type="text"></label></p>
        <p><label> 부서번호 : <input name="deptno" type="text"></label></p>
        <p><label> 입사일 : <input name="hiredate" type="text"></label></p>
        <p>
            <button type="reset">초기화</button>
            <button type="submit">등록</button>
        </p>
    </form>
</body>
</html>
