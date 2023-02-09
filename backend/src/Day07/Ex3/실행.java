package Day07.Ex3;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		
		
		//*객체활용
		Scanner scanner=new Scanner(System.in);
		
		String[] 배열=new String[3];//*string문자열 1개 저장할수 있는 클래스
		
		Member[] 배열2=new Member[3];//멤버 객체를 3개를 저장할수있는 배열
		
		System.out.println("아이디:"); String id=scanner.next();
		System.out.println("비밀번호"); String pw=scanner.next();
		배열[0]=id+","+pw;	//비효율적이다 결국 다시 쪼개야함
		System.out.println(배열[0].split(",")[0]);
		
		//2.회원 클래스 만들어서 회원객체를 만들자
		
		Member m1=new Member();
		m1.id=id; //입력받은 id를 객체내 필드인 id 대입(지역이 다르기떄문에 이름같아도됨)
		m1.pw=pw; //입력받은 pw를 객체내 필드인 pw 대입
		
		배열2[0]=m1;	// 아이디와 비밀번호가 둘다 들어가지게된다
		System.out.println(배열2[0].id);
		
		
		
	}
	
}
