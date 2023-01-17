/*
	객체
	1.미리 만들어진 객체
		1. console객체
			console.log( )
		2. Math 클래스
			Math.random( )
		3. document객체 : DOM객체
			document.qeurySelector( )
		등등등
		
	2.사용자 정의 객체 
		
*/
// 1. DOM 객체 : HTML를 객체화
let h1 = `<h1>${ '안녕하세요' }</h1>`
document.body.innerHTML = h1

// 2. DOM 객체의 이벤트
	// 1. 기존 함수 적용 
function 함수1(){ console.log('문서열림1') }

document.addEventListener( 'DOMContentLoaded' , 함수1  )//html 열렸을때 사용 

	// 2. 익명[이름없는] 함수 적용 
window.onload = function(){ console.log('문서열림2') }
document.addEventListener( 'DOMContentLoaded' , function(){ console.log('문서열림2')  })

	// 3. 화살표[ ( 인수 ) => { 실행문 } ] 함수 적용 
window.onload = () => { console.log('문서열림3') }
document.addEventListener( 'DOMContentLoaded' , () => { console.log('문서열림3') } )

let 익명함수 = function ( ){ console.log('문서열림5') }
let 화살표함수 = ( ) => { console.log('문서열림4') }
let 객체 = { 행동 : ( )=>{ console.log('문서열림6') } }






/*객체
   1.사용자정의 객체
            let 객체명={
               속성명:데이터,
               속성명:데이터,
               속성명:데이터
         }   
   2.미리 만들어진 객체
         1.document
               1.document.body.innerHTML=데이터 :body 마크업에 html형식으로 대입
               
               2.마크업 객체화
               *<div class="box1"
                  let 객체명=document.querySelector('식별자')       :해당하는 식별자와 마크업을 1개 객체반환
                  let 객체배열명=document.querySelectorAll('식별자')    :해당하는 식별자의 모든 마크업 객체를 배열로 반환
               
               3.객체명.addEventListener('이벤튼',(e)=>{})
                        *e(event):이벤트 실행결과 정보객체 인수받음
                        1.DOMContentLoaded   :html열렸을때
                        2.click              :클릭했을때
                        3.keyup              :키보드 키를 떼었을떄
                        4.keydown            :키보드 키를 눌렀을때 
                              e.keyCode
                              
               4.객체명.style
                     *카멜표시법:justify-content-> justifyContent
                     객체명.style.justifyContent='center'   
                     
         *내장함수            
             inNaN[데이터]: 만약에 데이터가 숫자가 아니면 true 숫자이면 false
             typeof[데이터]: 해당 데이터형 확인[object, array, function등등]               
 */                                          

























