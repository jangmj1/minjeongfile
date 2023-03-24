<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height:100%;">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="height:100%;">
	<%@ include file = "/header.jsp" %> <!-- header 를 같이 연것 jsp 페이지 포함 -->
	<!-- 모달창 -->
	<div style="position: fixed;left: 10px;top: 40%; z-index:999;
		 width: 100px; height: 100px; background-color: white;">
		검색창
	</div>
	
	
	<div style="display: flex;width: 100%;height: 80%;">
		<div id="map" style="width:80%;height:80%;"></div>
		<div class="productlistbox" style="width: 20%">
			
		</div>
	</div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=302a2d5c43d29cb22e0d5d10d6434665&libraries=clusterer"></script>
	<script src="/jspweb/js/index.js" type="text/javascript"></script>
</body>
</html>