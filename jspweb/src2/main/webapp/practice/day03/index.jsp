<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>예제1 : http 메소드</h3>
	<button onclick="doPost()" type="button">post 메소드</button>
	<button onclick="doGet()" type="button" >get 메소드</button>
	<button onclick="doPut()" type="button">put 메소드</button>
	<button onclick="doDelete()" type="button">delete 메소드</button>
	
	<h3>예제 2 : 방문록 </h3>
	내용 : <input type="text" class="content"> <br/>
	작성자 : <input type="text" class="writer"> <br/>
	<button onclick="onWrite()" type="button">방문록 등록</button>
	
	<h3>예제2 : 출력</h3>
	<table class="boardtable" border="1">
	
	</table>
	
	<h3>과제1 : 제품등록 </h3>
	제품명:<input type="text" class="product"><br/>
	가격:<input type="text" class="price">
	
	<button onclick="등록()">제품등록</button>

	<h3>과제1 : 제품출력</h3>
	<table class="pprint" border="1">
	
	</table>

	
	<!-- JQUERY(ajax사용하기위해) -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 사용자 -->
	<script src="index.js" type="text/javascript"></script>





</body>
</html>