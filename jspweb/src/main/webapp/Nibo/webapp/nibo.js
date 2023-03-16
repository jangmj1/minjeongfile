console.log('gd');

function insert(){ //db에 입력하고 모달을 닫아야한다
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
			
			
		}
		
	})
}