console.log('write 열림')
if(memberInfo.mid==null){
	alert('로그인 후 제품등록 가능')
	location.href="/jspweb/member/login.jsp"
}
let plat=0;
let plng=0;



function onwrite(){
	console.log('onwrite연동')
	//1.폼 객체
	let writeForm=document.querySelectorAll('.writeForm')[0];
	
	//2.폼 데이터 객체 선언
	let writeFormData=new FormData(writeForm);
	
	//3.좌표[위도,경도] 추가
	//폼객체에 필드 추가(폼값으로 전송이 바로안돼서 js아래에잇는 경도 위도를 변수에 담아서 따로 가져감)
	writeFormData.set("plat",plat); 
	writeFormData.set("plng",plng);
	if(plat==0||plng==0){
		alert('위치 선택후 등록해주세요');
		return; //! 경도 위도없으면 한번 거르기
	}
	if(fileList.length<1){
		alert('하나 이상의 이미지를 등록하세요');
		return;	//! 첨부파일이 하나도 없으면 한번더 거르기
	}
	//폼에 [드래그된 파일들을] 첨부파일 등록
	fileList.forEach( (f)=>{
		//배열에 존재하는 파일들을 하나씩 폼에 등록
		//append 필드명 중복 가능
		writeFormData.append("fileDrop",f) //writeFormData.set("fileDrop",f); 아니고 append!
	})
	
	$.ajax({
		url:"/jspweb/product/info",
		method:"post",
		data:writeFormData,
		contentType:false,
		processData:false,
		success:(r)=>{
			console.log(r)
			if(r=='true'){
				alert('등록성공');
				location.href="/jspweb/index.jsp"
			}
		}
	})
	
}
//---------------------------------카카오 지도를 표시할 div 객체--------------------------
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

//---------------------------------지도를 클릭한 위치에 표출할 마커입니다 --------------------------


// 
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

//---------------------------------지도에 클릭 이벤트를 등록합니다 --------------------------
// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
 
    var latlng = mouseEvent.latLng;     // 클릭한 위도, 경도 정보를 가져옵니다
    marker.setPosition(latlng);	   // 마커 위치를 클릭한 위치로 옮깁니다
   plat=  latlng.getLat()
     	console.log('위도:'+latlng.getLat())
   plng=  latlng.getLng()
     	console.log('경도:'+latlng.getLng())
    ;
    
});

//--------------------------------드래그앤드랍 구현-------------------------------//
//1.해당 구역 가져오기[DOM] 객체 호출
let fileDrop=document.querySelector('.fileDrop');

//2. 해당 구역에 이벤트 등록
	//1.
fileDrop.addEventListener("dragenter",(e)=>{ //! html에서 온클릭과 같음
	console.log('드래그 요소가 해당 구역에 닿았을때')
	fileDrop.style.backgroundColor = "#e8e8e8"; //닿았을때 배경색상 회색으로

	e.preventDefault();
})

	//2.
fileDrop.addEventListener("dragover",(e)=>{
	console.log('드래그 요소가 해당 구역에 위치하고있을때')
	e.preventDefault();
})
	//3.
fileDrop.addEventListener("dragleave",(e)=>{
	console.log('드래그 요소가 해당 구역에서 나갔을때');
	e.preventDefault();
})
	//4.
fileDrop.addEventListener("drop",(e)=>{
	console.log('드래그 요소가 해당 구역에 드랍됐을때')
			fileDrop.style.backgroundColor = "#ffffff"; //파일잡고 손떘을때 색상 원래흰색으로
		//!문제점 발생 : 브라우저에 드랍했을때 해당 사진이 브라우저로 열린다..
			//브라우저에 저장되어있는 드랍이벤트가있는데 브라우저가 상위가 그게 먼저 실행됨
		e.preventDefault(); //브라우저의 기본 고유 이벤트를 삭제 시킨다 (.fileDrop 구역만 삭제됨)
		//1.드랍된 파일을 호출해서 가져오기
		let files=e.dataTransfer.files	//드랍된 파일
		console.log(files);
		
		for(let i=0; i<files.length;i++){
			console.log(files[i])
			if(files[i]!=null &&files[i]!=undefined){
				fileList.push(files[i]);//각파일들을 하나씩 배열에 저장
			}
		}

		
		/*files.forEach( (f)=>{ forEach는 불가 file는 변수이지 배열이 아니기때문
			console.log(f)
			if(f!=null && f!=undefined){
				//비어있찌않고 정의가 되어있으면 실행
				fileList.push(f); 
			}
		})*/
		console.log(fileList)
		 printfiles();
})

let fileList = [];//파일들이 하나씩 저장되는 배열


//3.해당 구역에 드랍된 파일 목록 출력
function printfiles(){
	let html='';
	fileList.forEach( (f,i)=>{
		let fname=f.name;
		console.log(fname);
		let fsize=(f.size /1024).toFixed(3);	//파일용량[바이트-->KB로 변경] !toFixed(3) 소수점 3까지 =>0.012
		console.log(fsize);
		
		html+=
		`
			<div>
				<span>파일명 : ${fname}</span>
				<span>사이즈 : ${fsize}MB</span>
				<span><button type="button" onclick="filedelete(${i})">삭제</button></span>
			</div>
		`
	})
	fileDrop.innerHTML=html;
}
//4.드래그앤드랍된 파일 목록에 특정 파일 제거 후 재출력
function filedelete(i){
	fileList.splice(i,1);printfiles();
}

















