<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link href="/jspweb/Nibo/css/nibo.css" rel="stylesheet">
	
</head>
<body>
	
		<div class="nibo">
			<h3>Nice body</h3>
			<button onclick="mybody()">시 작 하 기</button>
			
		</div>
		<!-- 모달만들자 -->
		<div class="modal_wrap">
			<div class="modal_box">
				<h3 class="modal_title">bodycheck!</h3>
				
				<div class="bodycheck" >
					<div>
						<div>날짜</div>
						<input class="today" type="date">
					</div>
					<div>
						<div>키</div>
						<input class="height"  type="text">cm
					</div>
					<div>
						<div>몸무게</div>
						<input class="weight" type="text">kg
					</div>
					<div>
						<div>오늘한운동</div>
						<select class="exercise">
							<option value="1">운동안함</option>
							<option value="2">계단오르기</option>
							<option value="3">요가</option>
							<option value="4">수영</option>
							<option value="5">줄넘기</option>
							<option value="6">자전거</option>
							<option value="7">런닝머신</option>
						</select>
					</div>
				</div>
				
				
				<div class="modalBtn">
					<button onclick="bodycheck()" class="modal_check" type="button">확인</button>
					<button onclick="closeModal()" class="modal_cencel" type="button">취소</button>
				</div>
			
			</div>
		
		</div>
	

	<!-- jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script> <!-- 아작트 쓰기위한용도 -->
	
	<!-- 사용자 js -->
	<script src="/jspweb/Nibo/js/nibo.js" type="text/javascript"></script>
</body>
</html>