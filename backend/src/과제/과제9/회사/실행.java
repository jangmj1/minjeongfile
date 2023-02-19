package 과제.과제9.회사;

public class 실행 {

	public static void main(String[] args) {
		
		출결 관리부출결=new 관리부();
		관리부출결.출근();
		관리부출결.퇴근();
		
		출결 설계부출결=new 설계부();
		설계부출결.출근();
		설계부출결.퇴근();
	
		출결 영업부출결=new 영업부();
		영업부출결.출근();
		영업부출결.퇴근();
	}

}
