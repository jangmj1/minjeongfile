
function signup(){
	//console.log('하이')
	let memberForm=document.querySelectorAll('.memberForm')[0];
	let memberFormDate= new FormData(memberForm);
	
	$.ajax({
		url:"/jspweb/hisystem",
		method:"post",
		data:memberFormDate,
		contentType:false,
		processData:false,
		success:(r)=>{
			console.log('통신했니');console.log(r);
			if(r=='true'){
				console.log('등록성공')
				print();
			}else{
				console.log('등록실패')
			}
		}
		
		
		
	})
	
	
	
		   
	
}



print();
let log;	
function print(){
	console.log('출력될것이다')
	$.ajax({
		url:"/jspweb/hisystem",
		method:"get",
		success:(result)=>{
			console.log('통신');console.log(result);
			
			let html=`<tr>
					<th width="10%" height="5%">사원번호</th>
					<th width="10%">사원사진</th>
					<th width="10%">사원명</th>
					<th width="10%">직급</th>
					<th width="10%">고용형태</th>
					<th width="10%">부서</th>
					<th width="10%">입사일</th>
					<th width="10%">퇴사일</th>
					<th width="10%">퇴사사유</th>
					<th width="10%">비고</th>
				</tr>`
			
			
			result.forEach((o,i)=>{
			
			html+=
				`<tr>
					<td height="5%">${o.no}</td>
					<td><img width="100%"src="/jspweb/member/pimg/${o.mimg==null ? '기본프로필.webp':o.mimg}"</td>
					<td>${o.name}</td>
					<td>${o.mrank}</td>
					<td>${o.employment}</td>
					<td>${o.division}</td>
					<td>${o.idate}</td>
					<td>${o.edate}</td>
					<td>${o.resign}</td>
					<td>
						<button onclick="update(${o.no})" type="button">수정</button>
						<button onclick="ondelete(${o.no})" type="button">삭제</button>
					</td>
				</tr>`
		
			
			})
			
			
			document.querySelector('.box').innerHTML=html;
			
		}

		
	})

}

let sno =0;
function update(no){ //pk no
	sno=no;
	document.querySelector('.modal_wrap').style.display='flex';
		$.ajax({
			
		url:"/jspweb/test",
		method:"get",
		data:{"no":no},
		success:(r)=>{
			console.log('통신완료');console.log(r);
			
	document.querySelector('.newmimg').src=`/jspweb/member/pimg/${r.mimg==null?'기본프로필.webp': r.mimg}`;
	document.querySelector('.newmname').value=r.name
	document.querySelector('.newmrank').value=r.mrank
	document.querySelector('.newemployment').value=r.employment
	document.querySelector('.newdivision').value=r.division
	
		}
	})
	
	
	
	
}

function newupdate(){
	
	let memberForm=document.querySelectorAll('.newinfo')[0];
	let memberFormDate= new FormData(memberForm);
	memberFormDate.set("no",sno);
		$.ajax({
			
		url:"/jspweb/hisystem",
		method:"put",
		contentType:false,
		processData:false,
		data:memberFormDate,
		success:(r)=>{
			console.log('통신완료');console.log(r);
			if(r=='true'){
				console.log('수정완료');print();
				document.querySelector('.modal_wrap').style.display='none';
			}else{
				console.log('관리자에게문의하세요')
			}
			
		}
	})
	
	
}

function cancel(){
	
	
	document.querySelector('.cmodal').style.display='none';
	document.querySelector('.modal_wrap').style.display='none';
	
}
function ondelete(no){
	sno=no;
	document.querySelector('.cmodal').style.display='flex';
}

function del_modal(){
	let del_no=document.querySelector('.del_no').value;
	console.log("del_no"+del_no);
	
	$.ajax({
			
		url:"/jspweb/hisystem",
		method:"delete",
		data:{"del_no":del_no},
		success:(r)=>{
			console.log('통신완료');console.log(r);
			if(r=='true'){
				console.log('잘끄지그라');
				print();
			document.querySelector('.cmodal').style.display='none';
				
			}else{
				console.log('퇴사실패에~~반려야~~~당장자리에가앉아~~')
			}
			
			
		}
	})
	
}	
