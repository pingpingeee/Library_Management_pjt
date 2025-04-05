<%@page import="com.lmpjt.pilotpjt.DTO.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	User user = (User) session.getAttribute("loginUser");
	
	if (user != null){	
	%>
	메인화면
	<p>아이디 :  <%=user.getUserId() %></p>
	<p>이름 :  <%=user.getUserName() %></p>
	<p>전화번호 :  <%=user.getUserTel() %></p>
	<p>이메일 :  <%=user.getUserEmail() %></p>
	<p>주소 :  <%=user.getUserAddress() %></p>
	<a href="/pilotpjt/logout">로그아웃</a>
	<%
	} else {
	%>
	<p>로그인 정보 없음</p>
	<% }%>
</body>
</html>