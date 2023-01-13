console.log('작동')

//1.숫자 버튼 출력하는 함수
function 버튼출력(){
		console.log('함수작동')//그냥 확인 용도
	let 버튼목록='';
	for(let i=1;i<=45;i++){
		//i는 45까지 1씩 증가 반복
		console.log('3.'+i)//확인용도
		// 1.첫번째 문자열 처리
			//'<button onclick="버튼클릭('+i+')>'+i+'</button>'
		// 2.`(백틴-esc아래):전체를 빽틴으로 묶기 더하기를 안써도 된다는 장점
		//    변수/수식은 ${}간싼다.
		버튼목록+=`<button onclick="버튼클릭(${i})">${i}</button>`
		if(i%5==0){
			버튼목록+='</br>'
		}
	}
	
	console.log('4.:'+버튼목록)
	document.querySelector('.버튼목록상자').innerHTML=버튼목록
	document.querySelector('.취소버튼').style.display='inline'
	
	
}
//2.로또 구매 취소 함수
function 버튼출력취소(){
	document.querySelector('.버튼목록상자').innerHTML='' //취소 버튼 안보이게 비활성화
	document.querySelector('.취소버튼').style.display='none'
	//배열내 모든 요소 제거
	선택번호목록.splice(0);//0번 인덱스부터(개수) 생략했을때 모두 제거
	추첨버튼출력()

}	
//1.선택한 숫자를 6개 저장하는 배열
let 선택번호목록=[3]

//3.버튼 클릭함수
function 버튼클릭(번호){
	console.log(번호) //확인
	
	/*선택번호목록.indexOf( 3 ) = 0 // 인덱스가 있다. [ 즁복 있다 ]
	선택번호목록.indexOf( 4 ) = -1 // 인덱스가 없다 [ 중복 없다 ]*/
	
	//1.중복검사[배열명.]
	if(선택번호목록.indexOf(번호)>=0){
		alert('이미선택한 번호입니다.[해당 버튼 취소했습니다]')
		선택번호목록.splice(선택번호목록.indexOf(번호),1) //배열명.splice(인덱스,개수) : 해당인덱스에서 갯수만큼 삭제한다
		추첨버튼출력();
		return;// 반환값은 없지만 함수를 끝낼수있다.[더이상 아래로 코드가 실행되지않는다.]
	}
	//2.6개 까지만 저장
	if(선택번호목록.length==6){ //배열 내 숫자가 6개 존재하면
		alert('이미 모두 6개를 선택했습니다.')
		return;
	}
	선택번호목록.push(번호)
	//추첨버튼 활성화 or 비활성화
	추첨버튼출력();
}
//4.선택번호목록출력 및 추첨버튼 활성화
function 추첨버튼출력(){ //1.구매취소했을때,2.버튼클릭시 숫자등록,3.버튼클릭스 숫자취소
	//추첨 버튼 활성화/비활성화
	if(선택번호목록.length==6){
		document.querySelector('.추첨버튼').style.display='inline'
	}
	else{
		document.querySelector('.추첨버튼').style.display='none'
		}
	
	document.querySelector('.선택번호상자').innerHTML=선택번호목록

}	
let 추첨번호목록=[]

//5.추첨하기 버튼을 클릭했을때 함수
function 구매추첨(){
	
	//1. 컴퓨터가 난수 발생[6개 1~45사이의 수 6개]
	for(let i=1;i<=6;i++){ //i는 6까지 1씩 증가 반복처리
		/*console.log(Math.random()) //0~1까지 소수점까지 나옴
		console.log(Math.random()+1)  //1~2까지 소수점까지 나옴
		console.log(Math.random()*45) //0~45사이의 실수(소수점까지) 난수 발생
		console.log(Math.random()*45+1) //1~46 사이의 실수 난수 발생
		console.log(parseInt(Math.random()*45+1))*/ //1~46 사이의 정수 난수 발생
		
		//1. 실수 난수 만들기
		let 실수난수=Math.random()*45+1	//1~45사이 실수 생성
		//2. 실수->정수 변환
		let 정수난수=parseInt(실수난수)
		
			//*중복검사
			if(추첨번호목록.indexOf(정수난수)>=0){//이미 존재한 난수이면 아무것도안함->추첨되면 암것도안뜸..
				i--;//i는 6회 반복하는데 난수 저장 실패시 1회 차감
			}else{//배열내 존재하지 않은 난수이면
				//3. 정수난수를 배열에 저장
				추첨번호목록.push(정수난수)
		//1~3 : 추첨번호목록.push(parseInt(Math.random()*45+1))
			}
		
		
	}//for e
	
	document.querySelector('.추첨번호상자').innerHTML=추첨번호목록
	
	//.1 등수 구하기
	let 맞은개수=0;
	//추첨 결과 출력[두 배열간 맞은 개수와 등수[6개-1등,5개-2등, 4개-3등, 3개-4등 그외 꽝]]
	for(i=0;i<추첨번호목록.length;i++){//i는 0~추첨 배열의 길이 즉 6미만까지 1씩증가
		for(j=0;j<선택번호목록.length;j++){
				console.log(추첨번호목록[i]+":"+선택번호목록[j])
			if(추첨번호목록[i]==선택번호목록[j]){맞은개수++}
		}
	}
	
	/*//2.
	for(let i=0;i<추첨번호목록.length;i++){
		if(선택번호목록.indexOf(추첨번호목록[i])>=0){맞은개수++}
	}
	
	//3.for(반복변수 of배열):배열내 요소 하나씩 마지막 요소까지 반복변수 대입
	for(let value of 추첨번호목록){
		if(선택번호목록.includes(value)==true){맞은개수++}
	}*/
	alert(맞은개수)
}//f e



/*
	난수만들기
		1. math클래스[누군가가 미리 만들어둔 설계도]
			1)random()함수[math클래스가 제공하는 미리 만들어둔 함수]
				예시)
					Math.random() 	: 0~1 사이의 난수 발생
					Math.random()+1 : 1~2 사이의 난수 발생
					Math.random()*45 : 0~45 사이의 난수 발생
					Math.random()*45+1 : 1~46 사이의 난수 발생
			2) floor():소수점 버림 함수
				Math.floor(3.14):3			
		2.parseInt():
*/



/*
	두 배열 배교하기
		1.
			-배열1: 3,7,2,5
			-배열2: 1,5,3,4
				3->1	7->1	2->1	5->1 	 
				3->5	7->5	2->5	5->5
				3->3	7->3	2->3	5->3 
				3->4	7->4	2->4	5->4
		

*/



