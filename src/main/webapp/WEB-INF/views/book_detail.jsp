<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${book.bookTitle} - 도서 상세 정보 - 잉크 트리</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700&display=swap"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<link rel="stylesheet" type="text/css"
	href="/pilotpjt/resources/css/book_detail.css">
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="container">
		<div class="book-detail-container">
			<div class="book-detail-header">
				<h1 class="book-detail-title">
					<i class="fas fa-book"></i> 도서 상세 정보
				</h1>
			</div>

			<div class="book-detail-content">
				<div class="book-image-section">
					<div class="book-cover">
						<!-- 실제 구현 시 도서 이미지 경로를 사용해야함 -->
						<!-- <img src="/pilotpjt/resources/images/books/${book.bookNumber}.jpg" alt="${book.bookTitle}" 
                            onerror="this.style.display='none'; document.getElementById('placeholder-${book.bookNumber}').style.display='flex';"> -->
						<div class="book-cover-placeholder" id="placeholder-${book.bookNumber}">
							<i class="fas fa-book"></i>
						</div>
					</div>
				</div>

				<div class="book-info-section">
					<div class="book-info-main">
						<h2 class="book-title">${book.bookTitle}</h2>

						<div class="book-meta">
							<div class="book-meta-item">
								<span class="meta-label">저자</span> <span class="meta-value">${book.bookWrite}</span>
							</div>
							<div class="book-meta-item">
								<span class="meta-label">출판사</span> <span class="meta-value">${book.bookPub}</span>
							</div>
							<div class="book-meta-item">
								<span class="meta-label">출판일</span> <span class="meta-value">
									<fmt:formatDate value="${book.bookDate}" pattern="yyyy년 MM월 dd일" />
								</span>
							</div>
							<div class="book-meta-item">
								<span class="meta-label">ISBN</span> <span class="meta-value">${book.bookIsbn}</span>
							</div>
						</div>

						<div class="book-categories">
							<span class="book-category">${book.bookMajorCategory}</span>
							<c:if test="${not empty book.bookSubCategory}">
								<span class="book-category">${book.bookSubCategory}</span>
							</c:if>
						</div>

						<div class="book-status">
							<div
								class="book-availability ${book.bookCount > 0 ? 'available' : 'unavailable'}">
								<c:choose>
									<c:when test="${book.bookCount > 0}">
										<i class="fas fa-check-circle"></i> 대출 가능
                                    </c:when>
									<c:otherwise>
										<i class="fas fa-times-circle"></i> 대출 불가
                                    </c:otherwise>
								</c:choose>
							</div>
							<div class="book-count">
								<i class="fas fa-book"></i> 보유 수량: ${book.bookCount}권
							</div>
							<div class="book-count">
								<i class="fas fa-chart-line"></i> 대출 횟수: ${book.bookBorrowcount}회
							</div>
						</div>

						<div class="book-actions">
							<c:choose>
								<c:when test="${book.bookCount > 0}">
									<a href="book_borrow?bookNumber=${book.bookNumber}"
										class="book-action-button borrow-button"> <i
										class="fas fa-hand-holding"></i> 대출하기
									</a>
								</c:when>
								<c:otherwise>
									<button class="book-action-button borrow-button" disabled>
										<i class="fas fa-hand-holding"></i> 대출 불가
									</button>
								</c:otherwise>
							</c:choose>
							<a href="/pilotpjt/add_wishlist?bookNumber=${book.bookNumber}"
								class="book-action-button wishlist-button"> <i
								class="fas fa-heart"></i> 위시리스트에 추가
							</a> <a href="javascript:history.back()"
								class="book-action-button back-button"> <i
								class="fas fa-arrow-left"></i> 목록으로 돌아가기
							</a>
						</div>
					</div>

					<div class="book-description-section">
						<h3 class="section-title">도서 소개</h3>
						<div class="book-description">
							<p>${book.bookComent}</p>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 관련 도서 섹션 (선택적) -->
		<c:if test="${not empty relatedBooks}">
			<div class="related-books-section">
				<h3 class="section-title">관련 도서</h3>
				<div class="related-books-grid">
					<c:forEach items="${relatedBooks}" var="relatedBook">
						<div class="related-book-card">
							<div class="related-book-cover">
								<i class="fas fa-book"></i>
							</div>
							<div class="related-book-info">
								<h4 class="related-book-title">${relatedBook.bookTitle}</h4>
								<div class="related-book-author">${relatedBook.bookWrite}</div>
								<a
									href="/pilotpjt/book_detail?bookNumber=${relatedBook.bookNumber}"
									class="related-book-link">상세보기</a>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</c:if>
	</div>
   <c:if test="${not empty errorMsg}">
    <script>
        alert("${errorMsg}");
    </script>
    </c:if>
</body>
</html>