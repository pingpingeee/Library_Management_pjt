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
         ����<input type="text" name="bookTitle">
      </label>
      <label>
         ����<input type="text" name="bookComent">
      </label>
      <label>
         �۰�<input type="text" name="bookWriter">
      </label>
      <label>
         ���ǻ�<input type="text" name="bookPub">
      </label>
      <label>
         ������<input type="text" name="bookDate">
      </label>
      <label>
         ī�װ�<input type="text" name="bookCategory">
      </label>
      <label>
         ���<input type="text" name="bookCount">
      </label>
   <input type="submit" value="���">
   </form>
</body>
</html>
