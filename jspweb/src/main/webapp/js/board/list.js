
console.log('gg111')
/*
	게시물 출력할때 사용하는 page 오브젝트를 하나만들자 
		페이지,검색,타입 보관된 객체 
*/
let pageObject = {
	page:1,
	key:"",
	keyword:"",
	type:1,
	cno:document.querySelector('.cno').value,//카테고리 번호
	listsize:3
	
}
//카테고리 제목 넣어주기
let cnamehtml='';
if(pageObject.cno==1){cnamehtml='공지사항';}
if(pageObject.cno==2){cnamehtml='커뮤니티';}
if(pageObject.cno==3){cnamehtml='QnA';}
if(pageObject.cno==4){cnamehtml='노하우';}
document.querySelector('.cname').innerHTML=cnamehtml;


getBoardlist(1);//js열릴떄 페이지 1 기본값 설정
function getBoardlist(page){ //출력함수
	//해당 함수로 부터 페이징 번호 받기 = page
	console.log(page)
	pageObject.page=page;
	console.log(pageObject)
	$.ajax({
		url:"/jspweb/board/info",
		method:"get",
		data:pageObject,//1이면 전체출력 2면 개별출력
		success:(r)=>{
			console.log('통신 ㄱㄱ')
			console.log("r은 무엇이 넘어올까요?:",r)//pagedto{} 가 넘어온다 
			//-------------------테이블출력------------------------/
			let html=
			`<tr>
				<th>번호</th><th>제목</th>
				<th>작성자</th><th>작성일</th>
				<th>조회수</th><th>좋아요</th>
				<th>싫어요</th>
			</tr>`
			
	 	 //r: { 안에 [] 가 있는 형태} forEach는 []ArrayList 형태일경우만 돌린다 그래서 r에서 []인boarList를 끄집어내서 forEach를 돌리자 
	 	 	//!! : boarList를 아는 방법은 콘솔창에서 확인가능 dto값과 동일 (r.result x)
			r.boarList.forEach( (o,i)=>{//포문시작
			html+=
				`<tr>
					<td>${o.bno}</td><td><a href="/jspweb/board/view.jsp?bno=${o.bno}"> ${o.btitle} </a></td>
					<td>${o.mid}</td><td>${o.bdate}</td>
					<td>${o.bview}</td><td>${o.bup}</td>
					<td>${o.bdown}</td>
				</tr>`
			})//포문끝
			
			document.querySelector('.boardTable').innerHTML=html; //html넣고 밑에 html로 이동
			
			//------------------페이징 버튼 출력-------------------------------
			html='';//html비우기
			//현재 1보다 같거나 작으면 -1페이지는 없으니 이전 페이지 없음!!
			
			//이번버튼
			html+= page<=1? //3항 연산자를 사용하여 이전 버튼을 제어좀하자 
				`<button onclick="getBoardlist(${page})" type="button">이전</button>
				`:
				`<button onclick="getBoardlist(${page-1})" type="button">이전</button>
				`
			//현재버튼
			for(let i=r.startbtn;i<=r.endbtn;i++) //시작버튼 번호 부터 마지막 버튼 번호까지 버튼 생성
			html+=
				`<button onclick="getBoardlist(${i})" type="button">${i}</button>
				`
			//다음[만약에 현재 페이지가 총 페이지 수 이상이면 다음페이지는 없음]	
			
			html+= page>r.totalpage?//3항 연산자를 사용하여 다음 버튼을 제어좀하자 
				`<button onclick="getBoardlist(${page})" type="button">다음</button>
				`:
				`<button onclick="getBoardlist(${page+1})" type="button">다음</button>
				`
			
				document.querySelector('.pagebox').innerHTML=html;
				
			//------------------------------게시물 수 출력-----------------------------------
			
			document.querySelector('.seachcount').innerHTML='총 게시물 수 :'+r.totalsize;
			
			
		}//success 끝
		
	})//ajax끝
}

//검색을 했을때 나오는 출력값
function getsearch1(){
	console.log('하하')
	let key=document.querySelector('.key').value;
	let keyword=document.querySelector('.keyword').value;
	console.log(key,keyword)
	//*입력받은 데이터를 전역변수 pageObject 안에 값에 넣어주자
	pageObject.key=key; 
	pageObject.keyword=keyword;
	
	//*게시물 리스트 호출
	getBoardlist(1); // ??
	
}

//다시 전체출력으로 바꾸기(키와 키워드를 없애서 재호출)
function setsearch(){
	console.log('풀려라')
	pageObject.key='';
	pageObject.keyword='';
	getBoardlist(1);
}

//4. 화면에 표시할 게시물 변경 함수
function setlistsize(){
	let listsize=document.querySelector('.listsize').value; // 셀렉트에서 선택된 값을 변수에담기
	console.log(listsize);
	
	pageObject.listsize=listsize //담은 변수를 전역변수로 빼놓은 pageObject.listsize 에 담기
	
	getBoardlist(1);//재호출
	
}



/*
	1.클릭한 pk[식별자] 이동하는 경우의수
		1.http get 메소드 방식의 a태그를 이용한 pk이동 (보안이 필요없는경우사용 / a테그를 써서 페이지를 전환하면 성공r값이 다 사라지기때문에 a테그에 pk가져가는 방법) 
		-그냥 a테그 썼을때 : <a href="/jspweb/board/view.jsp> ${o.btitle} </a> ---------------> 제목을 클릭해을때 해당페이지로 이동
		-추가 a테그에 변수를 넘길때 : <a href="/jspweb/board/view.jsp?bno=${o.bno}"> ${o.btitle} </a>--->제목을 클릭했을때 해당페이지로 이동하면서 해당넘버까지 가져감
			=>맨 마지막에 물음표를 넣어서 가져가길 원하는 값을 넣는다 
		
*/













