package 과제.과제4싱글톤.controller;

import java.util.ArrayList;

import 과제.과제4싱글톤.model.Member;


public class Mcontroller {
	
	//*싱글톤 : 다른곳에서 해당 객체를 공유하고싶을때 
	//1번과 2번을 Bcontroller 에서 사용하고싶다
	/*
	 * 	싱글톤 만드는방법
	 */
	//1.본인 클래스로 본인 객체 만들기
	private static Mcontroller mc=new Mcontroller();
	
	//2.외부에서 생성자를 사용할수 없도록 생성자에 private
	private Mcontroller(){ }
	
	//3.객체는 외부로부터 차단하고 getInstance 함수를 통해 객체를 내보낸다[유효성검사를위해] public!!
	public static Mcontroller getInstance() {
		return mc;
	}
	
	
	
	
	private ArrayList<Member>MemberDb=new ArrayList<>();//1.
	private Member logSession=null; //전역변수 2.
	//로그인 한 회원의 객체를 저장
	
	
	
	public Member getLogSession() {
		return logSession;
	}//프라이빗 로그세션을 게터
	
	//1.회원가입 처리
	public int signup(String id,String pw,String confirmpw,
						String name,String phone) {
		//로직 작성할 예정
		if(!pw.equals(confirmpw)) {
			return 1;
		}
		Member m=new Member(id, pw, name, phone,new ArrayList<>());
		MemberDb.add(m);
		return 0;
	}

	

	//2.로그인 처리
	public int login(String id ,String pw) {
		for(int i=0;i<MemberDb.size();i++) {
			if(MemberDb.get(i).getId().equals(id)) {
				if(MemberDb.get(i).getPw().equals(pw)) {
					logSession=MemberDb.get(i);	//로그인 성공한 회원 객체를 필드에 저장
					return i;
					
				}else {
					
					return -1;
				}
			}
		}
		return -2;
		
		
	}
	
	//3.아이디 찾기 처리
	public String findId(String name , String phone) {
		for(Member m:MemberDb) {
			//여러개의 맴버가 들어있는MemberDb 에서 멤버를 하나씩 꺼낼꺼기 때문에 자료형은 Member이다
			//향상된 포문 ->자료형(돌릴구간과 맞추기) 이름(아무거나):돌릴구간
			if(m.getName().equals(name) && m.getPhone().equals(phone)) {
				return m.getId();
			}
		}
		
		return null;
	}
	
	//4.비밀번호 찾기 처리
	public String findPw(String id,String phone) {
		for(Member m:MemberDb) {
			if(m.getId().equals(id)&& m.getPhone().equals(phone)) {
				return m.getPw();
			}
		}
		return null;
	}
	
	//5.로그아웃처리
	public boolean logOut() {
		logSession=null;//필드에 저장된 로그인 성공한 회원의 객체를 지우기
		//null 대입하면 GC가 힙 메모리 자동 제거
		return true;
	}
	
	
	
	
	
	
	
}
