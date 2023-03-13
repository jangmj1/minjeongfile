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
	<%-- <%@ include file="../header.jsp" %> --%> <!-- 상대경로 -->
	<%@ include file="/header.jsp" %> <!-- 절대경로(webapp이하 생략) -->
	<div class="container">
		
		<form class="signupForm"> <!-- form 사용하기위해 매개변수 식별을 위함 : name   -->
			<h3>Ezen community</h3>
			<p> 환영합니다. 다양한 커뮤니티 플랫폼 제공합니다</p>
			
			<div class="title">아이디</div>
			<input onkeyup="idcheck()" maxlength="30" type="text" name="mid" class="mid">
			<div class="checkconfirm">  </div> 
			
			<div class="title">비밀번호</div>	
			<input onkeyup="pwdcheck()" maxlength="20" type="password" name="mpwd"  class="mpwd">
						
			<div class="title">비밀번호 확인</div>		
			<input onkeyup="pwdconfromcheck()" maxlength="20" type="password" name="mpwdconfirm" class="mpwdconfirm"> 
			<div class="checkconfirm">  </div>
			
			<div class="title">이메일</div>	
			<div class="emailbox">
				<input onkeyup="emailcheck()" type="text" name="memail" class="memail">
				<button class="authbtn" onclick="getauth()" type="button" disabled="disabled">인증</button>
			</div>	
			
			<!-- 인증코드 입력 구역 -->
			<div class="authbox">
				
				
			</div>
			<div class="checkconfirm"> </div> 
			
			<div class="title">프로필</div>
			<div class="pimgbox">
				<input onchange="premimg(this)" type="file" name="mimg" class="mimg">
				<img class="premimg" alt="" src="/jspweb/member/pimg/default.webp">
			</div>		
			
			<button class="signupbtn" type="button" onclick="signup()">가입</button>
		</form>
		
	
	</div>
	
	
	<!-- 모달 -->
	<div class="modal_wrap">
		<div class="modal_box">
			<h3 class="modal_title">환영합니다</h3>
			<div class="modal_content">
				회원가입을 축하 포인트 100 지급
			</div>
			
			<div class="modal_btn">
				<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button>
			</div>
		
		</div>
	
	</div>
	
	<script src="/jspweb/js/member/signup.js" type="text/javascript"></script>
</body>
</html>