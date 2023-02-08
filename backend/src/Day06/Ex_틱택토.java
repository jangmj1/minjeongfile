package Day06;

import java.util.Random;
import java.util.Scanner;

public class Ex_틱택토 { //c s
	public static void main(String[] args) {//m s
		
		
		Scanner scanner=new Scanner(System.in);
		//1.배열 선언:자료형 [] 배열명={데이터1,데이터2,데이터3........}
		//*.게임판 9칸 문자열 선언
		String[]게임판= {
				"[ ]","[ ]","[ ]",
				"[ ]","[ ]","[ ]",
				"[ ]","[ ]","[ ]"
				};
		//*승리판단 결과 저장 변수
		boolean 결과=false;//결과가 아직 없을 경우 공백
		
		//---------------------------------------게임판 출력-------------------------
				
			//3. 알두기
		game:while (true) {// while s
		//---------------------------------------배열내 데이터 호출/게임판 출력-------------------------		
				for(int i=0;i<게임판.length;i++) {
					System.out.print(게임판[i]);
					
					//만약에 3칸마다 줄바꿈 [인덱스가 0부터 시작하기때문에 2,5,8일때 바껴야한다 이패턴을 찾아야한다 2/3의 나머지는 2 ,5/3 나머지는 2 ]
					if(i%3==2) {System.out.println();}
				
			}
		//---------------------------------------3.플레이어가 알두기-------------------------			
				
				while (true) {//무한루프[종료조건 : 정상 알 두기했을때]
				
					System.out.print("위치[0~8]선택:");
					int 위치=scanner.nextInt();
					//유효성 검사[1. 0~8 사이가 아니거나 2. 이미 알이 존재한 자리 --> 다시입력
					if(위치 < 0 || 위치 > 8) {
						System.err.println("0~8사이만 입력하세요"); 
						continue;
					}	//1. 0~8 사이의 숫자가 아니면 -->다시입력
				
					if(!게임판[위치].equals("[ ]") ) {
						System.err.println("[알림]이미 알이 존재하는 위치입니다");
						continue; //정상 알두기 전까진 계속 위로 올라간다 밑으로 내려가지않음
					}
					게임판[위치]="[o]";
					break; //정상 알두기가 성공했을때 멈춤
				}
				//** 결과가 존재하면 게임끝
				//if(결과==true) {break;}
		//-----------------------4.컴퓨터가 랜덤으로 알두기-----------------------
				while (true) {
					Random random=new Random();
					int 위치 = random.nextInt(9); //0~8 까지 랜덤으로 나온다
					if ( !게임판[위치].equals("[ ]") ) {continue;}
					게임판[위치]="[x]";break;
					
				}
		//-----------------------5. 승리자 판단----------------------
				
			for(int i=0;i<=6;i+=3) { //가로
					if( !게임판[i].equals("[ ]") && 게임판[i].equals(게임판[i+1]) && 게임판[i+1].equals(게임판[i+2]) ) {
						System.out.println("승리"+게임판[i]);
						break game;//그냥 브레이크쓰면 현재 포문만 나감 다시 알두기가 시작됨
						//return;//브레이크와 리턴중 하나만 쓰면된다
						// 결과=true; 이것도 방법
					}
				}
				
			for(int i=0;i<=2;i++) { //세로
				if( !게임판[i].equals("[ ]") && 게임판[i].equals(게임판[i+3]) && 게임판[i+3].equals(게임판[i+6]) ) {
					System.out.println("승리"+게임판[i]);
					break game;
				}
			}
			
			//대각선
			if(!게임판[0].equals("[ ]")&& 게임판[0].equals(게임판[4])&&게임판[4].equals(게임판[8])) {
				System.out.println("승리"+게임판[0]);
				break game;
			}
			if(!게임판[2].equals("[ ]") && 게임판[2].equals(게임판[4]) && 게임판[4].equals(게임판[6])) {
				System.out.println("승리"+게임판[2]);
				break game;
			}
			
			
			
			//3.무승부 :  알이 9개면
			int 빈자리수=0;
			for(int i=0;i<게임판.length;i++) {
				if(게임판[i].equals("[ ]") )빈자리수++;
			}
			if(빈자리수==0){결과=true; System.out.println("무승부");}
			
			
	
	
	
	
	
	
	
		}//while e
		
		
	}//m e
} //c e
