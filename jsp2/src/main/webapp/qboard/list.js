


출력()
function 출력(){
	let html=''
	
	let qboardlist = [
	   { no : 5 , title : '문의합니다A' , writer : '유재석' , date : '2023-01-30' , view:325 , 문의상태 : true , down : '2023-01-30'  } , 
	   { no : 4 , title : '문의합니다B' , writer : '강호동' , date : '2023-01-27' , view:123 , 문의상태 : true , down : '2023-01-30'  } , 
	   { no : 3 , title : '문의합니다C' , writer : '신동엽' , date : '2023-01-25' , view:753 , 문의상태 : true , down : '2023-01-30'  } , 
	   { no : 2 , title : '문의합니다D' , writer : '서장훈' , date : '2023-01-24' , view:521 , 문의상태 : true , down : '2023-01-30'  } , 
	   { no : 1 , title : '문의합니다E' , writer : '김희철' , date : '2023-01-23' , view:951 , 문의상태 : true , down : '2023-01-30' } ]
	   
	   
	qboardlist.forEach( (qboard)=>{
		html+=`<tr><th >${qboard.no}</th><th><a href="../board/veiw.html">${qboard.title}</a></th>
				<th>${qboard.writer}</th><th>${qboard.date}</th>
				<th>${qboard.view}</th><th>${qboard.문의상태}</th>
				<th>${qboard.down}</th></tr>`
		
	})
	document.querySelector('.qboardlist').innerHTML=html
	
}













