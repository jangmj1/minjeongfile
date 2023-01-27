/**
 * 
 *///1.userbox/logbox/monbox Dom객체 가져오기
let userbox=document.querySelector('.userbox')
let monbox=document.querySelector('.monbox')
let logbox=document.querySelector('.logbox')
let logbox2=document.querySelector('.logbox2')
let mhp_box=document.querySelector('.mhp_box')
let uhp_box=document.querySelector('.uhp_box')

let 몬스터=[
	{img:'몬스터2.gif',hp:100,left:910,exp:50},
	{img:'몬스터3.gif',hp:200,left:910,exp:50},
	{img:'몬스터4.gif',hp:300,left:910,exp:50},
	{img:'몬스터5.gif',hp:400,left:910,exp:50}
]

/*userbox [기본/처음]위치*/
let u_left=10;//유저의 위치
let m_left=910 //몬스터의위치
let mhp = 100;
let uhp = 100;

//2. 문서안에서 키 입력이동이벤트
document.addEventListener('keydown',(e)=>{
   /*console.log('키입력')
   console.log(e)
   console.log(e.keyCode)
   */
   
   
   let key =e.keyCode;  //입력된 키 코드를 변수에 저장
   if(key==37){//왼쪽키
      u_left -=10
      u_left=u_left<0? 0:u_left //만약에 차감된 왼쪽 좌표가 0보다 작으면 (즉 흰배경으로 나가게되면 못나가게하려고) u_left 값을 최소0으로 ..
   }else if(key==39){//오른쪽키
      u_left +=10
      /*console.log(u_left)*///맨 오른쪽으로 이동했을때 값보려고 
      u_left=u_left>910? 910:u_left //만약에 차감된 왼쪽 좌표가 0보다 작으면 (즉 흰배경으로 나가게되면 못나가게하려고) u_left 값을 최소0으로 ..
      userbox.style.backgroundImage=`url("img/캐릭터2_이동.png")`
      userbox.style.backgroundSize=`110%`
   }else if(key==65){//a키 공격키로 만들기
   		userbox.style.backgroundImage=`url("img/캐릭터2_이동.png")`
   		console.log(m_left)
   		
   		if( m_left-u_left > 0 && m_left-u_left < 100){
			   console.log('작동')
				몬스터치명타()	
				console.log('mhp',mhp)		  
			  	mhp<0 ? mhp=0 : mhp=mhp
			  	mhp_box.style.width = `${ mhp }px`
			  	
		}
			   
   }
	
     if(mhp<=0){
		monbox.style.backgroundImage='url("")'
		몬스터출력()
		
		
 	}if(m_left-u_left>0 && m_left-u_left<50){
		 유저치명타()
		 uhp<0 ? uhp=0 : uhp
		 uhp_box.style.width=`${uhp}px`
	 }if(uhp<=0){
		 alert('게임종료되었습니다')
	 }
 	
   

   
   userbox.style.left=`${u_left}px`//키 입력후 css:left 변경
   
   logbox.innerHTML=`<div>좌표:${u_left}</div>`
   
 	document.querySelector('.mhp').innerHTML='hp:'+mhp 
 	document.querySelector('.uhp').innerHTML='hp:'+uhp 
   
})
	

	document.addEventListener('keyup',(e)=>{
		 userbox.style.backgroundImage=`url("img/케릭터.png")`
		 userbox.style.backgroundSize=`90%`
	})
	
	//3. 몬스터 	

// setInterval ((  )=>{  } , 밀리초 1000/1초) 


setInterval ( mon_moving , 1000) 


function mon_moving(  ) {
	//1. 난수 +-10
	let rand=parseInt(Math.random()*100+1);//1~100까지 //이동거리
	let rand2=parseInt(Math.random()*2) //0 or 1 // 이동방향
	if(rand2==1) m_left+=rand
	else m_left-=rand
	
	
	//2. 화면 밖으로 안나가게하기위해
	if(m_left<0)m_left=0;
	if(m_left>910)m_left=910;
	//3.
	monbox.style.left=`${ m_left }px`
	logbox2.innerHTML=`<div>몹좌표:${m_left}</div>`
	
	
	
}
/*
	함수의 형태
		1.일반함수: function 함수명() {  } *재호출가능
		2.익명함수: function () {  }
		3.람다식함수: ()  => {  }
		4.변수함수:  let 변수명 =() = {} *재호출가능
		
	let rand=Math.random();//0~1까지
	let rand=Math.random()*10;//0~10까지 9.9999까지
	let rand=Math.random()*10+1;//1~10까지 9.9999까지
	let rand=parseInt(Math.random()*10+1);//1~10까지의 정수만
*/

function 몬스터치명타(){
	let rand=parseInt(Math.random()*20+1 )
	mhp-=rand
	console.log('rand',rand)
}
function 유저치명타(){
	let rand=parseInt(Math.random()*10+1 )
	uhp-=rand
	console.log('rand',rand)
}



function 몬스터출력(){
	
	for(i=0;i<몬스터.length;i++){
		if
	}






















	