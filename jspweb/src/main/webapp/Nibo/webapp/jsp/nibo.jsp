<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	
</head>
<body>
	<div>
		<h3>Nice body</h3>
		
		
		<button onclick="mybody()">등록하기</button>
		
		
	
		
	</div>
	<!-- 모달만들자 -->
	<div class="modal_wrap">
		<div class="modal_box">
			<h3 class="modal_title">bodycheck!</h3>
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
					<option>운동안함</option>
					<option>계단오르기</option>
					<option>요가</option>
					<option>수영</option>
					<option>줄넘기</option>
					<option>자전거</option>
					<option>런닝머신</option>
				</select>
			</div>
			
			
			<div class="modalBtn">
				<button onclick="insert()" class="modal_check" type="button">확인</button>
				<button onclick="closeModal()" class="modal_cencel" type="button">취소</button>
			</div>
		
		</div>
	
	</div>

	<!-- jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script> <!-- 아작트 쓰기위한용도 -->
	
	<!-- 사용자 css -->
	<script src="/jspweb/Nibo/js/nibo.js" type="text/javascript"></script>
</body>
</html>