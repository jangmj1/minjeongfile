console.log('gg')
function login(){
	console.log('apfhd')
	
	//1.입력받은값
	let mid=document.querySelector('.mid').value;
	let mpwd=document.querySelector('.mpwd').value;
	
	//2.
	$.ajax({
		url:"/jspweb/login",
		method:"post",
		data:{"mid":mid,"mpwd":mpwd} ,
		success:(r)=>{
			
			console.log('성공');
			console.log(r);
			//만약에 로그인을 성공했으면
			if(r=='true'){
				location.href="/jspweb/index.jsp"
			}else{
				
				document.querySelector('.checkconfirm').innerHTML='회원정보가 다릅니다'
			}
		}
		
	})
	
	
}

//아이디찾기
function findid(){
	let memail=document.querySelector('.memail').value;
	
	$.ajax({ //2.ajax 에게 보내서 결과 받기
		url:"/jspweb/find",
		method:"get",
			//"type":1 아이디찾기/ "type":2 비밀번호찾기
		data:{"type":1, "memail":memail} ,
		success:(r)=>{
			
			console.log('통신');
			console.log(r);
			//만약에 아이디찾기를 성공했으면
			if(r=='false'){
				document.querySelector('.checkconfirm').innerHTML='없는 회원 입니다'
			}else{
				document.querySelector('.checkconfirm').innerHTML= '회원님의 아이디 :'+ r
				
			}
		}
	})
		
}
//비밀번호찾기
function findpwd(){
	console.log('비번')
	let info={
	type:2,	
	 memail:document.querySelector('.memail').value,
	 mid:document.querySelector('.mid').value
	
	}
	$.ajax({ //2.ajax 에게 보내서 결과 받기
		url:"/jspweb/find",
		method:"get",
			//"type":1 아이디찾기/ "type":2 비밀번호찾기
		data:info ,
		success:(r)=>{
			
			console.log('통신');
			console.log(r);
			//만약에 아이디찾기를 성공했으면
			if(r=='false'){
				document.querySelector('.checkconfirm').innerHTML='없는 회원 입니다'
			}else{
				document.querySelector('.checkconfirm').innerHTML= '임시 비밀번호를 이메일로 전송 하였습니다:'
				
			}
		}
	})
		
}




















