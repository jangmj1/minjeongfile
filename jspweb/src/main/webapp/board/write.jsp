<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 썸머노트 : textarea -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
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
		 Object o = request.getSession().getAttribute("login");
	if(o==null) {
		response.sendRedirect("/jspweb/member/login.jsp"); //서블릿은 페이지 전환하는게  response.sendRedirect!!
	}
	%>
	
	
	<div class="container">
		<h3>글쓰기</h3>
		
		<form class="writeForm"> 
			카테고리:
			 <select name="cno" class="cno">
				<option value="1">공지사항</option>
				<option value="2">커뮤니티</option>
				<option value="3">QnA</option>
				<option value="4">노하우</option>
			</select><br>
			제목:<input name="btitle" type="text"><br>
			내용:<textarea  id="summernote" name="bcontent"></textarea>
			첨부파일<input name="bfile" type="file"><br>
			<button onclick="bwrite()" type="button">쓰기</button>
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
	
	<!-- 썸머노트 : textarea --> 
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	 
	 <!-- 사용자 정의 -->
	<script src="/jspweb/js/board/write.js" type="text/javascript"></script>
	</div>
</body>
</html>