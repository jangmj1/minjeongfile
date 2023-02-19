package 과제.과제9.인터페이스예제1;

public class 게시판 implements 작성{
	String writer;
	String pw;
	String content;
	String title;
	
	@Override
	public void 쓰기() {
		System.out.println("----------게시글창입니다---------");
		System.out.println("작성자:");
		this.writer=작성.scanner.next();
		System.out.println("비밀번호:");
		this.pw=작성.scanner.next();
		System.out.println("제목:");
		this.title=작성.scanner.next();
		System.out.println("내용:");
		this.content=작성.scanner.next();
		System.out.println("작성완료");
		System.out.println("작성자:"+writer+"\t제목:"+title+"\t내용:"+content);
	}

	
	
	
	
	
}

