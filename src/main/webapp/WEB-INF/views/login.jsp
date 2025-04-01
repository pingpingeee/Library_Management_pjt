<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="/pilotpjt/resources/css/login.css">
</head>
<body>
	<div class="container">
		<h2>로그인</h2>

		<%-- 로그인 실패 시 메시지 표시 --%>
		<c:if test="${not empty error}">
			<p class="error-message">${error}</p>
		</c:if>

		<form method="post" action="/pilotpjt/login">
			<label>아이디: <input type="text" name="id"></label><br>
			<label>비밀번호: <input type="password" name="pwd"></label><br>

			<input type="submit" value="로그인">
			<input type="button" value="회원가입" onclick="location='/pilotpjt/join'">
		</form>
	</div>
</body>
</html>
