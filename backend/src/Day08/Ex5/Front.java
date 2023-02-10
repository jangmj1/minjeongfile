package Day08.Ex5;

import java.util.ArrayList;
import java.util.Scanner;

public class Front {//c s
	//1.필드
		//1.입력객체
		Scanner scanner=new Scanner(System.in);
		
		//2.멤버 객체를 여러개 저장할수 있는 리스트 객체 선언
		ArrayList<Member>memberList=new ArrayList<>();
	
	
	//2.생성자
	//3.메소드
	
	//1.메인 페이지 프론트 함수
	void index() {// index s
		
		while (true) {//w s
			print();
			System.out.println("1.회원등록: 2.회원삭제:");
			int ch=scanner.nextInt();
			if(ch==1) {signup();
				
			}else if (ch==2) {delete();
				
			}else {
				System.out.println("알수없는번호");
			}
	
		}//w e
		
	}//index e
	
	//2. 회원등록 페이지 함수
	void signup() {
		System.out.print("회원명:");	String name= scanner.next();
		System.out.print("전화번호:"); String phone=scanner.next();
		Member member=new Member(name, phone);
		memberList.add(member);
		
		
	}
	//3. 회원 삭제 페이지 함수
	void delete() {
		System.out.print("삭제할 번호/인덱스:");
		int no=scanner.nextInt();
		memberList.remove(no);
		
	}
	//4.회원 출력 함수
	void print() {
		System.out.println("번호\t회원\t전화번호");
		for(int i=0;i<memberList.size();i++) {
			System.out.println(i+"\t"+memberList.get(i).name+"\t"+memberList.get(i).phone);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}//c e
