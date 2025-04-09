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

			<!-- 1행: 제목 -->
			<div class="form-row">
				<div class="input-group">
					<label> 제목<input type="text" name="bookTitle" required
						placeholder="도서 제목을 입력하세요">
					</label>
				</div>
			</div>
<!-- 			<br> -->
			<!-- 2행: 작가와 재고 -->
			<div class="form-row">
				<div class="input-group">
					<label> 작가<input type="text" name="bookWrite" required
						placeholder="작가 이름을 입력하세요">
					</label>
				</div>
				<div class="input-group">
				 <label> 재고<input type="number" name="bookCount"
						required min="1" placeholder="보유 재고 수량을 입력하세요">
					</label>
				</div>
			</div>
<!-- 			<br> -->
			<!-- 3행: 출판사와 발행일 -->
			<div class="form-row">
				<div class="input-group">
					<label> 출판사<input type="text" name="bookPub" required
						placeholder="출판사 이름을 입력하세요">
					</label>
				</div>
				<div class="input-group">
					<label> 발행일<input type="date" name="bookDate" required>
					</label>
				</div>
			</div>
<!-- 			<br> -->
			<!-- 대분류 선택 -->
			<!-- 4행: 카테고리(대분류)와 카테고리(소분류) -->
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
					<!-- 소분류 선택 -->
					<label> 카테고리(소분류) <select id="subCategory"
						name="bookSubCategory" required>
							<option value="">소분류를 선택하세요</option>
					</select>
					</label> 
				</div>
			</div>
			<!-- 5행 내용 -->
			<div class="form-row">
				<div class="input-group full-width">
					<br>
					<label> 내용<input type="text" name="bookComent" required
						placeholder="책의 간략한 내용을 입력하세요">
					</label>
				</div>
			</div>
			<br>
			<!--       <input type="submit" value="등록"> -->
			<input class="btn" type="button" value="등록" onclick="fn_submit()">
		</form>
</body>
</html>
