console.log('하이연동')
getboard();
function getboard(){
	
	let bno=document.querySelector('.bno').innerHTML;
	console.log('bno:'+bno);
	
	
	$.ajax({
		url:"/jspweb/board/info",
		method:"get",
		data:{"type":2 , "bno":bno}, //1이면 전체출력 2면 개별출력
		success:(r)=>{
			console.log('개별출력성공')
			console.log(r)
			
			let html=`<div>${r.bdate}/${r.bview}/${r.bup}/${r.bdown}</div>`
			
			document.querySelector('.infobox').innerHTML=html
			document.querySelector('.pimgbox').innerHTML=r.mid
			document.querySelector('.btitle').innerHTML=r.btitle
			document.querySelector('.bcontent').innerHTML=r.bcontent
			
			if(r.bfile==null){//첨부파일이 없는 게시글이면
			document.querySelector('.bfile').innerHTML='첨부파일없음';
			}else{//첨부파일이 있을때
				html= `${r.bfile}<button onclick="bdownload('${r.bfile}')" type="button">다운로드</button>`
				document.querySelector('.bfile').innerHTML=html
				
				//"bdownload(${r.bfile})" => logo.jpg 이렇게 해버리면 .접근연산자라고 인지한다 logo 객체로인식
				//"bdownload('${r.bfile}')" =>'logo.jpg' 이렇게 문자 처리를 해줘야한다 
			}
			
		}
		
	})
}


//2.다운로드라는 버튼 클릭시 함수(다운로드할 파일을 인수로 받기)
function bdownload(bfile){
	console.log("bfile:"+bfile)
	
	
	/*$.ajax({
		url:"/jspweb/filedownload",
		method:"get",
		data:{"bfile":bfile},
		success:(r)=>{
			console.log('다운로드통신완료')
			console.log(r)
		}
		
	})*/
	
	location.href="/jspweb/filedownload?bfile="+bfile;
}

/*
 2. 전송방법
 	html	: 1.<form>  2.<a href="">
 	js		: 1. location.href=""
 	jquery	: 1. $.ajax
*/













