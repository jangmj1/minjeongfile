
board_print(null,null) //스크립트가 열렸을때 [조건이 없다. 함수갈호가 비어있는모습 () 써도 무관]
//1. 게시물 출력 함수
function board_print(keyword,key){
	 //1.검색했을때[조건이 없음]와 2.스크립트가 열렸을때[키워드와 키가 필요한 조건] 3.페이지가 전환 되었을때 (지금은 하지않을것!)작동할것

	//1.java[벡엔드]로 부터 데이터 요청	//~추후
		//1.검색이 없는경우
		if(keyword==null&&key==null){
			/*alert('검색이 없는 게시물 출력')*/
			 //java에게 검색이[조건이] 없는 게시물들을 요청
			
		}else{ /*alert('검색이 있는 게시물 출력')*/ }//키워드와 키를 받은 경우 출력
			//java에게 kyword,key 보내서 검색이[조건이] 있는 게시물들을 요청
		
		console.log(keyword);console.log(key)
		
		//2.검색이 있는경우
	
	
		//[벡엔드로 부터 요청된결과]2.db->java 로 전달된 게시물리스트 데이터
	let boardlist = [
	   { no : 5 , title : '안녕하세요A' , writer : '유재석' , date : '2023-01-30' , view:325 , up : 9 , down : 1  } , 
	   { no : 4 , title : '안녕하세요B' , writer : '강호동', date : '2023-01-27' , view:123 , up : 2 , down : 0  } , 
	   { no : 3 , title : '안녕하세요C' , writer : '신동엽' , date : '2023-01-25' , view:753 , up : 3 , down : 0  } , 
	   { no : 2 , title : '안녕하세요D' , writer : '서장훈' , date : '2023-01-24' , view:521 , up : 10 , down : 3  } , 
	   { no : 1 , title : '안녕하세요E' , writer : '김희철' , date : '2023-01-23' , view:951 , up : 21 , down : 4 } 
	]
	
	let html=''
	
	boardlist.forEach(( board)=>{
		html+=`<tr><th>${board.no}</th><th><a href="veiw.html">${board.title}</a></th>
				<th >${board.writer}</th><th >${board.date}</th><th >${board.view}</th>
				<th >${board.up}</th><th >${board.down}</th></tr>`
	})
	
	document.querySelector('.boardlist').innerHTML=html
}

document.querySelector('.searbtn').addEventListener('click',(e)=>{ //searbtn 버튼을 클릭할때마다 실행
	console.log('클릭중')
	//1. 키워드
	let keyword= document.querySelector('.keyword').value //셀렉트 클래스 keyword 가져온다
	//2. 검색어
	let key= document.querySelector('.key').value //인풋 클래스 key 가져온다
	console.log('keyword',keyword)
	console.log('key',key)
	
	//보드프린트한테 키워드와 키를 전달한다---> board_print라는함수에게..
	board_print(keyword,key) //키와 키워드를 받은 board_print 함수가 else 콘솔출력을한다
})














