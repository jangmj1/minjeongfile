console.log('작동')

//전역변수! 함수밖에 만드는 이유:전역변수:모든 함수에서 동일한 메모리 사용
let contents=[]
onprint()
//이벤트함수
	//1.<button type="button" onclick="onwrite()">글등록</button>
		//function onwrite(){}
	//2.<button type="button" class="onwritetbn()">글등록</button>
		//document.querySelector('.onwritetbn').addEventListener('click',(e)=>{ })
	//1번은 다른곳에서도 쓸수있따 2번은 일회성

//1.
function onwrite(){//글 등록 버튼을 눌렀을때
	console.log('작동2')
	
	//1.입력받은 4개의 데이터를 하나의 객체 선언
	let info={//let 객체명(아무거나)={속성명:데이터,속성명:데이터...}
	bwriter:document.querySelector('.bwriter').value,
	bpassword:document.querySelector('.bpassword').value,
	btitle:document.querySelector('.btitle').value,
	bcontent:document.querySelector('.bcontent').value,
	bdate:new Date(),//현재와 시간
	bview:0//조회수
	}
	
	console.log(info)
	
	//2.유효성 검사//객체명 쩜! 속성명 
	//1.입력받은 데이터 길이가 체크 가능하다 
	if(info.bwriter.length <=0 ||info.bpassword.length<=0 ||info.btitle.length<=0 ||info.bcontent.length<=0 ){
		alert('작성이 안된 구역이 있습니다.')
		return;//함수 종료 ...더이상 해당 함수에서 아래로 진행 불가능 x
		
	//배열에 저장하기 //추후에는 백엔드와 통신해서 데이터를 전달 시킨다 [백엔드:java,db]
	}
	contents.push(info)	
	alert('글 등록 성공')
	onprint()
	console.log(contents)
	//초기화
	document.querySelector('.bwriter').value=''
	document.querySelector('.bpassword').value=''
	document.querySelector('.btitle').value=''
	document.querySelector('.bcontent').value=''
}

//글 출력

function onprint(){//스크립트가 열렸을때 한번,글 등록했을때 삭제햇을때 수정했을때 열릴예정
	
	console.log('gkdl')
	//1.기본 html구성
	let html=`<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th></tr>`
	//2.내용 html구성
	for(let i=0;i<contents.length;i++){
		let date=contents[i].bdate.getFullYear()+'년'+
				(contents[i].bdate.getMonth()+1)+'월'+
				contents[i].bdate.getDay()+'일'+
				contents[i].bdate.getHours()+'시'+
				contents[i].bdate.getMinutes()+'분'+
				contents[i].bdate.getSeconds()+'초'
		html+=`<tr onclick="onview(${i})"><th>${i+1}</th>
		<th>${contents[i].btitle}</th><th>${contents[i].bwriter}</th>
		<th>${date}</th><th>${contents[i].bview}</th></tr>`
		//날짜함수
		// new date() : 현재 날짜 /시간 반환
		//2.연도/월/일
			// getFullYear():날짜에서 연도만 추출
			// getMonth():날짜에서 월만 추출[0~11 ]
			// getDate():날짜에서 일만 추출
			// getDay():날짜에서 요일[3]만추출
			// getHours():시간에서 시만 추출
			// getMinutes():시간에서 분만 추출
			// getSeconds():시간에서 초만 추출
		
	}			//tr 에 온클릭(i)넣어주기
	//3.마크업 html 대입
	document.querySelector('.boardtable').innerHTML=html
}//함수 글 출력 끝


//3.글보기함수[조회수증가]
function onview(i){ //1.글 목록에서 해당 행을 클릭했을때
	contents[i].bview +=1;
	onprint()
	console.log(i)
	let html=`<div>제목:${contents[i].btitle}</div>
			  <div>내용:${contents[i].bcontent}</div>
			  <div>작성자:${contents[i].bwriter}</div>
			  <div><button onclick="del(${i})">삭제</button></div>`
			  			  
	document.querySelector('.viewbox').innerHTML=html
	
}

function del(i){
	let 비밀번호=prompt('비밀번호를 입력하세요')
	if(contents[i].bpassword==비밀번호){
		contents.splice(i,1)
		onprint()
		document.querySelector('.viewbox').innerHTML=''
		
	}
	else{alert('비번확인하세요')}
	
}













