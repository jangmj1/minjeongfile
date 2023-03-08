
getMemberList();
function getMemberList(){
	
	$.ajax({
		
	url:"/jspweb/member",
	method:"get",
	success:(r)=>{
		console.log('cnffur')
		console.log(r)
		
		let html=	
			`<tr>
			<th width="10%">번호</th>
			<th width="10%">프로필</th>
			<th width="10%">아이디</th>
			<th width="10%">이메일 주소</th>
			<th width="10%">비고</th>
		</tr>`
		r.forEach((o,i)=>{
		//3항 연산자를 사용하여 만약에 사진값을 없으면(null) 디폴트 사진 null이 아니면 선택이미지
		html+=
				`<tr>
			<td>${o.mno}</td>				
			<td><img src="/jspweb/member/pimg/${o.mimg==null?'default.webp':o.mimg}"width="100%" ></td> 
			<td>${o.mid}</td>					
			<td>${o.memail}</td>
			<td></td>
		</tr>`
		} )
		
		document.querySelector('.mlistTable').innerHTML=html;
		
		
		}
	})
}