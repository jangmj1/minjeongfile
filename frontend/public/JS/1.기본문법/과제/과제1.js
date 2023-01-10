
/*4.배열 선언과 동시에 요소 3개 저장
	1.함수 안에서 할것지(함수실행마다 선언-누적 저장x)
	2.함수 바깥에서 할껀지(js실행 1번 선언-누적 저장o)
*/
	let studentArray =['20230110','20230109','20230108'] 
	let sa=[]


//3.onclick="onLogin() 대한 함수를 만들어보자
// :onclick="onLogin() -->function onLogin() hmtl의 온클릭을 자바의 펑션을 써서 실행시키겠다
function onLogin(){
//5. dom객체    <input>마크업을 스크립트로 가져오기
	let sno=document.querySelector('.sno')
//5.             <input>마크업에 입력된 데이터 호출
	let snovalue=sno.value;
//6. 찾기[만약에 배열 내 입력한 값이 존재하면 찾는 인덱스/존재하지않으면 -1]
	let sIndex=studentArray.indexOf(snovalue)
		//확인
		//console.log('6번체크:'+sIndex)
//7.논리
	if(sIndex==-1){
//8.출력innerHTML='로그인실패'	
	document.querySelector('.resultBox').innerHTML='로그인실패'}
	//alert('로그인 실패')
	else{
//8.출력innerHTML='로그인성공'	
	document.querySelector('.resultBox').innerHTML='로그인 성공'}
	//{alert//('로그인성공')}

}
/****************************************과제2***************************************************/
function onReg(){
//5. dom객체    <input>마크업을 스크립트로 가져오기
	let sreg=document.querySelector('.sreg')
//5.             <input>마크업에 입력된 데이터 호출
	//let sno=sreg.value;
//6. 찾기[만약에 배열 내 입력한 값이 존재하면 찾는 인덱스/존재하지않으면 -1]
	//let sInd=studentArray.indexOf(sno)
	
	sa.push(sreg.value) //sa=빈깡통
	console.log(sa)
	
	document.querySelector('#resultBox')	
	resultBox.innerHTML = '<li>'+sa+'</li>'
	
//7.논리
	if(resultBox==sa)
//8.출력innerHTML='로그인실패'	
	console.log('실패')
	//alert('로그인 실패')
	else
//8.출력innerHTML='로그인성공'	
	console.log=('성공')
	//{alert//('로그인성공')}
	
		
}

