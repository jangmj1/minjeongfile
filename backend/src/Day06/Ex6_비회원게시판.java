package Day06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Ex6_비회원게시판 {//c s
	public static void main(String[] args)throws Exception {//m s //2.예외처리
		
		
		//step1:필요한 데이터를 입력받아 저장
		//step2: 쓰기 페이지 실행되는 조건
		//step3: 입력된 데이터를 파일 처리[영구저장]
		//step4: 파일에 있는 문자열 가지고오기
		
		
		
		
		
		
		//입력객체
		Scanner scanner=new Scanner(System.in);
		
		while (true) {
			//1.파일클래스 객체 생성(파일경로)
			FileInputStream fin=new FileInputStream("c:/java/board.txt");
			
			//2.읽어온 바이트를 저장하기 위해 미리 바이트 배열 1000바이트 미리 생성
			byte[] inbytes=new byte[1000];//빈상자
			
			//3. .read() 메소드를 이용한 파일 읽기 [*읽은 바이트를 바이트 배열 저장]
				//inbytes : 읽어온 바이트가 배열에 저장
				//bytecount : 읽어온 바이트의 개수를 변수에 저장
			int bytecount= fin.read(inbytes);//2.읽어온 바이트를 바이트 배열 저장 *가져온 fin을 읽어서 inbytes에 넣어라
			
			//4. 바이트 배열--> 문자열
				//new string("유재석"); 이라고 써도 되지만
				//new string(바이트배열); new String(바이트배열,시작인덱스,마지막인덱스)
			if( bytecount != -1 ) {  
				String fStr=new String(inbytes,0,bytecount);//읽어온 바이트 배열을-->문자열로 변환 //배열에서(1000중) 0부터 300까지만 가져와서 문자열로 변환
				
				String[] boards=fStr.split("\n");//행 기준으로 분리[만약에 게시물이 2개일때 2조각]
				
				System.out.println("----------게시글목록---------");
				System.out.printf("%2s  %10s  %5s  \n","번호", "제목","작성자"); //타이틀 출력
				
				
				//*[행마다] 열 기준 자르기
				for(int i=0; i<boards.length;i++) {
					/* System.out.println(boards[i]); */
					String[] cols= boards[i].split(",");//4조각
					String title=cols[0];
					String writer=cols[1];
					String content=cols[2];
					String password=cols[3];
					System.out.printf("%2d  %10s  %5s  \n",i, title,writer);//내용 출력
					System.out.printf("--------------------------\n");//내용 출력
				}
			}
		//1.  여기서 부터 시작	
			System.out.println("메뉴>-1:쓰기 -2:나가기");
			int ch=scanner.nextInt();
			if(ch==-1) {
				System.out.println("제목:"); String title= scanner.next();
				System.out.println("내용:"); String content= scanner.next();
				System.out.println("작성자:"); String writer= scanner.next();
				System.out.println("비밀번호:"); String password=scanner.next();
				
				String outStr=title+","+content+","+writer+","+password+"\n";		//, : 열구분선 \n:행구분선 할려고
				
				//1.파일처리 객체 생성("파일경로",true); //처음에 트루 안넣고 파일생성시키고 생성된후에 트루를 넣어서 이어쓰기 해야함
				FileOutputStream fout=new FileOutputStream("c:/java/board.txt",true);
				fout.write(outStr.getBytes());//문자가 바이트단위로 바뀐다
			}
			else if (ch==-2) {
				break;
			}
		}
		
		
		
		
		
	}//m e
}//c e
