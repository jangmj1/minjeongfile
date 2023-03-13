//로그인한 회원정보 호출
let memberInfo=null;
 getlogin();
function getlogin(){
	
	$.ajax({
		url:"/jspweb/login",
		async:false, //동기 통신 =>웨이팅이생긴다 header.jsp 가 먼저 열리면서 header.js가 먼저 실행후 info.js가 실행됨
		method:"get",
		success:(r)=>{
			memberInfo=r; // <---지역변수를 전역변수로 옮기기 왜? 다른 js에서 쓰려고 (info.js)
			console.log('통신성공');
			console.log(r) // r={mno,mid , mimg , memail 들어가있다} 1객체
					
			let html='';
			if(r.mid==null){
				html+=`<a href="/jspweb/member/signup.jsp">회원가입</a>`
				html+=`<a href="/jspweb/member/login.jsp">로그인</a> `
				
			}else{ // 로그인 했으면
				html+=
				`
				<div class="dropdown">
				  <button class="hpimghtn" type="button" data-bs-toggle="dropdown" >
				  	<img class="hpimg"  src="/jspweb/member/pimg/${r.mimg}">
				  </button>
				  <ul class="dropdown-menu">
					<li><a class="dropdown-item" href="/jspweb/member/info.jsp"> 내프로필</a></li>
					<li><a class="dropdown-item" href="#"> 친구목록</a></li>
					<li><a class="dropdown-item" href="/jspweb/member/logout.jsp"> 로그아웃</a></li>
				  </ul>
				</div>
						
				${r.mid}님
				<a href="#">쪽지함</a>
				<a href="${r.mpoint}">포인트</a>`
					
				
				if(r.mid=='admin'){ //근데 로그인 한 사람이 아이디가 어드민이면 즉 관리자이면
				html+=`<a href="/jspweb/admin/info.jsp">관리자 페이지</a>`
				}
				
			}
			console.log(html)
			document.querySelector('.submenu').innerHTML=html
		}
	})
}

