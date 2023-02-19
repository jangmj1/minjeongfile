package 과제.과제9.인터페이스예제1;

import java.util.ArrayList;

public class 실행 {
	
	public static void main(String[] args) {
		
		while (true) {
			
			작성 rc;
			rc=new 댓글();
			rc.쓰기();
			
			rc=new 게시판();
			rc.쓰기();
			
			rc=new 리뷰();
			rc.쓰기();
		}
		
		
		
		
	}
		
		
}
