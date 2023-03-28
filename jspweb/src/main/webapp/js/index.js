/*	$.ajax({
		url:"/jspweb/product/info",
		method:"get",
		success:(r)=>{
			console.log('출력성공')
			console.log(r)*/
			
let productlist=null;
/*제품목록출력*/			
function productlistprint(){//<==눌렀을때 리스트들의 값이 출력
	
	let html='';
		productlist.forEach( (p,i)=>{
		console.log(p)
			html+=
			`<div onclick="productprint(${i})" class="productbox">
				<div class="pimgbox">
					<img src="/jspweb/product/pimg/${p.pimglist[0]}">
				</div>
				<div class="pcontentbox">
					<div class="pdate">${p.pdate}</div>
					<div class="pname">${p.pname}</div>
					<div class="pprice">${p.pprice.toLocaleString()}원</div>
					<div class="petc">
						<i class="far fa-eye"></i>${p.pview}
						<i class="far fa-thumbs-up"></i>5
						<i class="far fa-comment-dots"></i>2
					</div>
				</div>
			</div>`
		});
		document.querySelector('.productlistbox').innerHTML=html
}	
//제품 개별 출력 조회
function productprint(i){
	let p=productlist[i];
	
	let imghtml='';
		p.pimglist.forEach( (img,i)=>{
			
			if(i==0){
				
			/*active : 현재 보여지는 이미지를 뜻함 처음에 한번만 넣어야한다*/
			imghtml+=`<div class="carousel-item active"> 
					      <img src="/jspweb/product/pimg/${img}" class="d-block w-100" alt="...">
					    </div>`
			}else{
					imghtml+=`<div class="carousel-item"> 
					      <img src="/jspweb/product/pimg/${img}" class="d-block w-100" alt="...">
					    </div>`
			}
		})
		
			let html='';				
			html+=
			`<div class="pviewbox">
				<div class="pviewinfo">
					<div class="mimgbox">
						<img alt="" src="/jspweb/member/pimg/${p.mimg == null ? 'default.webp' : p.mimg }" class="hpimg">
						<span class="">${p.mid}</span>
					</div>
					<div >
						<button onclick=" productlistprint()" class="pbadge" type="button">목록보기</button>
					</div>
				</div>
			
				<!-- 이미지캐러샐 : 부트스트랩 -->
				<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
				  <div class="carousel-inner">
					${imghtml}
				  </div>
				  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
				    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Previous</span>
				  </button>
				  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
				    <span class="carousel-control-next-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Next</span>
				  </button>
				</div>
			
			
				<!-- 제품상세 내용물 -->
				<div class="pdate">${p.pdate}</div>
				<div class="pname">${p.pname}</div>
				<div class="pcomment">${p.pcomment}</div>
				<div class="pstate">
					<span  class="pbadge">${p.pstate==1?'판매중':p.pstate==2?'거래중':'판매완료'}</span>
				</div>
				<div class="pprice">${p.pprice.toLocaleString()}</div>
				<div class="petc">
					<i class="far fa-eye"></i>${p.pview}
						<i class="far fa-thumbs-up"></i>5
						<i class="far fa-comment-dots"></i>2
				</div>
				<div class="pviewbtnbox">
					<button class="plikebtn" onclick="setplike(${p.pno})" type="button"><i class="far fa-heart"></i></button>
					<button onclick="chatprint(${i})" type="button">쪽지보내기</button>
				</div>
			</div>`
	      	document.querySelector('.productlistbox').innerHTML=html;
}	


//쪽지보내기채팅
function chatprint(i){
	if(memberInfo.mid==null){
		alert('회원기능입니다. 로그인부터해주세요');
		return;
	}
	
	let p=productlist[i]
	let chathtml='';
	$.ajax({
		url:"/jspweb/product/chat",
		method:"get",
		data:{"pno":p.pno},
		async:false,//동기식으로
		success:(r)=>{
			console.log(r)
			
			r.forEach( (o)=>{
				if(o.frommno==memberInfo.mno){
					chathtml+=`<div class="sendbox">${o.ncontent}</div>`
					
				}else{
					chathtml+=`<div class="receivebox">${o.ncontent}</div>`
				}
				
			})
				
			}
	
		
	})
	
	
	
	
	
	
	console.log(p)
	let html=`
			<div class="chatbox">
				
				<div class="pviewinfo">
					<div class="mimgbox">
						<img alt="" src="/jspweb/product/pimg/${p.pimglist[0]}" class="hpimg">
						<span class="pname">${p.pname}</span>
					</div>
					
					<div >
						<button onclick=" productlistprint()" class="pbadge" type="button">목록보기</button>
					</div>
				</div>
				
				<div class="chatcontent">
					${chathtml}
				</div>
				
				<div class="chatbtn">
					<textarea class="ncontentinput" rows="" cols=""></textarea>
					<button onclick="sendchat(${p.pno},${p.mno})" type="button">전송</button>
				</div>
				
			</div>`
	
	document.querySelector('.productlistbox').innerHTML=html;
}



//5.쪽지보내기
function sendchat( pno , tomno ){
	console.log(pno);
	let ncontent = document.querySelector('.ncontentinput').value;
	
	$.ajax({
		url:"/jspweb/product/chat",
		method:"post",
		data:{ncontent:ncontent,pno:pno,tomno:tomno},
		success:(r)=>{
			console.log(r)
			if(r=='ture'){
				
				document.querySelector('.ncontentinput').value='';	
				printchat();
			}
		}
	})
	
	
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
 
 //2/마커 이미지변경
var imageSrc = '/jspweb/img/pppp.png', // 마커이미지의 주소입니다    
    imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      
// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
    markerPosition = new kakao.maps.LatLng(37.54699, 127.09598); // 마커가 표시될 위치입니다
 
 
 
 
 
 
 
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
        var markers = r.map((p,i)=> {
			console.log(p)
           //마커에 추가코드 작성하기위해 변수화
           let marker=  new kakao.maps.Marker({
                position : new kakao.maps.LatLng(p.plat, p.plng),
                image:markerImage
            });
            
	            // 마커에 클릭이벤트를 등록합니다
			kakao.maps.event.addListener(marker, 'click', function() {
					productprint(i)
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
