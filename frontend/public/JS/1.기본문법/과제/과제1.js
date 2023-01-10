
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
//	 dom객체    <input>마크업을 스크립트로 가져오기
	let sreg=document.querySelector('.sreg') //<input>마크업에 입력된 데이터 호출하여 sreg라는 변수명에 넣는다
             
	let sno2=sreg.value; //<input>마크업에 입력된 데이터의 값이 뭐가될진 모르지만 sno2에 담음
 
	let sInd=studentArray.indexOf(sno2)
	 //<input>마크업에 입력된 데이터의 값의 인덱스 인덱스번호찾기(studentArray안에 있는 데이터3가지만 적용)
	
	studentArray.push(sreg.value) //인풋에 작성될 데이터가 studentArray 변수 안에 쌓인다
	console.log(studentArray) //콘솔 창에서 확인가능
	
	
	if(sInd==-1){ //만약에 sInd인덱스에 값이 없으면(0,1,2) 즉!동일한 학번이 없는게 참일경우 아래를 실행하라
	document.querySelector('#resultBox').innerHTML='성공'} //마크업  <div #resultBox> 성공 </div>  =성공출력
	
	/*추가*/
 	else if(sno2==('')){ //input 벨류값이 ('') 과 같은게 참일시 다음을 실행해라
		document.querySelector('#resultBox').innerHTML='학번을 입력해주세요~ '} //마크업  <div #resultBox> 학번을 입력해주세요~ </div>  =성공출력
	
	/*추가2,3 잘모르겠습니당*/	
	else if(sno2.length!=8){
		document.querySelector('#resultBox').innerHTML='8자리로 입력해 주세요'}
	
	else{ //그렇지 않을경우(거짓) 다음을 실행하라
	document.querySelector('#resultBox').innerHTML='실패'} //<div #resultBox> 성공 </div> =실패 출력
}

