package 과제.과제9.인터페이스예제1;

public class 리뷰 implements 작성{
	int grade;
	String content;
	
	@Override
	public void 쓰기() {

		System.out.println("----------리뷰창입니다---------");
		System.out.println("별점:");
		this.grade=작성.scanner.nextInt();
		System.out.println("내용:");
		this.content=작성.scanner.next();
		System.out.println("작성완료");
		System.out.println("별점:"+grade+"\t내용:"+content);
		
	}


	
}
