
console.log('gg111')
getBoardlist();
function getBoardlist(){
	$.ajax({
		url:"/jspweb/board/info",
		method:"get",
		data:{"type":1},//1이면 전체출력 2면 개별출력
		success:(r)=>{
			console.log('통신 ㄱㄱ')
			console.log(r)
			
			let html=
			`<tr>
				<th>번호</th><th>제목</th>
				<th>작성자</th><th>작성일</th>
				<th>조회수</th><th>좋아요</th>
				<th>싫어요</th>
			</tr>`
			
			r.forEach( (o,i)=>{
			html+=
				`<tr>
					<td>${o.bno}</td><td><a href="/jspweb/board/view.jsp?bno=${o.bno}"> ${o.btitle} </a></td>
					<td>${o.mid}</td><td>${o.bdate}</td>
					<td>${o.bview}</td><td>${o.bup}</td>
					<td>${o.bdown}</td>
				</tr>`
			})
			
			document.querySelector('.boardTable').innerHTML=html;
		}
		
	})
}

/*
	1.클릭한 pk[식별자] 이동하는 경우의수
		1.http get 메소드 방식의 a태그를 이용한 pk이동 (보안이 필요없는경우사용 / a테그를 써서 페이지를 전환하면 성공r값이 다 사라지기때문에 a테그에 pk가져가는 방법) 
		-그냥 a테그 썼을때 : <a href="/jspweb/board/view.jsp> ${o.btitle} </a> ---------------> 제목을 클릭해을때 해당페이지로 이동
		-추가 a테그에 변수를 넘길때 : <a href="/jspweb/board/view.jsp?bno=${o.bno}"> ${o.btitle} </a>--->제목을 클릭했을때 해당페이지로 이동하면서 해당넘버까지 가져감
			=>맨 마지막에 물음표를 넣어서 가져가길 원하는 값을 넣는다 
		
*/













