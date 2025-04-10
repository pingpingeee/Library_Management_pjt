<!-- <%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>도서 등록</title>
<link rel="stylesheet" type="text/css"
	href="/pilotpjt/resources/css/book_insert.css">
<!-- <link rel="stylesheet" type="text/css" href="/css/book_insert.css"> -->
<script src="/pilotpjt/resources/js/book_insert.js"></script>
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
<!-- 	<!-// 	카테고리 부분 인코딩이 깨짐;;; -->
<!-- 	request.setCharacterEncoding("utf-8");); -->
<!-- 	%>--> 
	 
<!-- 	<form method="post" action="book_insert"> -->
		<form id="frm">
			<h1>도서 등록 페이지</h1>

<!-- 			<div class="form-intro"> -->
<!-- 				<p> -->
<!-- 					도서 등록 페이지입니다.<br>아래 순서대로 도서의 정보를 등록해 주세요. -->
<!-- 				</p> -->
<!-- 			</div> -->

			<!-- 1행: ISBN -->
			<div class="form-row">
				<div class="input-group">
					<label>ISBN<input type="text" name="bookIsbn" required
						placeholder="ISBN을 입력하세요">
					</label>
				</div>
			</div>
<!-- 			2행 :제목 -->
			<div class="form-row">
				<div class="input-group">
					<label> 제목<input type="text" name="bookTitle" required
						placeholder="도서 제목을 입력하세요">
					</label>
				</div>
			</div>
<!-- 			<br> -->
			<!-- 3행: 내용 -->
			<div class="form-group">
			<label>도서 설명</label>
			<div class="input-container">
				<textarea name="bookComent" required placeholder="도서 설명을 입력해주세요" 
				oninvalid="this.setCustomValidity('책의 간략한 내용을 입력해주세요')"
				oninput="setCustomValidity('')"></textarea>
			</div>
		</div>
<!-- 			<br> -->
			<!-- 4행: 저자와 출판사-->
			<div class="form-row">
				<div class="input-group">
					<label> 저자<input type="text" name="bookWrite" required
						placeholder="저자 이름을 입력하세요">
					</label>
				</div>
				<div class="input-group">
					<label> 출판사<input type="text" name="bookPub" required
						placeholder="출판사 이름을 입력하세요">
					</label>
				</div>
			</div>
			<!-- 5행 재고 발행일 -->
			<div class="form-row">
				<div class="input-group">
				 <label> 재고<input type="number" name="bookCount"
						required min="1" placeholder="보유 재고 수량을 입력하세요">
					</label>
				</div>
				<div class="input-group">
					<label> 발행일<input type="date" name="bookDate" required>
					</label>
				</div>
			</div>
<!-- 			<br> -->
			<!-- 대분류 선택 -->
			<!-- 6행: 카테고리(대분류)와 카테고리(소분류) -->
			<div class="form-row category-row">
				<div class="input-group">
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
			</div>
					<!-- 소분류 선택 -->
				<div class="form-row category-row">
					<label> 카테고리(소분류) <select id="subCategory"
						name="bookSubCategory" required>
							<option value="">소분류를 선택하세요</option>
					</select>
					</label> 
				</div>
			<br>
			<div class="form-button">
				<!--       <input type="submit" value="등록"> -->
				<input class="btn" type="button" value="등록" onclick="fn_submit()">
				<button type="reset">초기화</button>
				<button type="button" onclick="history.back()">취소</button>
			</div>
		</form>
</body>
</html>
