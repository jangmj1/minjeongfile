  var IMP = window.IMP;   // 생략 가능
  IMP.init("imp87238255"); // 예: imp00000000
 
 let pay=0;
 function setpay(p){
	 pay=p;
	 alert(p+'원 선택')
	 
 }
  
 /*포트원 가맹전 [관리자회원] 식별번호*/
  function requestPay() {
	  
	  if(pay==0){
		  alert('충전할 금액을 선택해주세요')
		  return;
	  }
    IMP.request_pay({
      pg: "kakaopay",//각 pg사 별 이름이 존재
      pay_method: "card", //결제방법도 있음 방식이 조금씩 틀린
      merchant_uid: "ORD20180131-0000011",   // 주문번호 결제 db에서 사용할것 pk
      name: "이젠 포인트 결제",
      amount: pay,                         // 숫자 타입
      buyer_email: "gildong@gmail.com",		//관리자정보
      buyer_name: "홍길동",
      buyer_tel: "010-4242-4242",
      buyer_addr: "서울특별시 강남구 신사동",
      buyer_postcode: "01181"
    }, function (rsp) { // callback
      if (rsp.success) { // 결제 성공 시 로직
        console.log(rsp)
      } else { // 결제 실패 시 로직
        console.log(rsp)
        //결제 성공 했다는 가정
        
        info={
			mpcomment:'포인트충전',
			mpamount:pay,
			mno:memberInfo.mno
		}
        $.ajax({
			
			url:"/jspweb/point",
			data:info,
			method:"post",
			success:(r)=>{
				if(r=="true"){alert('포인트 충전 완료')}
			}
			
			
		})
      }
    });
  } 

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  