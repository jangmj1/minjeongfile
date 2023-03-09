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
			}else{alert('회원정보가 다릅니다.')}
		}
		
	})
	
	
}