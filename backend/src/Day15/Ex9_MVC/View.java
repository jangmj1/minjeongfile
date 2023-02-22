package Day15.Ex9_MVC;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
	
	//싱글톤
	
	private static View view=new View();
	private View() {};
	
	
	public static View getInstance() {
		return view;
	}

	Scanner scanner=new Scanner(System.in);
	public void index() {
		while (true) {
			System.out.println("1.등록[c] 2.출력[r] 3.수정[u] 4.삭제[d] ");
			int ch=scanner.nextInt();
			if(ch==1) {singup();}
			else if (ch==2) {list();}
			else if (ch==3) {Update();	}
			else if (ch==4) {delete();	}
		}
		
	}
	
	public void singup() {
		System.out.println("-----------등록[C]----------");
		System.out.println("아이디:"); String mid=scanner.next();
		System.out.println("비밀번호:");String mpw=scanner.next();
		
		//입력받은 데이터를 컨트롤에게 전달후 결과얻기
		boolean result=
		Controller.getInstance().singup(mid, mpw); //controller 의 singup에 인수 id 와 pw를 보내고 true or false 를 받는다
		
		if(result==true) {
			System.out.println("회원가입성공");
		}else{
			System.out.println("회원가입실패");
		}
	}
	
	
	public void list() {
		
		System.out.println("-------------------------");
		System.out.printf("%2s \t %10s \t %10s \n","번호","아이디","비밀번호");
		
		//1.컨트롤에게 모든회원을 요청 '=' 오른쪽걸 실행 먼저함
		ArrayList<MemberDto>result=	Controller.getInstance().list();
		
		
		//2.요청한거 반복문
		for(int i=0;i<result.size();i++) { //전달받은걸 출력
			System.out.printf("%2d \t %10s \t %10s \n",
					result.get(i).getMno(),result.get(i).getMid(),result.get(i).getMpw());
		}
		
		
		
		
	}
	
	
	public void Update() {
		System.out.println("-----------------");
		System.out.println("회원번호:"); int mno=scanner.nextInt();
		System.out.println("비밀번호:"); String npw=scanner.next();
		
		boolean result=Controller.getInstance().Update(mno, npw);
		
		if(result) {
			System.out.println("수정성공");
			
		}else {
			System.out.println("수정시일풰!");
		}
		
		
	}
	
	public void delete() {
		System.out.println("---------삭제-----------");
		System.out.println("회원번호");int mno=scanner.nextInt();
		
		boolean result=Controller.getInstance().delete(mno);
		
		if(result) {
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제시일풰에!!!");
		}
	}
	
	
	
	
	
	
	
	
	
	

}
