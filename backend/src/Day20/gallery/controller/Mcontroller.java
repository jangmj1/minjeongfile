package Day20.gallery.controller;

import Day20.gallery.model.Dao.MemberDao;
import Day20.gallery.model.Dto.MemberDto;

public class Mcontroller {
	private static Mcontroller mcontroller=new Mcontroller();
	private Mcontroller() {};
	public static Mcontroller getInstance () {
		return mcontroller;
	}
	
	//회원가입 처리
	public int signup(String mid , String mpw , String mname , String mphone) {
		//1.원래는 유효성 검사
			//아이디 중복체크
		if(MemberDao.getInstance().idCheck(mid)) {
			return 2; // 중복된 아이디
		}
		//2.객체화시킬거임
		
		MemberDto dto=new MemberDto(0, mid, mpw, mname, mphone);
		
		
		//3.회원가입db처리
		
		return MemberDao.getInstance().signup(dto);
	
	}
	
	private int loginSession=0;
	
	
	
	public int getLoginSession() {
		return loginSession;
	}
	
	
	public void setLoginSession(int loginSession) {
		this.loginSession = loginSession;
	}
	
	//로그인처리
	public boolean login(String mid,String mpw) {
		//1.유효성검사
		
		//2.
		int result=
			MemberDao.getInstance().login(mid, mpw);
		
		if(result==0) {return false;}//로그인 실패
		else {
			loginSession=result; //로그세션에 로그인 성공한 회원은 pk 번호가 들어간다
			return true;
		}
		//3.
	}

}
