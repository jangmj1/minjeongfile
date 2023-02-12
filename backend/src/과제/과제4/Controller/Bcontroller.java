package 과제.과제4.Controller;

import java.util.ArrayList;

import 과제.과제4.model.Board;
import 과제.과제4.model.Member;

public class Bcontroller {
	
public	ArrayList<Board> boards=new ArrayList<>();
	
	//1.글쓰기로직
	public int writing(
		String title, String content,String writer,int count	){
		
		
		Board board=new Board(content,title,writer,count);
		boards.add(board);
		
		
		for(int i=0; i<boards.size(); i++) {
			if(boards.size()>=0) {
				return 1;
			}
		}
		return 0;
		
	}
	
	Mcontroller mc=new Mcontroller();
	//2.삭제함수
	public int del(int no1 ) {
		for(int i=0;i<mc.memberDb.size();i++) {
			if(mc.test()==boards.get(no1).writer ) {
				
				boards.remove(i);
				return 1; //삭세성공
			}else if (mc.test()!=mc.memberDb.get(no1).id) {
				return 2;//삭제실패
			}
		}return 0;
	}
	
	

}
