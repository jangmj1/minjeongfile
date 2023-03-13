console.log('하이')

/*
	JS정규 표현식 : 문자의 특정 규칙 , 패턴 , 집합 표현할때 사용되는 언어
		-- 문법	
			/^ 		: 정규 표현식 시작 하겠다
			$/ 		: 정규 표현식 끝났따
			[a-z]	: 소문자 a-z 패턴
			[A-Z]	: 소문자 A-Z 패턴
			[0-9]	: 소문자 0-9 패턴
			[가-힣]	: 한글 패턴
			{최소길이,최대길이}:문자열 길이 패턴
			-----
			
			[a-zA-Z] -- 영.문.만입력
			[a-zA-Z0-9] -- 영문+숫자입력
			[a-zA-Z0-9가-힣] -- 영문+숫자+한글입력
			
			---
			1개 이상 문자가 포함되어야 하는 경우
			(?=.*[a-z]) 	:소문자 한개 이상 입력
			(?=.*[A-Z]) 	:대문자 한개 이상 입력
			(?=.*[0-9]) 	:숫자 한개 이상 입력
			(?=.*[!@#$%^*]) :특수문자 한개 이상 입력
			/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/
			
			1.(?=.*[A-Za-z])		:영대소문자 한개 이상 입력
			2.(?=.*\d) OR (?=.*[0-9])	:숫자 한개 이상 입력
			3.[A-Za-z\d] OR [A-Za-z0-9]	:영문 + 숫자
			==>영문1개 숫자 1개 필수를 갖는 5~20글자 사이
			
			/^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)[A-Za-z\d]{5,20}$/
			==>영대문자1개 + 영소문자1개+숫자1개를 필수로 갖는 5~20글자
			
			
			
			--패턴 검사 해주는 함수가..
				정규표현식.test(데이터) : 패턴이 적합하면 true/아니면 false
				
				ex)
				/^[a-z]$/.test(qwe) -->true
				/^[a-z]$/.test(QWE) -->false  : QWE가 대문자

*/
//*첨부파일 이미지 미리보기[업로드와 상관없음]
	//사용자[클라이언트]에 
function premimg(object){ //여기서 object는 프로필 인풋박스
	console.log('첨부파일 바뀜:'+object);
	console.log(object.files[0]);	//현재 이벤트 실행된 input의 등록한 파일명 호출
	
	//해당 클래스의 인풋에 등록한 파일명 호출
	console.log(document.querySelector('.mimg').files[0])
	//1.js 파일클래스를 이용해서 파일의 정보를 갖고오기
	let file=new FileReader(); //파일 읽기 클래스
	
	//2.해당 첨부된 파일 읽어오기(file.readAsDataURL(첨부파일))
	file.readAsDataURL(object.files[0])	//해당 파일 읽어오기 files[0] 0쓰는 이유 첨부파일은 한개이기때문에
	
	//3.읽어온 파일을 꺼내기 => byte식으로 꺼내온다 콘솔찍어보면 이상한게나옴
	file.onload=(e)=>{//파일을 꺼내서 읽는다
		console.log(e.target.result)
		//e.target => file.onload : 읽어온 파일
		//e.target.result => 읽어온 파일의 바이트 결과
		//4.이미지 테그의 src 에다가 이미지 바이트 대입
		document.querySelector('.premimg').src=e.target.result;
	}
	

}

//1.checkconfirm span 모두가져오기 => 여러개의 스팬이 배열/리스트 객체에 담긴다
let checkconfirm = document.querySelectorAll('.checkconfirm')

//아이디 유효성검사[1.문자체크 2.중복검사]
function idcheck(){
	console.log('입력')
	
	//1.입력할때마다 입력값 가져오기
	let mid=document.querySelector('.mid').value;
	console.log(mid)
	 
	//2.정규표현식[소문자+숫자 5~30 글자 ] //길이넣기 길이는 대갈호가 아니라 중갈호 {최소,최대}
	let midj = /^[a-z0-9]{5,30}$/
	
	//3.정규표현식
	console.log(midj.test(mid))
	if(midj.test(mid)){ //아이디 검사를 했는데 테스트를 통과하면! 중복아이디 유효성검사가 다시시작
		
		//아이디 중복검사 [js -> 서블릿 -> dao 에게 해당 아이디 검색 select]
		$.ajax({
			url:"/jspweb/mconfirm",
			method:"get",
			data:{"mid":mid},
			success:(r)=>{
				console.log('통신완료');
				console.log(r)
				if(r=='true'){
					checkconfirm[0].innerHTML='x';
				}else{
					checkconfirm[0].innerHTML='O';
					
				}
			}
		})
		
	}else{
		checkconfirm[0].innerHTML='영소문자+숫자 조합 5~30사이로 입력해주세요!'
	}
	
	
	
	
}

//회원가입
function signup(){
	//*유효성 검사에 대한 체크
	let count=0;
	for(let i=0;i<checkconfirm.length;i++){
		if(checkconfirm[i].innerHTML=='O'){count++}
	}
	if(count!=3){
		alert('정상적으로 입력되지 않은 데이터가있습니다');return;
	}
	
	//console.log('함수열림')
	//첨부파일이 없을때에 입력받은 값 모두 가쟈와서 객체화
	
	//첨부파일 있을때엔 html에 file 직접적으로 value값을 못뺌!!! 조작불가능
	 //mimg : document.querySelector('.mimg').value 이렇게가 안된다 그래서!
	 //첨부파일이 있는 아작트만들기!!!!!!!!!! form 사용하여 가져와야한다
	 let signupForm=document.querySelectorAll('.signupForm')[0]; // 첫번째 form 가져오기
	 	//2.폼 안에있는 데이터 호출할거다
	 let signupFormDate=new FormData(signupForm);//가져온 폼의 데이터 꺼내기 꺼낸값을 signupFormDate에 대입
	 console.log(signupFormDate)
	
	$.ajax({
		url :"/jspweb/member",				//서블릿 주소
		method :"post", 					//첨부파일은 무조건 post 
		data:signupFormDate,				//formData 객체 전송
		contentType:false,					//true : 매개변수(변수) 형식의 문자열 타입(기본값)
												//form-urlencoded 타입으로 전송
											//false : 해제
		processData:false,					//	multipart/form 형식으로 전송
		success:(r)=>{
			console.log('ajax응답')
			console.log(r)
			 if(r=='true'){
				 openModal();
				
			 }else{
				 alert('회원가입 실패')
			 }
		}
	})
	
}
	//3.비밀번호 유효성 검사
	function pwdcheck(){
		console.log('비번유효성')
		let mpwd=document.querySelector('.mpwd').value;
		console.log('mpwd'+mpwd)
		
		let mpwdj=/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/
		//정규표현식 : 영대소문자+숫자 조합  5~20 글자
		
		console.log(mpwdj.test(mpwd))
		
		//3.제어
		if(mpwdj.test(mpwd)){
			checkconfirm[1].innerHTML='O';pwdconfromcheck();
		}else {
			checkconfirm[1].innerHTML='영대소문자+숫자 조합 5~20 글자'
		}
	}
	
	//4.비밀번호 유효성 검사
	function pwdconfromcheck(){
		console.log(' 재확인')
		
		let mpwd=document.querySelector('.mpwd').value;
		let mpwdconfirm=document.querySelector('.mpwdconfirm').value;
			console.log(mpwdconfirm);
		let mpwdj=/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/
		if(mpwdj.test(mpwdconfirm)){
			//두 비밀번호간의 동일성 체크
			if(mpwd!=mpwdconfirm){
				checkconfirm[1].innerHTML='X'
			}else{
				
				checkconfirm[1].innerHTML='O'
			}
		}else{
			
				checkconfirm[1].innerHTML='영대소문자+숫자 조합 5~20 글자'
		}
	}
	
	function emailcheck(){//5.이메일 유효성 검사
		let memail=document.querySelector('.memail').value;
		let memailj=/^[a-zA-Z0-9_-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-]+$/ 	//아이디구간
			///^[a-zA-Z0-9]$/ : 영문+숫자
			///^[a-zA-Z0-9_]$/ : 영문+숫자+_+-
			//아이디와 도메인 사이의@ 무조건 들어가겠다 플러스+넣어라		//도메인구간	
			//[a-zA-Z0-9-]		:영문+숫자+-(도메인)		    namer
			//+\.				: 쩜! 이 무조건 들어간다		  .
			//[a-zA-Z0-9-]		:영문 + 숫자 + -			com
			//+					: .						naver.co.kr
			console.log(memailj.test(memail));
			if(memailj.test(memail)){
				
				checkconfirm[2].innerHTML='이메일 형식이 맞습니다. 인증을 해주세요'
				document.querySelector('.authbtn').disabled=false;	//형식이 맞으면 인증 버튼을 사용하겠다
			}else{
				checkconfirm[2].innerHTML='X'
				document.querySelector('.authbtn').disabled=true; //형식이 틀리면 인증 버튼을 사용안하겠다
				
			}
	}



//6.이메일 인증 함수
	function getauth(){ // 인증 버튼을 눌렀을때 밑에가 실행 
		//* ajax JAVA 에게 이메일 전송후 인증 코드 받기;
		$.ajax({
			url : "/jspweb/email",
			method:"post",
			data:{"memail":document.querySelector('.memail').value},
			success:(r)=>{
				console.log('성공접속')
				console.log(r)
			}
			
		})
	
		console.log("apapap")
		
		let html=`
				<div class="timebox"></div>
				<input placeholder="인증코드" type="text" class="autboxinput">
				<button onclick="authconfirm()" class="authconfirmbtn"  type="button">확인</button>`
				
		//2. html 대입
		document.querySelector('.authbox').innerHTML=html;
		
		//3. 타이머 함수 실행 : 
		auth=1234;	 // 인증 코드 대입 [이메일에게 보낸 난수 대입]
		timer=120;	 // 인증 시간 대입 5초
		settimer();	 // 인증 시간 대입
	}
let timer=0; // 인증시간
let timerInter ; //Interver 함수를 저장할 변수
let auth=0;	
//7.타이머함수
 function settimer(){
	 
	 //setInterval ( ()=>{} , 시간/밀리초) : 특정 시간 마다 함수를 실행 
	timerInter= setInterval ( ()=>{ 
		 let minutes = parseInt(timer / 60 );  //분 하나 초 하나 만들기=> 분 계산
		 let seconds = parseInt(timer % 60); 	//분 계산후 나머지가 초
		 
		 minutes = minutes < 10 ? "0"+minutes : minutes //3항 연산자
		 seconds = seconds < 10 ? "0"+seconds : seconds //3항 연산자
		 
		 //시간 구성
		 let timehtml=minutes + ":" + seconds;
		 	console.log(timehtml)
		 	
		//html 대입
		document.querySelector('.timebox').innerHTML=timehtml;
		
		//1초 차감
		timer--;
		
		if(timer<0){
			clearInterval(timerInter);
			checkconfirm[2].innerHTML='인증 실패'
			document.querySelector('.authbox').innerHTML=""; // 인증 실패하면 authbox를 숨겨라 즉 html을 없애라
			
		}
	 } , 1000); // 1초 (1000) 마다 {} 안이 실행된다
 }

//8. 인증코드확인
function authconfirm(){
	//1. 입력받은 인증 코드 호출
	let autboxinput=	document.querySelector('.autboxinput').value;
	if(autboxinput==auth) {
		clearInterval(timerInter);
		document.querySelector('.authbox').innerHTML=""; 
		document.querySelector('.authbtn').innerHTML="완료";
		document.querySelector('.authbtn').disabled=true;
		checkconfirm[2].innerHTML='O'
		//인증코드일치
	}else {
		//인증코드불일치
		checkconfirm[2].innerHTML='인증코드가 틀립니다.'
	}

}

/*	첨부파일이 없을때!!!!!
	let info={
		mid : document.querySelector('.mid').value,
		mpwd : document.querySelector('.mpwd').value,
		mpwdconfirm : document.querySelector('.mpwdconfirm').value,
		memail : document.querySelector('.memail').value,
		mimg : document.querySelector('.mid').value,
	}

	//console.log(info);
	// $.ajax 사용해서 서블렛이랑 연결하기  $.ajax  사용하기위해서 
	// <script src="http://code.jquery.com/jquery-latest.min.js"></script> 이게필요
	 $.ajax({
		 url : "/jspweb/member",
		 method: "post",
		 data : info,
		 success:(r)=>{
			 console.log('ajax응답')
			 if(r=='true'){
				 alert('회원가입 성공');
				 location.href="/jspweb/index.jsp"
			 }else{
				 alert('회원가입 실패')
			 }
			}
	 })
	 
	 */
