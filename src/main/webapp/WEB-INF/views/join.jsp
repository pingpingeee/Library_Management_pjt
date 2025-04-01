<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="/pilotpjt/resources/css/join.css">
</head>
<body>
	<div class="container">
		<h2>회원가입</h2>
		<form method="post" action="/pilotpjt/join">
			<label>아이디</label>
			<input type="text" name="id" required>
			
			<label>비밀번호</label>
			<input type="password" name="pwd" required>
			
			<label>비밀번호 확인</label>
			<input type="password" name="pwdConfirm" required>
			
			<label>이름</label>
			<input type="text" name="name" required>
			
			<label>이메일</label>
			<input type="email" name="email" required>
			
			<label>전화번호</label>
			<input type="tel" name="phone" required>
			
			<label>생년월일</label>
			<input type="date" name="birthdate" required>
			
			<label>주소</label>
			<input type="text" name="address" required>

			<input type="submit" value="회원가입">
			<input type="button" value="뒤로가기" onclick="location='login.jsp'">
		</form>
	</div>
</body>
</html>
