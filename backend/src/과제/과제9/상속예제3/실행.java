package 과제.과제9.상속예제3;

import java.util.ArrayList;
import java.util.Scanner;

public class 실행 {
	
		
		ArrayList<냉장고>냉장고Db=new ArrayList<>();
		
		private static 실행 실행=new 실행();
		private 실행() {}
		
		public static 실행 get실행() {	return 실행;}


		 Scanner scanner=new Scanner(System.in);

		 public void index() {
			while (true) {
				System.out.println("1.딤채냉장고 2.엘지냉장고 3. 삼성냉장고");
				int ch=scanner.nextInt();
				if(ch==1) {
					딤채냉장고 딤채냉장고=new 딤채냉장고();
					딤채냉장고.등록();
					냉장고Db.add(딤채냉장고);
					System.out.println("등록이 완료 되었습니다");
					//냉장고 db 안에 도어가 들어갔는지 확인불가 아마도 자료형이 냉장고인것같다  ??
					
					
					
				}else if ( ch==2) {
					엘지냉장고 엘지냉장고=new 엘지냉장고();
					엘지냉장고.등록();
					냉장고Db.add(엘지냉장고);
					System.out.println("등록이 완료 되었습니다");
					
					
				}else if (ch==3) {
					삼성냉장고 삼성냉장고=new 삼성냉장고();
					삼성냉장고.등록();
					냉장고Db.add(삼성냉장고);
					System.out.println("등록이 완료 되었습니다");
					
				}else {
					System.err.println("없는번호입니다");
				}
				
				
			
			
			
			
			}	
			
			
		}
		
	
	
}