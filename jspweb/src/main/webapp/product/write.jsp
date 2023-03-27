<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
	<style type="text/css">
		.fileDrop{width: 600px; height: 200px; overflow: auto; border: 1px solid red;}
			/* overflow: auto => 처음에는 안보이다가 넘어가면 스크롤이 자동으로 생긴다*/
		
	
	</style>

</head>
<body>
	<%@include file="/header.jsp" %>
	
	<div class="container">
		<form class="writeForm">
			제품명:<input type="text" name="pname">		<br/>
			제품설명:<input type="text" name="pcomment">	<br/>
			제품가격:<input type="text" name="pprice">		<br/>
			위치: <!-- 폼으로 전송불가 -->
				<div id="map" style="width:100%;height:350px;"></div>
				
				<!-- 첨부파일 여러개2 -->
				<!-- <h5>첨부파일 여러개2[multiple/cos.jar불가 commons 가능]</h5>
				<input type="file" multiple="multiple" accept="image/*" name="pfiles"> -->
				
				<!-- 드래그앤드랍(을쓰기위해서 multiple 써야함) -->
				<div class="fileDrop">
					[드래그앤드랍]여기에 첨부파일을 넣어주세요.
				</div>
				
				
				
				<button type="button" onclick="onwrite()">제품등록</button>
			<!-- 
			첨부파일 한개
				<h5>첨부파일 한개</h5>
				<input type="file" name="pfile" accept="image/*">
			
			첨부파일 여러개1
				<h5>첨부파일 여러개1[서로다른 file input /multiple cos.jar 불가능]</h5>
				<input type="file" name="pfile1" accept="image/*">
				<input type="file" name="pfile2" accept="audio/*">
				<input type="file" name="pfile3" accept="video/*"> -->
			
			
			
		</form>
	
	</div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=302a2d5c43d29cb22e0d5d10d6434665"></script>

<script src="/jspweb/js/product/write.js" type="text/javascript"></script>
</body>
</html>