<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ���</title>
<link rel="stylesheet" type="text/css" href="/pilotpjt/resources/css/book_insert.css">
</head>
<body>
	<c:if test="${not empty error}">
		<p class="error-message">${error}</p>
	</c:if>
   
   <form method="post" action="/pilotpjt/book_insert">
      <label>
         ����<input type="text" name="bookTitle" required placeholder="���� ������ �Է��ϼ���">
      </label>
      <br>
      <label>
         ����<input type="text" name="bookComent" required placeholder="å�� ������ ������ �Է��ϼ���">
      </label>
      <br>
      <label>
         �۰�<input type="text" name="bookWriter" required placeholder="�۰� �̸��� �Է��ϼ���">
      </label>
      <br>
      <label>
         ���ǻ�<input type="text" name="bookPub" required placeholder="���ǻ� �̸��� �Է��ϼ���">
      </label>
      <br>
      <label>
         ������<input type="date" name="bookDate" required>
      </label>
      <br>
      <label>
         ī�װ�<input type="text" name="bookCategory" required placeholder="���� ī�װ��� �Է��ϼ��� (��: �Ҽ�, ����)">
      </label>
      <br>
      <label>
         ���<input type="number" name="bookCount" required min="1" placeholder="���� ��� ������ �Է��ϼ���">
      </label>
      <br>
      <input type="submit" value="���">
   </form>
</body>
</html>
