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
	<div class="container chattingwrap" >
		
		<div class="connectlistbox"><!-- 접속명단 표시구역 -->
			
			
		</div>
	
		<div class="cattingbox"> <!-- 채팅구역 -->
			<div>
				<div class="contentbox"><!-- 채팅창 -->
					
					
				</div>
				
				<!-- 부트스트립 -->
				<textarea onkeyup="enterkey()" class="msgbox" rows="" cols=""></textarea>
				
				<div class="cattingbtnbox">
					
					
					<!-- 
						bs:드롭다운
							클릭위치 : data-bs-toggle="dropdown"
							표시구역 :	 class="dropdown-menu"
							클릭위치버튼을 누르면 표시구역이 보여짐 처음에는 숨겨져있음
					 -->
					<!-- 드롭다운 버튼으로 사용할예정 부트스트랩 사용할꺼임-->
					<button class="emobtn" type="button" data-bs-toggle="dropdown">
						<i class="far fa-smile"></i>
					</button>
					<!-- 드롭버튼 클릭시 보이는 구역 -->
					<div class="dropdown-menu emolist"> 
						
					</div>
					
					
					<button  onclick="보내기()" class="sendbtn" type="button">보내기</button>
				</div>
				
			</div>
		
		</div>
	
	
	</div>	
		

	<script src="/jspweb/js/board/chatting.js" type="text/javascript"></script>
</body>
</html>