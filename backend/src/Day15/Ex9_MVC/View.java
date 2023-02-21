package Day15.Ex9_MVC;

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
			else if (ch==3) {	}
			else if (ch==4) {	}
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
		
	}

}
