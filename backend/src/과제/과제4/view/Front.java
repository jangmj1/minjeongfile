package 과제.과제4.view;
//*print,scanner

import java.util.Scanner;

import 과제.과제4.Controller.Mcontroller;

public class Front {
	Scanner scanner=new Scanner(System.in);
	
	
	//1.메인페이지
  	public void index() {
  		while (true) {
			
			
			System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기");
			int ch=scanner.nextInt();
			if(ch==1) {	signup();}
			else if (ch==2) { login();}
			else if (ch==3) { findId();}
			else if (ch==4) { findPw();}
			else {	}
		}
	}
	
	Mcontroller mc=new Mcontroller();
	//2.회원가입
	void signup() {
		System.out.print("아이디:"); String id=scanner.next();
		System.out.print("비밀번호:");String pw=scanner.next();
		System.out.print("비밀번호확인:");String confirmpwd=scanner.next();
		System.out.print("이름:");		String name=scanner.next();
		System.out.print("전화번호:");	String phone=scanner.next();
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
		System.out.println("아이디를 입력하세요"); String id=scanner.next();
		System.out.println("비밀번호를 입력하세요");String pw=scanner.next();
		
		int result=mc.login(id, pw);//mc.login 쪽으로 입력한 id와 pw를 보낼테니 리턴값을 보내라
		
		if(result>=0) {
			System.out.println("로그인성공");
			afterLogin();
		}else if (result==-1) {
			System.out.println("비밀번호가 틀렸습니다.");
		}else if (result==-2) {
			System.out.println("없는회원입니다.");
		}
		
		
		
		
	}	
	//4.아이디찾기페이지
	void findId() {
		System.out.print("이름:"); String name=scanner.next();
		System.out.print("전화번호:"); String phone=scanner.next();
		
		String result=mc.findId(name, phone);
		if(result=="1") {
			System.err.println("전화번호를확인하여주세요");
			return;
		}else if (result=="2") {
			System.err.println("없는회원입니다");
			return;
		}
		System.out.println("찾고자하는 아이디는:"+result);
				
		
		
	}	
	//5.비밀번호찾기페이지
	void findPw() {
		System.out.print("아이디"); String id=scanner.next();
		System.out.print("전화번호"); String phone=scanner.next();
		
		String result=mc.findPw(id, phone);
		if(result=="1") {
			System.err.println("전화번호를확인하여주세요");
			return;
			
		}else if (result=="0") {
			System.err.println("없는회원입니다.");
			return;
		}
		System.out.println("찾고자하는 비밀번호:"+result);
	
	}
	
	
	void afterLogin(){//로그인 성공화면s
		while (true) {//w s
			System.out.println(" ---------- 커뮤니티 ---------------");
			System.out.println("번호\t조회수\t작성자\t제목");
			System.out.println("메뉴> 1.글쓰기 2.글보기 3.로그아웃");
			int ch1=scanner.nextInt();
			if(ch1==1) {//1.글쓰기
				System.out.println(" ---------- 글 쓰기 ---------------");
				System.out.println("제목:"); String title=scanner.next();
				System.out.println("내용:");	String content=scanner.next();
			}else if (ch1==2) {//2.글보기
				
			}else if (ch1==3) {//3.로그아웃
				index();
			}
			
			
		}//w e
	}//로그인 성공화면e
	
}
