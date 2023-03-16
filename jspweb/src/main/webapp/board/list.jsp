<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<h3 class="cname"></h3>
		<a href="write.jsp">글쓰기</a>
		
		<button onclick="setsearch()" type="button">전체보기[검색제거]</button>
		<div class="seachcount"> </div>
		<select onchange="setlistsize()" class="listsize">
				 <!--onchange=setlistsize() -> 옵션들이 변경 될때마다 발생하는 함수 -->
			<option>3</option>
			<option>5</option>
			<option>10</option>
		</select>
		
				
		<table class="boardTable table table-hover">
			
		</table>
		
		<!-- 페이징 처리 버튼 -->
		<div class="pagebox">
			
		</div>
		
		<!-- 검색창 -->
		<div>
			<select class="key"> 
			<!-- select 시 사용되는 조건의 필드명 : selet*from board where 어쩌고-->
				<option value="b.btitle">제목</option>
				<option value="b.bcontent">내용</option>
				<option value="m.mid">글쓴이</option>
			</select>
			
			<input class="keyword" type="text">
			<button onclick="getsearch1()" type="button">검색</button>
		</div>
		
	</div>
	
	<script src="/jspweb/js/board/list.js" type="text/javascript"></script>
</body>
</html>