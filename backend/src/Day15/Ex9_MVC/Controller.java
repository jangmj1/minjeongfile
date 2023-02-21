package Day15.Ex9_MVC;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	
	//싱글통
	
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
		return null;
	}
}
