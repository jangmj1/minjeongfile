package Day20.gallery.view;

import java.util.Scanner;

import Day20.gallery.controller.Mcontroller;

public class IndexView {
	private static IndexView indexView=new IndexView();
	private IndexView() {};
	public static IndexView getInstance () {
		return indexView;
	}
	
	private Scanner scanner=new Scanner(System.in);
	
	public void index() { //index s
		while (true) {
			
			System.out.println("-------------이젠 갤러리-------------");
			System.out.println("1.로그인 2.회원가입");
			try {
				
				int ch=scanner.nextInt();
				if(ch==1) {login();}
				else if (ch==2) {signup(); }
				
			} catch (Exception e) {
				System.err.println("잘못된 입력입니다");
				scanner=new Scanner(System.in);
			}
				
		}
		
		
	}//index e
	
	
	//2.회원가입
	public void signup() throws Exception{// 만일 해당 메소드에서 오류 발생하면 해당 메소드를 호출했던곳으로 예외 이동
		System.out.println("------------회원가입-----------");
		System.out.println("아이디 :"); String mid =scanner.next();
		System.out.println("비밀번호 :"); String mpw =scanner.next();
		System.out.println("이름 :"); String mname =scanner.next();
		System.out.println("전화번호 :"); String mphone =scanner.next();
		
		int result =
				Mcontroller.getInstance().signup(mid, mpw, mname, mphone);
		if(result==1) {
			System.out.println("[성공] 회원가입이되었습니다");
		}else if (result==2) {
			System.out.println("[실패]사용중인 아이디 입니다");
		}else if (result==3) {
			System.out.println("[실패]관리자에게 문의");
		}
		
		
		
	}
	
	public void login() {
		System.out.println("------------로그인----------");
		System.out.println("아이디 : ");	String mid=scanner.next();
		System.out.println("비밀번호 : "); String mpw=scanner.next();
		
		boolean result=Mcontroller.getInstance().login(mid, mpw);
		if(result==true) {
			System.out.println("로그인성공");
			BoardView.getInstance().index();
		}else {
			System.out.println("로그인실패");
		}
	}
	
	
	
}
