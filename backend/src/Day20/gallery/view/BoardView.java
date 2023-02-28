package Day20.gallery.view;

import java.util.ArrayList;
import java.util.Scanner;

import Day20.gallery.controller.Bcontroller;
import Day20.gallery.controller.Mcontroller;
import Day20.gallery.model.Dto.BoardDto;
import Day20.gallery.model.Dto.CategoryDto;

public class BoardView {

	private static BoardView boardView=new BoardView();
	private BoardView() {};
	public static BoardView getInstance () {
		return boardView;
	}
	
	private Scanner scanner=new Scanner(System.in);
	
	public void index() {//index s
		while (true) {
			
			System.out.println("------------로그인------------");
			//최신 게시물 3개 출력
			boardPrintRecent();
			
			categoryPrint() ;//모든 갤러리 출력
			System.out.print("-1:로그아웃 /0:갤러리 추가 / 이동할 갤러리 번호 선택 :");
			int ch=scanner.nextInt();
			if(ch==-1) {
				Mcontroller.getInstance().setLoginSession(0);
				System.out.println("[로그아웃] 안녕히가세욤");
				break;
				//갤러리추가
			}else if (ch==0) {categoryAdd();
				//이동
			}else if (ch>0) { boardPrint(ch);
				
			}
		}
		
	}//index e
	
	public void categoryAdd() {
		System.out.println("------------갤러리추가------------");
		scanner.nextLine();
		System.out.println("추가할 갤러리 이름 :"); String cname=scanner.nextLine();//nextLine 띄어쓰기까지
		
		boolean result=Bcontroller.getInstance().categoryAdd(cname);
		if(result=true) {
			System.out.println("등록성공");
		}else {
			System.out.println("등록실패");
		}
		
		
	}
	
	public void categoryPrint() {
		//1.컨트롤에게 모든 카테고리 요청후 반환된 리스트에 담기
		ArrayList<CategoryDto> clist=Bcontroller.getInstance().categoryPrint();
		
		//for(int i=0;i<clist.size();i++) {
		//	System.out.println(clist.get(i).getCno()+"-"+clist.get(i).getCname());
		//}
		
		int count=0;
		for(CategoryDto dto:clist) {
			System.out.print(dto.getCno()+"-"+dto.getCname()+"\t");
			count++;
			if(count%4==0)System.out.println(); //4줄 마다 줄바꿈
		}
		System.out.println();
	}
	
	//4.게시물등록
	public void boardAdd(int cno) {
		System.out.println("-----------게시물쓰기----------");
		System.out.println("제목 : "); String btitle=scanner.next();
		System.out.println("내용 : "); String bcontent=scanner.next();
		int mno = Mcontroller.getInstance().getLoginSession();
		
		boolean result=Bcontroller.getInstance().boardAdd(btitle, bcontent,mno,cno);
		if(result) {
			System.out.println("글쓰기성공");
		}else {
			System.out.println("글쓰기실패");
		}
		
		
	}
	
	//5.최신글출력
	public void boardPrintRecent() {
		ArrayList<BoardDto>blist=Bcontroller.getInstance().boardPrintRecent();
		System.out.printf("%10s\t%10s\t%10s\t %10s\t %10s\t %10s \n",
				"번호","제목","작성자","조회수","갤러리","작성일");
		for(BoardDto dto:blist) {
			System.out.printf("%10s\t%10s\t%10s\t %10s\t %10s\t %10s\n",
					dto.getBno(),dto.getBtitle(),dto.getMdi(),dto.getBview(),dto.getCname(),dto.getBdate()
					);
		}
	}
	
	//6.
	
	public void boardPrint(int cno) {
		ArrayList<BoardDto>blist=Bcontroller.getInstance().boardPrint(cno);
		System.out.printf("%10s\t%10s\t%10s\t %10s\t %10s \n",
				"번호","제목","작성자","작성일","조회수");
		for(BoardDto dto:blist) {
			System.out.printf("%10s\t%10s\t%10s\t %10s\t %10s \n",
					dto.getBno(),dto.getBtitle(),dto.getMdi(),dto.getBview(),dto.getBdate()
					);
		}//for end
		
		while ( true) {
			System.out.println("갤러리메뉴 : 1.뒤로가기 2.게시물쓰기 3.게시물 보기");
			int ch=scanner.nextInt();
			if(ch==1) {
				break;
			}else if (ch==2) {
				boardAdd(cno);
			}else if (ch==3) {
				//미구현
			}
		}
	}
}
