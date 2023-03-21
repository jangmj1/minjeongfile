/*ajax이용한 데이터 포탈의 데이터 가져오기*/

/*	$.ajax({
		
		url:"신청한공공 데이터url",
		method:"get",
		success:(r)=>{
			console.log(r)
		}
	})*/
	
	//공공데이터 : 시도별 미세먼지 실시간 현솽
	getap12();
	function getap12(){
		$.ajax({
			url:"https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey=cO9iM%2FZvQcqC9uLrdgNR0tPyBU3%2Bjxi9Z0u2x%2FNuYg%2FS2C4KCe0M5mlbabI9mrmILwew3%2FvR7M4YWaZ9IT2udw%3D%3D&returnType=json&numOfRows=125&pageNo=1&sidoName=%EA%B2%BD%EA%B8%B0&ver=1.0",
			method:"get",
			success:(r)=>{
				console.log(r);
				console.log(r.response.body.items)
			}
		})
	}
	
	
	
		
	
	
	//공공데이터 : 전기차충전소 현황가져오기
	getapi1()
	function getapi1(){
		
	$.ajax({
		
		url:"https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=cO9iM%2FZvQcqC9uLrdgNR0tPyBU3%2Bjxi9Z0u2x%2FNuYg%2FS2C4KCe0M5mlbabI9mrmILwew3%2FvR7M4YWaZ9IT2udw%3D%3D",
		method:"get",
		success:(r)=>{
			console.log(r)
			document.querySelector('.totalcount').innerHTML= '전기차 충전소 개수:'+r.totalCount+'개';
			let html=
				`<tr>
					<th>경도(WGS84)</th>
					<th>소재지도로명주소</th>
					<th>소재지우편번호</th>
					<th>소재지지번주소</th>
					<th>시군명</th>
					<th>운영기관명</th>
					<th>위도(WGS84)</th>
					<th>충전기타입명</th>
					<th>충전소명</th>
				</tr>`
				
				r.data.forEach( (o)=>{//o.경도(WGS84) , o.위도(WGS84) 이런것들은 함수 취급을 당해서 쩜! 사용불가=>대갈호 써야함 o['경도(WGS84)'] 
					html+=
					`<to>
					<td>${o['경도(WGS84)']}</td>
					<td>${o.소재지도로명주소}</td>
					<td>${o.소재지우편번호}</td>
					<td>${o.소재지지번주소}</td>
					<td>${o.시군명}</td>
					<td>${o.운영기관명}</td>
					<td>${o['위도(WGS84)']}</td>
					<td>${o.충전기타입명}</td>
					<td>${o.충전소명}</td>
				</tr>`
				})
			document.querySelector('.table').innerHTML=html;
			}
		})
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	