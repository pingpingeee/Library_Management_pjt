<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="/pilotpjt/resources/css/join.css">
</head>
<body>
	<div class="container">
		<h2>회원가입</h2>
		<form method="post" action="/pilotpjt/join">
			<label>아이디</label>
			<input type="text" name="userId"
			required
			placeholder="영문, 숫자로 4~12자 입력"
			pattern="^[a-zA-Z0-9]{4,12}$"
			oninvalid="this.setCustomValidity('아이디는 영문, 숫자로 4~12자로 입력해주세요.')"
			oninput="setCustomValidity('')">

			<label>비밀번호</label>
			<input type="password" name="userPw"
			required
			placeholder="영문, 숫자, 특수문자 포함 8~16자"
			pattern="^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*]).{6,16}$"
			oninvalid="this.setCustomValidity('비밀번호는 영문, 숫자, 특수문자를 포함하여 6~16자로 입력해주세요.')"
			oninput="setCustomValidity('')">

			<label>비밀번호 확인</label>
			<input type="password" name="pwdConfirm"
			required
			placeholder="비밀번호를 다시 입력"
			oninput="checkPasswordMatch(this)">

			<label>이름</label>
			<input type="text" name="userName"
			required
			placeholder="한글 2~4자 입력"
			pattern="^[가-힣]{2,4}$"
			oninvalid="this.setCustomValidity('이름은 한글 2~4자로 입력해주세요.')"
			oninput="setCustomValidity('')">

			<label>이메일</label>
			<input type="email" name="userEmail"
			required
			placeholder="example@email.com"
			pattern="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$"
			oninvalid="this.setCustomValidity('올바른 이메일 주소 형식으로 입력해주세요.')"
			oninput="setCustomValidity('')">

			<label>전화번호</label>
			<input type="tel" name="userTel"
			required
			placeholder="010-0000-0000"
			pattern="^010-\d{4}-\d{4}$"
			oninvalid="this.setCustomValidity('올바른 전화번호 형식(010-0000-0000)으로 입력해주세요.')"
			oninput="setCustomValidity('')">

			<label>생년월일</label>
			<input type="date" name="userBirth"
			required
			oninvalid="this.setCustomValidity('생년월일을 선택해주세요.')"
			oninput="setCustomValidity('')">

			<label>주소</label>
			<input type="text" name="userAddress"
			required
			placeholder="도로명 또는 지번 주소 입력"
			oninvalid="this.setCustomValidity('주소를 입력해주세요.')"
			oninput="setCustomValidity('')">

			<input type="submit" value="회원가입">
			<input type="button" value="뒤로가기" onclick="location='/pilotpjt/login'">
		</form>
	</div>
	
<!-- 이따 js파일로 옮겨야함 -->
	<script>
 		function checkPasswordMatch(input) { 
 			var password = document.getElementsByName("userPw")[0].value; 
 			if (input.value !== password) {
 				input.setCustomValidity("비밀번호가 일치하지 않습니다."); 
 			} else { 
 				input.setCustomValidity("");
 			}
 		}
	</script>
</body>
</html>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%-- <%-- 	pageEncoding="UTF-8"%> --%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>회원가입</title> -->
<!-- <link rel="stylesheet" type="text/css" href="/pilotpjt/resources/css/join.css"> -->
<!-- </head> -->
<!-- <body> -->
<!-- 	<div class="container"> -->
<!-- 		<h2>회원가입</h2> -->
<!-- 		<form method="post" action="/pilotpjt/join"> -->
<!-- 			<label>아이디</label> -->
<!-- 			<input type="text" name="userId" -->
<!-- 			required -->
<!-- 			placeholder=""> -->
			
<!-- 			<label>비밀번호</label> -->
<!-- 			<input type="password" name="userPw" required> -->
			
<!-- 			<label>비밀번호 확인</label> -->
<!-- 			<input type="password" name="pwdConfirm" required> -->
			
<!--  			<label>이름</label>  -->
<!--  			<input type="text" name="userName" required>  -->
<!-- 			<label>이름</label> -->
<!-- 			<input type="text" name="userName" required> -->
<!--  			<label>이름</label>  -->
<!--  			<input type="text" name="userName"   -->
<!--  			required -->
<!--  			pattern="^[가-힣]{2,4}"  -->
<!--  			oninvalid="this.setCustomValidity('3글자 이상 입력해주세요.')"  -->
<!-- 			oninput="setCustomValidity('3글자 이상 입력해주세요.')">  -->
			
<!-- 			<label>이메일</label> -->
<!-- 			<input type="email" name="userEmail" required> -->
<!--  			<input type="email" name="userEmail" required  -->
<!-- 			pattern="^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}">  -->
			
<!-- 			<label>전화번호</label> -->
<!-- 			<input type="tel" name="userTel" -->
<!-- 			required -->
<!-- 			placeholder="010-0000-0000('-' 없이 입력)"> -->
			
<!-- 			<label>생년월일</label> -->
<!-- 			<input type="date" name="userBirth" required> -->
			
<!-- 			<label>주소</label> -->
<!-- 			<input type="text" name="userAddress" required> -->


<!-- 			<input type="submit" value="회원가입"> -->
<!-- 			<input type="button" value="뒤로가기" onclick="location='/pilotpjt/login'"> -->
<!-- 		</form> -->
<!-- 	</div> -->
<!-- </body> -->
<!-- </html> -->