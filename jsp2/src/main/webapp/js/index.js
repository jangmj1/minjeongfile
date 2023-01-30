let productList=[
	{img:'목살한상.png',title:'목살한상',size:'2~3인용',price:40000,discount:0.40,like:54,review:412},
	{img:'폭립한상.png',title:'폭립한상',size:'2~3인용',price:42000,discount:0.40,like:54,review:412},
	{img:'통겹살스테이크.png',title:'통겹살스테이크',size:'1~2인용',price:31000,discount:0.25,like:54,review:412},
	{img:'목살스테이크.png',title:'목살스테이크',size:'1~2인용',price:31000,discount:0.25,like:54,review:412},
	{img:'빠네크림파스타.png',title:'빠네크림파스타',size:'1~2인용',price:18000,discount:0.25,like:54,review:412},
	{img:'해물토마토파스타.png',title:'해물토마토파스타',size:'1~2인용',price:17000,discount:0.25,like:54,review:412}
]


product_print()
function product_print(){
	let html=''
	productList.forEach((o,i)=>{
	 html+=`<div class="item">
				<img class="img" src="img/${o.img}"><!-- 제품 이미지1 -->
				<div class="item_info"><!-- 제품정보 -->
					<div class="item_title">${o.title}</div>
					<div class="item_size">${o.size}</div>
					<div class="item_price">${ o.price.toLocaleString() }원	</div>
					<div>
						<span class="item_sale">${parseInt(o.price-o.price*o.discount).toLocaleString() }원	</span>
						<span class="item_discount">${ parseInt(o.discount*100) }%	</span>
					</div>
				</div>
				
				<div class="item_bottom">
					<div>
						<span class="badge rounded-pill text-bg-warning">BEST</span>
						<span class="badge rounded-pill text-bg-danger">MD추천</span>
					</div>	
					<div  class="item_review">찜${o.like}  리뷰수${o.review}</div>
				</div>
				
			</div> `
			
			
		})		
			document.querySelector('.itembox').innerHTML=html;
}


