	console.log('gkdl')
	let contentbox=document.querySelector('.contentbox')
	
	let 클라이언트소켓=null;
	
		if(memberInfo.mid==null){//memberInfo : 해더js 존재하는 객체
			alert('로그인 하고 오세요~') ;location.href="/jspweb/member/login.jsp"
		}else{
			
		//1. 클라이언트 소켓 생성과 동시에 서버소켓 연결[open]
		클라이언트소켓 = new WebSocket('ws://192.168.17.12:8080/jspweb/chatting/'+memberInfo.mid); //웹소켓만들기. 오픈 자체는 여기서 됨
		console.log(클라이언트소켓)
		클라이언트소켓.onopen=function(e){서버소켓연결(e);}//클라이언트 소켓 객체에 내가만든 함수 대입
		
		클라이언트소켓.onmessage= function(e){ 메시지받기(e) }  //만들어논 함수를 함수에 담아서 onmessage 에 담음! 
							//java 의 세션명.getBasicRemote().sendText(메세지내용); 한테 받음
							//onmessage가 성공했을시 e값을 가진다 e값을 메세지받기라는 함수에 인수로 전달
		클라이언트소켓.onclose=function(e){연결해제(e)}

		}
		


	//2.클라이언트 소켓이 접속햇을때 이벤트 함수 정의( 연결이 정상적을 되었을때 실행) 넣어도되고 안넣어도됨 확인용
function 서버소켓연결(e){contentbox.innerHTML+= 
					`<div class="alarm">
						<span> 채팅방에 입장 하셨습니다. </span>
					</div>`}//접속했을때 하고싶은 함수 정의

//3.클라이언트 소켓이 서버에게 메시지를 보내기[@OnMessage]
	function 보내기(){
		let msgbox=document.querySelector('.msgbox').value;
		//**서버소켓에게 메세지 전송하기
		클라이언트소켓.send(msgbox);
		
		document.querySelector('.msgbox').value='';//전송 성공시 채팅창 초기화
	}
	
	//4. 서버로부터 메세지가 왔을때 메세지 받기
	function 메시지받기(e){ //e가뭐임????? e:메세지내용 이건 성공후 r값과 같은것
		console.log(e)
		console.log(e.data);
		console.log(JSON.parse(e.data));//문자열 json->객체 json형변환
		
		let data=JSON.parse(e.data);
		
		//보낸사람
		if(data.frommid==memberInfo.mid){
			contentbox.innerHTML+=
			`	<div class="secontent">
						<div class="date">${data.time}</div>
						<div class="content">${data.msg}</div>
					</div>`
			
		}else{//내가 받은 메세지
			
			contentbox.innerHTML+= `
					
					<div class="tocontent">
						<div><img class="hpimg" src="/jspweb/member/pimg/${data.frommimg==null? 'default.webp':data.frommimg}"> </div>
						<div class="rcontent">
							<div class="name">${data.frommid}</div>
							<div class="contentdate">
								<div class="content">${data.msg}</div>
								<div class="date">${data.time}</div>
							</div>
						</div>
						
					</div>`
		}
		//------------스크롤 최하단으로 내리기--------------
		/*let top=contentbox.scrollTop;//현재 스크롤의 상단 위치 좌표
			console.log(top);
			
		let height=contentbox.scrollHeight;//현재 스크롤 전체의 높이[기본값 contentbox height]
			console.log(height);*/
	
		//스크롤막대
		contentbox.scrollTop= contentbox.scrollHeight;
		
		
	}



 //5.서버와 연결이 끊겼을때=>클라이언소켓 객체가 초기화됐을때 f5 or 페이지전환
	function 연결해제(e){
		alert('연결해제되었습니다')
		console.log(e)
	}

//6.엔터키를 눌렀을때
 	function enterkey(){
		 console.log(window.event.keyCode)
		 if(window.event.keyCode ==13){//만약에 입력한 키 코드가13[엔터] 메시지 전송
			 보내기();
		 }
	 }
	
	/*
	클라이언트소켓 필드
		onopen
		onclose
		onmessage
		//통신결과
		클라이언트소켓.onclose=function(e){console.log('연결해제되었습니다')} 여기서 e는 닫는게 성공됐을때 통신결과값이 e에 들어간다
			vs
		클라이언트소켓.onclose=(e)=>{console.log('연결해제되었습니다')} 여기서 e는 닫는게 성공됐을때 값이 e에 들어간다
			vs
		function 연결해제(e){console.log('연결해제되었습니다')}
		클라이언트소켓.onclose=(e)=>{연결해제(e)}

	ajax 필드
		success : function(r){} 여기서 r은 성공했을때의 값이 r에 담긴다
		success : (r)=>{}


*/





	
 /*
		소켓		: 두 프로그램간의 양방향 통신 종착점[도착지]
		서버소켓	: [JAVA]서버가 가지고 있는 소켓
		클라이언소켓	: 각 [JS]클라이언트가 가지고있는 소켓
	
		(카카오유저)					(카카오 본사)
		클라이언트							서버
		
		유재석		----------안녕------->
		(소켓) 	<--------안녕---------
		
		강호동 	<--------안녕---------	(단톡방)
		(소켓)
		
		신동엽 	<--------안녕---------
		(소켓)
		
		js websocket (유재석 강호동 신동엽)
			1.js에서 제공하는 클래스  WebSockt
			2.소켓 객체 만들기
				let 클라이언트소켓 = new WebSocket('ws://ip:포트번호서버소켓 url'); ??
								- .onopen	: new WebSocket가 제공하는 기능중 하나 =>java 의  @OnOpen 로 보낸다 즉 연결 (양방향 <-->)
								- .send		: new WebSocket가 제공하는 기능중 하나 =>java 의  @OnMessage 로 보낸다 즉 메세지를 (-->)서버로 보냄 
								- .onmessage: new WebSocket가 제공하는 기능중 하나 =>
												java 의  세션명.getBasicRemote().sendText(메세지내용); --> 클라이언트소켓.onmessage=function(e){메시지받기(e)} 
								-  .onclose	: new WebSocket가 제공하는 기능중 하나 =>연결끊기-->@OnClose로 이동 하단메소드실행
								
			3.new 서버소켓을 만드는 순간 소켓이 서버소켓과 연동
				1.WebSocket 생성자에서 해당 서버소켓의 경로 확인 통신함(무조건 @OnOpen 아래가 실행됨)
			
		java serverSocket 만들기
			1.임의의 클래스 생성
			2.서버소켓 만들기
				클래스위에 @ServerEndpoint("/서버 소켓 경로 url")
				- @ServerEndpoint - 서버소켓(ws)의url만들기
				- @WebServlet - http의 url만들rl("/email")
			3. 클라이언 소켓이 서버소켓[엔드포인트]으로 접속했을때
				@OnOpen : 클라이언트 소켓이 접속했을때 매핑[연결]		
				
				
				
	*/		
		
		
	
