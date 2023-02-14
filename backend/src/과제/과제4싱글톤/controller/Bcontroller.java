package 과제.과제4싱글톤.controller;

import java.util.ArrayList;

import 과제.과제4싱글톤.model.Board;

public class Bcontroller {
	
	private ArrayList<Board>boardDb=new ArrayList<>();
	
	//싱글톤 만들기
	private static Bcontroller bc=new Bcontroller();
	private Bcontroller() {}
	public static Bcontroller getInstance() {return bc;}
	
	//1.글쓰기 처리
	public boolean write(String title,String content) {
		//1.유효성검사.[로그인을 했는지 안했는지]
		if(Mcontroller.getInstance().getLogSession()==null) {
			//Mcontroller를 가져오기 위해 Mcontroller페이지에서 싱글톤을 만들었다
			return false;
		}
		//2.db저장
			//1.객체화[글작성:입력받은 제목,내용,조회수 0,로그인한 회원의 객체=글쓴이]
		Board board=new Board(title, content, 0, Mcontroller.getInstance().getLogSession());
		
		
		
			//3.멤버객체에 내가 쓴글 등록
		Mcontroller.getInstance().getLogSession().getBoardList().add(board);
		
		
			
				
		
		return true;
	}
	//2.글출력 처리
	public ArrayList<Board> getList(){
		
		//추후에 검색처리,페이징 처리 등 로직이 들어갈 예정
		
		return boardDb;
	}
	
	//3.글상세
	public Board getboard(int bno) {
		boardDb.get(bno).setView(boardDb.get(bno).getView()+1);//조회수 증가
		return boardDb.get(bno);
	}
	
	//4.글삭제 처리
	public boolean delete(int bno) {
		boardDb.remove(bno);
		return true;
	}
	//5.글수정
	public boolean update(int bno,String title,String content) {
		boardDb.get(bno).setTitle(title);//겟은 꺼내오는거고 셋은 저장하는거
		boardDb.get(bno).setContent(content);//인수로 전달받은 인덱스[게시물번호]의 게시물 내용 수정
		
		return true;
	}
	
	
	
	

}


/*
5.글쓰기처리
인수 : title,content				반환 : true:성공 , false : 실패

6.글출력 데이터반환
인수 : x					반환 : 모든글이 담긴 arrsyList <board>

7.글상세 데이터 반환
인수 : 글번호				반환 : 글 하나 board
*조회수 증가				

8.글 삭제 처리
인수 : 글번호				반환:ture :성공 false : 실패

9.글 수정 처리
인수 : 글번호,새로운제목,새로운내용		반환:ture :성공 false : 실패

10.로그아웃처리
인수 : x					반환:ture :성공 false : 실패
*/