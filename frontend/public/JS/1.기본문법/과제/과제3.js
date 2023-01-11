
let contentArray=[]

function addContent(){
	
let 방명록='<tr> <th>번호</th> <th>방명록</th> </tr>';
	let 내용작성=document.querySelector('.내용작성').value;
	contentArray.push(내용작성)
	console.log(contentArray)
	
	for(i=1;i<=contentArray.length;i++){
		console.log(i)
	방명록+= '<tr> <th>'+i+'</th>	<th>'+contentArray[i-1]+'</th>';
	document.querySelector('.게시판').innerHTML=방명록	
	
	}
	
	
}