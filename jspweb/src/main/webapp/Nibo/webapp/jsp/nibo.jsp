<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	
</head>
<body>
	<div>
		<h3>Nice body</h3>
		
		
		<button onclick="mybody()">����ϱ�</button>
		
		
	
		
	</div>
	<!-- ��޸����� -->
	<div class="modal_wrap">
		<div class="modal_box">
			<h3 class="modal_title">bodycheck!</h3>
			<div>
				<div>��¥</div>
				<input class="today" type="date">
			</div>
			<div>
				<div>Ű</div>
				<input class="height"  type="text">cm
			</div>
			<div>
				<div>������</div>
				<input class="weight" type="text">kg
			</div>
			<div>
				<div>�����ѿ</div>
				<select class="exercise">
					<option>�����</option>
					<option>��ܿ�����</option>
					<option>�䰡</option>
					<option>����</option>
					<option>�ٳѱ�</option>
					<option>������</option>
					<option>���׸ӽ�</option>
				</select>
			</div>
			
			
			<div class="modalBtn">
				<button onclick="insert()" class="modal_check" type="button">Ȯ��</button>
				<button onclick="closeModal()" class="modal_cencel" type="button">���</button>
			</div>
		
		</div>
	
	</div>

	<!-- jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script> <!-- ����Ʈ �������ѿ뵵 -->
	
	<!-- ����� css -->
	<script src="/jspweb/Nibo/js/nibo.js" type="text/javascript"></script>
</body>
</html>