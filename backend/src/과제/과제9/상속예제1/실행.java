package 과제.과제9.상속예제1;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		독수리 독수리=new 독수리("토끼", "70");
		독수리.사냥();
		독수리.먹이();
		
		뱀 뱀=new 뱀("쥐", "30");
		뱀.사냥();
		뱀.먹이();
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("호랑이가 잡을 저녁메뉴를 적어주세요");
		String 사냥메뉴= scanner.next();
		System.out.println("호랑이의 시속을 적어주세요");
		String 시속= scanner.next();
		호랑이 호랑이=new 호랑이(사냥메뉴,시속);
		
		호랑이.사냥();
		호랑이.먹이();
		
	}
	
	
			
}
