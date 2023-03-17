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
	
	<script type="text/javascript">
		if(memberInfo.mid==null){
			alert('회원제 기능입니다.로그인후 작성해주세요');
			location.href="/jspweb/member/login.jsp" //js 는 페이지 전환하는게 location !!! 참고로 jsp는 a테그!!
		}
	</script> <!-- 이걸 여기다가 먼저 써주는이유는 보통 html이 실행되고 scr이 실행되기 때문에  깜빡거린다 -->
	
	<%
		//1.로그인 여부 제어
			 Object o = request.getSession().getAttribute("login");
		if(o==null) {
			response.sendRedirect("/jspweb/member/login.jsp"); //서블릿은 페이지 전환하는게  response.sendRedirect!!
		}
		
		//2.http url안에 있는 매개변수  bno호출
		String bno= request.getParameter("bno");
		
	%>
	
	<input type="hidden" class="bno" value="<%=bno%>">
	<div class="container">
		<h3>글수정</h3>
		
		<form class="updateForm"> 
			<div>
				카테고리:
				 <select name="cno" class="cno">
					<option value="1">공지사항</option>
					<option value="2">커뮤니티</option>
					<option value="3">QnA</option>
					<option value="4">노하우</option>
				</select>
			</div>
			<div>
				제목:<input name="btitle" class="btitle" type="text">
			</div>
			<div>
				내용:<textarea name="bcontent" class="bcontent" rows="3" cols="3"></textarea>
			</div>
			<div class="bfilebox">
				
			</div>
			<button onclick="bupdate()" type="button">수정</button>
		</form>
	
	<!-- 
		html의 유일한 전송기능 : form!! js를 통해서 가는게아님[동기식 : 페이지 전환이 있어야함!]
		<form action="통신할url" method="http메소드">
			1.enctype="application/x-www-form-urlencoded" : 기본 폼 전송타입
			2.enctype="mutipart/form-data"
		- 주의! form 태그 안에 있는 <button> type 생략시 type="submit"(폼 보내기)
			  form 태그 안에 있는 <button type "button"> js쓸꺼면 꼭 타입 버튼으로 넣기
		
		vs
		
		js--- > ajax[비동기식 , 동기식 두가지 다 가능함]
	 -->
	 
	 <script src="/jspweb/js/board/update.js" type="text/javascript"></script>
	</div>
</body>
</html>