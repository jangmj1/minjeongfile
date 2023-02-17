package 과제.과제9.예시;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		키보드 key=null;
		
		while (true) {
			System.out.println("----바탕화면----");
			System.out.println("1.피파온라인");
			System.out.println("2.메이플스토리");
			System.out.println("선택:");
			int ch=scanner.nextInt();
			if(ch==1) {key=new 피파온라인();}
			else if (ch==2) {
				key=new 메이플스토리();
				System.out.println("1.마법사 2.전사");
				int ch2=scanner.nextInt();
				if(ch2==1) {key=new	마법사();}
				if (ch2==2) {key=new 전사(); }
			}	
				
			while (true) {
				System.out.println("게임시작!");
				String 입력=scanner.next();
				if(입력.equals("A")) {
					key.A버튼();
				}else if (입력.equals("B")) {
				
					key.B버튼();
				}else if (입력.equals("x")) {
					break;
				}
			}
			
		}
	}

}
