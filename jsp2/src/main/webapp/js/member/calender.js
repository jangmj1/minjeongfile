/*
 new Date() 날짜/시간 관련된 클래스
 	1. let date= new Date() : 현재 날짜/시간 객체
 	2. let date= new Date(2023,01,31) : 사용자 정의 날짜/시간 객체

구지 객체명을 안쓰고  new Date().getFullYear() 라고 바로 써도됨
date(객체명).getFullYear()	:연도 출력
date(객체명).getMonth()		:월[0~11월 0:1월~11:12월] 멍통해서 숫자로나온다
date(객체명).getDate()		:일
date(객체명).getDay()			:요일[0~6 0:일요일~6토요일]

 	
*/

let date=new Date(); console.log('date:'+date)
let date2=new Date(2020,1,30); console.log('date2:'+date2)
console.log('연도'+date.getFullYear() );  //2023으로 출력
console.log('월'+date.getMonth() );		//0월로 출력 0=1월
console.log('일'+date.getDate() );		//31로 출력	
console.log('요일'+date.getDay() );		//2 로 출력 2=화요일  2023 1월 31일 기준

let contents=[/*//일정목록
	{date:'20230101',content:'새해맞이여행'},
	{date:'20230103',content:'친구만나기'},
	{date:'20230101',content:'새해쇼핑하기 맛있는거먹고 배통통거리기'}*/
	
]//칼라 넣기 위해 배열을 비워놓음 아니면 bg_color: 넣으면됨





//1. js 열렸을때 현재 연도와 월을 구해서 변수에 저장
let year=new Date().getFullYear() //기본값:현재연도 // 이전연도,다음연도 클릭버튼에따라 변경
let month=new Date().getMonth()+1 //기본값:현재월 // 이전연도,다음월 클릭버튼에따라 변경

cal_print()//스크립트 열렸을때 달력이 현재날짜로 딱 나오게하기위함
//2. 캘린더 상단에 표시[1.스크립트 열렸을때 한번2.이전or다음달로 버튼 클릭할떄마다 또한번출력 반복되는건 함수로만들기]
function cal_print(){
	//1.상단에 월/일 표기
document.querySelector('.top_date').innerHTML=`${year}년 ${month}월` //top_date h3에 아무것도 없어도 들어간다

	
	let html=`<div class="day weekday sunday">일</div><div class="day weekday">월</div>
				<div class="day weekday">화</div><div class="day weekday">수</div>
				<div class="day weekday">목</div><div class="day weekday">금</div>
				<div class="day weekday">토</div>`
	//2. 현재 캘린더에 설정된 날짜를 상단에 월 일 표시하는 객체 만들기
	let lastday=new Date(year,month,0).getDate();console.log('현재갤린더의 마지막일:'+lastday) // 마지막에 0넣은 이유: 마지막 일의 날짜 객체 자동으로 들어간다 
		//시작 요일 구하기
			//2.현재 갤린더 설정된 날짜의 1일 시작 요일 구하기
	let weekday=new Date(year,month-1,1).getDay();console.log('현재 캘린더의 시작요일:'+weekday) 
				
	for(let b=1;b<=weekday;b++){
		html+=`<div class="day"></div>`
	}			
				
				
	//1. 일(day)만들기 [1~마지막 일까지(월마다 다르다)]
	for(let day=1;day<=lastday; day++){
		
		//4.날짜확인
		let date= date_format(  new Date(year,month-1,day) ); // 포멧한거 대입
		
		
		
		
		html+=`<div class="day" onclick="openModal(${date})">
		 ${day} ${content_print(date)}</div>` //1부터~마지막 달까지[ 변수.getDate() ]쁠쁠
		
	}
	
	
				
	document.querySelector('.cal_day').innerHTML=html

}

//5. 일정을 출력하는 함수
function content_print(date){
	console.log(date)
	
		let html=``
	contents.forEach( (o)=>{// 일정목록을 반복문을 돌리는데!
		if(date==o.date){//만약에 date와 객체의 date가 같으면
			html+=`<div class="content" style="background-color : ${o.bg_color}">${o.content}</div>`
			
		}
	})
	return html;
}
//8.등록 버튼 눌렀을때 함수
document.querySelector('.modea_write').addEventListener( 'click',(e)=>{
	//1.입력받은 내용과 선택된 날짜 가져와서 객체화
	let content={
		date:document.querySelector('.modal_date').innerHTML,
		content:document.querySelector('.modal_input').value,
		bg_color:document.querySelector('.modal_color').value //html 에서칼라 받기
	};console.log(content);
	//2.유효성 검사 생략
	//3. 배열 저장
	contents.push(content);
		document.querySelector('.modal_input').value='';
		document.querySelector('.modal_wrap').style.display='none';
		cal_print()
	
})


//7번함수 모달에서 닫기클릭했을때
document.querySelector('.modal_close').addEventListener('click',(e)=>{
	//1. 모달 배경 구역 css변경해서 모달숨기기
	document.querySelector('.modal_wrap').style.display='none'
})

//6.모달 열기 함수
function openModal(date){
	console.log('date',date)
	document.querySelector('.modal_wrap').style.display='flex'
	//처음에 숨겨져 있는 모달을 클릭했을때 보이게 하기위해 none이라고 되어있는 display를   flex로 바꿔준다
	document.querySelector('.modal_date').innerHTML=date
	
	// 일정 출력
	let html=`<tr><th width="5%">#</th><th >일정내용</th><th width="15%">비고</th></tr>`
	let j = 0;
	contents.forEach( (o,i)=>{ // i=contents의 인덱스 순서이다
		if(date==o.date){
			j++;
		html+=`<tr><td>${ j }</td><td>${o.content}</td><td ><button onclick="onDelete(${i})" type="button">삭제</button></td></tr>`
		}	//여기에 i값을 넣으면 같은 날짜에 1번 5번 60번 나오는 대참사가 일어난다 				삭제는 i 써야함 인덱스받아서 삭제해야하니까
	})

	document.querySelector('.table').innerHTML=html
}

//9.일정삭제
function onDelete(i){
	//1. 배열내 해당 인덱스 삭제
	contents.splice(i,1);
	document.querySelector('.modal_wrap').style.display='none'	;
	cal_print()
	
}










//3. 이전달 다음달 버튼클릭 이벤트에 따른 연도와 월이 변경
document.querySelector('.previousbtn').addEventListener('click',(e)=>{ //이전달로 가는 버튼을 클릭했을때
	//1.월을 1 차감했을경우  만약에 0이면 ㅇ연도 1차감 월 12설정 =0월은 없으니 ..
	console.log('작동')
	month--;
	if(month<1){//만약에 월이 1보다 작아지면 즉 0이면
		year--;month=12; //년도는 줄이고 월은 12월로 변경
	}
		cal_print()//그리고 출력
	
})
document.querySelector('.nextbtn').addEventListener('click',(e)=>{ //다음달로 가는 버튼을 클릭했을때
	console.log('작동1')
	month++;
	
	if(month>12){//만약에 month가 13이 되면
		year++;month=1 //년도가 1 증가 month는 1로 지정
	}
		cal_print() // 그리고 출력
})

//4.날짜 포멧 함수
function date_format(date){
	//일짜 형식을 바꿔본다
	let d_year=date.getFullYear();
	let d_month=(date.getMonth()+1 )<=9? '0'+(date.getMonth()+1 ) : (date.getMonth()+1 );
	let d_day=date.getDate()<=9?'0'+date.getDate():date.getDate() ;
	return `${d_year}${d_month}${d_day}`
}










