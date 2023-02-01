
//공통
let categoryList=['프리미엄','스페셜','와퍼','올데이킹','치킨버거']
let bugerlist=[
	{name:"몬스터x",price:9200,img:'몬스터x.png',category:'프리미엄'},
	{name:"콰트로치즈와퍼",price:10500,img:'콰트로치즈와퍼.png',category:'프리미엄'},
	{name:"통새우와퍼",price:8500,img:'통새우와퍼.png',category:'스페셜'}
]
let cartlist=[]
let orderlist=[]

category_print()
category_select(0) //:기본값 프리미엄 빨갛게 보이게
product_print(0)	//:기본값 프리미엄
//1. 카페고리 출력하는 함수
function category_print (){
	let html=`<ul>`
		for(let i=0;i<categoryList.length;i++){
		html+=`<li class="categoryli" onclick="category_select(${i})">${categoryList[i]}</li>`
		}
		html+=`</ul>`
				
	
			
	document.querySelector('.categorybox').innerHTML=html				
	
}
//2. 카테고리 선택 함수 빨갛게되는거
function category_select(i){//i:선택된 li의 인덱스
	//1. 모든 li 가져와서 배열저장
	let categoryli=	document.querySelectorAll('.categoryli')
	
	//2. 모든 li 배열 반복문
	for(let j=0;j<categoryli.length;j++){//선택한 i 와 다.른.걸 찾기위해 포문돌린다
		if(j==i){//i=선택된 li / 만약에 if배열에서 내가 선택한 li의 인덱스와 같으면 
			categoryli[j].classList.add('categoryselect');//카테고리 선택한 i와 j가 같으면 css파일에서 빨갛게 꾸며논 .categoryselect 클래스를 넣는다
			
			}	else{
			categoryli[j].classList.remove('categoryselect');//css파일에서 꾸며논 .categoryselect 클래스를 빼서 회색으로 만든다 선택된 i가 아닌 j 를
			}
	
			product_print( i )
		}
}
//3. 제품 출력 함수 [js열렸을때,카테고리가 바겼을때 index들어온다]
function product_print( index ){
	console.log( index )
	let html=''
	
	for(let i=0;i<bugerlist.length;i++){
		 //i는 0번째 인덱스부터 마지막 인덱스까지 버거객체를 가져온다
	//1.html 구성 
		if( bugerlist[i].category == categoryList[index] ){
			// 모든 버거목록에서 i번째 버거객체의 카테고리와 내가 선택한 카테고리와 같으면 
			html+=`<div class="product" onclick="cartadd(${i})"><!-- 제품한개 -->
					<img  src="과제5/${bugerlist[i].img}" width="100%">
					<div class="productinfo">
						<div class="ptlte">${bugerlist[i].name}</div>
						<div class="pprice">${bugerlist[i].price.toLocaleString()}</div>  
					</div>								
				</div>`
								// toLocaleString 9200=>9,200 넣어준다 문자로인식
		}
	}
	//2. 구성된 html 마크업 대입
	document.querySelector('.productbox').innerHTML=html
		
}


//4.제품 선택 함수
function cartadd(i){
	//1.선택한 i 번째의 객체를 카트 리스트에 추가 푸쉬 중복되어도 상관없음
	cartlist.push(bugerlist[i])
	

	
	//4.카트내 버거 출력
	cart_print() //화면내에 새로고침 7번 참조
	
	
}



//5.주문 취소 버튼
function cancel(){ //i는 필요없다 모두삭제이기때문에 특정번호 삭제가아님
	cartlist.splice(0) // 갯수를 안넣으면 모두 삭제가 된다
	cart_print()
}




//6.주문 하기 버튼
function order(){
	
	
	alert('주문합니다')
	//1.주문번호 만들기 즉 인덱스만들기
	let num=0;
	if( orderlist.length==0){num=1;} // 만약에 주문이 하나도 없으면 주문 번호는 1번이 될꺼다
	else{num=orderlist[orderlist.length-1].no+1 ; console.log(' 마지막 주문의 주문번호 : ' + orderlist[orderlist.length-1].no )} // 아니면 마지막 인덱스의 주문번호 +1 *참고로 인덱스는 길이의 -1
	
	
	
	
	//총 가격 만들기
	
	let map배열=cartlist.map( (o)=>{return o; } )//map 함수에서 리턴된 객체를(o) 하나씩 반복되며 map배열에 대입
	
	
	let total=0;
	
	for(let i=0;i<cartlist.length;i++){total+=cartlist[i].price}
			
			 
		//1.order 객체 만들기
		let order={
			no:num,
			items: map배열, //map( ()=>{  } )
			time:new Date(), // 현재 날짜와 시간을 호출해준다
			state: true, //true:주문 false:주문완료
			complete:0 , // 아직 주문완료 되기 전이기때문에 
			price : total
		 }
	
		//2.order 객체 배열에저장
		orderlist.push(order)
		
		
	//2.주문 환료후
	주문현황출력()
	
	cartlist.splice(0)
	cart_print()
	현황()
}




//7. 카트네 버거 출력[1.제품 클릭 할때마다, 2. 주문 취소할때 =>화면을 업데이트 시킨다고생각하면된다]
function cart_print(){
		//3.버거 개수 증가 시키기
	document.querySelector('.pcount').innerHTML=cartlist.length
	
	//4.버거의 총 금액
	let total=0;
	for(let j=0;j<cartlist.length;j++){
			total+=cartlist[j].price
	}
	document.querySelector('.ptotal').innerHTML=total.toLocaleString()
	
	
	let html='' //헤더가 필요없기때문에 깡통
	for(let j=0;j<cartlist.length;j++){
		html+=`<div class="item">
				<div class="ititle">${cartlist[j].name}</div>
				<div class="iprice">${cartlist[j].price.toLocaleString()}원</div>
			 </div>`
	}
		//2. 구성된 html마크업에 대입
		document.querySelector('.cartbottom').innerHTML=html;
}

/*************************************************************************/

function 버거등록(){
let	새로운버거={
	 	name:document.querySelector('.이름').value,
		price:parseInt(document.querySelector('.가격').value),
		img:'스태커3와퍼.png' ,
		category:document.querySelector('.카테고리').value
	}
	
		if( !(categoryList.includes( 새로운버거.category)) ){
			alert('카테고리 확인해라.'); return;
			}
		else if(isNaN(새로운버거.price)){
			alert('금액은 숫자로 작성해주세요'); return; 
			}
		else{
			bugerlist.push(새로운버거)		
			product_print(0);console.log(bugerlist)}
			등록출력()	
			
	}	
	등록출력()
function 등록출력(){
	html=`<tr><th>제품번호</th><th>이미지</th><th>버거이름</th><th>카테고리</th><th>가격</th><th>비고</th></tr>`
	
	for(i=0;i<bugerlist.length;i++){
		html+=`<tr><td>${i+1}</td><td><img style="width: 40px;"  src= "과제5/${bugerlist[i].img}"></td><td>${bugerlist[i].name}</td>
				   <td>${bugerlist[i].category}</td><td>${bugerlist[i].price.toLocaleString()}원</td>
				   <td><button onclick="삭제버튼(${i})">삭제</button><button onclick="가격수정버튼(${i})">가격수정</button> </td></tr>`
	}
	document.querySelector('.신메뉴').innerHTML=html
}		


function 삭제버튼(i){
	bugerlist.splice(i,1)
	product_print(0)
	등록출력()
	console.log('버거리스트',bugerlist)
}

function 가격수정버튼(i){
	let 수정=prompt('금액을 수정해 주세요.')
	bugerlist[i].price=parseInt(수정)
	console.log(bugerlist[i].price)
	product_print(0)
	등록출력()
}
	
주문현황출력()	



function 주문현황출력(){
			let html= `<tr><th>주문번호</th><th>버거이름</th><th>상태</th><th>요청/완료일</th><th>비고</th></tr>`
			
			for(let i=0;i<orderlist.length ; i++){
				for(let j=0;j<orderlist[i].items.length;j++){
					console.log('orderlist',orderlist)
					
				
					
					console.log('orderlist[i].items.length',orderlist[i].items.length)
					
					console.log('order2',orderlist[i].items[j].name )
					
					
				let time1=orderlist[i].time.getHours()+':'+orderlist[i].time.getMinutes();
				if(orderlist[i].state==false){
					time1+= '/'+orderlist[i].complete.getHours()+':'+orderlist[i].complete.getMinutes();
				}	
					
				html +=  `<tr><td>${orderlist[i].no}</td><td>${orderlist[i].items[j].name}</td>
						 <td class="상태">${orderlist[i].state ? '주문요청':'주문완료'}</td>
						 <td>${time1}</td>
						 <td>${orderlist[i].state ? `<button class="주문버튼"  onclick="주문완료(${ (orderlist[i].no)-1} )">주문완료</button>`:''}</td></tr>`
																						//주문완료의 인덱스 (orderlist[i]만 쓰니까 안됨..why)
					
				}
				
				
			}	
				document.querySelector('.주문현황').innerHTML=html
	
		
				현황() 	
	
}





function 주문완료(j){
	console.log('no',j) //j 값은 오더리스트의 인덱스
	
	orderlist[j].state=false //클릭함과 동시에 state값이 펄스가됨 =>삼항연산자에값을 펄스로 바꿔 주문완료로 바꾼다
	orderlist[j].complete=new Date(); 
	
	console.log(orderlist[j].state) // 상태 펄스
	
	주문현황출력()//출력하면 삼항연산자가 바
	
	
	
	
}

현황()

function 현황(){
		let html= `<tr><th>제품번호</th><th>버거이름</th><th>판매수량</th><th>매출액</th><th>순위[매출액기준]</th></tr>`
		
			bugerlist.forEach( (buger,i )=>{//등록된 모든 버거가 반복중
				html +=`<tr><td>${i+1}</td><td>${buger.name}</td><td>${sales_count(i)}</td><td>${ (sales_count(i)*buger.price).toLocaleString() }</td><td>${sales_rank(i)}</td></tr>`
			})
				
		
		
		document.querySelector('.salestable').innerHTML=html
	
}


//8.판매수량 찾기
function sales_count(index){
	console.log('i번쨰 버거',i);
	let count=0;//i번째 제품의 누적 판매량수 저장하는 변수
	
	//2. 주문목록에서 i번째 제품 찾기
	orderlist.forEach((order,i  )=>{ //function sales_count(i) i가 중복되어 못써서 위에 index로 바꿨음 //주문목록 반복문
		order.items.forEach((buger,j  )=>{//주문마다 버거리스트 반복문
			console.log(buger)
			if(buger.name==bugerlist[index].name){count++}//만약에 현재  버거리스트내 버거이름과 index번째 버거이름과 같으면
		})
	})
	
	return count //i 번째 제품의 누적 판매량수 변수 반환
	
}
function sales_rank(index){console.log(index+' 번째 버거 순위')
let rank=1;// 1.index번째 버거의 순위 저장하는 함수[기본값 1등]
	//2.index번째 버거 순위 구하기
		
		//index 번째 버거의 매출액 //매출액 : 수량*금액
		let total=sales_count(index)*bugerlist[index].price;
		
		//2.모든 버거들 마다의 매출액
		bugerlist.forEach((buger,i)=>{
			let total2=sales_count(i)*buger.price;//각각의 모든 버거들의 판매수량*버거금액
			
			//3. 비교
			if(total < total2){rank++}//만약에 인덱스 번째 버거의 매출액이(total) 모든버거의 매출액을 구하고있는 total2보다 작으면 랭크를 올려라
			
		})

return rank;

}



