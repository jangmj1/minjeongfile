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
	<% 
		// < % % > 이거 쓰면 java코드를 쓸수있다 jsp에서 가능함
		//a테그에 딸려온 bno값을 요청한다
		String bno= request.getParameter("bno");
	%>
	 <!-- java코드를 html출력하는 자리 -->
	
	<div class=" container">
		<h3> 게시물 개별 조회/보기 </h3>
		<div>
			<div>게시물번호:</div>
			<div class="bno"><%=bno%></div>
			
			<div>작성일/조회수/좋아요/싫어요:</div>
			<div class="infobox"></div>
			
			<div>작성자[프로필]:</div>
			<div class="pimgbox"></div>
			
			<div>제목:</div>
			<div class="btitle"></div>
			
			<div>내용:</div>
			<div class="bcontent"></div>
			
			<div>첨부파일:</div>
			<div class="bfile"></div>
		</div>
	</div>
	
	<script src="/jspweb/js/board/view.js" type="text/javascript"></script>
</body>
</html>