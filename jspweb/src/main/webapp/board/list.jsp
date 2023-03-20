<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/list.css" rel="stylesheet">
	
</head>
<body>
	<%@ include file="/header.jsp"  %>  <!-- a테그안에 cno 숨겨놈 -->

	 
	 <%
	 	//http get <a> 전달된 매개변수 가져오기
	 	String cno = request.getParameter("cno");
	 	
	 %>
	<!-- cno 숨겨서 js에게 연결 -->
	<input  type="hidden" class="cno" value="<%=cno%>">
	
	
	<div class="container">
		<div class="boardbox">
			<div class="boardtop">
				<h3 class="cname">공지사항</h3>
				<p>다양한 사람들과 정보를 공유해 보세요</p>
			</div>
			<div class="boardtopetc">
				<a href="write.jsp">
					<button class="bbtn" type="button"><i class="fas fa-pencil-alt"></i> 글쓰기</button>
				</a>
				<div>
					<span class="seachcount">게시물 수 : 6</span>
					<button onclick="setsearch()" class="bbtn" >전체보기</button>
					<select class="bbtn listsize" onchange="setlistsize()">
						<option>3</option>
						<option>5</option>
						<option>10</option>
					</select>
				</div>
			</div>
			
			
			<div class="boardTable">
			
			</div>
			
			<div class="boardbottom">
				<!-- 페이징 처리 버튼 -->
				<div class="pagebox">
					
				</div>
				
				<!-- 검색창 -->
				<div>
					<select class="key bbtn"> 
					<!-- select 시 사용되는 조건의 필드명 : selet*from board where 어쩌고-->
						<option value="b.btitle">제목</option>
						<option value="b.bcontent">내용</option>
						<option value="m.mid">글쓴이</option>
					</select>
					
					<input class="keyword" type="text">
					<button class="bbtn" onclick="getsearch1()" type="button">검색</button>
				</div>
			
			</div>
			
		
		</div>
	
	</div>
	
		
	<script src="/jspweb/js/board/list.js" type="text/javascript"></script> 
</body>
</html>