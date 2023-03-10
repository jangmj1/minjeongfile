<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspweb/css/singup.css" rel="stylesheet">
</head>
<body>

	<%@ include file="/header.jsp" %>
	<div class="container">
		
		<form class="signupForm"> <!-- form 사용하기위해 매개변수 식별을 위함 : name   -->
			<h3>비밀번호찾기 찾기</h3>
			<p> 회원님의 비밀번호를를 찾아드립니다</p>
			
			<div class="title">아이디</div>
			<input  type="text" name="mid" class="mid">
			
			<div class="title">이메일 주소</div>
			<input  type="text" name="memail" class="memail">
			
			
						
			<div class="checkconfirm">  </div> 
			
			
			
			<button class="signupbtn" type="button" onclick="findpwd()">비밀번호 찾기</button>
		</form>
		
	
	</div>
	<script src="/jspweb/js/member/login.js" type="text/javascript"></script>

</body>
</html>