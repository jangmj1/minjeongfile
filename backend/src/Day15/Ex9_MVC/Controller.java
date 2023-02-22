package Day15.Ex9_MVC;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	
	//싱글톤
	
	private static Controller controller=new Controller();
	private Controller () {};
	public static Controller getInstance() {
		return controller;
	}
	
	

	public boolean singup(String mid,String mpw) {
		//유효성 검사 생략
		//2.객체화
		MemberDto dto=new MemberDto(0, mid, mpw);
		
		//3.해당 객체를 db에 저장 [dao]호출 하고 실행 겨로가 저장
		boolean result=
		MemberDao.getInstance().signup(dto);		
		
		return result;
	}
	
	//2.모든 회원 출력 [인수 : x ,반환 : 여러명 ArrayList<>]
	public ArrayList<MemberDto> list() {
		
		
		//1.dao에게 요청->모든 회원들 호출하는 DAO메소드 호출해서 결과 얻기
		ArrayList<MemberDto> result=MemberDao.getInstance().list();
		
		
		return result;//뷰에서 여기함수를 호출함 회원리스트값을 보내줌
		
		
	}
	
	public boolean Update(int mno, String mpw) {
		return MemberDao.getInstance().Update(mno, mpw);
		
		
	}
	
	public boolean delete(int mno) {
		return MemberDao.getInstance().delete(mno);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
