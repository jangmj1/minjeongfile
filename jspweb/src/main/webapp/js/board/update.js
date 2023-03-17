console.log('업데이트수정')

let bno=document.querySelector('.bno').value;
console.log("bno"+bno);

getBoard();
function getBoard(){ //내가 수정할 게시물 부터 가져오기
	
	$.ajax({
		
		url:"/jspweb/board/info",
		method:"get",
		data:{"type":2,"bno":bno},
		success:(r)=>{//s s
			console.log('수정통신완')	
			console.log(r)	
			
			//수정전 기존 값을 가져오기
			document.querySelector('.btitle').value=r.btitle;
			document.querySelector('.bcontent').value=r.bcontent;
			//document.querySelector('.cno').value=r.cno; // 번호로 이프문 쓰면 안되나? 해도됨 대신에 jsp에서 옵션에 value값을 다 넣어야함
			
			
			//카테고리도 기존값을 가져오자 ??왜해야함?
			let cnoselet=document.querySelector('.cno');
			console.log(cnoselet) // 셀렉트만 가져온거고
			console.log(cnoselet.options[0]) //셀렉트 안에있는 옵션들을 조작할수있따 [0] 첫번째 option
			
			for(let i=0; i<cnoselet.options.length;i++){//for s
				//i는 0부터 옵션<option> 테그 갯수만큼 반복한다
				
				if(cnoselet.options[i].value==r.cno){
					//i번째 옵션 테그에 값과 현재 게시물의 카테고리번호와 일치하면 
					cnoselet.options[i].selected=true; //트루이면 뭐?
				}
				
			}//for e*/
			
			//2.첨부파일이 있을때/없을때
			let html='';
			if(r.bfile==null){//없을때
				html+='<div>첨부파일이 없습니다.</div>'
				
			}else{
				html+=
					`<div>
					기존 첨부파일:<span class="oldbfile"></span>
					<button onclick="bfiledelete()" type="button">삭제</button><br/>
					변경할 첨부파일:
					<input name="bfile" type="file"></div>`
				
			}
			
			document.querySelector('.bfilebox').innerHTML=html;
			document.querySelector('.oldbfile').innerHTML=r.bfile; //기존 파일 불러오기
		}//s e
		
	})
}

//수정하기
function bupdate(){
	//폼값 가져오기
	let updateForm=document.querySelectorAll('.updateForm');
	//폼값 객체화
	let updateFormDate=new FormData(updateForm[0]);
		//폼 밖에거나 js에 있는 추가 데이터는 formDate에 폼에 추가할수있다 =>formdata객체명.set
		//bno는 form 밖에 있지만 가져올수있따
		updateFormDate.set('bno',bno); // 전역변수여야함??
			//bno를 가져가는 이유 ? 누구를 수정할건지가 필요한거니까!
			// 입력받은거(cno,btitle,bcontent,bfile) + bno 가져가야함 ! oldbfile은 기존거기떄문에 구지 가져갈필요 x
		
	$.ajax({
		url:"/jspweb/board/info",
		method:"put",
		data:updateFormDate,
		contentType:false, //첨부파일을 보내기 위해서 쓰는것
		processData:false, //첨부파일을 보내기 위해서 쓰는것
		success:(r)=>{
			console.log('업데수정');
			console.log(r)
			if(r=='true'){
				alert('수정성공')
				location.href="/jspweb/board/view.jsp?bno="+bno
			}else{alert('수정실패')}
		}
	})
}



//기존에 있떤 파일만 삭제하기
function bfiledelete(){
	
	$.ajax({
		url:"/jspweb/board/info",
		method:"delete",
		data:{"bno":bno,"type":2},//타입 2는 첨부파일만 삭제
		success:(r)=>{
			console.log('파일만삭제통신완료')
			if(r=='true'){
				//특정 div만 reload 하는 방법 (특정부분만 새로고침)
				$(".bfilebox").load(location.href+' .bfilebox'); //jquery 방식($들어가면 다 jquery방식)
					//load함수가 jquery에서 재공해줌 ! 중요: location.href= 아니라 +이다 !' .bfilebox' 쩜앞에 띄어쓰기
				//vs
				//document.querySelector('.bfilebox').load(location.href+' .bfilebox'); 이거는 안된다
			}
			
			
			}
	})
}





















