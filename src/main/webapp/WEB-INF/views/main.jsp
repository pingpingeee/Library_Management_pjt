<%@page import="com.lmpjt.pilotpjt.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>도서관리 시스템</title>
<link rel="stylesheet" type="text/css" href="/pilotpjt/resources/css/main.css">
</head>
<body>
	<jsp:include page="header.jsp" />
    <div class="container">
<!--         <header> -->
<!--             <h1>도서관리 시스템</h1> -->
<!--         </header> -->
        
        <%
        UserDTO user = (UserDTO) session.getAttribute("loginUser");
            
        if (user != null){
        %>
        
<!--         <div class="user-info"> -->
<%--             <h2><%=user.getUserName() %>님 환영합니다</h2> --%>
<%--             <p><strong>아이디:</strong> <%=user.getUserId() %></p> --%>
<%--             <p><strong>이름:</strong> <%=user.getUserName() %></p> --%>
<%--             <p><strong>전화번호:</strong> <%=user.getUserTel() %></p> --%>
<%--             <p><strong>이메일:</strong> <%=user.getUserEmail() %></p> --%>
<%--             <p><strong>주소:</strong> <%=user.getUserAddress() %></p> --%>
            
<!--             <a href="/pilotpjt/logout" class="btn">로그아웃</a> -->
<!--         </div> -->
        
        <div class="search-box">
            <h3>도서 검색</h3>
            <form action="/pilotpjt/book_search" method="GET">
                <input type="text" name="keyword" placeholder="도서명, 저자, 출판사 등으로 검색">
                <button type="submit">검색</button>
            </form>
        </div>
        
        <div class="feature-section">
            <div class="feature-card">
                <h3>내 대출 현황</h3>
                <p>현재 대출 중인 도서와 반납 예정일을 확인하세요.</p>
                <a href="/pilotpjt/my_books" class="btn">대출 현황 보기</a>
            </div>
            
            <div class="feature-card">
                <h3>도서 예약</h3>
                <p>원하는 도서를 미리 예약하여 이용하세요.</p>
                <a href="/pilotpjt/book_reservation" class="btn">예약하기</a>
            </div>
            
            <div class="feature-card">
                <h3>도서 추천</h3>
                <p>회원님의 관심사에 맞는 도서를 추천해 드립니다.</p>
                <a href="/pilotpjt/book_recommendation" class="btn">추천 받기</a>
            </div>
        </div>

<%--         <% if (user.getUserAdmin() == 1) { %> --%>
<!--         <div class="admin-section"> -->
<!--             <h3>관리자 기능</h3> -->
<!--             <div class="admin-features"> -->
<!--                 <a href="/pilotpjt/book_insert_view">도서 등록</a> -->
<!--                 <a href="/pilotpjt/book_manage">도서 관리</a> -->
<!--                 <a href="/pilotpjt/user_manage">회원 관리</a> -->
<!--                 <a href="/pilotpjt/borrow_manage">대출/반납 관리</a> -->
<!--                 <a href="/pilotpjt/reservation_manage">예약 관리</a> -->
<!--                 <a href="/pilotpjt/statistics">이용 통계</a> -->
<!--             </div> -->
<!--         </div> -->
<%--         <% } %> --%>

        <%
        } else {
        %>
        <div class="login-section">
            <h2>도서관리 시스템에 오신 것을 환영합니다</h2>
            <p>서비스를 이용하시려면 로그인이 필요합니다.</p>
            <a href="/pilotpjt/loginView" class="btn">로그인 하러 가기</a>
            <p style="margin-top: 20px;">계정이 없으신가요? <a href="joinView">회원가입</a></p>
        </div>
        <% } %>
    </div>
</body>
</html>