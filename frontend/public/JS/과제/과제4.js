console.log('작동')




	let newBook,list_index,b_list='';
	let 도서목록= [ '혼자공부하는자바' , '이것이자바다' , '열혈 C언어'  ]
	


function 중복함수(){
	b_list='<tr><th>번호</th><th>도서</th><th>도서대여여부</th><th>버튼</th></tr>'
	newBook=document.querySelector('.newBook').value
	list_index=도서목록.indexOf(newBook)
	
	}
		
	
	function 등록(){
		중복함수();
	/*	
		let b_list='<tr><th>번호</th><th>도서</th><th>도서대여여부</th><th>버튼</th></tr>'
		let newBook=document.querySelector('.newBook').value
		let list_index=도서목록.indexOf(newBook)
		*/
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
				console.log(도서목록)
			}
		
		for(let i=1;i<=도서목록.length;i++){// for s
				let 가능여부=['가능','불가능']
				let index
				if(도서목록[i-1].length>=5){
					index=0
				}else{
					index=1
				}
					console.log('도서목록[i-1].length'+도서목록[i-1].length+가능여부)
	
			
			b_list+='<tr><th>'+i+'</th><th>'+도서목록[i-1]+'</th><th class="가능여부">'+가능여부[index]+'</th><th>'+'<button onclick="삭제버튼('+i+')">삭제버튼</button>'+'</th></tr>'
			
		}// for e
		
		document.querySelector('.b_list').innerHTML=b_list
	
	}


function 삭제버튼(i){
	
	중복함수();
	도서목록.splice(i-1,1)
	console.log(도서목록)
	for(let i=1;i<=도서목록.length;i++){
			// 그냥 써논거임
			let 가능여부=['가능','불가능']
			let index
			if(도서목록[i-1].length>=5){
				index=0
			}else{
				index=1
				}

		b_list+='<tr><th>'+i+'</th><th>'+도서목록[i-1]+'</th><th class="가능여부">'+가능여부[index]+'</th><th>'+'<button onclick="삭제버튼('+i+')">삭제버튼</button>'+'</th></tr>'
	}
		console.log(도서목록)
		

	document.querySelector('.b_list').innerHTML=b_list
}









