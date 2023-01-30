
console.log('작동')
let 문의사항저장소=[]
function qboard_wirte(){
	console.log('작동2')
	
	let qboard={
		qtitle:document.querySelector('.qtitle').value,
		qcontent:document.querySelector('.qcontent').value,
		qwriter:document.querySelector('.qwriter').value,
		qpassword:document.querySelector('.qpassword').value
	}
	
	문의사항저장소.push(qboard)
	console.log(문의사항저장소)
	
	let result=true;
	if(result){alert('글쓰기성공!!') ;location.href='list.html'}
	else{alert('글쓰기를 실패하였습니다.')}
}