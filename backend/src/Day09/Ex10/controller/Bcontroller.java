package Day09.Ex10.controller;
import java.util.ArrayList;
import java.util.Date;

import Day09.Ex10.model.Board;

public class Bcontroller {
	
	
	
	//1.싱글톤 객체
	private static Bcontroller bc=new Bcontroller();
	private Bcontroller() {}
	public static Bcontroller getInstance() {
		return bc;
		
	}
	private ArrayList<Board> boardDb=new ArrayList<>();
	
	
	public ArrayList<Board> getBoardDb() {
		return boardDb;
	}
	
	public Board view(int bno) {
		//*조회수 올리기 //객체명.set 필드명 (객체명.get 필드명()+1 )
		boardDb.get(bno).setVeiw(boardDb.get(bno).getVeiw()+1);
		return boardDb.get(bno);
	}
	
	public boolean write(String title,String content,String writer,
			String password,Date date,int view) {
		
		//1.유효성검사[생략]
		
		//2.저장[db대신 리스트 ArrayList]
			//1. 저장 하기위해 객체화(스트링,인트 등등 다양한게 한꺼번에 뭉칠려면 객체화밖에없다)
		Board board=new Board(title, content, writer, password, date, view);
		
		boardDb.add(board);
		return true;
	}
	
	
	
}
