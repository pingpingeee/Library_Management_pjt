<%@page import="com.lmpjt.pilotpjt.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${notice.title} - 공지사항</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" type="text/css" href="/pilotpjt/resources/css/admin_notice_detail.css">
<script src="/pilotpjt/resources/js/admin_notice_datail.js"></script>
</head>
<body>
	<jsp:include page="header.jsp" />
	
	<div class="container">
	    <div class="notice-header">
	        <c:choose>
	            <c:when test="${notice.category == 'important'}">
	                <span class="notice-category category-important">중요 공지</span>
	            </c:when>
	            <c:when test="${notice.category == 'event'}">
	                <span class="notice-category category-event">이벤트</span>
	            </c:when>
	            <c:when test="${notice.category == 'info'}">
	                <span class="notice-category category-info">안내</span>
	            </c:when>
	            <c:when test="${notice.category == 'update'}">
	                <span class="notice-category category-update">업데이트</span>
	            </c:when>
	        </c:choose>
	        
	        <h1 class="notice-title">${notice.title}</h1>
	        
	        <div class="notice-meta">
	            <div class="meta-left">
	                <div class="meta-item">
	                    <i class="fas fa-user meta-icon"></i>
	                    <span>${notice.writer}</span>
	                </div>
	                <div class="meta-item">
	                    <i class="fas fa-calendar meta-icon"></i>
	                    <span><fmt:formatDate value="${notice.regDate}" pattern="yyyy-MM-dd HH:mm"/></span>
	                </div>
	            </div>
	            <div class="meta-item">
	                <i class="fas fa-eye meta-icon"></i>
	                <span>조회수 ${notice.viewCount}</span>
	            </div>
	        </div>
	    </div>
	    
	    <div class="notice-content">
	        <div class="content-text">
	            ${notice.content}
	        </div>
	    </div>
	    
	    <c:if test="${not empty notice.attachments}">
	        <div class="notice-attachments">
	            <h3 class="attachments-title">
	                <i class="fas fa-paperclip"></i> 첨부파일
	            </h3>
	            <ul class="attachment-list">
	                <c:forEach items="${notice.attachments}" var="attachment">
	                    <li class="attachment-item">
	                        <a href="/pilotpjt/download?fileId=${attachment.id}" class="attachment-link">
	                            <i class="fas fa-file attachment-icon"></i>
	                            <span>${attachment.originalName}</span>
	                            <span>(${attachment.fileSize}KB)</span>
	                        </a>
	                    </li>
	                </c:forEach>
	            </ul>
	        </div>
	    </c:if>
	    
	    <div class="notice-actions">
	        <a href="/pilotpjt/notice_view" class="action-btn list-btn">
	            <i class="fas fa-list"></i> 목록으로
	        </a>
	        
	        <% 
	        UserDTO user = (UserDTO) session.getAttribute("loginUser");
	        if (user != null && user.getUserAdmin() == 1) { 
	        %>
	        <div class="admin-actions">
	            <a href="/pilotpjt/notice_edit?id=${notice.id}" class="action-btn edit-btn">
	                <i class="fas fa-edit"></i> 수정하기
	            </a>
	            <a href="#" onclick="confirmDelete(${notice.id}); return false;" class="action-btn delete-btn">
	                <i class="fas fa-trash"></i> 삭제하기
	            </a>
	        </div>
	        <% } %>
	    </div>
	    
	    <div class="notice-navigation">
	        <c:if test="${not empty prevNotice}">
	            <div class="nav-item">
	                <span class="nav-label"><i class="fas fa-chevron-up"></i> 이전글</span>
	                <a href="/pilotpjt/notice_detail?id=${prevNotice.id}" class="nav-link">${prevNotice.title}</a>
	                <span class="nav-date"><fmt:formatDate value="${prevNotice.regDate}" pattern="yyyy-MM-dd"/></span>
	            </div>
	        </c:if>
	        <c:if test="${not empty nextNotice}">
	            <div class="nav-item">
	                <span class="nav-label"><i class="fas fa-chevron-down"></i> 다음글</span>
	                <a href="/pilotpjt/notice_detail?id=${nextNotice.id}" class="nav-link">${nextNotice.title}</a>
	                <span class="nav-date"><fmt:formatDate value="${nextNotice.regDate}" pattern="yyyy-MM-dd"/></span>
	            </div>
	        </c:if>
	    </div>
	</div>
	
	<script>
	    function confirmDelete(noticeId) {
	        if (confirm('정말로 이 공지사항을 삭제하시겠습니까?')) {
	            location.href = '/pilotpjt/notice_delete?id=' + noticeId;
	        }
	    }
	</script>
</body>
</html>

