/*
	입력
		1.confirm('메세지') : 확인(true)/취소(false) 입력받는 메세지
		2.prompt('메세지') :데이터를 입력하는 인풋 박스가 나온다
			문자형:let 변수명=prompt('메세지')
			숫자형:let 변수명=Number(prompt('메세지'))
			논리형:let 변수명=Boolean(prompt('메세지'))
	
	입력받은 데이터 저장[변수]
		let 변수명=confirm('메세지') 확인[t]/취소[f] 입력받는메세지
		let 변수명=prompt('메세지') : 데이터 입력받는 메세지
	
	숫자형 입력받을때
		Number(prompt('메세지')) : prompt의 기본값이 문자임 이걸 숫자로 변경해줌
	논리형 입력받을때
		 Boolean(prompt('메세지')):
	문자형 입력받을때
		prompt('메세지')
*/
//1.입력메세지에 대한 확인/취소 결과를 변수 저장
let result1=confirm('실행하시겠습니까?')
console.log('결과1:'+result1)


let result2=prompt('데이터입력')
console.log('결과2:'+result2)
