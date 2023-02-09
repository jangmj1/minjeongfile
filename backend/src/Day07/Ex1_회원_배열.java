package Day07;

import java.util.Scanner;

public class Ex1_회원_배열 {// c s 
	
	public static void main(String[] args) {// m s
		
		Scanner scanner=new Scanner(System.in);
		
		//밖에다가 회원을 잡아둔다 와일문 돌떄마다 초기화가 되기때문에
		//문자열 [String] 3개를 저장할수 있는 배열선언 memberList= {null,null,null} 
		String[] memberList=new String[3];
		
		
		while (true) {//w s 무한루프[종료조건:없음]
			
			//2. 배열내 데이터 출력
			System.out.println("번호[인덱스]\t회원명\t전화번호");
			for(int i=0;i<memberList.length;i++) { //for s
				if(memberList[i]!=null) {//if s	//멤버가 널이 아니고 무슨 값이 있어야 아래가 실행되어야하기때문에 (만약에 데이터가 있으면! 잘라라 데이터가 없으면 냅둬라)
					
					String[] member =memberList[i].split(","); //"유재석,010-4444-4444" => split(",") ====>{"유재석","010-4444-4444"}
					System.out.println(i+"\t"+member[0]+"\t"+member[1]);
				}//if e
				
				
			}//for e
			
			
			System.out.print("1.회원등록 2.회원삭제"); // 1.시작
			
			int ch= scanner.nextInt();
			
			if(ch==1) {//1.회원등록을 입력했을때
				System.out.println("회원명:"); String name=scanner.next();
				System.out.println("전화번호:");	String phone=scanner.next();
				
				//1.push 기능 만들기 java는 푸쉬기능이 없다 멤버리스트에 빈공간을 찾아서 null을 찾으면 그곳에 이름과 번호를 저장
				for(int i=0;i<memberList.length;i++) {//for s
					if(memberList[i]==null) { //if s
						memberList[i]=name+","+phone; //문자열 합쳐서 저장 {"유재석,010-4444-4444","null","null"}
						System.out.println("회원이 등록 되었습니다.정보:"+memberList[i]);
						break; //저장 하면 반복문 탈출 . 안써주면 빈 멤버리스트에 싹다 들어간다 
					}//if e
				}//for e
				
			}else if (ch==2) {//2.회원삭제 입력했을때
				
				System.out.println("삭제할 번호:");
				int no=scanner.nextInt();
				//3.배열내 데이터 삭제 //splice는 없지만 ..[배열내 null만들기]
				memberList[no]=null;
				
				//*삭제후 빈자리 매꾸기 중요!
				//삭제된 인덱스 뒤로 한칸씩 당기기 해야함
				for(int i=no;i<memberList.length;i++) {
					if(i+1== memberList.length) {//마지막 인덱스 ex)인덱스 0,1,2 중 2번을 지운다(맨마지막) == 멤버리스트의 렝쓰는 3 즉 2+1=3 
						memberList[i]=null;	break; //마지막 인덱스에 널을 넣어준다
					}
					memberList[i]=memberList[i+1];
					if(memberList[i+1]==null)break;
					
				}
	
				
				
				
			}else {//그외 
				
			}
			
			
			
			
			
		}//w e
		
		
		
		
		
	}// m e

}// c e
