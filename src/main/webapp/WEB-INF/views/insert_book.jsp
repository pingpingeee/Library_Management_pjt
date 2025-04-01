<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
   <form method="post" action="/pilotpjt/insert_book">
      <label>
         제목<input type="text" name="b_title">
      </label>
      <label>
         내용<input type="text" name="b_coment">
      </label>
      <label>
         작가<input type="text" name="b_writer">
      </label>
      <label>
         출판사<input type="text" name="b_pub">
      </label>
      <label>
         발행일<input type="text" name="b_date">
      </label>
      <label>
         카테고리<input type="text" name="b_category">
      </label>
      <label>
         재고<input type="text" name="b_count">
      </label>
   <input type="submit" value="등록">
   </form>
</body>
</html>
