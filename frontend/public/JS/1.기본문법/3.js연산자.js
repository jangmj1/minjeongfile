/*
	js 연산자
		1.산술 연산자:+더하기 -뺴기 *곱하기 /나누기 %나머지
		2.연결 연산자:+
			숫자+숫자 : 산술 / 문자+숫자 : 연결 / 문자+문자 : 연결 /문자+(숫자+숫자) : 문자+숫자
		
		3.비교연산자: 결과는 항상 true/false 참/거짓 으로 나옴
					>[초과] <[미만] >=[이상-크거나같다] <=[이하-작거나 같다]
					== 같다[데이터만 비교] ===[데이터와 자료형이 같다]
					!= 같지않다[아니다/제외 등등] !==[데이터와 자료형 같지않다]
		
		4.관계연산자: 주로 비교연산자가 2개 이상일때 
					&&:and 이면서 면서 이고 모두 그리고 [비교 연산자 결과가 모두 참이면 참]
						10<a<20[x] a>10 && a<20 [o]
					||:or 이거나 거나 또는 하나라도		[비교 연산자 결과가 하나라도 참이면 참]
					
					!:부정 반대					[비교 연산자 결과가 참이면 거짓]
				
*/

/*//1.산술연산자
console.log(3+3)
console.log('더하기:'+3+3) // =>연결문자로 나옴 33
console.log('더하기:'+(3+3))//=>(숫자+숫자) 33
console.log('빼기:'+(3-2))
console.log('곱하기:'+(3*2))
console.log('나누기:'+(10/3))
console.log('나머지:'+(10%3)) //몫을 제외한 나머지*/
	/*
	문제1
		1.국어,영어,수학 점수를 입력받아 변수에 저장
		2. 총접 출력,평균 출력 ,		
	*/
	/*let data1=Number(prompt('국어점수'))
	let data2=Number(prompt('영어점수'))
	let data3=Number(prompt('수학점수'))
	console.log('총첨'+ (data1+data2+data3))
	console.log('평균'+ (data1+data2+data3)/3)*/
 /*문제: 
 	2.prompt 합수로 반지름 입력 받아서 원 넓이[반지름*반지름*3.14]
 	3.prompt 함수로 두 실수를 입력받아서 앞 실수의 값이 뒤실수의 값의 몇 %인지
 	4.prompt 함수로 정수를 입력받아 홀수[true]/짝수[false] 여부 출력
 	5.prompt 함수로 정수를 입력받아 7의 배수면 true/아니면 false 출력
 	6.prompt 함수로 금액 입력 받아 지폐 개수 세기
 	7.prompt 함수로 아이디 비밀번호를 입력받아 아이디가 admin이고 비밀번호가 1234와 일치하면 결과 t 아니면 f
 	8.
 		
 	*/
 /*	2번문제
	let 반지름=Number(prompt('반지름'))
	console.log('반지름'+(반지름*반지름*3.14))
	
	3번문제
	let data1=Number(prompt('data1'))
	let data2=Number(prompt('data2'))
	console.log('몇%:'+(data1/data2)*100)
	
	4번문제
	let 홀짝=Number(prompt('홀수인가 짝수인가'))
	console.log('홀이면t 짝이면 f:'+(홀짝%2==1))*/ /*!(홀짝%2==0)) 같은말*/
	
/*	5번문제let seven=Number(prompt('7의 배수인가'))
	console.log('7의 배수인가:'+(seven%7==0))*/
	
/*	6번문제 let money=Number(prompt('지페입력'))
	console.log('십만원권'+parseInt(money/100000)+'장')*/
/*	console.log('만원권'+parseInt((money-(parseInt(money/100000)*100000))/10000 )+'장')
	console.log('천원권'+parseInt((money-(parseInt(money/10000)*10000))/1000 )+'장')
	*/
/*	money=money-parseInt(money/100000)*100000
	     /*356789-300000=56789*/
/*	console.log ('만원권'+parseInt(money/10000)+'장')
	money=money-parseInt(money/10000)*10000
	console.log ('천원권'+parseInt(money/1000)+'장')*/
	
	/*7번 문제prompt 함수로 아이디 비밀번호를 입력받아 아이디가 admin이고 비밀번호가 1234와 일치하면 결과 t 아니면 f*/
/*	let id=prompt('아이디를 입력하세요')
	let pw=prompt('비밀번호를 입력하세요')
	console.log(id=='admin' && pw==1234)*/
	
/*	//8번문제
	let 정수3=Number(prompt('정수'))
	console.log('홀수이면서 7의 배수:'+(정수3%2==1 && 정수3%7==0))
*/
	
	

/*console.log('초과:'+ (10>3) )//갈호를 넣어줘야함 아니면 초과10은 3보다 크다로 인식
console.log('미만:'+(10<3))
console.log('이상:'+(10>=3))
console.log('이하:'+(10<=3))
console.log('같다:'+(10==3))
console.log('다르다:'+(10!=3))

//4.관계연산자
console.log('&&이면서'+ (10>3 && 10>5)) //트루 엔드 트루:트루 (둘다 참이면 참)
console.log('||이면서'+ (10>3 || 3>5)) //트루 엔드 펄스:트루 (하나라도 참이면 참)
console.log('!부정'+ !(10>3)) //트루를 펄스로 /펄스를 트루로
*/

//5.대입연산자:
	/* =대입[오른쪽에서 왼쪽으로 대입]
		+=더한후대입[오른쪽 데이터를 왼쪽에 더한후 대입]
		-=, *=, /= , %=
	*/
	
//6.증감 연산자:
	/* 변수++[후위 1증가] 변수--[후위1감소]
	   ++변수[선위 1증가] --변수[선위1감소]
	*/
//7.삼항연산자 :만약에 조건이 참[true]이면 참 변환/거짓이면[false]이면 거짓반환 
	/*  1.조건 ?  참  : 거짓
			예시) 나이>=19?'성인':'청소년'			
		2.중첩
			조건1?참1:  조건2?참2:  조건3?참3: 거짓
			예시) 나이<=19 '청소년' : 나이<=40 ? '청년' : 나이<=60 ? 중년 : '노년'
	*/
	
	
	
	let data1=10 //대입[선언과 동시에 대입=초기값]
	data1+=2 // 10+2=12
	console.log('+='+data1)
	
	data1-=5 // 12-5=7
	console.log('-='+data1)
	
	data1 *=2 //7*2=14
	console.log('*='+data1)
	
	data1 /=3 //14/3=4.6666
	console.log('/='+data1)
	
	data1 %=3 //1.66666
	console.log('%='+data1)
	
	/*응용*/
	/*let html='<h3>js 작성된 코드</h3>'
	html += <div>안녕하세여</div>
	document.write(html);
	
/*5.증감연산자[data++(효율적),data +=1,data=data+1 ] */
let data2=10;
console.log('변수값'+data2)  //10
console.log('변수값'+(data2++)) //10 : 출력 후 1이 증가
console.log('변수값'+data2) //11
console.log('변수값'+(++data2))//12 : 출력과 동시에 1이 올라간다

console.log('변수값'+(data2--))//12: 출력하고나서 1이 증감
console.log('변수값'+(data2))//확인 11
console.log('변수값'+(--data2))//출력과 동시에 10

/*6.삼항연산자 [조건?참:거짓] */
let age=38;
let 나이대=age<=19?'청소년':'성인' //38이 19보다 크기때문에 펄스(거짓)가 된다 즉 성인
console.log('38의 나이대는'+나이대)
let 점수=78;
let 등급=
		점수>=90?'a등급': //점수가 90 이상이면 a등급
		점수>=80?'b등급': //점수가 80 이상이면 b등급
		점수>=70?'c등급': //점수가 70 이상이면 c등급
		탈락			   //그 외 탈락


console.log('78점의 등급은:'+등급)




/*
	문제9:정수를 입력 받아서 홀수인지 짝수인지 출력
	문제10: 정수 두개를 입력 받아서 더 큰수를 출력
	문제11: 정수 3개를 입력 받아서 가장 큰 수를 출력
	문제12: 정수 3개를 입력 받아서 오름 차순으로 출력
*/
//9번
let 정수=Number(prompt('숫자를 입력하세요'))//Number를 꼭 붙힐것 
console.log(정수%2==0?'짝수':'홀수')
//10번
let num1=Number(prompt('첫번째 숫자'))
let num2=Number(prompt('두번째 숫자'))
console.log(num1+'와'+num2+'중 더 큰 숫자는?'+(num1>num2?num1:num1<num2?num2:'두수는같다'))
//11번
let num3=Number(prompt('첫번째 숫자'))
let num4=Number(prompt('두번째 숫자'))
let num5=Number(prompt('세번째 숫자'))
//이렇게 써도됨 console.log(num3+'와'+num4+'와'+num5'중 젤큰숫자는?'+num3>num4?num3:num3>num5?num3:num4>num5?num4:num5)
let max=num3
max=max<num4?num4:max //만약에 max보다 더 크면 num4 아니면 가만히
max=max<num5?num5:max
console.log('가장 큰 수는:'+max)
//12

	








