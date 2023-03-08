

//1.
function doPost(){
	alert('http post 메소드 실행')
	$.ajax({
		url:"/jspweb/Ex3", //서블릿만든거랑 통신 할 주소를 써라
		method:"Post",
		success:(result)=>{ }
	})
}
//2.
function doGet(){
	alert('http Get 메소드 실행')
	$.ajax({
		url:"/jspweb/Ex3", //서블릿만든거랑 통신 할 주소를 써라
		method:"Get",
		success:(result)=>{ }
	})
	
}
//3.
function doPut(){
	alert('http Put 메소드 실행')
	$.ajax({
		url:"/jspweb/Ex3",
		method:"Put",
		success:(result)=>{ }
	})
	
}
//41.
function doDelete(){
	alert('http Delete 메소드 실행')
	$.ajax({
		url:"/jspweb/Ex3",
		method:"Delete",
		success:(result)=>{ }
		
	})
	
}

//-------------------------------------------------------------------------

function onWrite(){
	
	let info={
		content : document.querySelector('.content').value,
		writer : document.querySelector('.writer').value
	}
	console.log(info)
	
	$.ajax({
		url:"/jspweb/Ex3/Board",
		method:"Post",
		data:info,
		success:(r)=>{
			console.log('응답성공');
			onlist()
			if(r=='true'){
				alert('등록성공')
				document.querySelector('.content').value='';
				document.querySelector('.writer').value='';
			}else{alert('등록실패')}
		}
	})
	
}
onlist();
//2.모든 게시물 출력
function onlist(){
	$.ajax({
		url:"/jspweb/Ex3/Board",
		method:"get",
		success:(r)=>{
		 	console.log('get응답 성공')
		 	console.log(r)
		 	
		 		let html=
		 		`
				<tr>
					<th>번호</th><th>제목</th><th>작성자</th><th>비고</th>
				</tr>
			`;
			
			r.forEach( (o,i)=>{
			html+=`<tr>
					<td>${o.bno}</td><td>${o.bcontent}</td><td>${o.bwriter}</td><td>
					<button onclick=onupdate(${o.bno})>수정</button> 
					<button onclick="Delete(${o.bno})">삭제</button> 
					</td>
				</tr>`
				
			});
			
			document.querySelector('.boardtable').innerHTML=html;
		}
		
	})
}

function Delete(bno){
	
	$.ajax({
		url:"/jspweb/Ex3/Board",
		method:"Delete",
		data:{"bno":bno},
		success:(r)=>{
			if(r=='true'){
			console.log('삭제성공'+r);
			onlist();
			
		}else{
			console.log('삭제실패'+r);
		}
	}
	
	})
}


function onupdate(bno){//특정 게시물 수정
	
	console.log(bno)
	let newContent=prompt('수정할 내용');
	$.ajax({
		url:"/jspweb/Ex3/Board",
		method:"put",
		data:{"bno" :bno, "newContent":newContent},
		success:(r)=>{
			if(r=='true'){
			console.log('수정성공'+r)
			onlist();
			}else{
				console.log('수정실패!!'+r)
			}
		}
		
	})
	
}

function 등록(){
	info={
		product: document.querySelector('.product').value,
		price: document.querySelector('.price').value
	}
	
	$.ajax({
		
		url:"/jspweb/product",
		data:info,
		method:"post",
		success:(r)=>{
			if(r=='true'){
			console.log('제품등록 성공')
			출력();
							
			}else{
				console.log('등록실패')
			}
		}
		
		
	})
	
	
}
출력();
function 출력(){
	
	$.ajax({
		url:"/jspweb/product",
		method:"get",
		success:(r)=>{
		let html=	
			
			`<tr>
				<th>번호</th> <th>제품명</th> <th>금액</th> <th>비고</th>
			
			</tr>
			
			`
			r.forEach( (o , i)=>{
			html+=
				
			`<tr>
				<td>${o.pno}</td> <td>${o.pproduct}</td> <td>${o.pprice}</td>
				<td>
				<button onclick="pupdate(${o.pno})">수정</button>
				<button onclick="pdelete(${o.pno})">삭제</button>
				</td>
			
			</tr>
			
			`
				
			})
			document.querySelector('.pprint').innerHTML=html;
			console.log('출력성공');
		}
		
	})
}

function pupdate(pno){
	let newpproduct=prompt('새로운상품');
	let newprice=prompt('새로운금액');
	
	//console.log(pno)
	$.ajax({
		url:"/jspweb/product",
		method:"Put",
		data:{"pno":pno , "newpproduct":newpproduct,"newprice":newprice},
		success:(r)=>{
			if(r=='true'){
			출력();
			console.log("수정성공!")
				
			}else{
				console.log('수정실패!')
			}
			
			
		}
		
	})
	
	
}

function pdelete(pno){
	
	//console.log(pno)
	
	$.ajax({
		url:"/jspweb/product",
		method:"Delete",
		data:{"pno":pno},
		success:(r)=>{
			if(r=='true'){
			출력();
			console.log(r+"삭제성공!")
				
			}else{
				console.log("삭제실패!")
			}
		}
	})
	
}














/*
	jsp 서블릿  http 메소드 get , post 는 안해도되는데 
					put, delete 사용시 필수 설정
		
		*기본값 : 매개변수 요청차단
		1.Servers 폴더 클릭(Tomcat v9.0 Server at localhost-config)
		2.server.xml 클릭
		3.하단에 source 클릭
		4. 원본 :<Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" /> 
		   수정 :<Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" parseBodyMethods="POST,PUT,DELETE" URIEncoding="UTF-8" />
			대략 60번대 줄 원본을 수정처럼 변경해줌

*/



































