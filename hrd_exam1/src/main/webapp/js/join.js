console.log('열림');

function join(){
	if(document.joinform.custno.value==""){
		alert('custno 입력해주세요')
		document.joinform.custno.focus();
		return false;
	}
	if(document.joinform.custname.value==""){
		alert('회원성명을 입력해주세요')
		document.joinform.custname.focus();
		return false;
	}
	if(document.joinform.phone.value==""){
		alert('전화번호를 입력해주세요')
		document.joinform.phone.focus();
		return false;
	}
	if(document.joinform.address.value==""){
		alert('주소를 입력해주세요')
		document.joinform.address.focus();
		return false;
	}
	if(document.joinform.joindate.value==""){
		alert('날짜를 입력해주세요')
		document.joinform.joindate.focus();
		return false;
	}
	if(document.joinform.grade.value==""){
		alert('등급을 입력해주세요')
		document.joinform.grade.focus();
		return false;
	}
	if(document.joinform.city.value==""){
		alert('도시코드를 입력해주세요')
		document.joinform.city.focus();
		return false;
	}
	alert('회원등록이 완료 되었습니다.')
	document.joinform.submit();
	alert('회원등록이 되었습니다.')
}















