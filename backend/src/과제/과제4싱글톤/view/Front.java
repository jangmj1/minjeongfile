package 과제.과제4싱글톤.view;

import java.util.Scanner;

import Day08.Ex5.Member;
import 과제.과제4싱글톤.controller.Bcontroller;
import 과제.과제4싱글톤.controller.Mcontroller;
import 과제.과제4싱글톤.model.Board;

public class Front {
	
	
	//싱글톤
	private static Front front=new Front();
	private Front() {}
	public static Front getInstance() {
		return front;
	}
	private Scanner scanner=new Scanner(System.in);
	
	//1.메인페이지
	public void index() {
		while (true) {//무한루프
			System.out.println("-----------이젠커뮤니티-----------");
			System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기");
			
			int ch=scanner.nextInt();
			if(ch==1) {signup_page();}
			else if (ch==2) {login_page();}
			else if (ch==3) {findid_page();}
			else if (ch==4) {findpw_page();}
			//while end
		}
		
	}
	
	
	
	//2.회원가입
	public void signup_page() {	
		
		System.out.println("아이디:"); String id=scanner.next();
		System.out.println("비밀번호:");String pw=scanner.next();
		System.out.println("비밀번호확인:");String confirmpw=scanner.next();
		System.out.println("이름:");String name=scanner.next();
		System.out.println("전화번호:");String phone=scanner.next();
		
		//2.입력받은걸 컨트롤에게 전달 후 결과값 받기
		int result=
		Mcontroller.getInstance().signup(id, pw, confirmpw, name, phone);
		
		//3.결과제어
		if(result==1) {
			System.out.println("회원가입 실패.패스워드가 다릅니다");
		}else if (result==0) {
			System.out.println("회원가입 성공");
		}
		
		
	}
	//3.로그인페이지
	public void login_page() {
		System.out.println("아이디:");	String id=scanner.next();
		System.out.println("패스워드:");	String pw=scanner.next();
		
		//2.컨트롤에게 전달후 결과 받기
		int result=
		Mcontroller.getInstance().login(id, pw);
		
		if(result==-1) {
			System.out.println("로그인 실패.패스워드 틀림");
		}else if (result==-2) {
			System.out.println("로그인 실패.존재하는 아이디가 없습니다");
		}else {
			System.out.println("로그인 성공");
			board_page();//성공하면 보드 페이지로 이동 
		}
		
		
		
		
	}
	//4.아이디찾기 페이지
	public void findid_page() {	
		System.out.println("이름:");String name=scanner.next();
		System.out.println("전화번호:");String phone=scanner.next();
		
		String result=
				Mcontroller.getInstance().findId(name, phone);
		if(result==null) {
			System.out.println("아이디 찾기 실패");
		}else {
			System.out.println("회원님의 아이디는:"+result+"입니다.");
		}
		
	}
	//5.비밀번호 찾기 페이지
	public void findpw_page() {
		System.out.println("아이디:");String id=scanner.next();
		System.out.println("전화번호:");String phone=scanner.next();
		String result=
				Mcontroller.getInstance().findPw(id, phone);
		if(result==null) {
			System.out.println("비밀번호 찾기 실패");
		}else {
			System.out.println("회원님의 비밀번호는:"+result+"입니다.");
		}
	}
	
	//6.로그인 성공시 게시물 출력 페이지
	public void board_page() {
		while (true) {//while s
			
		
		System.out.println("번호\t조회수\t작성자\t제목");
		// Bcontroller.bc->Bcontroller에 public 으로 객체 만들면 가능하지만..private해놨음(싱글톤)
		
	
		
		//1.내가쓴글
		System.out.println(Mcontroller.getInstance().getLogSession().getBoardList());
	
		for(int j=0;j<Mcontroller.getInstance().getLogSession().getBoardList().size();j++) {
			//로그인한 내 정보에 담긴 나의 글 사이즈만큼 돈다
			Board temp=Mcontroller.getInstance().getLogSession().getBoardList().get(j);
				//로그인한 내 정보에 담긴 j번째 게시글
			
			System.out.println(temp.getTitle());
		}
		
		
		int i=0;//인덱스용도
		for(Board b:Bcontroller.getInstance().getList()) {
			System.out.println(i+"\t"+b.getView()+"\t"+
							b.getMember().getId()+"\t"+b.getTitle());
			i++;
		}
		
		System.out.println("1.쓰기 2.글보기 3.로그아웃");
		int ch2=scanner.nextInt();
		if(ch2==1) {write_page();		}
		else if (ch2==2) {view_page();	}
		else if (ch2==3) {	Mcontroller.getInstance().logOut();break;}
		//index말고 리턴이나 브레이크를 써서 와일문 탈출->로그인쪽으로 이동->index로 이동
		}//while end
	}
		
	//7.게시물 쓰기 페이지
	public void write_page() {
		
		System.out.println("-----------글쓰기----------");
		System.out.println("제목:"); String title=scanner.next();
		System.out.println("내용:");String content=scanner.next();
		boolean result=Bcontroller.getInstance().write(title, content);
		if(result) {
			System.out.println("글작성 성공");
		}else {
			System.out.println("글작성 실패");
		}
		
	}
	//8.게시물 상세 페이지
	public void view_page() {
		System.out.println("이동할 게시물 번호[인덱스]");
		int bno=scanner.nextInt();
		Board result= Bcontroller.getInstance().getboard(bno);
		
		System.out.println("제목:"+result.getTitle());
		System.out.println("제목:"+result.getMember().getId()+"\t조회수"+result.getView());
		System.out.println("내용:"+result.getContent());
		
		System.out.println("1.삭제 2.수정 3.뒤로가기");
		int ch3=scanner.nextInt();
		if(ch3==1) { delete_page(bno); }
		else if (ch3==2) {update_page(bno);}
		else if (ch3==3) {return;}
	}
	
	//9.게시물삭제페이지
	public void delete_page(int bno) {	
		//1.유효성검사[현재보고잇는 글의 작성자와 현재 로그인된 회원과 같으면]
		if(Bcontroller.getInstance().getboard(bno).getMember().equals
				(Mcontroller.getInstance().getLogSession())) {
			Bcontroller.getInstance().delete(bno);
			System.out.println("삭제완료");
			return;
			
		}
		
		
		System.out.println("삭제 권한이 없습니다.");
	}
	//10.게시물 수정 페이지
	public void update_page(int bno) {
		if(Bcontroller.getInstance().getboard(bno).getMember().equals
				(Mcontroller.getInstance().getLogSession())) {
			System.out.println("새로운제목"); String title=scanner.next();
			System.out.println("새로운내용"); String content=scanner.next();
			
			Bcontroller.getInstance().update(bno, title, content);
			System.out.println("수정완료");
			return;
		}
		System.out.println("수정권한이 없습니다");
	}
	
	
	
	
}
