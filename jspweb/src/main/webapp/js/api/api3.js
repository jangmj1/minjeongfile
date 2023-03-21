

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(37.3218778, 126.8308848), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };
// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption); 
    
/*------------------마커이미지변경------------------------------------*/		

var imageSrc = 'http://localhost:8080/jspweb/img/pppp.png', // 마커이미지의 주소입니다    
    imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      
// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
    markerPosition = new kakao.maps.LatLng(37.54699, 127.09598); // 마커가 표시될 위치입니다
    
    


// 마커 클러스터러를 생성합니다 
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 8 // 클러스터 할 최소 지도 레벨 
    });

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();



 $.get(//get s
		
		"https://api.odcloud.kr/api/3035882/v1/uddi:5fae3cf5-bc15-4eba-87d8-8289b74e659b_201912202015?page=1&perPage=292&serviceKey=z427Q0DLkQqM0SDOc1Lz8jPzk%2BKj0ng%2Bvz7h3I8CpVs3T90219bWi2o%2BmStIxJW%2B9lwayA%2FsAT6apxsxuvydQg%3D%3D",
       (r)=>{
			   console.log(r)
			   console.log(r.data)
			   // 주소로 좌표를 검색합니다
			   
			$(r.data).map( function(i,o){//포문시작
				
				
				//주소를 가지고 장소를 찍어줌
				geocoder.addressSearch( o.주소 , function(result, status) {//geo s
		
		    // 정상적으로 검색이 완료됐으면 
		     if (status === kakao.maps.services.Status.OK) {//if s
		
			        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			
			        // 결과값으로 받은 위치를 마커로 표시합니다
			        let marker = new kakao.maps.Marker({//s
			            map: map,
			            position: coords,
			            image : markerImage
			       		 });//e
			        // 인포윈도우로 장소에 대한 설명을 표시합니다
			        var infowindow = new kakao.maps.InfoWindow({
			            content: `<div style="width:150px;text-align:center;padding:6px 0;">${o.약국명}</div>`
			        });
			        infowindow.open(map, marker);
			
			        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			        map.setCenter(coords);
			        
			        kakao.maps.event.addListener(marker, 'click', function() {
				//클릭했을때 모달 띄우기
				
				//
				document.querySelector('.modal_title').innerHTML=o.약국명;
				document.querySelector('.modal_title').style.fontSize='10px';
				
				document.querySelector('.modal_content').innerHTML=o
				
				openModal();
				
			});	
			      
			       		 
					clusterer.addMarker(marker);
					   
					}//if e
					
				});//geo e
				
				
			})//포문 끝
			 
			 
	})//get e 
			 
			 
			 
			 
			 
			 
			 