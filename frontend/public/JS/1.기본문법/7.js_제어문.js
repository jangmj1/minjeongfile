/* 
	삼항 연산자 : 조건?참:거짓
	제어문(삼항 연산자와 비슷 둘중하나 골라쓰셈)
		if: 만~~약에~~~[경우의수]
			1.형태
				1.if(조건) true에 대한실행문 한개
				2.if(조건) {true실행문1;실행문2;실행문3;} <-2개 이상의 실행문을 가질떄 중갈호를 이용한 묶음처리
				3.if(조건) {true실행문1;} 
				  else {falte 실행문1;}
				4.if(조건) {true실행문1;} 
					else if(조건2){true실행문2;}
					else if(조건3){true실행문3;}
					else if(조건4){true실행문4;}
					else{false 실행문;}
				5.중첩
					if(조건1){
						if(조건2){
							if(조건3){
								
							}
							
						}
						
					}
//1번 형태
if(10>3)console.log('[참1]10이 더 크다') //실행됨
if(10>20)console.log('[참2]10이 더 크다')//실행안됨 
if(10>20);console.log('[참3]10이 더 크다')//세미콜론 쓰면 안됨 
/*
	; =세미콜론[명령어 단위 마침표]
	실행문 한개면 뒤에 생략 가능
	실행문;실행문;
	if()실행문 ->이게 한개의 세트

*/
//2번형태
/*if(10>3)console.log('참1');console.log('1.10이 더크다');		[x] 콘솔 :참1나옴 1.10이 더크다 <-얘는 그냥 나오는애
if(10>20)console.log('참2');console.log('2.10이 더크다');*/// 	[x] 콘솔 :참2안나옴 2.10이 더크다<-얘는 그냥 나오는애
if(10<20){console.log('참3');console.log('3.10이 더크다');}//	[0] 중갈호를 써줄것

//3번 형태
if(10>3){console.log('참.10이 더크다')}
else{console.log('거짓.10이 더작다')}   //긴거쓸때 이프문
//vs둘중 하나 골라쓰되 코드가 길어지면 위에꺼 짧으면 밑에꺼
//10>3?console.log(참):console.log(거짓) 짧은거 쓸때 

//4번 형태
if(10>=20){console.log('참1 10이 20보다 이상.')} //만약에 10>=20 이상이면 
else if(10>=15){console.log('참2 10이 15보다 이상.')} //아니면서 10>=15 이상이면
else if(10>=10){console.log('참3 10이 10보다 이상.')} //아니면서 10>=10 이상이면
else{console.log('참3 10이 10보다 이상.')}//그외
//vs
/*위에꺼랑 같은거
10>20?console.log('참1 10이 20보다 이상.'):
10>=15?console.log('참2 10이 15보다 이상.'):
10>=10?console.log('참3 10이 10보다 이상.'):
console.log('참3 10이 10보다 이상.')

*/
/*
 1.prompt로 정수1개 입력 받아 90이상이면 합격 아니면 탈락 if사용할것
 2.prompt로 성별을 입력받아 m 또는 M또는 남자또는 남 일 경우 '남자이군요'출력/W 또는 w또는 여자또는 여 일 경우 '남자이군요'출력/그외 
 	남자:m,M,남,남자 여자:w,W,여,여자 로 입력하세요 라고 출력
 3.prompt 로 점수 1개를 입력받아
 90점 이상이면 a등급 80점 이상이면  b등급 70점 이상이면 c등급 그외탈락
 4.
 
*/
//1번 문제
let num1=Number(prompt('정수를 쓰시오'))
if(num1>=90){console.log('합격')}
else {console.log('불합격')}

//2.번문제
/*let 성별=prompt('성별을 입력하세요')
if(성별=='m'){console.log('남자이군요');}
else if(성별=='M'){console.log('남자이군요')}
else if(성별=='남'){console.log('남자이군요')}
else if(성별=='남자'){console.log('남자이군요')}
else if(성별=='w'){console.log('여자이군요')}
else if(성별=='W'){console.log('여자이군요')}
else if(성별=='여자'){console.log('여자이군요')}
else if(성별=='여'){console.log('여자이군요')}
else {console.log('남자:m,M,남,남자 여자:w,W,여,여자 로 입력하세요')}
*/
let 성별=prompt('성별을 입력하세요')
if(성별=='m'||성별=='M'||성별=='남'||성별=='남자'){console.log('남자이군요')}
//만약에 성별이 m이거나 성별이M 이거나 성별이 남 이거나 성별이 남자이면 남자이군요 출력
else if(성별=='W'||성별=='w'||성별=='여'||성별=='여자'){console.log('여자이군요')}
//그게아니면 만약에 성별이W이거나 성별이w이거나 성별이 여 이거나 성별이 여자이면 여자이군요 출력
else {console.log('남자:m,M,남,남자 여자:w,W,여,여자 로 입력하세요')}
//이도저도아니면 남자:m,M,남,남자 여자:w,W,여,여자 로 입력하세요 출력

//3.번 문제
let score=Number(prompt('점수를 입력하세요'))
if(score>=90)console.log('a등급')
else if(score>=80){console.log('b등급')}
else if(score>=70){console.log('c등급')}
else console.log('탈락')


