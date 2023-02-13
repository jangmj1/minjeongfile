package Day09.Ex10.model;
/*
 * 	클래스 model 클래스 만들기
 * 		1.필드 선정
 * 		2.모든 필드는 private
 * 		3.생성자는 빈거 하나랑 풀 하나만들기
 * 		4.메소드[1.tostring(),2.get,set 메소드]
 */

import java.util.Date;

public class Board {
	//1.필드
	private String title;
	private String content;
	private String writer;
	private String password;
	private Date date;
	private int view;
	
	//2. 생성자 빈깡통
	public Board() {
	}
	//2. 생성자 풀
	public Board(String title, String content, String writer, String password, Date date, int view) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.password = password;
		this.date = date;
		this.view = view;
	}

	//3.메소드
	@Override
	public String toString() {//필드의 정보를 알려줌
		return title+"\t"+writer+"\t"+view+"\t"+date;
	}

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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getVeiw() {
		return view;
	}

	public void setVeiw(int veiw) {
		this.view = veiw;
	}
	
	

}
