package 과제.과제2;

import java.util.Scanner;

public class console키오스크 {//c s
	
	public static void main(String[] args) {//m s
	/*
		 과제2 [ console  키오스크 ]
					요구사항
					1. 제품 가격
						1.콜라[300원]  2.사이다[400원]  3.환타[500원]
					
					2. 제품 초기 재고
						콜라 10개	, 사이다 8개 , 환타 15개      * 판매시 재고 차감되고 다시 채우기 제외 
					3. 키오스크 메뉴 [ 무한루프 : 종료 없음(24시간) ] 
						1. 콜라 2.사이다 3.환타 4.결제
						[ 1~3 선택시 ]
							- 재고가 있을경우 장바구니 담기 / 없으면 '재고부족' 출력 
						[ 4 선택시 ] 
							- 현재 장바구니 현황 표시 목록 
							----------------------------------
							제품명	수량	가격
							사이다	1	400
							환타	2	1000
							환타		2	1000
							총가격 : 1400

							- 결제메뉴 표시
								1. 결제 2.취소 
								[결제]
									- 금액 입력받아 총가격에 뺀 잔액 출력 -> 결제 성공시 장바구니 초기화 
									- 만약에 금액이 부족하면 결제 취소 -> 장바구니 초기화 / 재고 다시 되돌리기
								[취소]
									- [ 장바구니 초기화 / 재고 다시 되돌리기 ] */
		
		Scanner scanner=new Scanner(System.in);
		
		String a="콜라";	String b="사이다";	String c="환타";	String d="결제";
		
		int 콜라=10;	int 사이다=8;	int 환타=15;
		
		int 콜라가격=300;	int 사이다가격=400;	int 환타가격=500;
		
		int 콜라장바구니=0;	int 사이다장바구니=0;	int 환타장바구니=0;
		
		int 통장잔고=10000; 
		
		int 콜라주문=0; int 사이다주문=0; int 환타주문=0;
		
		while (true) {
			System.out.println("콜라 사이다 환타 결제중 선택해주세요");
			String 음료= scanner.next();
			if(음료.equals(a)) {//if콜라 s
				System.out.println("콜라의 재고:"+콜라+"개");
				System.out.println("몇개를 주문하시겠습니까?:");
				콜라주문=scanner.nextInt();
				if(콜라주문<=콜라) {//if1 s
					콜라-=콜라주문;
					콜라장바구니+=콜라주문;
					System.out.println("콜라의남은수량:"+콜라);
					System.out.println("장바구니:"+콜라장바구니);
					
				}//if1 e
				else {
					System.out.println("재고가부족합니다");
				}
				
			}//if콜라 e
			else if (음료.equals(b)) {//if사이다s
				System.out.println("사이다의 재고:"+사이다+"개");
				System.out.println("사이다몇개살껀데요?:");
				사이다주문=scanner.nextInt();
				if(사이다주문<=사이다) {//if2 s
					사이다-=사이다주문;
					사이다장바구니+=사이다주문;
					System.out.println("사이다의남은수량:"+사이다);
					System.out.println("장바구니:"+사이다장바구니);
					
				}//if2 e
				else {
					System.out.println("사이다가 다떨어졌으예~~");
				}
			}//if사이다 e
			else if (음료.equals(c)) {//if환타s
				System.out.println("환타의 재고:"+환타+"개");
				System.out.println("환타몇개살껀데요?:");
				환타주문=scanner.nextInt();
				if(환타주문<=환타) {//if2 s
					환타-=환타주문;
					환타장바구니+=환타주문;
					System.out.println("환타의남은수량:"+환타);
					System.out.println("장바구니:"+환타장바구니);
					
				}//if2 e
				else {
					System.out.println("재고가부족합니다");
				}
			}//if환타 e
			else if (음료.equals(d)) {//결제 s
			/*	
				----------------------------------
				제품명	수량	가격
				사이다	1	400
				환타	2	1000
				환타		2	1000
				총가격 : 1400 */
			int total=(콜라장바구니*콜라가격)+ (사이다장바구니*사이다가격)+(환타장바구니*환타가격);
			System.out.println("-----------장바구니----------");	
			System.out.printf("%6s %5s  %6s \n","제품명","수량","가격");	
			System.out.printf("%6s %5s  %6s \n",a,콜라장바구니,콜라가격);	
			System.out.printf("%6s %5s  %6s \n",b,사이다장바구니,사이다가격);	
			System.out.printf("%6s %5s  %6s \n",c,환타장바구니,환타가격);	
			System.out.printf("%6s %10s  \n","총가격",total+"원"  );	
			System.out.printf("1.결제 2.취소" );	
			int 결제=scanner.nextInt();
				if(결제==1) {//if1 s
					if(통장잔고>total) {
						
						System.out.println(total+"원을 결제합니다");
						System.out.println("남은잔액:"+(통장잔고-total)+"원");
						콜라장바구니=0;사이다장바구니=0;환타장바구니=0;
						System.out.println("장바구니:"+ (콜라장바구니+사이다장바구니+환타장바구니)+"개" );
						
					}else {
						System.out.println("잔액이 부족합니다");
					}
					
				}//if1 e
				else {
					System.out.println("주문이 취소되었습니다.");
					콜라장바구니=0;사이다장바구니=0;환타장바구니=0;
					System.out.println("장바구니:"+ (콜라장바구니+사이다장바구니+환타장바구니)+"개" );
					콜라+=콜라주문;
					사이다+=사이다주문;
					환타+=환타주문;
					System.out.println(
							"콜라재고:"+콜라+"개"+
							"사이다재고:"+사이다+"개"+
							"환타재고:"+환타+"개");			
				}
					
					
					
					
					
					
					
					
			}//결제 e
			
			else {
				System.out.println("[알림]알수없는 번호입니다.");
			}
		
		
		
		
		
		
		
		
		
		
		
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//m s

}//c e
