console.log('gg')
console.log(memberInfo) //header.js 에서 ajax 동기식으로 회원정보를 가져온 상태 
if(memberInfo.mid==null){
	alert('로그인하고오세요');
	location.href="/jspweb/member/login.jsp"
}
document.querySelector('.mid').innerHTML=memberInfo.mid;
document.querySelector('.memail').innerHTML=memberInfo.memail;
document.querySelector('.mimg').src=`/jspweb/member/pimg/${memberInfo.mimg==null?'default.webp':memberInfo.mimg}`
document.querySelector('.mpoint').innerHTML=memberInfo.mpoint;



//1.회원탈퇴
function setDelete(){
		console.log('탈퇴탈퇴')
		
		
		
		$.ajax({
			url:"/jspweb/member",
			method:"delete",
			data:{"mpwd":document.querySelector('.mpwd').value},
			success: (r)=>{
				console.log('통신'); console.log(r);
				if(r=='true'){
					alert('회원탈퇴성공');
					location.href="/jspweb/index.jsp";
				}else{
					alert('회원탈퇴실패 관리자에게 문의')
				}
			}
			
			
		})
}

//2.회원수정
function setUpdate(){
	console.log('회원수정!');
	
}
