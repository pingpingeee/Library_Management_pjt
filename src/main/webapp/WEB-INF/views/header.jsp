<%@page import="com.lmpjt.pilotpjt.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>도서관리 시스템</title>
<link rel="stylesheet" type="text/css" href="/pilotpjt/resources/css/header.css">
</head>
<body>
	<%
	UserDTO user = (UserDTO) session.getAttribute("loginUser");
	String currentPage = request.getRequestURI();
	%>
	<header class="top-header">
		<div class="header-container">
			<div class="logo">
				<a href="/pilotpjt/main">
					<img src="/pilotpjt/resources/images/logo_2.png" alt="InkTree" onerror="this.src='/pilotpjt/resources/images/default-logo.png'; this.onerror=null;">
				</a>
				<div class="logo-text">잉크 트리</div>
			</div>

			<nav class="nav-links">

				
				<a href="admin_notice" class="nav-link <%= currentPage.contains("notice_view") ? "active" : "" %>">
					공지사항
				</a>
				
				<a href="/pilotpjt/board_view" class="nav-link <%= currentPage.contains("board_view") ? "active" : "" %>">
					게시판
				</a>
				
				<a href="/pilotpjt/library_info" class="nav-link <%= currentPage.contains("library_info") ? "active" : "" %>">
					이용안내
				</a>
				
				<% if (user != null) { %>
				<a href="/pilotpjt/my_books" class="nav-link <%= currentPage.contains("my_books") ? "active" : "" %>">
					내 대출현황
				</a>
				<% } %>
				

			</nav>
			<div class="user-menu">
			    <% if (user != null) { %>
			    <div class="user-dropdown">
			        <button class="dropdown-toggle">
			            <div class="user-avatar">
			                <%= user.getUserName().substring(0, 1) %>
			            </div>
			            <span class="user-name"><%= user.getUserName() %> 님</span>
			            <span class="toggle-icon">▼</span>
			        </button>
			        <div class="dropdown-menu">
			            <div class="dropdown-header">
			                <div class="user-avatar large">
			                    <%= user.getUserName().substring(0, 1) %>
			                </div>
			                <div class="header-info">
			                    <div class="header-name"><%= user.getUserName() %> 님</div>
			                    <div class="header-email"><%= user.getUserEmail() %></div>
			                </div>
			            </div>
			            
			            <div class="dropdown-divider"></div>
			            
			            <a href="/pilotpjt/my_page" class="dropdown-item">
			                <i class="dropdown-icon">👤</i>
			                <span>마이페이지</span>
			            </a>
			            <a href="/pilotpjt/edit_profile" class="dropdown-item">
			                <i class="dropdown-icon">✏️</i>
			                <span>내정보수정</span>
			            </a>
			            
			            <% if (user.getUserAdmin() == 1) { %>
			            <div class="dropdown-divider"></div>
			            <a href="admin_view" class="dropdown-item admin-item">
			                <i class="dropdown-icon">⚙️</i>
			                <span>관리자모드</span>
			                <span class="admin-badge">Admin</span>
			            </a>
			            <% } %>
			            
			            <div class="dropdown-divider"></div>
			            <a href="/pilotpjt/logout" class="dropdown-item">
			                <i class="dropdown-icon">🚪</i>
			                <span>로그아웃</span>
			            </a>
			        </div>
			    </div>
			    <% } else { %>
			    <div>
			        <a href="/pilotpjt/loginView" class="auth-link login-link">로그인</a>
			        <a href="/pilotpjt/joinView" class="auth-link register-link">회원가입</a>
			    </div>
			    <% } %>
			</div>
	</header>
	<script>
    // 드롭다운 토글 기능
    document.addEventListener('DOMContentLoaded', function() {
        const dropdownToggle = document.querySelector('.dropdown-toggle');
        const userDropdown = document.querySelector('.user-dropdown');
        
        if (dropdownToggle) {
            dropdownToggle.addEventListener('click', function(e) {
                e.preventDefault();
                userDropdown.classList.toggle('active');
            });
            
            // 드롭다운 외부 클릭 시 닫기
            document.addEventListener('click', function(e) {
                if (!userDropdown.contains(e.target)) {
                    userDropdown.classList.remove('active');
                }
            });
        }
    });
	</script>
</body>
</html>