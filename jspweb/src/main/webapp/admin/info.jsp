<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/header.jsp" %>
	<h3>모든 회원 명단</h3>
	<div class="mlist">
		<table class="mlistTable" border="1">
			
		</table>
		
		<div class="btnbox">
			
		</div>
		
		<div>
			<select class="key">
				<option value="mno">번호</option>
				<option value="mid">아이디</option>
				<option value="memail">이메일</option>
			</select>
			<input class="keyword" type="text">
			<button onclick="fildmember()" type="button">검색</button>
		</div>
		
	</div>
<script src="/jspweb/js/admin/info.js" type="text/javascript"></script>
</body>
</html>