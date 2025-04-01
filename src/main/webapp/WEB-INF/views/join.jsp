<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>join.jsp</h1>
	<form method="post" action="/pilotpjt/login">
		<label>아이디 : <input type="text" name="id"></label><br>
		<label>비밀번호 : <input type="text" name="id"></label><br>
		<label>비밀번호확인 : <input type="text" name="id"></label><br>
		<label>이름 : <input type="text" name="id"></label><br>
		<label>이메일 : <input type="text" name="id"></label><br>
		<label>전화번호 : <input type="text" name="id"></label><br>
		<label>생일 : <input type="text" name="id"></label><br>
		<label>주소 : <input type="text" name="id"></label><br>
		<input type="submit" value="회원가입">
		<input type="button" value="뒤로가기" onclick="location='login.jsp'">
	</form>
</body>
</html>
