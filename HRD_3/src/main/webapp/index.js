function vote(){
	let f=document.voteForm;
	if(f.v_jumin.value==""){alert("주민번호가 입력되지않았습니다.");f.v_jumin.focus();return false}
	if(f.v_name.value==""){alert("성명이 입력되지않았습니다.");f.v_name.focus();return false}
	if(f.m_no.value==""){alert("후보가 선택되지 않았습니다.");f.m_no.focus();return false}
	if(f.v_time.value==""){alert("투표시간이 입력되지않았습니다.");f.v_time.focus();return false}
	if(f.v_area.value==""){alert("투표장소가 입력되지않았습니다.");f.v_area.focus();return false}
	if(f.v_confirm.value==""){alert("유권자 확인이 선택되지않았습니다.");f.v_confirm.focus();return false}
	console.log('성공')
	f.submit();
	
}

function voteReset(){
	
	alert('정보를 지우고 처음부터 다시 입력합니다!')
	let f=document.voteForm;
	f.reset();
	f.v_jumin.focus();
}