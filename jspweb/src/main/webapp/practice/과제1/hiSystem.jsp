<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="/jspweb/practice/과제1/modal.css" rel="stylesheet">
</head>
<body>
	<h3>인사관리 시스템</h3>
	<div class="hienter">
		<h4>직원등록</h4>
		<form class="memberForm">
			사원명:<input class="mname" name="mname" type="text">	<br/>
			직급:<select class="mrank" name="mrank">
					<option>사원</option>
					<option>대리</option>
					<option>과장</option>
					<option>부장</option>
					<option>대표</option>
				</select><br/>
			고용형태:<select class="employment" name="employment">
					<option>일용직</option>
					<option>정규직</option>
					<option>임원</option>		
				</select><br/>
			부서:<select class="division" name="division">
					<option>인사팀</option>
					<option>영업팀</option>
					<option>개발팀</option>		
				</select><br/>
			입사일:<input class="idate" name="idate" type="date"><br/>
			사원사진:<input class="mimg" name="mimg" type="file"><br/>
			퇴사일:<input class="edate" name="edate" type="date"><br/>
			퇴사사유:<textarea class="resign" name="resign"></textarea><br/>
			
			<div>
				<button type="button" onclick="signup()">등록</button>
			</div>
		</form>
		
		
	</div>
	<div  class="hiprint">
		<h4 >직원출력</h4>
		<div>
			<table class="box" border="1">
			
			</table>
		</div>
	
	</div>
	
	
	<div class="modal_wrap">
		<div class="modal_box">
			<form class="newinfo">
			
				사원사진:<input class="newmimg" name="newmimg" type="file"><br/>
				사원명:<input class="newmname" name="newmname" type="text"><br/>
				직급:
					<select class="newmrank" name="newmrank">
						<option>사원</option>
						<option>대리</option>
						<option>과장</option>
						<option>부장</option>
						<option>대표</option>
					</select><br/>
				
				고용형태:
					<select class="newemployment" name="newemployment">
						<option>일용직</option>
						<option>정규직</option>
						<option>임원</option>		
					</select><br/>
				
				부서:
					<select class="newdivision" name="newdivision">
						<option>인사팀</option>
						<option>영업팀</option>
						<option>개발팀</option>		
					</select><br/>
				입사일:<input class="newidate" name="newidate" type="date"><br/>
				퇴사일:<input class="newedate" name="newedate" type="date"><br/>
				퇴사사유:<textarea class="newresign" name="newresign"></textarea><br/>
			</form>
			<div class="btn">
				<button onclick="newupdate()" type="button">확인</button>
				<button onclick="cancel()" type="button">닫기</button>
			</div>
		</div>
	</div>
	
	<div class="cmodal">
		<div class="cmodal_box">
			<h3>직원 삭제</h3>
			사원번호:<input class="del_no" type="text">
			<div class="btn">
				<button onclick="del_modal()" type="button">확인</button>
				<button onclick="cancel()" type="button">삭제취소</button>
			</div>
		</div>
	</div>
	
	<!-- jquery -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 부트스트랩 -->
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	
	<!-- 사용자 -->
	<script src="hiSystem.js" type="text/javascript"></script>
	
	
</body>
</html>