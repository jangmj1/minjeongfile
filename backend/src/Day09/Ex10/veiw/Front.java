package Day09.Ex10.veiw;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Day09.Ex10.controller.Bcontroller;
import Day09.Ex10.model.Board;

public class Front {
	//1.싱글톤객체[1.프로그램내 하나의 객체-공유 메모리]
	private static Front front=new Front();
	private Front() {}
	public static Front getInstance() {
		return front;
	}
	
	//필드[인스턴스 맴버]
	private Scanner scanner=new Scanner(System.in);
	
	//2.index 함수
	public void index() {
		while(true) {
			
		print_page ();
		System.out.println("1.쓰기 2.상세보기");
		int ch=scanner.nextInt();
		if(ch==1) {	writer_page();	}
		else if(ch==2) { view_page() ;}
		}
	}
	
	//3. 쓰기 페이지 함수
	private void writer_page() {
		System.out.println("제목");String title= scanner.next();
		System.out.println("내용");String content= scanner.next();
		System.out.println("작성자");String writer= scanner.next();
		System.out.println("비밀번호");String password= scanner.next();
		Date date=new Date();
		int view=0;
		
		
		boolean result=
		Bcontroller.getInstance().write(title, content, writer, password, date, view);
		if(result) {
			System.out.println("글쓰기성공");
		}else {
			System.out.println("글쓰기실패");
		}
		
		
		
		
	}
	
	//4.출력 페이지 함수
	private void print_page () {
		System.out.println("넘버 \t제목 \t작성자 \t조회수 \t작성일");
		ArrayList<Board> result=Bcontroller.getInstance().getBoardDb();
		
		for(int i=0;i<result.size();i++) {
			System.out.println(i+"\t"+result.get(i).toString());
		}
				
		
	}
	
	private void view_page() {
		System.out.println("게시물넘버:"); int bno=scanner.nextInt();
		Board result=Bcontroller.getInstance().view(bno);
		System.out.println("제목"+result.getTitle());
		System.out.println("작성자"+result.getTitle()+"\t작성일"+result.getDate()+
				"\t조회수"+result.getVeiw());
		System.out.println("내용:"+result.getContent());
		System.out.println(">>1.뒤로가기 2.삭제 3.수정");
		int ch2=scanner.nextInt();
		if(ch2==1) { } 
		
	}
	
}
