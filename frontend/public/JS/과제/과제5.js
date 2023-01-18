//공통
let categoryList=['프리미엄','스페셜','와퍼','올데이킹','치킨버거']
let bugerlist=[
	{name:"몬스터x",price:9200,img:'몬스터x.png',category:'프리미엄'},
	{name:"콰트로치즈와퍼",price:10500,img:'콰트로치즈와퍼.png',category:'프리미엄'},
	{name:"통새우와퍼",price:8500,img:'통새우와퍼.png',category:'스페셜'}
]
let cartlist=[]
let orderlist=[]

category_print ()
category_select(0) //:기본값 프리미엄 빨갛게 보이게
product_print(0)	//:기본값 프리미엄
//1. 카페고리 출력하는 함수
function category_print (){
	let html=`<ul>`
		for(let i=0;i<categoryList.length;i++){
		html+=`<li class="categoryli" onclick="category_select(${i})">${categoryList[i]}</li>`
		}
		html+=`<ul>`
				
	
						
	document.querySelector('.categorybox').innerHTML=html				
	
}
//2. 카테고리 선택 함수 빨갛게되는거
function category_select(i){//i:선택된 li의 인덱스
	//1. 모든 li 가져와서 배열저장
	let categoryli=	document.querySelectorAll('.categoryli')
	
	//2. 모든 li 배열 반복문
	for(let j=0;j<categoryli.length;j++){
		if(j==i){//i=선택된 li / 만약에 if배열에서 내가 선택한 li의 인덱스와 같으면 
			categoryli[j].classList.add('categoryselect');
			
		}else{
			categoryli[j].classList.remove('categoryselect');
		}
	}
	
	product_print( i )
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
	console.log('주문전'+cartlist)
	//1.주문번호 만들기 즉 인덱스만들기
	let no=0;
	if( orderlist.length==0){no=1;} // 주문이 하나도 없으면 주문 번호는 1번이 될꺼다
	else{no=orderlist[orderlist.length-1].no+1} //만약에 아니면 마지막 인덱스의 주문번호 +1 *참고로 인덱스는 길이의 -1
	
	
	//총 가격 만들기
	
	let map배열=cartlist.map( (o)=>{console.log(o);return o; } )
	console.log(map배열)
	
	let total=0;
	for(let i=0;i<cartlist.length;i++){total+=cartlist[i].price}
			 
		//1.order 객체 만들기
		let order={
			no:no,
			items: map배열, //map( ()=>{  } )
			time:new Date(), // 현재 날짜와 시간을 호출해준다
			state: true, //true:주문 false:주문완료
			complete:0 , // 아직 주문완료 되기 전이기때문에 
			price : total
		 }
	
		//2.order 객체 배열에저장
		orderlist.push(order)
		console.log('주문전'+orderlist)
	
	
	
	
	
	//2.주문 환료후
	cartlist.splice(0)
	cart_print()
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









