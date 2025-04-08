<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>내 대출 도서 - 잉크 트리</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700&display=swap"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<link rel="stylesheet" type="text/css"
	href="/pilotpjt/resources/css/user_book_borrowing.css">
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="container">
		<div class="borrowed-header">
			<div class="header-content">
				<h1 class="borrowed-title">
					<span class="title-icon"><i class="fas fa-book-reader"></i></span>
					<span class="title-text">내 대출 도서</span>
				</h1>
				<p class="borrowed-subtitle">현재 대출 중인 도서 목록과 반납 예정일을 확인하세요. 도서
					대출 기간은 최대 14일입니다.</p>
			</div>

			<div class="borrowed-stats">
				<div class="stat-card">
					<div class="stat-icon">
						<i class="fas fa-book"></i>
					</div>
					<div class="stat-info">
						<div class="stat-value">${borrowedCount}권</div>
						<div class="stat-title">현재 대출 중</div>
					</div>
				</div>

				<div class="stat-card">
					<div class="stat-icon warning">
						<i class="fas fa-exclamation-circle"></i>
					</div>
					<div class="stat-info">
						<div class="stat-value">${overdueCount}권</div>
						<div class="stat-title">연체 중</div>
					</div>
				</div>

				<div class="stat-card">
					<div class="stat-icon success">
						<i class="fas fa-check-circle"></i>
					</div>
					<div class="stat-info">
						<div class="stat-value">${userCanBorrow}권</div>
						<div class="stat-title">대출 가능</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 필터 탭 -->
		<div class="filter-tabs">
			<a href="?status=all"
				class="filter-tab ${param.status == 'all' || empty param.status ? 'active' : ''}">
				<i class="fas fa-list-ul"></i>&nbsp; 전체 <span
				class="filter-tab-count">${totalCount}</span>
			</a> <a href="?status=borrowed"
				class="filter-tab ${param.status == 'borrowed' ? 'active' : ''}">
				<i class="fas fa-book-open"></i>&nbsp; 대출중 <span
				class="filter-tab-count">${borrowedCount}</span>
			</a> <a href="?status=returned"
				class="filter-tab ${param.status == 'returned' ? 'active' : ''}">
				<i class="fas fa-check-circle"></i>&nbsp; 반납완료 <span
				class="filter-tab-count">${returnedCount}</span>
			</a>
		</div>

		<div class="borrowed-list">
			<c:choose>
				<c:when test="${empty books}">
					<div class="empty-state">
						<div class="empty-icon">
							<i class="fas fa-book-open"></i>
						</div>
						<h2 class="empty-title">
							<c:choose>
								<c:when test="${param.status == 'borrowed'}">
									대출 중인 도서가 없습니다
								</c:when>
								<c:when test="${param.status == 'returned'}">
									반납 완료된 도서가 없습니다
								</c:when>
								<c:otherwise>
									대출 이력이 없습니다
								</c:otherwise>
							</c:choose>
						</h2>
						<p class="empty-description">
							<c:choose>
								<c:when test="${param.status == 'borrowed'}">
									현재 대출 중인 도서가 없습니다. 도서관에서 관심 있는 도서를 찾아보세요.
								</c:when>
								<c:when test="${param.status == 'returned'}">
									반납 완료된 도서가 없습니다. 도서를 대출하고 반납하면 여기에 표시됩니다.
								</c:when>
								<c:otherwise>
									아직 대출 이력이 없습니다. 도서관에서 관심 있는 도서를 찾아보세요.
								</c:otherwise>
							</c:choose>
						</p>
						<a href="/pilotpjt/book_search_view" class="browse-button"> <i
							class="fas fa-search"></i> 도서 검색하기
						</a>
					</div>
				</c:when>
				<c:otherwise>
					<div class="borrowed-grid">
						<c:forEach items="${books}" var="book">
							<div class="borrowed-card ${book.isReturned ? 'returned' : ''}">
								<div class="borrowed-card-header">
									<span>대출일: <fmt:formatDate value="${book.borrowDate}"
											pattern="yyyy.MM.dd" /></span>

									<c:choose>
										<c:when test="${book.isReturned}">
											<span class="returned-date"> <i
												class="fas fa-check-circle"></i> <fmt:formatDate
													value="${book.returnDate}" pattern="yyyy.MM.dd" /> 반납
											</span>
										</c:when>
										<c:when test="${book.isOverdue}">
											<span class="due-date overdue"> <i
												class="fas fa-exclamation-circle"></i> <fmt:formatDate
													value="${book.dueDate}" pattern="yyyy.MM.dd" /> (연체)
											</span>
										</c:when>
										<c:when test="${book.isDueSoon}">
											<span class="due-date warning"> <i
												class="fas fa-exclamation-triangle"></i> <fmt:formatDate
													value="${book.dueDate}" pattern="yyyy.MM.dd" /> (곧 만료)
											</span>
										</c:when>
										<c:otherwise>
											<span class="due-date"> <i class="fas fa-calendar-alt"></i>
												<fmt:formatDate value="${book.dueDate}" pattern="yyyy.MM.dd" />
											</span>
										</c:otherwise>
									</c:choose>
								</div>

								<div class="borrowed-card-content">
									<div class="book-cover">
										<!-- 실제 구현 시 도서 이미지 경로를 사용해야함 -->
										<div class="book-cover-placeholder"
											id="placeholder-${book.bookDTO.bookNumber}">
											<i class="fas fa-book"></i>
										</div>
									</div>

									<div class="book-info">
										<h3 class="book-title">${book.bookDTO.bookTitle}</h3>
										<div class="book-author">${book.bookDTO.bookWrite}</div>

										<div class="book-details">
											<span class="detail-label">도서 번호:</span> <span
												class="detail-value">${book.bookDTO.bookNumber}</span> <span
												class="detail-label">ISBN:</span> <span class="detail-value">${book.bookDTO.bookIsbn}</span>
											<span class="detail-label">출판사:</span> <span
												class="detail-value">${book.bookDTO.bookPub}</span>

											<c:if test="${book.isReturned}">
												<span class="detail-label">상태:</span>
												<span class="detail-value"> <span
													class="status-badge returned"> <i
														class="fas fa-check-circle"></i> 반납 완료
												</span>
												</span>
											</c:if>
										</div>
									</div>
								</div>

								<div class="borrowed-card-footer">
									<c:choose>
										<c:when test="${book.isReturned}">
											<a
												href="/pilotpjt/book_detail?bookNumber=${book.bookDTO.bookNumber}"
												class="card-button detail-button"> <i
												class="fas fa-info-circle"></i> 도서 상세정보
											</a>
										</c:when>
										<c:otherwise>
											<a href="/pilotpjt/return_book?borrowId=${book.borrowId}"
												class="card-button return-button"> <i
												class="fas fa-undo-alt"></i> 반납하기
											</a>

											<a
												href="/pilotpjt/book_detail?bookNumber=${book.bookDTO.bookNumber}"
												class="card-button detail-button"> <i
												class="fas fa-info-circle"></i> 상세정보
											</a>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</c:forEach>
					</div>

					<!-- 페이지네이션 -->
					<c:if test="${totalPages > 1}">
						<div class="pagination">
							<c:if test="${currentPage > 1}">
								<div class="page-item">
									<a class="page-link"
										href="?status=${param.status}&page=${currentPage - 1}"> <i
										class="fas fa-chevron-left"></i>
									</a>
								</div>
							</c:if>

							<c:forEach begin="1" end="${totalPages}" var="pageNum">
								<div class="page-item ${pageNum == currentPage ? 'active' : ''}">
									<a class="page-link"
										href="?status=${param.status}&page=${pageNum}"> ${pageNum}
									</a>
								</div>
							</c:forEach>

							<c:if test="${currentPage < totalPages}">
								<div class="page-item">
									<a class="page-link"
										href="?status=${param.status}&page=${currentPage + 1}"> <i
										class="fas fa-chevron-right"></i>
									</a>
								</div>
							</c:if>
						</div>
					</c:if>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>