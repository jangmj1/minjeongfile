
function enter(){
	
	let 단= document.querySelector('.단').value;
	let 곱= document.querySelector('.곱').value;
			let 테이블행='<tr><th>단</th>	<th>곱</th>	<th>결과</th></tr>';//테이블의 첫 행    이게 펑션 바깥에 있으면 누적이 됨 
	
	
	// let html 변수명=html마크업작성 
	
	//3. 구구단 테이블 만들었으면-> 행 반복문을 돌릴것 테이블의 행tr반복문 만들기
	
		for(let j=1;j<=곱;j++){//입력한거 까지 j가 돌아간다 
			
			테이블행+= '<tr> <th>'+단+'</th>	<th>'+j+'</th>	<th>'+(단*j)+'</th> </tr>'
			console.log(단*j)
	 		document.querySelector('.gu_table').innerHTML=테이블행
		 }//for e
	}
	 //5 반복문으로 누적된 html 변수를 table에 넣어주기
 
 

 
 
 
 
 
 
 
 
 
 
 
 