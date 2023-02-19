package 과제.과제9.인터페이스예제2;

import java.util.Scanner;

public class 실행 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);

		while (true) {
			System.out.println("1.힐러 2.전사 3.마법사");
			int ch=scanner.nextInt();
			
			if(ch==1) {
			캐릭터 캐릭터=new 힐러();
			
			System.out.println("아이디:");
			String id=scanner.next();
			
			System.out.println("비밀번호:");
			String pw=scanner.next();
			캐릭터.생성(id, pw);
			
				while (true) {
					
					String key=scanner.next();
					캐릭터.공격(key);
					캐릭터.방어(key);
				}
				
			}else if (ch==2) {
				캐릭터 캐릭터=new 전사();
				
				System.out.println("아이디:");
				String id=scanner.next();
				
				System.out.println("비밀번호:");
				String pw=scanner.next();
				캐릭터.생성(id, pw);
				
					while (true) {
						
						String key=scanner.next();
						캐릭터.공격(key);
						캐릭터.방어(key);
					}
			}	else if (ch==3) {
				캐릭터 캐릭터=new 마법사();
				
				System.out.println("아이디:");
				String id=scanner.next();
				
				System.out.println("비밀번호:");
				String pw=scanner.next();
				캐릭터.생성(id, pw);
				
					while (true) {
						
						String key=scanner.next();
						캐릭터.공격(key);
						캐릭터.방어(key);
					}
			}
				
		}
	}

}
