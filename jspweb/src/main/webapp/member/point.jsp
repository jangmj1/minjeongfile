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
	
	<div>
		<button onclick="setpay(10000)" type="button">10000원</button>
		<button onclick="setpay(5000)" type="button">5000원</button>
		<br>
		<button onclick="requestPay()" type="button">결제하기</button>
		
		<h3>본인이증</h3>
	</div>
	

<!-- 포트원결제 -->-
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.4.js"></script>

<script src="/jspweb/js/member/point.js" type="text/javascript"></script>
</body>
</html>