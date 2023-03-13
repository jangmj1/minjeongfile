
if(memberInfo.mid==null){
	alert('로그인하고오세요');
	location.href="/jspweb/member/login.jsp"
}

document.querySelector('.mid').innderinnerHTML=memberInfo.mid;
document.querySelector('.memail').value=memberInfo.memail;
document.querySelector('.mimg').src=`/jspweb/member/pimg/${ memberInfo.mimg == null ? 'default.webp':memberInfo.mimg }`

function setUpdate(){
	//첨부파일이 있을때
	
	let updateForm = document.querySelectorAll('.updateForm')[0];
	let updateFormData = new FormData(updateForm);
	//3. 폼에 데이터 추가
		//1.체크박스 체크여부 확인
	let defaultimg=document.querySelector('.defaultimg').checked; //체크가 되어있으면 트루를 반환시킨다 체크가 되어있으면 트루 체크안되어있으면 펄스를 반환
	updateFormData.set("defaultimg",defaultimg)	;
	
	$.ajax({
		url:"/jspweb/member",
		method:"put",
		data:updateFormData,
		contentType : false,
		processData : false,
		success:(r)=>{
			console.log('통신성공'); console.log(r);
			if(r=='true'){
				alert('수정성동 : 다시로그인');
				location.href="/jspweb/member/logout.jsp"
			}else{
				alert('수정실패 : 기존 비밀번호가 틀립니다.');
				
			}
		}
	})
	
}


/*function setUpdate(){
	첨부파일이 없을때
	let info={
		'mpwd': document.querySelector('.mpwd').value,
		'newpwd':document.querySelector('.newpwd').value,
		'memail':document.querySelector('.memail').value
	}
	
	$.ajax({
		url:"/jspweb/member",
		method:"put",
		data:info,
		success:(r)=>{
			console.log('통신성공'); console.log(r);
		}
	})
}*/


