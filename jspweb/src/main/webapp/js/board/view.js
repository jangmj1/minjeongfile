
console.log(memberInfo)

if(memberInfo.mid==null){
document.querySelector('.rcontent').disabled=true;
document.querySelector('.rcontent').value='로그인 후에 작성 가능합니다';
document.querySelector('.rwritebtn').disabled=true;
}
console.log('하이연동')
let bno=document.querySelector('.bno').value;


getboard();
function getboard(){// 개별출력 !! 
	
	console.log('bno:'+bno);
	
	
	$.ajax({
		url:"/jspweb/board/info",
		method:"get",
		data:{"type":2 , "bno":bno}, //1이면 전체출력 2면 개별출력
		success:(r)=>{
			console.log('개별출력성공')
			console.log(r)
			
			let html =''
			
			document.querySelector('.mimg').src=`/jspweb/member/pimg/${ r.mimg == null ? 'default.webp' : r.mimg}`;
			document.querySelector('.mid').innerHTML = r.mid;
			document.querySelector('.bdate').innerHTML = r.bdate;
			document.querySelector('.bview').innerHTML = r.bview;
			document.querySelector('.bup').innerHTML = r.bup;
			document.querySelector('.bdown').innerHTML = r.bdown;
			document.querySelector('.btitle').innerHTML = r.btitle;
			document.querySelector('.bcontent').innerHTML = r.bcontent;
			
			if(r.bfile==null){//첨부파일이 없는 게시글이면
			//document.querySelector('.bfile').innerHTML='첨부파일없음';
			}else{//첨부파일이 있을때
				html = `<a href="/jspweb/filedownload?bfile=${ r.bfile }" > 
							<i class="fas fa-download"></i>${ r.bfile } 
						</a>`
				document.querySelector('.bfile').innerHTML = html;
				
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
			//댓글 출력
			getReplyList();
			
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



//6.댓글 쓰기
function rwrite(){
  
  $.ajax({
	  url:"/jspweb/board/reply",
	  method:"post", //"type":1 최상위 댓글
	  data:{"type":1,"bno":bno,"rcontent":document.querySelector('.rcontent').value},
	  success:(r)=>{
		  console.log('연동성공')
		  console.log(r)
		  
		  if(r=='true'){
			alert('댓글작성 성공!')	  
		  document.querySelector('.rcontent').value='';
		  
		  //특정 div만 새로고침[랜더링]
		 //$('.replylistbox').load( location.href+' .replylistbox');
		  location.reload();
		  }else{console.log('등록실패')}
	  }
  })
  
  
}
//댓글 출력
function getReplyList(){
	
	$.ajax({
		url:"/jspweb/board/reply",
		method:"get",
		data:{"type":1,"bno":bno},
		success:(r)=>{
			console.log('출력성공')
			console.log(r)
			let html=''
			r.forEach((o,i)=>{
			
					
				html+=
					`
						<div>
							<span>${o.mimg}</span>
							<span>${o.mid}</span>
							<span>${o.rdate}</span>
							<span>${o.rcontent}</span>
							<button onclick="rereplyview(${o.rno})" type="button">댓글보기</button>
							<div class="rereplybox${o.rno}" >
								
							</div>
						</div>
					`
				
			})
			document.querySelector('.replylistbox').innerHTML=html
		}
	})
}
//하위댓글 구역 표시
function rereplyview(rno){
	console.log('리리플확인')
	let html='------------------------------------------';
	
	
	$.ajax({
		url:"/jspweb/board/reply",
		async:'false',
		method:"get",
		data:{"type":2,"bno":bno,"rindex":rno},
		success:(r)=>{
			console.log(r)
			
			r.forEach( (o,i)=>{
				html+=
						`<div>
							<span>${i+1}.</span>
							<span>${o.mimg}</span>
							<span>${o.mid}</span>
							<span>${o.rdate}</span>
							<span>${o.rcontent}</span>
							
						</div>`
			})
			
			html+=
			`<div>
				<textarea class="rrcontent${rno}"></textarea>
				<button onclick="rrwirte(${rno})" type="button">대댓글 작성</button>
			</div>`
			document.querySelector('.rereplybox'+rno).innerHTML=html;
		}
	})
	
	

	
	
	
}

//하위댓글 입력
function rrwirte(rno){
	//준비물 : bno,mno,rrceontent,rindex(상위댓글번호),type
	
	$.ajax({
		url:"/jspweb/board/reply",
		method:"post", //"type":2 댓글의 댓글
		data:{
			"type":2,"bno":bno,"rindex":rno,
			"rcontent":document.querySelector('.rrcontent'+rno).value},
		success:(r)=>{
			console.log(r)
			alert('댓글달기성공');
			 location.reload();
			
			
		}
	})
}



















