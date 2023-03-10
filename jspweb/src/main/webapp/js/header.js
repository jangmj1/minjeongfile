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
			if(r==null){
				html+=`<a href="/jspweb/member/signup.jsp">회원가입</a>`
				html+=`<a href="/jspweb/member/login.jsp">로그인</a> `
				
			}else{ // 로그인 했으면
				html+=
				`
				<div class="dropdown">
				  <button class="hpimghtn" type="button" data-bs-toggle="dropdown" >
				  	<img class="hpimg"  src="/jspweb/member/pimg/default.webp">
				  </button>
				  <ul class="dropdown-menu">
					<li><a class="dropdown-item" href="#"> 내프로필</a></li>
					<li><a class="dropdown-item" href="#"> 친구목록</a></li>
					<li><a class="dropdown-item" href="/jspweb/member/logout.jsp"> 로그아웃</a></li>
				  </ul>
				</div>
						
				${r.mid}님
				<a href="#">쪽지함</a>
				<a href="#">포인트</a>`
					
				
				if(r.mid=='admin'){ //근데 로그인 한 사람이 아이디가 어드민이면 즉 관리자이면
				html+=`<a href="/jspweb/admin/info.jsp">관리자 페이지</a>`
				}
				
			}
			console.log(html)
			document.querySelector('.submenu').innerHTML=html
		}
	})
}

