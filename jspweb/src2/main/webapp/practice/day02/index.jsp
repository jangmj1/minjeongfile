
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>예1) [c] html -->document.querySelector--> js -->ajax-->servlet-->메소드-->dao</h3>
	data1[문자열] 		: <input type="text" class="data1"><br/>
	data2[패스원드] 	: <input type="password" class="data2"><br/>
	data3[실수]		: <input type="text" class="data3"><br/>
	data4[정수]		: <input type="number" class="data4"><br/>
	data5[날짜]		: <input type="date" class="data5"><br/>
	data6[날짜/시간]	: <input type="datetime-local" class="data6"><br/>
	data7[선택상자]	: <input type="radio" name="data7" value="남">남
					  <input type="radio" name="data7" value="여">여<br/>
	data8[체크상자]	: <input type="checkbox" class="data8">승인<br/>
	data9[목록상자]	: <select class="data9">
						<option>안산</option> <option>수원</option> <option>성남</option>
						</select> <br/>
	data10[긴글]		:<textarea class="data10"></textarea><br/>
	
	<button type="button" onclick="ex1()">전송</button>
	
	
	<h3>예2) [r] dao -->메소드--> ajax--> servlet -->js-->document.querySelector-->html</h3>
	<div class="box"></div>
	
	
	<h3>과제1 [c]</h3>
	[이름]:<input type="text" class="data11"><br/>
	[전화번호]:<input type="text" class="data12"><br/>
	[키]:<input type="text" class="data13"><br/>
	[나이]:<input type="number" class="data14"><br/>
	[등록일]:<input type="date" class="data15"><br/>
	[성별]:<input type="radio" name="data16" value="남">남
				<input type="radio" name="data16" value="여">여<br/>
	[동의]:<input type="checkbox" class="data17">동의<br/>
	[지역]:<select class="data18">
					<option>안산</option><option>안양</option><option>수원</option>
				</select><br/>
	[소개]:<textarea class="data19"></textarea><br/>
	
	<button type="button" onclick="ex2()">등록</button>
	
	<h3>과제1[r]</h3>
	<div class="box_2">
	
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<!-- JQUERY(ajax사용하기위해) -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 사용자 정의 js -->
	<script src="index.js" type="text/javascript"></script>
</body>

</html>