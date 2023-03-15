console.log('gg');
console.log('memberInfo',memberInfo)
if(memberInfo.mid==null){
	alert('회원제 기능입니다.로그인후 작성해주세요'); location.href="/jspweb/member/login.jsp"
}

function bwrite(){
	
 // let writeForm=document.querySelector('.writeForm') //폼을 이렇게 가져오면 문자로 가져와짐
 // console.log('writeForm'+writeForm);

  let writeForm=document.querySelectorAll('.writeForm'); //폼을 이렇게 가져오면 객체로 가져와짐
  console.log('writeForm'+writeForm);
 
  let writeFormDate=new FormData(writeForm[0]); //폼객체를 new FormData클래스를 사용하여 넣는다
  console.log(writeFormDate); //폼을 전송할 객체로 만든다
  
  	$.ajax ({
		  url:"/jspweb/board/info",
		  method:"post",
		  data:writeFormDate,
		  contentType:false, //첨부파일을 보내기 위해서 쓰는것
		  processData:false, //첨부파일을 보내기 위해서 쓰는것
		  success:(r)=>{
			  console.log('통신성공함')
			  console.log(r)
			  if(r=='true'){
				  console.log('글쓰기 성공')
			  }else{console.log('글쓰기 실패')}
		  }
		  
	  })
  
}
//Uncaught TypeError: Illegal invocation 	jquery-latest.min.js:4  : 주로! $.ajax 오류!!
//콘솔에 위와같은 오류가 나면 아작트 내에 오타가 났는지 또는
//jsp에 <script src="http://code.jquery.com/jquery-latest.min.js"></script> 를 넣어놨는지 확인할것