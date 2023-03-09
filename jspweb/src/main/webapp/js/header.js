//로그인한 회원정보 호출
 getlogin();
function getlogin(){
	
	$.ajax({
		url:"/jspweb/login",
		method:"get",
		success:(r)=>{
			console.log('통신성공');
			console.log(r) // r={mno,mid , mimg , memail 들어가있다} 1객체
					
			let html='';
			if(r.mid==null){
				html+=`<a href="/jspweb/member/signup.jsp">회원가입</a>`
				html+=`<a href="/jspweb/member/login.jsp">로그인</a> `
				
			}else{
				if(r.mid=='admin'){
				html+=`<a href="/jspweb/admin/info.jsp">관리자 페이지</a>`
				}
				html+=`<img class="hpimg" src=/jspweb/member/pimg/${r.mimg==null? 'default.webp' : r.ming}>`
				html+=`${r.mid}님 안녕하세요?<br/>`
				html+=`<a href="/jspweb/member/logout.jsp">로그아웃</a> `
			}
			console.log(html)
			document.querySelector('.header').innerHTML=html
		}
	})
}