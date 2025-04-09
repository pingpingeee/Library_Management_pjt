<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>도서 정보 수정</title>
<script src="/pilotpjt/resources/js/book_update.js"></script>
<link rel="stylesheet" type="text/css"
	href="/pilotpjt/resources/css/book_update.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript">
	function fn_submit() {
		var formData = $("#frm").serialize();//form 요소 자체

		//비동기 전송방식의 jquery 함수
		$.ajax({
			type : "post",
			data : formData,
			url : "book_insert",
			success : function(data) {
				alert("저장완료");
				location.href = "admin_view"
			},
			error : function() {
				alert("오류발생");
			}
		});
	}
</script>

</head>
<body>
	<jsp:include page="header.jsp" />
	<form id="updateForm" method="post" action="bookUpdate">
		<h2>도서 정보 수정</h2>
		<!-- 		1행 도서번호, ISBN -->
		<div>
			<label for="bookNumber">도서번호</label> <input type="number"
				id="bookNumber" name="bookNumber" value="${book.bookNumber}"
				readonly />
		</div>
		<div class="form-group">
			<label>ISBN</label> <input type="text" name="bookIsbn" required
				value="${book.bookIsbn}" placeholder="1111"
				oninvalid="this.setCustomValidity('올바른 Isbn 형식으로 입력해주세요.')"
				oninput="setCustomValidity('')"> <span class="input-hint">Isbn을
				입력해주세요.</span> <span class="error-message">올바른 Isbn 형식을 입력해주세요.</span>
		</div>
		<!-- 			2행 도서제목 -->
		<div class="form-group">
			<label>도서 제목</label> <input type="text" name="bookTitle" required
				value="${book.bookTitle}" placeholder="미움받을 용기"
				oninvalid="this.setCustomValidity('도서제목을 입력해주세요.')"
				oninput="setCustomValidity('')"> <span class="input-hint">도서제목을
				입력해주세요.</span> <span class="error-message">올바른 도서제목을 입력해주세요.</span>
		</div>

		<!-- 3행 도서 설명 -->
		<div class="form-group">
			<label>도서 설명</label> 
			<div class="input-container">
			<input type="text" name="bookComent" required
				value="${book.bookComent}" 
				oninvalid="this.setCustomValidity('도서설명을 입력해주세요.')"
				oninput="setCustomValidity('')">
				<span class="floating-label">도서 설명란</span>
			</div>
				<span class="input-hint">도서설명을입력해주세요.</span> 
				<span class="error-message">올바른 도서설명을 입력해주세요.</span>
		</div>
		<!-- 4행 저자,출판사 -->
		<div class="form-group">
			<label>저자</label> <input type="text" name="bookWrite" required
				value="${book.bookWrite}" placeholder="저자"
				oninvalid="this.setCustomValidity('저자의 이름을 입력해주세요.')"
				oninput="setCustomValidity('')"> <span class="input-hint">저자의
				이름을 입력해주세요.</span> <span class="error-message">올바른 저자의 이름을 입력해주세요.</span>
		</div>

		<div class="form-group">
			<label>출판사</label> <input type="text" name="bookPub" required
				value="${book.bookPub}" placeholder="출판사"
				oninvalid="this.setCustomValidity('출판사 이름을 입력해주세요.')"
				oninput="setCustomValidity('')"> <span class="input-hint">출판사
				이름을 입력해주세요.</span> <span class="error-message">올바른 출판사 이름을 입력해주세요.</span>
		</div>
		<!-- 5행 발행일 -->
		<div class="form-group">
			<label>발행일</label> <input type="date" name="bookDate" required
				value="${book.bookDate}" placeholder="발행일"
				oninvalid="this.setCustomValidity('발행일을 입력해주세요.')"
				oninput="setCustomValidity('')"> <span class="input-hint">발행일을
				입력해주세요.</span> <span class="error-message">올바른 발헹일을 입력해주세요.</span>
		</div>
		<!-- 6행 주 카테고리, 하위 카테고리 -->
		<div class="form-group category-row">
			<label> 카테고리(대분류) <select id="mainCategory"
				name="bookMajorCategory" required onchange="updateSubCategories()">
					<option value="">선택하세요</option>
					<option value="소설">소설</option>
					<option value="과학">과학</option>
					<option value="인문">인문</option>
					<option value="기술">기술</option>
					<option value="기타">기타</option>
			</select>
			</label>
		</div>
		<!-- 소분류 선택 -->
		<div class="form-group category-row">
			<label> 카테고리(소분류) <select id="subCategory"
				name="bookSubCategory" required>
					<option value="">소분류를 선택하세요</option>
			</select>
			</label>
		</div>
		<!-- 7행 재고, 대출횟수(읽기전용) -->
		<div class="form-group">
			<label>재고</label> <input type="number" name="bookCount" required
				min="1" value="${book.bookCount}" placeholder="보유 재고 수량을 입력하세요"
				oninvalid="this.setCustomValidity('보유 재고 수량을 입력해주세요.')"
				oninput="setCustomValidity('')">
				 <span class="input-hint">보유
				재고 수량을 입력해주세요.</span> <span class="error-message">올바른 보유 재고 수량을
				입력해주세요.</span>
		</div>
		<div>
			<label for="bookBorrowcount">대출횟수</label> <input type="number"
				id="bookBorrowcount" name="bookBorrowcount"
				value="${book.bookBorrowcount}" readonly />
		</div>
		<!-- 8행 저장 취소 삭제 버튼 -->
		<div>
			<button type="submit">수정 완료</button>
			<button type="reset">초기화</button>
			<button type="button" onclick="history.back()">취소</button>
			<!--                <button type="button" onclick="if(confirm('정말로 모든 도서 정보를 삭제하시겠습니까?')) -->
			<!--             	   location.href='deleteBookInfo.jsp'">삭제</button> -->
		</div>

	</form>
</body>
</html>
































