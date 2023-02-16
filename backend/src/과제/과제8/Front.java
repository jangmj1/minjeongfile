package 과제.과제8;

import java.util.ArrayList;
import java.util.Scanner;

public class Front {
	
	
	public ArrayList<화장품> 화장품디비 = new ArrayList<>();
	public Scanner scanner = new Scanner(System.in);
	
	// 싱글톤 : 내부에 객체를 미리 만들고  외부에서 new 사용 못하게 생성자 막는다.
	private static Front f = new Front();
	private Front() {}
	public static Front getF() { return f; }
	
	public void index() {
		while( true) {
			System.out.println("-----올리브영 관리자페이지-----");
			출력();
			System.out.println("메뉴>> 1.제품등록 2.상세보기");
			int ch = scanner.nextInt();
			if ( ch == 1 ) { 등록();	}
			else if ( ch == 2 ) { 상세보기();	}
		}
	}
	public void 등록() {
		System.out.println("1.파운데이션 2. 립스틱 3. 로션");
		int ch = scanner.nextInt();
		if ( ch == 1 ) {파운데이션();	}
		else if ( ch == 2 ) {립스틱만들기();	}
		else if ( ch == 3 ) {로션만들기();	}
		else { System.out.println("잘못된번호입니다.");	}
		
	}
	
	public void 상세보기(){
		System.out.println("번호를 선택해주세요");
		int no=scanner.nextInt();
		화장품 temp = 화장품디비.get(no);
		
		if( temp instanceof 파운데이션) {
			
			( (파운데이션)temp ).상세보기();
			
		}
		if( temp instanceof 립스틱 ) {
			
			 ( (립스틱)temp ).상세보기();
		}
		if( temp instanceof 로션) {
			((로션)temp).상세보기();
			
		}
		
	}
	
	
	
	
	
	
	
	public void 파운데이션() {
		System.out.println("제품명 : "); String 제품명 = scanner.next();
		System.out.println("가격 : "); int 가격 = scanner.nextInt();
		System.out.println("칼라 : "); int 칼라 = scanner.nextInt();
		System.out.println("제형 : "); String 제형 = scanner.next();
		
		파운데이션 파운데이션=new 파운데이션(제품명, 가격, 칼라, 제형 );
		파운데이션.등록( );
		
		
	}
	
	public void 립스틱만들기() {
		System.out.println("제품명 : "); String 제품명 = scanner.next();
		System.out.println("가격 : "); int 가격 = scanner.nextInt();
		System.out.println("칼라 : "); String 칼라 = scanner.next();
		System.out.println("제형 : "); String 제형 = scanner.next();
		립스틱 립스틱=new 립스틱(제품명, 가격, 칼라, 제형);
		립스틱.등록(  );
	}
	
	
	
	public void 로션만들기() {
		System.out.println("제품명 : "); String 제품명=scanner.next();
		System.out.println("가격 : ");   int 가격=scanner.nextInt();
		System.out.println("피부타입 : "); String 피부타입=scanner.next();
		로션 로션=new 로션(제품명, 가격, 피부타입);
		로션.등록();
	}
	
	public void 출력() {
		System.out.println("번호\t제품명\t가격");
		for(int i=0; i<화장품디비.size(); i++) {
			System.out.println(i+"\t"+화장품디비.get(i).get제품명()+"\t"+화장품디비.get(i).get가격());
		}
	}
	
}


















