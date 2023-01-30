console.log('작동')
let 게시물임시저장소=[]

function board_wirte(){
	console.log('작동2')
	//[첨부파일 없는경우]
	//1. 입력받은 데이터 객체화
	let board={
		btitle:document.querySelector('.btitle').value,
		bcontent :document.querySelector('.bcontent').value,
		bwriter :document.querySelector('.bwriter').value, 
		bpassword : document.querySelector('.bpassword').value,
	}
	console.log(board)
	
		//[첨부파일 있을경우]
		//1. 입력양식을 통채로
		let writeform=document.querySelector('.writeform');
			console.log(writeform)
		let formdata=new FormData(writeform)
			console.log('formdata',formdata)
		//*유효성 검사 생력
	
	//2. java에게 데이터 전송후 전송된 결과를 받는다.[통신-AJAX 등..]
		//생략
	
	 게시물임시저장소.push(board)
	 console.log(게시물임시저장소)
	//3.결과에 따른 이벤트
	
	let  result=true; // java로 부터 전송결과
	if(result){alert('글쓰기성공'); location.href='list.html'}
						//글쓰기 성공하면 페이지를  list.html 로 이동
	else{alert ('글쓰기 실패')}
}

$(document).ready(function() {
  $('#summernote').summernote( {
	  height:300 ,
	  lang:'ko-KR'
	  
	  });
});