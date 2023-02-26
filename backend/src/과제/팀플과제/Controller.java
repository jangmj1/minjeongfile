package 과제.팀플과제;

public class Controller {
	
	private static Controller controller=new Controller();
	private Controller() {}
	public static Controller getInstance() {
		return controller;
	}
	
	public boolean signup(String 아이디,String 비밀번호,String 전화번호,String 이름,int 등급) {
		
		회원 회원=new 회원(0, 아이디, 비밀번호, 전화번호, 이름, 등급);
		
		boolean result=
				MemberDao.getInstance().signup(회원);
		
		
		return result;
		
		
	}
	
	public int login(String 아이디,String 비밀번호) {
		
		return MemberDao.getInstance().login(아이디, 비밀번호);
		
	
		
		
	}

}
