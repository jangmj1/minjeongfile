package 과제.과제4.view;
//*print,scanner

import java.util.Iterator;
import java.util.Scanner;

import 과제.과제4.Controller.Bcontroller;
import 과제.과제4.Controller.Mcontroller;
import 과제.과제4.model.Board;
import 과제.과제4.model.Member;

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
	Bcontroller bc=new Bcontroller();
	
	
	
	//2.회원가입
	public	void signup() {
		System.out.print("아이디:"); String id=scanner.next();
		System.out.print("비밀번호:");String pw=scanner.next();
		System.out.print("비밀번호확인:");String confirmpwd=scanner.next();
		System.out.print("이름:");		String name=scanner.next();
		System.out.print("전화번호:");	String phone=scanner.next();
		int result= mc.signup(id,pw,confirmpwd,name,phone);
		if(result==1) {
			System.out.println("회원가입 실패");
		}else if (result==0) {
			System.out.println("회원가입 성공");
			
		}
		
	}
	
	//3.로그인
	public	void login() {
		System.out.println("아이디를 입력하세요"); String id=scanner.next();
		System.out.println("비밀번호를 입력하세요");String pw=scanner.next();		
		
		int result=mc.login(id, pw);//mc.login 쪽으로 입력한 id와 pw를 보낼테니 리턴값을 보내라
		
		if(result>=0) {
			System.out.println("로그인성공");
			enter();
			
		}else if (result==-1) {
			System.out.println("비밀번호가 틀렸습니다.");
		}else if (result==-2) {
			System.out.println("없는회원입니다.");
		}
		
		
		
		
	}	
	//4.아이디찾기페이지
	public	void findId() {
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
	public	void findPw() {
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
	

	
	
	
	
	
 public void enter(){//로그인 성공화면s
	 while (true) {//w s
		 	
			System.out.println(" ---------- 커뮤니티 ---------------");
			
			System.out.println("메뉴> 1.글쓰기 2.글보기 3.로그아웃");
			
			int ch1=scanner.nextInt();
			if(ch1==1) {//1.글쓰기
				afterLogin();
			}
			else if (ch1==2) {//2.글보기 시작
				del();
				}
			
			// 글보기 끝
			else if (ch1==3) {//3.로그아웃
				index();
			}
		}//w e
	}//로그인 성공화면e
 
	
	public void afterLogin(){
		System.out.println(" ---------- 글 쓰기 ---------------");
		System.out.println("제목:"); String title=scanner.next();
		System.out.println("내용:");	String content=scanner.next();
						
		//로그인한 사람의명
		String writer=mc.test();	
		int count=0;
		
		
		int result=bc.writing(title,content,writer,count);
		
			if(result==1) {
				System.out.println("글쓰기성공!");
				System.out.println("번호\t조회수\t작성자\t제목");
				
				for(int i=0; i<bc.boards.size(); i++) {
					System.out.println(i+"\t"+count+"\t"+bc.boards.get(i).writer+"\t"+bc.boards.get(i).title);
				}
				
			}
	}
	
	
	public void del() {//글보기=>글삭제,글수정,뒤로가기
		System.out.println("글번호를 입력해주세요");
		
		
		int no=scanner.nextInt();
		for(int i=0;i<bc.boards.size();i++) {//글보기
			if(no==i) {
				System.out.println("제목 :"+bc.boards.get(i).title);
				System.out.println("작성자 :"+bc.boards.get(i).writer);
				System.out.println("내용 :"+bc.boards.get(i).content);
				bc.boards.get(i).count++;
				System.out.println("조회수 :"+bc.boards.get(i).count);
			}
		}
		
		
		System.out.println("1.글삭제 2.글수정 3.뒤로가기"); int no1=scanner.nextInt();
		
		if(no1==1) {//만약 삭제를 눌렀을시.. 여기서부터 문제
			
			
			int result=bc.del(no1);
			
			if(result==1) {
				System.out.println("해당 게시글을 삭제하였습니다.");
				
			}
			else if(result==2) {
				System.out.println("해당 게시글을 삭제할 권한이 없습니다.");
			}
			
			else if(result==0) {//뒤로가기
				afterLogin();
				}// 뒤로가기끝	
		}
		
		
		
		
	}
 
 
 
 
 
 
 
 
 
 
 
 

	
}
