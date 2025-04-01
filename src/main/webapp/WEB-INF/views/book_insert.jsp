<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>도서 등록</title>
<link rel="stylesheet" type="text/css" href="/pilotpjt/resources/css/book_insert.css">
</head>
<body>
	<c:if test="${not empty error}">
		<p class="error-message">${error}</p>
	</c:if>
   
   <form method="post" action="/pilotpjt/book_insert">
      <label>
         제목<input type="text" name="bookTitle" required placeholder="도서 제목을 입력하세요">
      </label>
      <br>
      <label>
         내용<input type="text" name="bookComent" required placeholder="책의 간략한 내용을 입력하세요">
      </label>
      <br>
      <label>
         작가<input type="text" name="bookWriter" required placeholder="작가 이름을 입력하세요">
      </label>
      <br>
      <label>
         출판사<input type="text" name="bookPub" required placeholder="출판사 이름을 입력하세요">
      </label>
      <br>
      <label>
         발행일<input type="date" name="bookDate" required>
      </label>
      <br>
      <label>
         카테고리<input type="text" name="bookCategory" required placeholder="도서 카테고리를 입력하세요 (예: 소설, 과학)">
      </label>
      <br>
      <label>
         재고<input type="number" name="bookCount" required min="1" placeholder="보유 재고 수량을 입력하세요">
      </label>
      <br>
      <input type="submit" value="등록">
   </form>
</body>
</html>
