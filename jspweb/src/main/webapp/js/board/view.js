console.log('하이연동')
getboard();
function getboard(){// 개별출력 !! 
	
	let bno=document.querySelector('.bno').innerHTML;
	console.log('bno:'+bno);
	
	
	$.ajax({
		url:"/jspweb/board/info",
		method:"get",
		data:{"type":2 , "bno":bno}, //1이면 전체출력 2면 개별출력
		success:(r)=>{
			console.log('개별출력성공')
			console.log(r)
			
			let html=`<div>
					${r.bdate}/
					${r.bview}/
					<button onclick="bincrease(2)" type="button"> ${r.bup}</button>/
					<button onclick="bincrease(3)" type="button"> ${r.bdown}</button></div>`
			
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
			//-------------------------------------------------------------------
			//로그인된 회원과 작성자가 동일하면 삭제할수있음
			if(memberInfo.mid==r.mid){
				html=
									//(${bno,r.cno}) 이렇게 쓰지말자 r.cno 쩜이있어서 안됨					
				`<button onclick="bdelete(${bno},${r.cno})" type="button">삭제</button> 
				<button onclick="bupdate(${bno})" type="button">수정</button>`
				
				document.querySelector('.btnbox').innerHTML=html;
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

bincrease(1) // 해당 js가 열리는 순간 조회수는 증가
//3. 조회수[1] 좋아요[2] 싫어요[3]
function bincrease(type){
		//1.현재 게시물의 번호[증가할 대상]
	let bno=document.querySelector('.bno').innerHTML;
	console.log(bno)
	
	$.ajax({
		url:"/jspweb/board/view",
		method:"get",
		data:{"type":type,"bno":bno},
		success:(r)=>{
			console.log('조회수성공'); console.log(r)
			getboard();//새로고침
		}
	})
}

// 삭제 하기 bno이어받음
function bdelete(bno,cno){
	
	$.ajax({
		url:"/jspweb/board/info",
		method:"delete",
		data:{"type":1,"bno":bno}, //전체삭제
		success:(r)=>{
			console.log('개별출력성공')
			console.log(r)
			if(r=='true'){
				alert('삭제성공');
				location.href="/jspweb/board/list.jsp?cno="+cno;
			}else{
				alert('삭제실패')
			}
			
		}
			
	})


}
//수정 페이지로 이동
function bupdate(bno){
	location.href="/jspweb/board/update.jsp?bno="+bno
}


//400번대 오류 = js 500오류=java























