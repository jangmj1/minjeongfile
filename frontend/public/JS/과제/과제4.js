console.log('작동')

let 도서목록 = [ '혼자공부하는자바' , '이것이자바다' , '열혈 C언어'  ]
function 등록(){
	let newBook=document.querySelector('.newBook').value
	let list_index=도서목록.indexOf(newBook)
	
	
	
	
	let b_list='<tr><th>번호</th><th>도서</th><th>도서대여여부</th><th>버튼</th></tr>'
	
	if(newBook.length<5||newBook.length>10){// if s
			alert('5글자 이상 10글자이하만 등록 가능합니다.')
			return;
			}// if e
	if(list_index>=0){
				alert('같은책은 등록이 안됩니다')
			return;
		
		console.log(도서목록)
	}		
	else{
			도서목록.push(newBook)
			console.log(도서목록)
		}
	for(let i=1;i<=도서목록.length;i++){// for s

		
		b_list+='<tr><th>'+i+'</th><th>'+도서목록[i-1]+'</th><th>'+'가능'+'</th><th>'+'불가능'+'</th></tr>'
	}// for e
	
	document.querySelector('.b_list').innerHTML=b_list
}