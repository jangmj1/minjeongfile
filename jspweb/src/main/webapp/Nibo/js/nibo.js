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
		method:"post",
		data:bodycheck,
		success:(r)=>{
			console.log('연동성공')
			console.log(r)
			
			if(r=='true'){
				alert('등록 완료')
				print();
				//등록완료후 이동할 로케이션 생각하자
			}else if(r=='false'){
				alert('빈 칸을 채워주세요')
			}else if(r=='1'){
				alert('이전 날짜는 선택불가입니다.')
			}
		}
		
	})
}

function mybody(){
	document.querySelector('.modal_wrap').style.display='flex';
	let html=`<h3 class="modal_title">bodycheck!</h3>
				
				<div class="bodycheck" >
					<div>
						<div>날짜</div>
						<input class="today" type="date">
					</div>
					<div>
						<div>키</div>
						<input class="height"  type="text">cm
					</div>
					<div>
						<div>몸무게</div>
						<input class="weight" type="text">kg
					</div>
					<div>
						<div>오늘한운동</div>
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
function closeModal(){
	document.querySelector('.modal_wrap').style.display='none';
}


function print(){//출력
	console.log('프린트')
	$.ajax({//아작시작
		url:"/jspweb/nicebody",
		data:{"type":1},//전체출력 //2는상세출력 예정
		method:"get",
		success:(r)=>{
			console.log('통신성공');
			console.log(r);
			
			let html=`
						<table>
							<tr>
								<th>날짜</th><th>몸무게</th>
							</tr>
						</table>
					`
			
			r.forEach( (o,i)=>{
				
			html+=
				`
					<table>
						<tr>
							<td>${o.today}</td><td>${o.weight}</td>
						</tr>
					</table>
					<button onclick="mybody()">시 작 하 기</button>
				`
			})//포문 끝
			console.log(html);
			document.querySelector('.modal_box').innerHTML=html;
		}
	})//아작끝
	
	
}
