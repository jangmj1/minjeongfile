
//1.keyup 이벤트 : 키보드를 눌렀을때
	//1.<textarea> 마크업 객체화
const textarea=	document.querySelector('textarea')
const h3 =	document.querySelector('h3')

	
	//2.해당 마크업의 이벤트 등록 =>객체명.addEventListener()
	textarea.addEventListener('keyup',( 이벤트상태 )=>{
		
		//해당 마크업 사이에 html대입 =>객체명.innerHTML =html 형식문자
		h3.innerHTML=`글자수:${textarea.value.length}` //3.텍스트 길이 구하기`
		console.log(이벤트상태)
		console.log('alt키를 눌렀는지:'+이벤트상태.altkey)
		console.log('ctrl키를 눌렀는지:'+이벤트상태.ctrlKey)
		console.log('shift키를 눌렀는지:'+이벤트상태.shiftkey)
		console.log('code키를 눌렀는지:'+이벤트상태.code)
		console.log('name키를 눌렀는지:'+이벤트상태.key)
	})
		
		textarea.style.position='absolute'
		let x=0
		let y=0
		let block=30;
		
		print(); // 위치 배치 1번 실행 켜도그만 안켜도그만 키면 0,0에 딱 붙어있음 x,y=0,0
		function print(){
			textarea.style.left=`${x*block}px`  //css left=(x*이동단위)+'px'
			textarea.style.top=`${y*block}px`
		}
		
		
	document.body.addEventListener('keydown',(e)=>{ //키를 꾹~ 누르고 있을때 실행
		
		
		if(control){ // 만약에 control이 true인 경우에만 아래 실행
			let key=e.keyCode;
			if(key==37){//왼쪽 키보드의 코드가 37 누르면 왼쪽으로
			x--;}
			else if(key==38){ y--;}//위쪽 키보드의 코드가 38 누르면 --를 넣어서 위로 올리기
			else if(key==39){ x++;}//left ++대임
			else if(key==40){ y++;}
			print()
		}
	console.log(e.keyCode)
	
	
	}  )
	
	//*이벤트 제어 변수
	let control = true;//*이벤트 제어 전역 변수
	
	//3. 배치를 재어하기 
	document.querySelector('.moving').addEventListener('click',()=>{
		/*control = false;*/// 제어변경
		//스위치 on / off 껐다켰다 하고싶을때
		/*control?control=false:control=true*/
		control=!control
	} )
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	