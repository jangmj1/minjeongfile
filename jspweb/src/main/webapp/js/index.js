/*	$.ajax({
		url:"/jspweb/product/info",
		method:"get",
		success:(r)=>{
			console.log('출력성공')
			console.log(r)*/
			
let productlist=null;
			
function productlistprint(){//<==눌렀을때 리스트들의 값이 출력
	
	let html='<h3>제품목록페이지</h3>';
		productlist.forEach( (p)=>{
			html+=
					`<div>
						<span>${p.pname}</span>
						<span>${p.pcomment}</span>
						<span>${p.pprice}</span>
						<span>${p.pstate}</span>
						<span>${p.pview}</span>
						<span>${p.pdate}</span>
					</div>`
		});
		document.querySelector('.productlistbox').innerHTML=html
}			
			
			
	//1.지도넣기		
		console.log('연동')
		var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표 
        level : 6 // 지도의 확대 레벨 
    });
    
    
    
    //2/마커 클러스터러를 생성합니다 
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 8 // 클러스터 할 최소 지도 레벨 
    });
 
 
 //1.제품목록 호출[1.현재 보이는 지도 좌표내 포함된 제품만]
 function getproductList(동,서,남,북){//현재지도에 동서남북 좌표를 넣어서 아작트로 
 	//클러스터를 비워야한다 이동될떄마다 쌓임
 	clusterer.clear();
 	$.ajax({//아작시작
		 url:"/jspweb/product/info",
		 method:"get",
		 async:false,
		 data:{"동":동,"서":서,"남":남,"북":북},
		 success:(r)=>{
			 console.log(r)
			 
		 
	
        // 데이터에서 좌표 값을 가지고 마커를 표시합니다
        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
       
       /*----------------------------------사이드바제품목록------------------------ */
		productlist=r//제품목록결과인 r값을 전역변수로 빼놓은 productlist 에 넣는다
		productlistprint()
       
       /*----------------------------------마커작업------------------------ */
       		//.MAP( (인덱스,반복객체명)=>{ })		=>실행문에서return 값을 배열에 대입
       			//vs
       		//.forEach( (반복객체명,인덱스)=>{ })	=>실행문에서 return값 x
        var markers = r.map((p)=> {
			console.log(p)
           //마커에 추가코드 작성하기위해 변수화
           let marker=  new kakao.maps.Marker({
                position : new kakao.maps.LatLng(p.plat, p.plng)
            });
            
	            // 마커에 클릭이벤트를 등록합니다
			kakao.maps.event.addListener(marker, 'click', function() {
				let html=`<button onclick=" productlistprint()"> <==</button><h3>제품상세페이지</h3>`;
				html+=
					`<div>
						<div>${p.pname}</div>
						<div>${p.pcomment}</div>
						<div>${p.pprice}</div>
						<div>${p.pstate}</div>
						<div>${p.pview}</div>
						<div>${p.pdate}</div>
						<div><button class="plikebtn" onclick="setplike(${p.pno})" type="button"> ${getplike(p.pno)}</button></div>
					</div>`
	      			document.querySelector('.productlistbox').innerHTML=html;
				});//클릭이벤트 end
            
            return marker;
      		  });//map end

        // 클러스터러에 마커들을 추가합니다
        clusterer.addMarkers(markers);
       /*--------------------------------------------------------------- */
   			}//success end
   
   		 });//ajax end
		
     
	 
 }//getproductList end
 
 //2.현재지도의 좌표 얻기
 get동서남북();//처음에 한번 실행하고
 function get동서남북(){
	 		   
		       // 지도의 현재 영역을 얻어옵니다 
    var bounds = map.getBounds();
    
    // 영역의 남서쪽 좌표를 얻어옵니다 
    var swLatLng = bounds.getSouthWest(); 
    
    // 영역의 북동쪽 좌표를 얻어옵니다 
    var neLatLng = bounds.getNorthEast(); 
    

	let 남=swLatLng.getLat();
	let 서=swLatLng.getLng();
	let 북=neLatLng.getLat();
	let 동=neLatLng.getLng();
	//좌표를 다 구해주고 그 좌표를 가지고 getproductList함수실행
	getproductList(동,서,남,북);
 }
    
    

 /*------------------------------지도 중심 좌표 이동 이벤트+지도정보불러오기--------------------------------- */
 kakao.maps.event.addListener(map, 'dragend', function() {//dragend드레그가 끝나면 중심좌표알려줌
	//드레드할때마다 실행되고	   
		       // 지도의 현재 영역을 얻어옵니다 
    var bounds = map.getBounds();
    
    // 영역의 남서쪽 좌표를 얻어옵니다 
    var swLatLng = bounds.getSouthWest(); 
    
    // 영역의 북동쪽 좌표를 얻어옵니다 
    var neLatLng = bounds.getNorthEast(); 
    

	let 남=swLatLng.getLat();
	let 서=swLatLng.getLng();
	let 북=neLatLng.getLat();
	let 동=neLatLng.getLng();
	//좌표를 다 구해주고 그 좌표를 가지고 getproductList함수실행
	getproductList(동,서,남,북);
	  
});

//3.찜하기 버튼을 눌렀을때[첫 클릭시 찜하기 다음클릭시 찜하기 취소 또 다음 클릭시 찜하기]
function setplike(pno){
	if(memberInfo.mid==null){
		alert('회원기능입니다. 로그인후 사용해주세요'); return;
	}
	
	
	$.ajax({
		url:"/jspweb/product/like",
		method:"post",
		data:{"pno":pno},
		success:(r)=>{
			console.log(r)
			if(r=='true'){
				alert('찜하기등록')
				document.querySelector('.plikebtn').innerHTML='♥'
			}else{
				alert('찜하기취소')
				document.querySelector('.plikebtn').innerHTML='♡'
			}
		}
	/*
	
	*/
	})
		
}	

//4.현재 회원이 해당 제품을 찜했는지 안했는지 상태 호출
/*function getplike(pno){
		if(memberInfo.mid==null){return '♡';	}
	$.get( "/jspweb/product/like?pno="+pno,(r)=>{
		console.log("찜한상태:"+r)
		if(r=='true'){return '♥'}
		else{return '♡';}
		
	});
	
}*/
function getplike(pno){
		if(memberInfo.mid==null){document.querySelector('.plikebtn').innerHTML='♡';	}
	$.get( "/jspweb/product/like?pno="+pno,(r)=>{
		console.log("찜한상태:"+r)
		if(r=='true'){document.querySelector('.plikebtn').innerHTML='♥'}
		else{document.querySelector('.plikebtn').innerHTML='♡';}
		
	});
	
}
