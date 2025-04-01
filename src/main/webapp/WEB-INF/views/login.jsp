<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%-- 로그인 실패 시 메시지 표시 --%>
    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>
    
<form method="post" action="/pilotpjt/login">
    <label>아이디: </label><input type="text" name="id"><br>
    <label>비밀번호: </label><input type="password" name="pwd"><br>
    <input type="submit" value="로그인">
</form>
</body>
</html>