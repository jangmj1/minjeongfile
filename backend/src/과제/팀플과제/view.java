package 과제.팀플과제;

import java.util.Scanner;

public class view {
	
	private static view view=new view();
	private view () {}
	
	public static view getInstance() {
		return view;
	}
	
	Scanner scanner=new Scanner(System.in);
	
	public void index() {
		while (true) {
			System.out.println("1.회원가입  2.로그인");
			int ch=scanner.nextInt();
			if(ch==1) { signup ();}
			else if(ch==2) { login(); }	
			
		}
	}
	
	
	public void signup() {
		
		System.out.println("아이디:"); String 아이디=scanner.next();
		System.out.println("비밀번호:"); String 비밀번호=scanner.next();
		System.out.println("전화번호:");	String 전화번호=scanner.next();
		System.out.println("이름:");	String 이름=scanner.next();
		System.out.println("회원=> 1입력 , 관리자=> 2입력"); int 등급=scanner.nextInt();
		
		boolean result=
				Controller.getInstance().signup(아이디, 비밀번호, 전화번호, 이름, 등급);
		
		if(result==true) {
			System.out.println("회원가입성공");
		}else {
			System.out.println("가입실패");
		}
		
		
		
	}
	
	public void login() {
		
		System.out.println("아이디:"); String 아이디=scanner.next();
		System.out.println("비밀번호:"); String 비밀번호=scanner.next();
		
		int result=
				Controller.getInstance().login(아이디, 비밀번호);
		if(result==1) {
			System.out.println("일반 회원 로그인성공");
			//
			
		}else if(result==0) {
			System.out.println("비밀번호가 잘못되었습니다.");
		}else if (result==-1) {
			System.out.println("없는 회원 입니다.");
		}else if (result==2) {
			System.out.println("관리자회원 로그인 성공");
			//스케쥴 등록하기
		}
				
	}
	
	public void schecule() {
		
	}
	
	

}
