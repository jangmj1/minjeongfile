<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3>회원가입</h3>
	<form class="signupForm"> <!-- form 사용하기위해 매개변수 식별을 위함 : name   -->
		아이디: <input onkeyup="idcheck()" maxlength="30" type="text" name="mid" class="mid">
		 		<span class="idcheckconfirm"></span>
		  <br/>
		 
		비밀번호: <input type="text" name="mpwd"  class="mpwd"> <br/>
		비밀번호확인: <input type="text" name="mpwdconfirm" class="mpwdconfirm"> <br/>
		이메일: <input type="text" name="memail" class="memail"> <br/>
		프로필: <input type="file" name="mimg" class="mimg"> <br/>
	</form>
	<button type="button" onclick="signup()">가입</button>

	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="/jspweb/js/member/signup.js" type="text/javascript"></script>
</body>
</html>