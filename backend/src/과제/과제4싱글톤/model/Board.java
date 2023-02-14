package 과제.과제4싱글톤.model;



//회원이 글을 여러개 쓰는것
/*
 * 		model 과의 관계
 * 	1.한명의 회원이 글을 작성한다.[object]
 * 	2.회원은 여러개의 글을 작성할수 있다.[ArrayList]
 *  3.양방향 서록 서로를 담고있어서 toString못쓴다.
 */

public class Board {

	//1.필드
	private String title;
	private String content;
	private int view;
	private Member member;
		//하나의 게시물이 [객체]가 하나의 member객체를 가질수있다 즉 글은 1개 그 글의 주인은 1개

	
	//2. 생성자
	//빈생성자 한개 풀생성자 한개 
	
	public Board() {
	}
	
	
	
	public Board(String title, String content, int view, Member member) {
		this.title = title;
		this.content = content;
		this.view = view;
		this.member = member;
	}



	//3.메소드
	/*
	 * @Override public String toString() { return "Board [title=" + title +
	 * ", content=" + content + ", view=" + view + ", member=" + member + "]"; }
	 */
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
