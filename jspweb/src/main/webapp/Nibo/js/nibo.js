console.log('gd');

function bodycheck(){ //db에 입력하고 모달을 닫아야한다
	console.log('ggggg')
	
	let today1=document.querySelector('.today').value;
	let height=document.querySelector('.height').value;
	let weight=document.querySelector('.weight').value;
	let exercise=document.querySelector('.exercise').value;
	
	let bodycheck={
		today:today1,
		height:height,
		weight:weight,
		exercise:exercise
	}
	console.log(bodycheck)
	
	$.ajax({
		url:"/jspweb/nicebody",
		metdod:"post",
		data:bodycheck,
		success:(r)=>{
			console.log('연동성공')
			console.log(r)
			
			if(r=='true'){
				alert('등록 완료')
				startmybody();
				
				//등록완료후 이동할 로케이션 생각하자
			}else if(r=='false'){
				alert('빈 칸을 채워주세요')
			}else if(r=='1'){
				alert('이전 날짜는 선택불가입니다.')
			}
		}
		
	})
}



function writebody(){//오늘의 몸상태 기록
	let  html=`<h3>bodycheck!</h3>
				
				<div class="bodycheck" >
					<div>
						<h4>날짜</h4>
						<input class="today" type="date">
					</div>
					<div>
						<h4>키</h4>
						<input class="height"  type="text">cm
					</div>
					<div>
						<h4>몸무게</h4>
						<input class="weight" type="text">kg
					</div>
					<div>
						<h4>오늘한운동</h4>
						<select class="exercise">
							<option value="1">운동안함</option>
							<option value="2">계단오르기</option>
							<option value="3">요가</option>
							<option value="4">수영</option>
							<option value="5">줄넘기</option>
							<option value="6">자전거</option>
							<option value="7">런닝머신</option>
						</select>
					</div>
				</div>
				
				
				<div class="modalBtn">
					<button onclick="bodycheck()" class="modal_check" type="button">확인</button>
					<button onclick="closeModal()" class="modal_cencel" type="button">취소</button>
				</div>`
				document.querySelector('.modal_box').innerHTML=html;
}

function closeModal(){//취소하기 하면 모달 닫힘
	startmybody();
}


function startmybody(){//시작하기 누르면 그동안의 입력값들이 출력되고 버튼들이생긴다
	document.querySelector('.modal_wrap').style.display='flex';
	console.log('프린트')
	$.ajax({//아작시작
		url:"/jspweb/nicebody",
		data:{"type":1},//전체출력 //2는상세출력 예정
		metdod:"get",
		success:(r)=>{
			console.log(r)
			let html=
					`<div>
						<table  class="pbox1">
							<tr>
								<td>날짜</td><td>몸무게</td>
							</tr>
						</table>`;
					
			if(r.lengtd==0){
				 html+='<h6>아직 기록된 내용이 없어용 ㅠㅠ</br>기록을 눌러주세요 </h6>'
			}else{
			 
			
			r.forEach( (o,i)=>{
				
			html+=
				`<a onclick="oneview(${o.myno})">
						<table  class="pbox2" >
							<tr>
								<td>${o.today}</td><td>${o.weight}kg</td>
							</tr>
						</table>
					</a>
				`
				})//포문 끝
			
	
			}
			html+=
			`
				<div><button onclick="writebody()">기록</button>
				<button onclick="printData()">데이터분석</button></div> 
			</div>`
			document.querySelector('.modal_box').innerHTML=html;
		}
	})//아작끝
	
	
}


function oneview(myno){
	console.log('수정'+myno)
	
	$.ajax({//아작시작
		url:"/jspweb/nicebody",
		data:{"type":2,"myno":myno},//전체출력 //2는상세출력 예정
		metdod:"get",
		success:(r)=>{
			console.log('통신완료')
			console.log(r)
			
			let html=`<h3>상세보기</h3>
						<div>
							<table  class="pbox1">
								<tr>
									<td>키</td><td>몸무게</td><td>비만율</td><td>운동</td>
								</tr>
							</table>
							<table  class="pbox2">
								<tr>
									<td>${r[0].height}cm</td><td>${r[0].weight}kg</td><td>${r[0].bmi}</td><td>${r[0].sports}</td>
								</tr>
							</table>
						</div>
						<div>
							<button onclick="updatebody(${r.myno})">수정하기</button>
							<button onclick="startmybody()">뒤로가기</button></div> 
						</div>`
				document.querySelector('.modal_box').innerHTML=html;
			}//성공끝
	
		})//아작끝
		
	}
	
function updatebody(myno){
	console.log('수정하기');
	console.log(myno); // undefined ? 
}
	
	
