package 과제.과제4.Controller;

import java.util.ArrayList;

import 과제.과제4.model.Member;

//*처리/제어 담당
public class Mcontroller {
	//db 대신할 데이터 저장소
	ArrayList<Member> memberDb=new ArrayList<>();
	
	
	//1.회원가입 로직
	public	int signup(
			String id,String pw, 
			String confirmpwd,String name,String phone){
		
		if( !pw.equals(confirmpwd)) {	return 1;}//회원가입실패 1
		Member member=new Member(id, confirmpwd, name, phone);
		memberDb.add(member);
		
		return 0;//회원가입 성공 0
			
		}

}
