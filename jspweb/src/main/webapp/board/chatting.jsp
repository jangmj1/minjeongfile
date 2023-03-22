<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/chatting.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/header.jsp"  %>
	<div class="container">
	
		<div class="cattingbox"> <!-- 채팅구역 -->
			<div>
				<div class="contentbox"><!-- 채팅창 -->
					
					
				</div>
				
				<!-- 부트스트립 -->
				<textarea onkeyup="enterkey()" class="msgbox" rows="" cols=""></textarea>
				
				<div class="cattingbtnbox">
					<button  onclick="보내기()" class="sendbtn" type="button">보내기</button>
				</div>
				
			</div>
		
		</div>
	
	
	</div>	
		

	<script src="/jspweb/js/board/chatting.js" type="text/javascript"></script>
</body>
</html>