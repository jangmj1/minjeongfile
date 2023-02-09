package Day07.Ex6;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex_6회원시스템_컬렉션프레임워크 {//c s
	
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		ArrayList<Member> memberList=new ArrayList<>();
		//ArrayList : 리스트 선언 사용되는 클래스
		//<클래스명>	: 리스트 안에 들어갈 항목의 클래스
		
		while (true) {
			System.out.println("1.회원등록 2.회원삭제:");
			int ch=scanner.nextInt();
			
			/*
			// js : (인수)=>{실행문} 
			// java:(인수)->{실행문} 
			memberList.forEach((o)->{
				System.out.println(o.name);
			});*/
			
			//배열명.length : 배열내 길이			[고정길이]
			//리스트명.size() : 리스트내 요소들의 개수[가변길이]
			System.out.println("번호\t회원명\t전화번호");
			for(int i=0;i<memberList.size();i++) {
				//null 찾는 유효성 검사 안해도됨 remove의 장점
				System.out.println(i+"\t"+memberList.get(i).name+"\t"
							+memberList.get(i).phone);
			}
				
			
			
			if(ch==1) {	//저장
				System.out.println("회원명:"); String name=scanner.next();
				System.out.println("번호:"); String phone=scanner.next();
				
				Member member=new Member();
				member.name=name;
				member.phone=phone;
				memberList.add(member);// 리스트에 객체 추가 // js: push()
				System.out.println(member);
				
			}else if (ch==2) {//삭제
				System.out.println("삭제할 번호/인덱스");
				int no=scanner.nextInt();
				memberList.remove(no);
				
				
				
			}else {
				
			}
			
		}
		
		
	}

}// c e
