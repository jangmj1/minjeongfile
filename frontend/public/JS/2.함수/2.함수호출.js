/*

함수호출
1.호출할 함수의 이름이 존재
	1.인수 x 반환 x없는 함수
		정의								호출
		function 함수명(){}				함수명()
		
	2.인수o반환x 함수
		정의								호출
		function 함수명(x){}				함수명(x)
		
	3.인수x반환o 함수
		정의								호출
		function 함수명(){				let result=함수명()
			return 3
		}
		
	4.인수o반환o 함수
		정의								호출
		function 함수명(x){				let result=함수명(3)
			return 3
		}

*/
// 1.인수가 없는 함수 선언
function 함수1(){
	
	console.log('함수1 실행')
	
	
}
	//1-1.js 함수 호출
함수1()

//2. 인수가 1개인 함수 선언
function 함수2(x){
	console.log('함수2 실행 인수:'+x)
}
함수2(7)
	
//3. 인수가 2개인 함수 선언
function 함수3(x,y){
	console.log('함수3 실행 인수:'+(x+y))
}

//3.js에서 함수 호출
함수3(5,7)
//4.반환이 있는 함수 선언
function 함수4(x,y,z){
	let result=x+y+z
	return result;
	
}
함수4(1,2,3) //??? 반환후에 코드가 없다.
let result=함수4(1,2,3)
console.log('함수4변환:'+result)

	
