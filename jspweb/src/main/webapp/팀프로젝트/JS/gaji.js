console.log('연동')

function signup(){
	console.log('회원가입연동')
	
	let signupForm=document.querySelectorAll('.signupForm')[0];
	let signupFormData=new FormData(signupForm);
	console.log(signupFormData);
	
	$.ajax({
		url:"/jspweb/maininfo",
		method:"post",
		data:signupFormData,
		contentType:false,
		processData:false,
		success:(r)=>{
			console.log('연동성공')
			console.log(r)
			if
		}
		
	});
	
	
};