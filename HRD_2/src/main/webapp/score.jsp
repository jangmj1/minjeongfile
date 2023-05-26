<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<center>
	<h3>성적입력</h3>
	<form name="addForm" action="/HRD_2/add" method="post">
		<table border="1" style="border-collapse: collapse;" >
			<tr><th>학번</th><th><input type="text" 	 name="sno"   class="sno"></th></tr>
			<tr><th>국어점수</th><th><input type="text" name="ekor"  class="ekor"></th></tr>
			<tr><th>수학점수</th><th><input type="text" name="emath" class="emath"></th></tr>
			<tr><th>영어점수</th><th><input type="text" name="eeng"  class="eeng"></th></tr>
			<tr><th>역사점수</th><th><input type="text" name="ehist" class="ehist"></th></tr>
			<tr>
				<td colspan="2">
					<center><button type="button" onclick="add()">등록하기</button></center>
				</td>
			</tr>
		</table>
	</form>
</center>
<%@ include file="footer.jsp" %>


<script type="text/javascript" src="index.js"></script>
</body>
</html>