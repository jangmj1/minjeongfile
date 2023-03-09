<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		//모든 세션 지우기 invalidate[초기화] : 일반적으로 잘안씀
		//request.getSession().invalidate(); 
		//특정 세션 지우기[동일한 이름으로 null 대입 즉 초기화]
		request.getSession().setAttribute("login", null);
	%>


	<script type="text/javascript">
		location.href="/jspweb/index.jsp"
	</script>
</body>
</html>