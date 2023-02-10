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
		
		System.out.println(memberDb.size());
		return 0;//회원가입 성공 0
		
		}
	
	public int login(String id,String pw) {
		for(int i=0;i<memberDb.size();i++) {//for s
			if(memberDb.get(i).id.equals(id)) {//id f s
				if(memberDb.get(i).pw.equals(pw)) {//pw f s
					return i;
				}else {
					return -1;
				}
			}//id f e
		}//for e
		
		return -2;
	}
	
	
	
	public String findId(String name, String phone ) {
		for(int i=0;i<memberDb.size();i++) {
			if(memberDb.get(i).name.equals(name)){
				if (memberDb.get(i).name.equals(phone)) {
					return memberDb.get(i).id;//아이디 리턴
				}else {
					return "1";//번호가 잘못됨 1리턴
				}
			}
		
		}
		return "2";//포문을 다돌았는데도 이름과 번호가 존재하지않으면 회원가입권유
	}
	
	
	
	public String findPw(String id,String phone) {
		
		for(int i=0;i<memberDb.size();i++) {
			if(memberDb.get(i).id.equals(id)) {
				if(memberDb.get(i).phone.equals(phone)) {
					return memberDb.get(i).pw;//아이디와 번호가 같을시 비번리턴
				}else {
					return "1";//아이디는 같지만 번호가 다르면 1 리턴
				}
			}
		}
		return "0"; //포문이 다 돌떄까지 아이디와 번호가 다르면 0리턴
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
