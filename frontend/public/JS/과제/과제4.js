console.log('작동')




	let newBook,list_index,b_list,가능여부='';
	let 도서목록= [ '혼자공부하는자바' , '이것이자바다' , '열혈 C언어'  ]
	let 대여목록= [ '혼자공부하는자바' , '이것이자바다' ]
	
	


function 중복함수(){//f s
	
	b_list='<tr><th>번호</th><th>도서</th><th>도서대여여부</th><th>버튼</th></tr>'
	for(let i=0;i<도서목록.length;i++){// for s
		b_list+=`<tr>
					<td>${ i+1 }</td>
					<td>${ 도서목록[i] }</td>
					<td>${ 대여목록.includes( 도서목록[i] ) ? '불가능':'가능' }</td>
					
					<td><button onclick="삭제버튼(${i})">삭제</button></td></tr>`
		}//for e
	}//f e
		
	
	function 등록(){
		
		newBook=document.querySelector('.newBook').value
		list_index=도서목록.indexOf(newBook)
		
		if(newBook.length<5||newBook.length>10){// if s
				alert('5글자 이상 10글자이하만 등록 가능합니다.')
				return;
			}// if e
			
		if(list_index>=0){// if s
					alert('같은책은 등록이 안됩니다.')
				return;
			
			
			}// if e		
		else{
				도서목록.push(newBook)
				/*console.log(도서목록)*/
			}
		
		중복함수()
		출력()
		
		document.querySelector('.b_list').innerHTML=b_list
	
	}


function 삭제버튼(i){
	
	if( 대여목록.indexOf( 도서목록[i] ) >= 0 ){
		console.log('삭제가 불가능 합니다.')
	}
	else{
	도서목록.splice(i,1)
	console.log(도서목록)
	}
	중복함수();
		
		

	document.querySelector('.b_list').innerHTML=b_list
}


/*******************************************************************************************/







function 대여(i){

	// i : 내가 선택한 도서의 인덱스번호
	
	// 도서목록[i] : 내가 선택한 도서의 인덱스번호 호출 : 도서명
	
	if( 대여목록.indexOf( 도서목록[i] ) >= 0 ) {
		alert('대여중입니다.')
		
	}else{
		alert('대여가능합니다.')
		대여목록.push( 도서목록[i] )
		출력()
		중복함수()
		console.log('대여목록:'+대여목록)
	}
	
	
	
/*				for(let i=0; i<도서목록.length; i++){
					
					for(let j=0; j<대여목록.length; j++){
						if(도서목록[i]==대여목록[i]){alert(도서목록[i]+'는 대여중입니다.')
							
						}else{alert(도서목록[i]+'는 대여가능합니다.')}
					}
					
					
				return;	
					
				}
*/
}
function 반납(i){
	
	let 삭제번호 = 대여목록.indexOf( 도서목록[i] )
	if(  삭제번호 >=0   ){
		alert('대여중 반납가능 ')
		대여목록.splice( 삭제번호 , 1  )
		출력()
	}else{
		alert('대여중이 아니라 반납불가능 ')
		중복함수()	
	}
	
	
/*	for(let i=0; i<도서목록.length; i++){
		for(let j=0; j<대여목록.length; j++){
			if(도서목록[i]==대여목록[i]){alert(도서목록[i]+'는 반납했습니다.')
			}else{alert(도서목록[i]+'반납이 불가합니다.')}
		}
	}
	*/
}




출력()
function 출력() {
	let htm1=''
	
	
	let html = `<tr>			
					<th>번호</th>
					<th>도서명</th>
					<th>도서대여여부</th>
					<th colspan="2" >비고</th>
				</tr>` 			
	for( let i = 0 ; i<도서목록.length; i++ ){ // 5. 내용추가 [ 반복 이용한 배열내 요소 출력 ]
		html += `<tr>
					<td>${ i+1 }</td>
					<td>${ 도서목록[i] }</td>
					<td>${ 대여목록.includes( 도서목록[i] ) ? '대여중':'대여가능' }</td>
					
				<td><button onclick="대여(${i})">대여버튼</button></td>
				<td><button onclick="반납(${i})">반납버튼</button></td>
				</tr>`	
								
										
	} 
	document.querySelector('.표').innerHTML = html
}








