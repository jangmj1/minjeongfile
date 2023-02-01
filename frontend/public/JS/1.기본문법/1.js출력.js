/*
   js
	1.주석 [번위+ctrl+shigf+/]
  		//: 한줄주석
   		/*: 여러줄 주석 */
/*	2.출력
		1.console.log() : 콘솔에 출력하는 함수[test용도]
			-js코드 -->브라우저의 개발자 도구
		2.alert():알람 메세지를 출력하는 함수
		3.document.write():html의 body에 출력하는 함수
	3.제어문자[이스케이프 문자]
		-엔터 위에 원화 기호[백슬래시]:\
		1.\n:줄바꿈
		2.\t:들여쓰기
		3.\\:\ 출력 한개나옴   [백슬래스는 출력 \\]	
		4.\":"출력	
			
		* 키워드 : 미리 만들어진 단어들[명령어]
		  데이터 : 
		  	1.문자:1.' ' 2.""
		  	2.숫자:100
		  	3.논리:turu,false
	*/
	
//1.출력[console.log(출력할 데이터값)]
	console.log('hello world')//''안에 있는 데이터는 문자 처리
//	console.log(hello world) //!문자처리 ""생략하면 오류 발생
	console.log("hello world")//"안에 있는 데이터는 문자 처리"
	console.log(100)		//숫자는 문자 처리를 안한다
	console.log("100")		//숫자는 문자처리 하면 문자로 출력함
 	console.log(true)		//논리는 문자 처리 안함
//2.출력[alert(출력할 데이터값)] 	
 	alert('hello world2') //순서대로 알람 두개 뜬다
 	alert('world2')
 	alert(200+200)
 	alert(true)
//3.제어문자
	console.log('안녕하세용\njs처음입니다.')
	console.log('안녕하세용\tjs처음입니다.')
	//console.log('안녕하세용\js처음입니다.') -> 잘못된예시
	console.log('안녕하세용\\js처음입니다.') 
	console.log('안녕하세용\'js처음입니다.\'') 
	console.log('안녕하세용\"js처음입니다.\"') 
	
 

 /* 크롬 개발자 도구 f12
 console: 출력 가능,코드 작성가능(입 출력이 가능한 구역)
 */