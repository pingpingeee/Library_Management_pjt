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
<style>
/* 기본 스타일 */
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: 'Noto Sans KR', sans-serif;
	background-color: #f8f9fa;
	color: #333;
	line-height: 1.6;
}

.container {
	max-width: 1200px;
	margin: 30px auto;
	padding: 0 20px;
}

/* 대출 도서 헤더 */
.borrowed-header {
	margin-bottom: 30px;
}

.borrowed-title {
	font-size: 2rem;
	font-weight: 700;
	color: #2563EB;
	margin-bottom: 10px;
	display: flex;
	align-items: center;
}

.borrowed-title i {
	margin-right: 15px;
}

.borrowed-subtitle {
	color: #6B7280;
	font-size: 1.1rem;
	margin-bottom: 20px;
}

.borrowed-stats {
	display: flex;
	flex-wrap: wrap;
	gap: 20px;
	margin-bottom: 30px;
}

.stat-card {
	background-color: white;
	border-radius: 10px;
	padding: 20px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
	flex: 1;
	min-width: 200px;
	border-left: 4px solid #2563EB;
}

.stat-title {
	color: #6B7280;
	font-size: 0.9rem;
	margin-bottom: 10px;
}

.stat-value {
	font-size: 1.8rem;
	font-weight: 700;
	color: #2563EB;
	display: flex;
	align-items: center;
}

.stat-value i {
	margin-right: 10px;
	font-size: 1.5rem;
}

/* 필터 및 정렬 */
.borrowed-filters {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 20px;
	flex-wrap: wrap;
	gap: 15px;
}

.filter-group {
	display: flex;
	align-items: center;
	gap: 10px;
}

.filter-label {
	color: #6B7280;
	font-size: 0.9rem;
}

.filter-select {
	padding: 8px 12px;
	border-radius: 5px;
	border: 1px solid #D1D5DB;
	background-color: white;
	color: #374151;
	font-family: 'Noto Sans KR', sans-serif;
	cursor: pointer;
}

.filter-select:focus {
	outline: none;
	border-color: #2563EB;
}

.search-input {
	padding: 8px 12px;
	border-radius: 5px;
	border: 1px solid #D1D5DB;
	width: 250px;
	font-family: 'Noto Sans KR', sans-serif;
}

.search-input:focus {
	outline: none;
	border-color: #2563EB;
}

.search-button {
	background-color: #2563EB;
	color: white;
	border: none;
	border-radius: 5px;
	padding: 8px 15px;
	cursor: pointer;
	transition: background-color 0.3s;
}

.search-button:hover {
	background-color: #1d4ed8;
}

/* 대출 도서 목록 */
.borrowed-list {
	margin-bottom: 40px;
}

.borrowed-grid {
	display: grid;
	grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
	gap: 20px;
}

.borrowed-card {
	background-color: white;
	border-radius: 10px;
	overflow: hidden;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
	transition: transform 0.3s, box-shadow 0.3s;
	display: flex;
	flex-direction: column;
}

.borrowed-card:hover {
	transform: translateY(-5px);
	box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
}

.borrowed-card-header {
	padding: 15px;
	background-color: #2563EB;
	color: white;
	font-weight: 500;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.due-date {
	font-size: 0.9rem;
	display: flex;
	align-items: center;
}

.due-date i {
	margin-right: 5px;
}

.due-date.overdue {
	color: #FEF2F2;
	background-color: #EF4444;
	padding: 3px 8px;
	border-radius: 20px;
	font-size: 0.8rem;
}

.due-date.warning {
	color: #FFFBEB;
	background-color: #F59E0B;
	padding: 3px 8px;
	border-radius: 20px;
	font-size: 0.8rem;
}

.borrowed-card-content {
	padding: 20px;
	display: flex;
	gap: 15px;
	flex: 1;
}

.book-cover {
	width: 100px;
	height: 140px;
	background-color: #F3F4F6;
	display: flex;
	align-items: center;
	justify-content: center;
	border-radius: 5px;
	overflow: hidden;
	flex-shrink: 0;
}

.book-cover i {
	font-size: 2.5rem;
	color: #9CA3AF;
}

.book-info {
	flex: 1;
	display: flex;
	flex-direction: column;
}

.book-title {
	font-size: 1.1rem;
	font-weight: 700;
	color: #111827;
	margin-bottom: 5px;
	display: -webkit-box;
	-webkit-line-clamp: 2;
	-webkit-box-orient: vertical;
	overflow: hidden;
}

.book-author {
	color: #4B5563;
	margin-bottom: 10px;
	font-size: 0.9rem;
}

.book-details {
	display: grid;
	grid-template-columns: auto 1fr;
	gap: 5px 10px;
	font-size: 0.85rem;
	margin-bottom: 15px;
}

.detail-label {
	color: #6B7280;
}

.detail-value {
	color: #374151;
	font-weight: 500;
}

.borrowed-card-footer {
	padding: 15px;
	border-top: 1px solid #E5E7EB;
	display: flex;
	justify-content: space-between;
	gap: 10px;
}

.card-button {
	padding: 8px 12px;
	border-radius: 5px;
	font-weight: 500;
	font-size: 0.9rem;
	cursor: pointer;
	text-align: center;
	flex: 1;
	transition: all 0.3s;
	display: flex;
	align-items: center;
	justify-content: center;
	text-decoration: none;
}

.card-button i {
	margin-right: 5px;
}

.renew-button {
	background-color: #2563EB;
	color: white;
	border: none;
}

.renew-button:hover {
	background-color: #1d4ed8;
}

.renew-button:disabled {
	background-color: #9CA3AF;
	cursor: not-allowed;
}

.return-button {
	background-color: white;
	color: #2563EB;
	border: 1px solid #2563EB;
}

.return-button:hover {
	background-color: #EFF6FF;
}

.detail-button {
	background-color: white;
	color: #4B5563;
	border: 1px solid #D1D5DB;
}

.detail-button:hover {
	background-color: #F9FAFB;
	color: #111827;
}

/* 페이지네이션 */
.pagination {
	display: flex;
	justify-content: center;
	margin-top: 30px;
	gap: 5px;
}

.page-item {
	display: flex;
}

.page-link {
	padding: 8px 12px;
	border-radius: 5px;
	background-color: white;
	color: #4B5563;
	text-decoration: none;
	transition: all 0.3s;
	border: 1px solid #E5E7EB;
}

.page-link:hover {
	background-color: #F9FAFB;
	color: #2563EB;
	border-color: #2563EB;
}

.page-item.active .page-link {
	background-color: #2563EB;
	color: white;
	border-color: #2563EB;
}

/* 빈 상태 */
.empty-state {
	text-align: center;
	padding: 60px 20px;
	background-color: white;
	border-radius: 10px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
}

.empty-icon {
	font-size: 4rem;
	color: #D1D5DB;
	margin-bottom: 20px;
}

.empty-title {
	font-size: 1.5rem;
	font-weight: 700;
	color: #374151;
	margin-bottom: 10px;
}

.empty-description {
	color: #6B7280;
	margin-bottom: 20px;
	max-width: 500px;
	margin-left: auto;
	margin-right: auto;
}

.browse-button {
	display: inline-block;
	background-color: #2563EB;
	color: white;
	padding: 10px 20px;
	border-radius: 5px;
	text-decoration: none;
	font-weight: 500;
	transition: background-color 0.3s;
}

.browse-button:hover {
	background-color: #1d4ed8;
}

/* 반응형 */
@media (max-width: 768px) {
	.borrowed-filters {
		flex-direction: column;
		align-items: stretch;
	}
	
	.filter-group {
		flex-wrap: wrap;
	}
	
	.search-input {
		width: 100%;
	}
	
	.borrowed-grid {
		grid-template-columns: 1fr;
	}
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="container">
		<div class="borrowed-header">
			<h1 class="borrowed-title">
				<i class="fas fa-book-reader"></i> 내 대출 도서
			</h1>
			<p class="borrowed-subtitle">현재 대출 중인 도서 목록과 반납 예정일을 확인하세요.</p>

			<div class="borrowed-stats">
				<div class="stat-card">
					<div class="stat-title">현재 대출 중</div>
					<div class="stat-value">
						<i class="fas fa-book"></i> ${borrowedCount}권
					</div>
				</div>
				<div class="stat-card">
					<div class="stat-title">연체 중</div>
					<div class="stat-value">
						<i class="fas fa-exclamation-circle"></i> ${overdueCount}권
					</div>
				</div>
				<div class="stat-card">
					<div class="stat-title">대출 가능</div>
					<div class="stat-value">
						<i class="fas fa-check-circle"></i> ${remainingQuota}권
					</div>
				</div>
			</div>
		</div>

		<div class="borrowed-filters">
			<div class="filter-group">
				<label class="filter-label" for="sortBy">정렬:</label> <select
					class="filter-select" id="sortBy" name="sortBy">
					<option value="dueDate" ${param.sortBy == 'dueDate' ? 'selected' : ''}>반납일순</option>
					<option value="borrowDate"
						${param.sortBy == 'borrowDate' ? 'selected' : ''}>대출일순</option>
					<option value="title" ${param.sortBy == 'title' ? 'selected' : ''}>제목순</option>
				</select> <label class="filter-label" for="filterBy">필터:</label> <select
					class="filter-select" id="filterBy" name="filterBy">
					<option value="all" ${param.filterBy == 'all' ? 'selected' : ''}>전체</option>
					<option value="overdue"
						${param.filterBy == 'overdue' ? 'selected' : ''}>연체 중</option>
					<option value="dueToday"
						${param.filterBy == 'dueToday' ? 'selected' : ''}>오늘 반납</option>
					<option value="dueSoon"
						${param.filterBy == 'dueSoon' ? 'selected' : ''}>곧 반납</option>
				</select>
			</div>

			<div class="filter-group">
				<input type="text" class="search-input" id="searchKeyword"
					name="searchKeyword" value="${param.searchKeyword}"
					placeholder="도서명 또는 저자 검색">
				<button class="search-button" onclick="searchBorrowedBooks()">
					<i class="fas fa-search"></i> 검색
				</button>
			</div>
		</div>

		<div class="borrowed-list">
			<c:choose>
				<c:when test="${empty borrowedBooks}">
					<div class="empty-state">
						<div class="empty-icon">
							<i class="fas fa-book-open"></i>
						</div>
						<h2 class="empty-title">대출 중인 도서가 없습니다</h2>
						<p class="empty-description">현재 대출 중인 도서가 없습니다. 도서관에서 관심 있는
							도서를 찾아보세요.</p>
						<a href="/pilotpjt/book_search_view" class="browse-button"> <i
							class="fas fa-search"></i> 도서 검색하기
						</a>
					</div>
				</c:when>
				<c:otherwise>
					<div class="borrowed-grid">
						<c:forEach items="${borrowedBooks}" var="borrowed">
							<div class="borrowed-card">
								<div class="borrowed-card-header">
									<span>대출일: <fmt:formatDate value="${borrowed.borrowDate}"
											pattern="yyyy.MM.dd" /></span>

									<c:choose>
										<c:when test="${borrowed.isOverdue}">
											<span class="due-date overdue"> <i
												class="fas fa-exclamation-circle"></i> <fmt:formatDate
													value="${borrowed.dueDate}" pattern="yyyy.MM.dd" /> (연체)
											</span>
										</c:when>
										<c:when test="${borrowed.isDueSoon}">
											<span class="due-date warning"> <i
												class="fas fa-exclamation-triangle"></i> <fmt:formatDate
													value="${borrowed.dueDate}" pattern="yyyy.MM.dd" /> (곧 만료)
											</span>
										</c:when>
										<c:otherwise>
											<span class="due-date"> <i class="fas fa-calendar-alt"></i>
												<fmt:formatDate value="${borrowed.dueDate}"
													pattern="yyyy.MM.dd" />
											</span>
										</c:otherwise>
									</c:choose>
								</div>

								<div class="borrowed-card-content">
									<div class="book-cover">
										<!-- 실제 구현 시 도서 이미지 경로를 사용해야함 -->
										<!-- <img src="/pilotpjt/resources/images/books/${borrowed.book.bookNumber}.jpg" alt="${borrowed.book.bookTitle}" 
                                            onerror="this.style.display='none'; document.getElementById('placeholder-${borrowed.book.bookNumber}').style.display='flex';"> -->
										<div class="book-cover-placeholder"
											id="placeholder-${borrowed.book.bookNumber}">
											<i class="fas fa-book"></i>
										</div>
									</div>

									<div class="book-info">
										<h3 class="book-title">${borrowed.book.bookTitle}</h3>
										<div class="book-author">${borrowed.book.bookWrite}</div>

										<div class="book-details">
											<span class="detail-label">도서 번호:</span> <span
												class="detail-value">${borrowed.book.bookNumber}</span> <span
												class="detail-label">ISBN:</span> <span class="detail-value">${borrowed.book.bookIsbn}</span>
											<span class="detail-label">출판사:</span> <span
												class="detail-value">${borrowed.book.bookPub}</span> <span
												class="detail-label">대출 횟수:</span> <span class="detail-value">${borrowed.renewCount}회
												/ ${maxRenewCount}회</span>
										</div>
									</div>
								</div>

								<div class="borrowed-card-footer">
									<c:choose>
										<c:when
											test="${borrowed.renewCount < maxRenewCount && !borrowed.isOverdue}">
											<button class="card-button renew-button"
												onclick="renewBook(${borrowed.borrowId})">
												<i class="fas fa-redo"></i> 연장하기
											</button>
										</c:when>
										<c:otherwise>
											<button class="card-button renew-button" disabled>
												<i class="fas fa-redo"></i> 연장 불가
											</button>
										</c:otherwise>
									</c:choose>

									<a href="/pilotpjt/return_book?borrowId=${borrowed.borrowId}"
										class="card-button return-button"> <i
										class="fas fa-undo-alt"></i> 반납하기
									</a> <a
										href="/pilotpjt/book_detail?bookNumber=${borrowed.book.bookNumber}"
										class="card-button detail-button"> <i class="fas fa-info"></i>
										상세정보
									</a>
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
										href="?page=${currentPage - 1}&sortBy=${param.sortBy}&filterBy=${param.filterBy}&searchKeyword=${param.searchKeyword}">
										<i class="fas fa-chevron-left"></i>
									</a>
								</div>
							</c:if>

							<c:forEach begin="1" end="${totalPages}" var="pageNum">
								<div class="page-item ${pageNum == currentPage ? 'active' : ''}">
									<a class="page-link"
										href="?page=${pageNum}&sortBy=${param.sortBy}&filterBy=${param.filterBy}&searchKeyword=${param.searchKeyword}">
										${pageNum} </a>
								</div>
							</c:forEach>

							<c:if test="${currentPage < totalPages}">
								<div class="page-item">
									<a class="page-link"
										href="?page=${currentPage + 1}&sortBy=${param.sortBy}&filterBy=${param.filterBy}&searchKeyword=${param.searchKeyword}">
										<i class="fas fa-chevron-right"></i>
									</a>
								</div>
							</c:if>
						</div>
					</c:if>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

	<script>
		// 정렬 및 필터 변경 시 페이지 새로고침
		document.getElementById('sortBy').addEventListener('change', function() {
			applyFilters();
		});

		document.getElementById('filterBy').addEventListener('change', function() {
			applyFilters();
		});

		// 검색 함수
		function searchBorrowedBooks() {
			applyFilters();
		}

		// 필터 적용 함수
		function applyFilters() {
			const sortBy = document.getElementById('sortBy').value;
			const filterBy = document.getElementById('filterBy').value;
			const searchKeyword = document.getElementById('searchKeyword').value;
			
			window.location.href = '?sortBy=' + sortBy + '&filterBy=' + filterBy + '&searchKeyword=' + encodeURIComponent(searchKeyword);
		}

		// 도서 연장 함수
		function renewBook(borrowId) {
			if (confirm('대출 기간을 연장하시겠습니까?')) {
				// AJAX 요청으로 연장 처리
				$.ajax({
					type: "POST",
					url: "/pilotpjt/renew_book",
					data: { borrowId: borrowId },
					success: function(response) {
						if (response.success) {
							alert('대출 기간이 연장되었습니다.');
							location.reload(); // 페이지 새로고침
						} else {
							alert(response.message || '연장에 실패했습니다.');
						}
					},
					error: function() {
						alert('서버 오류가 발생했습니다. 다시 시도해주세요.');
					}
				});
			}
		}
	</script>
</body>
</html>