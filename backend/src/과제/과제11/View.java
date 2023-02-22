package 과제.과제11;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
	
	private static View view=new View();
	private View() {}
	public static View getInstance() {
		return view;
	}
	
	Scanner scanner=new Scanner(System.in);
	
	public void index() {
		while (true) {
			System.out.println("1.관리자 2.사용자");
			int ch1=scanner.nextInt();
			if(ch1==1) {관리자();}
			else if (ch1==2) {사용자(); }
				
		}
	}	
		
	public void 관리자() {
		while (true) {
			try {
				System.out.println("1.제품등록  2.제품출력  3.이름,가격수정  4.재고수정 5.삭제");
				int ch=scanner.nextInt();
				if(ch==1) {newproduct();}
				else if (ch==2) {list();}
				else if (ch==3) {Update();}
				else if (ch==4) {UpdateInven();}
				else if (ch==5) {del();}
				
			} catch (InputMismatchException e) {
				System.out.println("잘못된입력입니다");
				//입력값 초기화
				scanner=new Scanner(System.in); //잘못된걸 썻을때 (예: a) 무한루프에 빠진다 초기화해줘야하기때문에 필수로 써줌
			} catch (Exception e) {
				System.out.println("관리자한테 문의하세요");
			}
		}
		
		
	}
	
	public void 사용자() {
		
		Userlist();
		while (true) {
			
			System.out.println("번호를 선택하시면 장바구니가 등록됩니다. 결제를 원하시면 0번를 눌러주세요");
			int ch=scanner.nextInt();
			cart(ch);
			if(ch==0) {  pay();}
			
			
			}
				
		}
			
		
		
	
	
	
	
	
	
	public void newproduct() {
		System.out.println("--------제품등록-------");
		System.out.println("제품명:");String pname=scanner.next();
		System.out.println("금액:");int pprice=scanner.nextInt();
		System.out.println("재고:");int pinven=scanner.nextInt();
		
		boolean result=
		Controller.getInstance().newProduct(pname, pprice, pinven);
			
		if(result) {
			System.out.println("제품등록성공");
		}else {
			System.out.println("제품등록실패");
		}
		
	}
	
	public void list() {
		System.out.println("----------출력창----------");
		System.out.printf("%2s \t %10s \t %10s \t %10s\n","번호","제품명","금액","재고");
		
		ArrayList<ProductDto> result=Controller.getInstance().list();
		for(int i=0;i<result.size();i++) {
			System.out.printf("%2d \t %10s \t %10s \t %10s\n",
					result.get(i).getPno(),
					result.get(i).getPname(),
					result.get(i).getPprice(),
					result.get(i).getPinven()
					);
			
		}
	}
	
	
	public void Update() {
		System.out.println("-------수정창--------");
		System.out.println("수정할 제품번호:"); int pno=scanner.nextInt();
		System.out.println("수정할 제품명:");	String pname=scanner.next();
		System.out.println("수정할 제품금액:"); int pprice=scanner.nextInt();
		
		boolean result=
		Controller.getInstance().Update(pno, pname, pprice);
		
		if(result) {
			System.out.println("수정완료");
		}else {
			System.out.println("수정실패");
		}
		
	}
	
	public void UpdateInven() {
		System.out.println("----------재고수정----------");
		System.out.println("재고수정할 제품번호를 작성하세요"); int pno=scanner.nextInt();
		System.out.println("수정할 재고:"); int pinven=scanner.nextInt();
		
		
		
			boolean result=
					Controller.getInstance().UpdateInven(pno, pinven);
			
			if(result) {
				System.out.println("재고수정완료");
			}else {
				System.out.println("재고수정실패");
			}
			
	}
	
	public void del() {
		System.out.println("--------삭제창--------");
		System.out.println("삭제할 번호를 입력하세요"); int pno=scanner.nextInt();
		
		boolean result=
		Controller.getInstance().del(pno);
		
		if(result) {
			System.out.println("삭제완료");
		}else {
			System.out.println("삭제실패");
		}
	}
	
	//여기까지 관리자
/*************************************************************************************************/
	//여기서부터사용자
	
	public void Userlist() {
		System.out.println("-------------------------------출력창------------------------------");
		System.out.printf("%2s \t %10s \t %10s \t %10s\n","번호","제품명","금액","상태");
		
		ArrayList<ProductDto> result=Controller.getInstance().list();
		for(int i=0;i<result.size();i++) {
			if(result.get(i).getPinven()<=0) {
				System.out.printf("%2d \t %10s \t %10s \t %10s\n",
						result.get(i).getPno(),
						result.get(i).getPname(),
						result.get(i).getPprice(),
						"재고부족" //int형인 pprice 를 스트링으로 형변환안돼서 이렇게함
						);
			}else {
				System.out.printf("%2d \t %10s \t %10s \t %10s\n",
						result.get(i).getPno(),
						result.get(i).getPname(),
						result.get(i).getPprice(),
						"판매중"
						);
			}
			
			
			
			
		}
	}
			
			
	public void cart(int ch){
		ArrayList<ProductDto> result=Controller.getInstance().cart(ch);
		System.out.println("장바구니수량"+result.size());
		
		
		
		/*ArrayList<ProductDto> inven=Controller.getInstance().list();
		int afterInven=inven.get(0).getPinven();
		afterInven--;*/
		
		
	}
	public void pay(){
		ArrayList<ProductDto> result=Controller.getInstance().cart(0);
		System.out.println("------------------결제창-----------------");
		for(int i=0;i<result.size();i++) {
			System.out.printf(
					
					"%2d \t %5s \t %5s  \t %5s \n",
					result.get(i).getPno(),
					result.get(i).getPname(),
					result.get(i).getPprice(),
					"1개"
					);
		}
		System.out.println(">>>>>>>>>>>>결제완료!!<<<<<<<<<<");
		
		
	}
	
	
	

}
