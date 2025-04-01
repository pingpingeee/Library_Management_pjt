<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty error}">
		<p class="error-message">${error}</p>
	</c:if>
   <form method="post" action="/pilotpjt/book_insert">
      <label>
         제목<input type="text" name="bookTitle">
      </label>
      <label>
         내용<input type="text" name="bookComent">
      </label>
      <label>
         작가<input type="text" name="bookWriter">
      </label>
      <label>
         출판사<input type="text" name="bookPub">
      </label>
      <label>
         발행일<input type="text" name="bookDate">
      </label>
      <label>
         카테고리<input type="text" name="bookCategory">
      </label>
      <label>
         재고<input type="text" name="bookCount">
      </label>
   <input type="submit" value="등록">
   </form>
</body>
</html>
