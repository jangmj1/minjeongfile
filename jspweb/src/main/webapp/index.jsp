<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body >
	<%@ include file = "/header.jsp" %> <!-- header 를 같이 연것 jsp 페이지 포함 -->
	<!-- 모달창 -->
	<div class="searchbox">
		검색창
	</div>
	
	
	<div class="contentbox">
		<div id="map" style="width:70%;height:100%;"></div>
		<div class="productlistbox">
			
		
			
		</div>
	</div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=302a2d5c43d29cb22e0d5d10d6434665&libraries=clusterer"></script>
	<script src="/jspweb/js/index.js" type="text/javascript"></script>
</body>
</html>