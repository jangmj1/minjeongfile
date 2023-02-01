
let selectbox=	document.querySelector('.selectbox')
	selectbox.addEventListener('change',(e)=>{
		console.log(e)
		
		e.currentTarget //이벤트를 실행한 타겟 :selectbox
		console.log(e.currentTarget)
		
		let options= e.currentTarget.options //select 의 모든 옵션들을 배열로 
		console.log(e.currentTarget)
		
		let index= e.currentTarget.options.selectedIndex
		console.log(e.currentTarget.options.selectedIndex)


		console.log(options[index].value)
		document.querySelector('h3').innerHTML= `선택한옵션 : ${options[index].value}`

	} )
	
	//2. "checkbox" 변경이벤트
	let checkbox=document.querySelector('.checkbox')
	checkbox.addEventListener('change',(e)=>{
		console.log(e)
		
		e.currentTarget
		console.log (e.currentTarget)
		
		e.currentTarget.checked
		console.log(e.currentTarget.checked)
		
	})
	
	let timer=0 //타이머 시간(초) 저장하는 변수
	let timerID=0 //전역변수
	
	let timerbox=document.querySelector('.timerbox')
	let timerspan=document.querySelector('.timerspan')
	timerbox.addEventListener('change', (e)=>{
		if(e.currentTarget.checked){
			//만약에 체크박스안에 체크가 되어있으면 실행
			
			//setInterval:특정 시간마다 함수를 실행 시켜준다
			//setInterval(함수명,시간(밀리초))
			//setInterval( ()=>{실행문},1000) 1초마다 화살표 함수가 실행된다
			//clearInterval 말그대로 인터벌을 초기화해준다 시간멈추는거
				//let 변수명=
		
		timerID=setInterval( ()=>{
				timer++;
				timerspan.innerHTML=`${timer}초`
				},1000 )
		}else {
			clearInterval(timerID)
		}
	})
	
	
	
	
	
	
	
	
	
	
	
	
	
	
