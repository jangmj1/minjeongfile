package 과제.과제4.view;
//*print,scanner

import java.util.Scanner;

import 과제.과제4.Controller.Mcontroller;

public class Front {
	Scanner scanner=new Scanner(System.in);
	
	
	//1.메인페이지
	public void index() {
		System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기");
		int ch=scanner.nextInt();
		if(ch==1) {	signup();}
		else if (ch==2) { login();}
		else if (ch==3) { findId();}
		else if (ch==4) { findPw();}
		else {	}
	}
	
	//2.회원가입
	void signup() {
		System.out.print("아이디:"); String id=scanner.next();
		System.out.print("비밀번호:");String pw=scanner.next();
		System.out.print("비밀번호확인:");String confirmpwd=scanner.next();
		System.out.print("이름:");		String name=scanner.next();
		System.out.print("전화번호:");	String phone=scanner.next();
		Mcontroller mc=new Mcontroller();
		int result=
				mc.signup(id,pw,confirmpwd,name,phone);
		if(result==1) {
			System.out.println("회원가입 실패");
		}else if (result==0) {
			System.out.println("회원가입 성공");
		}
		
	}
	
	//3.로그인
	void login() {
		
	}	
	//4.아이디찾기페이지
	void findId() {
		
	}	
	//5.비밀번호찾기페이지
	void findPw() {
		
	}
}
