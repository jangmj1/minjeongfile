package 과제.과제9.인터페이스예제1;

public class 댓글 implements 작성{
	String writer;
	String content;
	
	
	

	@Override
	public void 쓰기() {
		
		
		System.out.println("----------댓글쓰기창입니다---------");
		System.out.println("작성자:");
		this.writer=작성.scanner.next();
		System.out.println("내용:");
		this.content=작성.scanner.next();
		System.out.println("작성완료");
		System.out.println("작성자:"+writer+"\t내용:"+content);
	}
	
	

	

	


	
	
	
	
}
