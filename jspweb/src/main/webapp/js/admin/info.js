
let mlistpage={
	page:1,
	key:"",
	keyword:"",
	type:1,
	listsize:3
}

getMemberList(1);
function getMemberList(page){
	console.log(page)
	mlistpage.page=page;
	$.ajax({
		
	url:"/jspweb/member",
	method:"get",
	data:mlistpage,
	success:(r)=>{
		console.log('cnffur')
		console.log(r)
		
		let html=	
			`<tr>
			<th width="5%">번호</th>
			<th width="5%">프로필</th>
			<th width="10%">아이디</th>
			<th width="10%">이메일 주소</th>
			<th width="10%">비고</th>
		</tr>`
		r.memberList.forEach((o,i)=>{
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

//-------------------------페이징 처리-----------------------------------
		html='';
		
		html+=//이전으로 가는 페이지 버튼
			page<=1?
			`
			<button onclick="getMemberList(1)" type="button">이전</button>
			`:`
			<button onclick="getMemberList(${page-1})" type="button">이전</button>
			`
		
		for(let i=r.startbtn;i<=r.endbtn;i++)
			
		{html+=
			`<button onclick="getMemberList(${i})" type="button">${i}</button>
			`}
			
		html+=//다음으로 가는 페이지 버튼
			page>=r.endbtn?
			`
			<button onclick="getMemberList(${r.endbtn})" type="button">다음</button>
			`:`
			<button onclick="getMemberList(${page+1})" type="button">다음</button>
			`
		
		
		
		
		
		document.querySelector('.btnbox').innerHTML=html;
		
		
		
		}
	})
}



//key와  keyword값으로 맴버 검색하기
function fildmember(){
	
	mlistpage.type=2;
	console.log('ckwwk')
	let key=document.querySelector('.key').value;
	let keyword=document.querySelector('.keyword').value;
	mlistpage.key=key;
	mlistpage.keyword=keyword;
	
	console.log("키와키워드",key,keyword)
	getMemberList(1);
	
}


















