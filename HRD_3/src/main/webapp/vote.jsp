<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<center>
		<h3>투표하기</h3>
		<form name="voteForm" action="/HRD_3/vote" method="post">
			<table  border="1" style="border-collapse: collapse; width: 500px;">
				<tr><th>주민번호</th><th><input type="text" name="v_jumin"> 예:8906153154726</th></tr>
				<tr><th>성명</th><th><input type="text" name="v_name"> </th></tr>
				<tr><th>투표번호</th>
					<th><select name="m_no">
						<option></option>
						<option value="1">[1]김후보</option>
						<option value="1">[2]이후보</option>
						<option value="1">[3]박후보</option>
						<option value="1">[4]조후보</option>
						<option value="1">[5]최후보</option>
					</select></th>
				 </tr>
				 <tr><th>투표시간</th><th><input type="text" name="v_time" placeholder="예)030"> </th></tr>
				 <tr><th>투표장소</th><th><input type="text" name="v_area" placeholder="예)제1투표장"> </th></tr>
				 <tr><th>유권자확인</th>
				 <th>
					 <input type="radio" name="v_confirm" value="Y">확인
					 <input type="radio" name="v_confirm" value="N">미확인 </th></tr>
				 <tr>
				 	<td colspan="2">
				 		<center>
					 		<button type="button" onclick="vote()">투표하기</button>
					 		<button type="reset" onclick="voteReset()">다시하기</button>
				 		</center>
				 	</td>
				 </tr>
				 
				 
			</table>
		</form>
	</center>
	<%@include file="footer.jsp" %>

<script type="text/javascript" src="index.js"></script>
</body>
</html>