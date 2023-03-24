console.log('gd');
let del_myno  ='';
function startmybody(){//1.시작하기 누르면 그동안의 입력값들이 출력되고 버튼들이생긴다
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
								<p>♥ 7일간의 기록</p>
								<td>날짜</td><td>몸무게</td>
							</tr>
						</table>`;
					
			if(r.length==0){
				 html+='<h6>아직 기록된 내용이 없어용 ㅠㅠ</br>기록을 눌러주세요 </h6>'
			}else{
			 
			r.forEach( (o,i)=>{
				
			html+=//수정하기 함수=>5번으로 이동
				`
				<div class="line">
					<input onclick="ckbox(event)" value="${o.myno}" class="ckbox"  name="ckbox" type="radio" >
					<a onclick="oneview(${o.myno})">
						<table  class="pbox2" >
							<tr>
								<td>${o.today}</td><td>${o.weight}kg</td>
							</tr>
						</table>
					</a>
				</div>
				`
				})//포문 끝
				
			}
			
			
			html+=
			`
				<div class="btn">
					<button onclick="writebody()">기록</button>
					<button class="opendel" onclick="opendel( )">삭제</button>
					<button class="deletedata" onclick="deletedata()">삭제</button>
				</div> 
				<div class="assay"><button  onclick="dataassay()" >데이트분석</button></div> 
			</div>`
			document.querySelector('.modal_box').innerHTML=html;
			
		}
	})//아작끝
	
	
}

//체크한값가져오기함수
function ckbox(e){
	if(e.target.checked){
		del_myno = e.target.value;
	}  
}
 

function opendel(){//opendel 버튼을 누르는 순간 ckbox 체크박스가 나옴,opendel 버튼 숨겨짐 deletedata삭제함수 실행 같은자리에 두기위해..
	
	
	let array =document.querySelectorAll('.ckbox');
	
	for(let i=0;i< array.length ; i++ ){
		array[i].style.display='flex';
	}
	document.querySelector('.opendel').style.display='none';
	document.querySelector('.deletedata').style.display='flex';
	
}

function deletedata(){ //삭제하기함수	
	console.log("삭제할번호 :"+del_myno)
	
	$.ajax({
		url:"/jspweb/nicebody",
		method:"delete",
		data:{del_myno:del_myno},
		success:(r)=>{
			console.log('삭제성공')
			console.log(r)
			startmybody();
		}
	})
	
}


function writebody(){//2.오늘의 몸상태 기록
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

function bodycheck(){ //3.db에 입력하고 모달을 닫아야한다
	console.log('ggggg')
	
	let today=document.querySelector('.today').value;
	let height=document.querySelector('.height').value;
	let weight=document.querySelector('.weight').value;
	let exercise=document.querySelector('.exercise').value;
	
	let bodycheck={
		today:today,
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


function closeModal(){//4.취소하기 첫페이지로 이동
	startmybody();
}




function oneview(myno){//5. 하나의 레코드 상세보기
	console.log('수정'+myno)
	
	$.ajax({//아작시작
		url:"/jspweb/nicebody",
		data:{"type":2,"myno":myno},//전체출력 //2는상세출력 예정
		method:"get",
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
						<div class="btn">
							<button onclick="updatebody(${myno})">수정하기</button>
							<button onclick="startmybody()">뒤로가기</button></div> 
						</div>`
				document.querySelector('.modal_box').innerHTML=html;
			}//성공끝
	
		})//아작끝
		
	}
	
function updatebody(myno){//6. 수정하기
	console.log('수정하기');
	console.log(myno); // undefined ?
	
	let html=`<h3>수정하기</h3>
						<div>
							<table  class="pbox1">
								<tr>
									<td>키</td><td>몸무게</td><td>운동</td>
								</tr>
							</table>
							<table  class="pbox2">
								<tr class="updatetext">
									<td><input class="upheight" type="text">cm</td> 
									<td><input class="upweight" type="text">kg</td>
									<td>
										<select class="upexercise">
											<option value="1">운동안함</option>
											<option value="2">계단오르기</option>
											<option value="3">요가</option>
											<option value="4">수영</option>
											<option value="5">줄넘기</option>
											<option value="6">자전거</option>
											<option value="7">런닝머신</option>
										</select>
									</td>
								</tr>
							</table>
						</div>
						<div class="btn">
							<button onclick="updateok(${myno})">수정완료</button>
						</div>` 
						
						document.querySelector('.modal_box').innerHTML=html;

	}

function updateok(myno){//수정완료
	console.log(myno);
	
	let upheight=document.querySelector('.upheight').value;
	let upweight=document.querySelector('.upweight').value;
	let upeno=document.querySelector('.upexercise').value;
	
	
	
	let upinfo={
		upheight:upheight,
		upweight:upweight,
		upeno:upeno,
		myno:myno
	};
	
	console.log(upinfo);//넘어옴 ok
		
	
	$.ajax({
		url:"/jspweb/nicebody",
		data:upinfo,
		method:"put",
		success:(r)=>{
			console.log('수정통신완료')
			console.log(r)
			startmybody();
			
		}
	})
	
	
}

	
	
