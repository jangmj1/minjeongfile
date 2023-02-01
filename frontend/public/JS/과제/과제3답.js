
let contentArray=[] //누적 기록을 위해 함수밖으로

function addContent(){
		console.log('함수작동')
	
	let content=document.querySelector('.content').value
		console.log(content)
	
	contentArray.push(content)
		console.log(contentArray)
		
	let html=`<tr> <th>번호</th> <th>방문내용</th> </tr>`
	for(let i=1;i<=contentArray.length;i++){
		html+=`<tr> <td>${i}</td> <td>${contentArray[i-1]}</td> </tr>`
		
	}
		
	document.querySelector('.contentTable').innerHTML=html
}	
