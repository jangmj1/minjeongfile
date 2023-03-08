//console.log('하이')

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
			
			--패턴 검사 해주는 함수가..
				정규표현식.test(데이터) : 패턴이 적합하면 true/아니면 false
				
				ex)
				/^[a-z]$/.test(qwe) -->true
				/^[a-z]$/.test(QWE) -->false  : QWE가 대문자

*/

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
					document.querySelector('.idcheckconfirm').innerHTML='사용중인 아이디 입니다.';
				}else{
					document.querySelector('.idcheckconfirm').innerHTML='사용 가능한 아이디.';
					
				}
			}
		})
		
	}else{
		document.querySelector('.idcheckconfirm').innerHTML='영소문자+숫자 조합 5~30사이로 입력해주세요!'
	}
	
	
	
	
}

//회원가입
function signup(){
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
				 alert('회원가입 성공');
				 location.href="/jspweb/index.jsp"
			 }else{
				 alert('회원가입 실패')
			 }
		}
	})






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
}