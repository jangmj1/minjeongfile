package 과제.과제9.상속예제2;

import java.util.Scanner;

public class 실행 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner scanner=new Scanner(System.in);	
			아이폰11 아이폰11=new 아이폰11();
			아이폰12 아이폰12=new 아이폰12();
	gg:	while (true) {
			System.out.println("1. 아이폰11 2. 아이폰12 ");
			int ch=scanner.nextInt();
			if(ch==1) {
				System.out.println("아이폰11의 비밀번호를 입력해주세요");
				String pw11=scanner.next();
					int result=아이폰11.지문인식(pw11);
					if(result==1) {
						System.out.println("잠금해제 성공!");
					}else if (result==2) {
						System.err.println("비밀번호가 틀렸어요!!!");
						continue gg;
					}
					System.out.println("1.결제하기 2.정보보기");	
					int ch2=scanner.nextInt();
					if(ch2==1) {
						아이폰11.카카오페이(pw11);
					}else if (ch2==2) {
						System.out.println("원하는 카메라(줌)와 용량(GB)을 적어주세요");
						String 카메라=scanner.next();
						String 용량=scanner.next();
						아이폰11.정보(카메라, 용량);
						
					}
					
					
					
			}else if (ch==2) {
				System.out.println("아이폰12의 비밀번호를 입력해주세요");
				String pw12=scanner.next();
				int result=아이폰12.지문인식(pw12);
				if(result==1) {
					System.out.println("잠금해제 성공!");
				}else if (result==2) {
					System.err.println("비밀번호가 틀렸어요!!");
					continue gg;
				}
				
				
				System.out.println("1.결제하기 2.정보보기");	
				int ch2=scanner.nextInt();
				if(ch2==1) {
					아이폰12.카카오페이(pw12);
				}else if (ch2==2) {
					System.out.println("원하는 카메라(줌)와 용량(GB)을 적어주세요");
					String 카메라=scanner.next();
					String 용량=scanner.next();
					아이폰11.정보(카메라, 용량);
					
				
				
				}
				
				
				
				
					
			}
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
	}

	
}
