console.log('gd');

function bodycheck(){ //db에 입력하고 모달을 닫아야한다
	console.log('ggggg')
	
	let today1=document.querySelector('.today').value;
	let height=document.querySelector('.height').value;
	let weight=document.querySelector('.weight').value;
	let exercise=document.querySelector('.exercise').value;
	
	let bodycheck={
		today:today1,
		height:height,
		weight:weight,
		exercise:exercise
	}
	console.log(bodycheck)
	
	$.ajax({
		url:"/jspweb/nicebody",
		method:"post",
		data:bodycheck,
		success:(r)=>{
			console.log('연동성공')
			console.log(r)
			
			if(r=='true'){
				alert('등록 완료')
				//등록완료후 이동할 로케이션 생각하자
			}else if(r=='false'){
				alert('빈 칸을 채워주세요')
			}else if(r=='1'){
				alert('이전 날짜는 선택불가입니다.')
			}
		}
		
	})
}

function mybody(){
	document.querySelector('.modal_wrap').style.display='flex';
}
function closeModal(){
	document.querySelector('.modal_wrap').style.display='none';
}
