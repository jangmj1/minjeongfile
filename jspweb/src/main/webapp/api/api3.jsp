<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file="/header.jsp" %>
	
	<div id="map" style="width:100%;height:750px;"></div>
	
	<!-- 모달 HTML -->
			<div class="modal_wrap">
				<div class="modal_box">
					<h3 class="modal_title">
						<!-- 제목이 들어가는 자리  -->
					</h3>
					<div class="modal_content">
						<!-- 내용이 들어가는 자리  -->
					</div>
					<div class="modal_btn">
						<button class="modal_check" 	type="button">확인</button>
						<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button>
					</div>
				</div>
			</div>
	
			
<!-- 카카오지도에 필요한 클래스/메소드 가지고있는 js라이브러리 -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=302a2d5c43d29cb22e0d5d10d6434665&libraries=services,clusterer,drawing"></script>

<script src="/jspweb/js/api/api3.js" type="text/javascript"></script>

</body>
</html>