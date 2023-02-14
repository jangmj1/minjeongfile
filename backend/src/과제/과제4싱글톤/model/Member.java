package 과제.과제4싱글톤.model;

import java.util.ArrayList;

//M : 데이터 저장할때 사용되는 데이터 모델링 기본 베이스
	//우리가 하고자 하는건 회원을 여러명을 만들어서 하나의 리스트에 저장->객체 여러개다 즉 인스턴스맴버
	//1.필드 : 접근제한자 ->일반적으로 필드는 private->외부로부터 직접 접근을 막는다->getter,setter를 만들어서 유효성검사를통해 써라
	//2.생성자 : 1)빈생성자 2)풀생성자
	//3.메소드: 1)toString() ->확인용   2) getter,setter
	
public class Member {
	
	//인스턴스맴버 : 객체를 만들어서 쓰는거 (객체가 있어야 사용)->스택영역
	//정적맴버 : 객체 없이 쓰는거 stiatic->메소드영역에 저장
	
	//1.필드
	private String id;
	private String pw;
	private String name;
	private String phone;
	private ArrayList<Board> boardList;//지워도된다 내가쓴글을 할때만 필요
	//한명의 회원이 (맴버객체1개가) 여러개의 보드객체를 가질수있따->즉 한명이 글 여러개를 쓸수있다
	
	
	
	//2.생성자
		//정해진건 없지만 빈 생성자 하나랑 풀 생성자 하나씩은 웬만하면 만들어라
	
	public Member(String id, String pw, String name, String phone, ArrayList<Board> boardList) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.boardList = boardList;
	}



	public Member() {
	}


	//3.메소드
	
	/*
	 * @Override public String toString() { return "Member [id=" + id + ", pw=" + pw
	 * + ", name=" + name + ", phone=" + phone + ", boardList=" + boardList + "]"; }
	 */


	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPw() {
		return pw;
	}



	public void setPw(String pw) {
		this.pw = pw;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public ArrayList<Board> getBoardList() {
		return boardList;
	}



	public void setBoardList(ArrayList<Board> boardList) {
		this.boardList = boardList;
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
}
