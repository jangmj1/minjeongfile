
//alert('클릭했습니다') // 함수가 아니기때문에 한번만 확인하면 끝
// 1. 추가 버튼을 눌렀을때 클릭 이벤트를 만들것
let 학생리스트=[]//배열 선언,초기요소없다[깡통]
	//1.추가 버튼을 눌렀을때 클릭 이벤트 함수
function onAdd()   {
	// 일번!함수시작
	//1.function :함수 정의 키워드
	//2. onAdd:함수명[아무거나]
	//3.():인수[함수안으로 전달받은 데이터]
	//4.{}함수가 실행되는 구역
	//alert('클릭했습니다.')
	//*함수 밖에 만든이유:함수가 실행 될때마다 선언하면 기존 데이터가 깡통상태라 삭제되기때문 
	
	//2. 입력받은 input value[값]을 가져오기
	let sname=document.querySelector('.sname') //document=htmls  클래스 명을 가져올떈 쩜! id값을 가져올땐 #
				//1) class 명으로 해당 마크업을 변수로 가져올때 2번!!!
				//document.querySelector(.클래스명)
				//document.querySelector(#아이디명)
				//sname이라는 변수에 input 마크업 저장
	//3. 마크업에서 값 가져와서 배열 담기
		//alert(sname.value) 3번!!!
		학생리스트.push(sname.value)//깡통.푸시(html값 벨류)
		console.log(학생리스트)	   //콘솔.로그(깡콩)
		//마크업(html)의 속성호출
		//value 속성을 가지고있는 html: input,select,textarea
		//innerHTML 속성을 가지고있는:<마크업></마크업> : div,span,table p h 등등
	//4.마크업에 출력 4번!!!
	document.querySelector('#slist')	
	slist.innerHTML = '<li>'+학생리스트+'</li>'
	
	//html ----> js document.querySelector()
	//js ----> html document.write()  함수끝!
}

//클릭시 배열내 요소를 삭제하는 리스트
function onDelet(){
	//1)input 이라는 마크업을 가져온다
	let sname=document.querySelector('.sname')
	
	//2)input 이볅된 value[값]가져오기
	let dname=sname.value
	
	//3.배열 내 값으로 해당하는 요소 인덱스 찾기
	let dindex=학생리스트.indexOf(dname); //입력받은 이름의 인덱스 찾기
	
	//4.배열내 해당 인덱스의 요소 제거
	학생리스트.splice(dindex,1);
	
	//출력
	//1. <ul>가져와서 변수에 저장[dom 객체]
	let slist= document.querySelector('#slist')
	//2.<ul> innerHTML 이용한<ul> {여기에 데이터 넣기}</ul>
	slist.innerHTML	='<li>'+학생리스트+'</li>'
	
	
	
	
	
	
	
	
	
	
	
	
	 
}

