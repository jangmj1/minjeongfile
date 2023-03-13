<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/modal.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/header.jsp"  %>
	
	<div class="container">
		<h3> 회원정보 </h3>
		<div>
			<div>
				<img width="20%" class="mimg" alt="" src="/jspweb/member/pimg/default.webp">
			</div>
			<div>
				<div>아이디</div>
				<div class="mid"></div>
			</div>
			<div>
				<div>이메일</div>
				<div class="memail"></div>
			</div>
			<div>
				<div>보유포인트</div>
				<div class="mpoint">3000</div>
			</div>
			
			<a href="/jspweb/member/upDate.jsp"><button  type="button">회원수정</button></a> 
			<button onclick="openModal()" type="button">회원탈퇴</button>
		</div>
	</div>
	
	
	<!-- 모달 -->
	<div class="modal_wrap">
		<div class="modal_box">
			<h3 class="modal_title">회원탈퇴</h3>
			<div class="modal_content">
				정말 회원 탈퇴를 하시겠습니까?<br/>
				비밀번호 : <input type="password" class="mpwd">
			</div>
			
			<div class="modal_btn">
				<button onclick="setDelete()" class="modal_check" type="button">확인</button>
				<button onclick="closeModal()" class="modal_cencel" type="button">취소</button>
			</div>
		
		</div>
	
	</div>
	
	<!-- 모달 js -->
	<script src="/jspweb/js/modal.js" type="text/javascript"></script>
	
	<script src="/jspweb/js/member/info.js" type="text/javascript"></script>
</body>
</html>

<!-- 
	동일한 html에서 열리는 js파일은 메모리 공유
	*단 먼저 호출된 js순
	*주의 ajax
		1.$.ajax({}) 	=> 비동기통신 [요청 보내고 응답을 기다리지 않음]		=> 양방향
							즉 요리를 먼저 주문했지만 커피주문이 먼저나오면 그것부터 답한다 
							
		2.$.ajax({ async : false }) : 동기통신 [웨이팅이 생긴다] 		=> 단방향
			
 -->
