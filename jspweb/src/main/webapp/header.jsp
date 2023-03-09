<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/index.css">


</head>
<body>
	<h3> 헤더입니다.</h3>
	<!--  js 로 할경우 -->
	<div class="header">
		<!-- js들어갈 자리 -->
	</div>
	
	
	
	
	<!--  jsp 로 할경우 -->
	<!-- 모든 페이지 공통 메뉴 -->
<%-- 	<%String login= (String)request.getSession().getAttribute("login"); %>
	
	<a href="/jspweb/index.jsp">홈</a>
	<%
	if(login==null){//로그인 안한거 or 로그아웃한거
	%>	
		<a href="/jspweb/member/signup.jsp">회원가입</a>
		<a href="/jspweb/member/login.jsp">로그인</a> 
		<!--그냥 이대로 두면 < % % >이안은 자바라서 jsp가 못들어간다  --> 
	<%
	}else if(login.equals("admin")){
	%>
		관리자모드
		<a href="/jspweb/admin/info.jsp">관리자 페이지</a>
	<%	
	}else {
	%>
		<%=login%>님 안녕하세요?<br/>
		<a href="/jspweb/member/logout.jsp">로그아웃</a>
	<%	
	}
	%> --%>
	
	
	
	
	<!-- 모든 페이지 공통 js -->
	<!-- jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<script src="/jspweb/js/header.js" type="text/javascript"></script>
</body>
</html>