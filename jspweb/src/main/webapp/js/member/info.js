
const ctx = document.getElementById('myChart');


$.get("/jspweb/point" , (r)=>{
	console.log(r) //list 로 반환되는게아니라 object타입으로 반환되어서 포문을 못돌려
	console.log(Object.keys(r)) // object 의 key 값(왼쪽에있는애들)
	console.log(Object.values(r))	 // object 의 values 값(오른쪽에있는애들)
	
	
	
	
	/*-----------------------------chart.js 차트---------------------------*/
	//new chart('dom객체',{차트옵션})
	// type: '차트이름',data: {차트에 표시할 데이터}, options: {차트옵션}
  
  new Chart(ctx, {
    type: 'bar',
    data: {
      labels: Object.keys(r), //가로축
      datasets: [{
        label: '포인트충전내역',
        data: Object.values(r),//세로축
        borderWidth: 1// 보더 선굵기
      }]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
  });
})

	/*
		JSON=js객체
		let 객체명={필드명/키:데이터 , }
	*/






/*--------------------------------------------------------*/

console.log('gg')
console.log(memberInfo) //header.js 에서 ajax 동기식으로 회원정보를 가져온 상태 
if(memberInfo.mid==null){
	alert('로그인하고오세요');
	location.href="/jspweb/member/login.jsp"
}
document.querySelector('.mid').innerHTML=memberInfo.mid;
document.querySelector('.memail').innerHTML=memberInfo.memail;
document.querySelector('.mimg').src=`/jspweb/member/pimg/${memberInfo.mimg==null?'default.webp':memberInfo.mimg}`
document.querySelector('.mpoint').innerHTML=memberInfo.mpoint;



//1.회원탈퇴
function setDelete(){
		console.log('탈퇴탈퇴')
		
		
		
		$.ajax({
			url:"/jspweb/member",
			method:"delete",
			data:{"mpwd":document.querySelector('.mpwd').value},
			success: (r)=>{
				console.log('통신'); console.log(r);
				if(r=='true'){
					alert('회원탈퇴성공');
					location.href="/jspweb/index.jsp";
				}else{
					alert('회원탈퇴실패 관리자에게 문의')
				}
			}
			
			
		})
}

//2.회원수정
function setUpdate(){
	console.log('회원수정!');
	
}
