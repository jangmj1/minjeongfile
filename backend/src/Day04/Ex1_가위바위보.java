package Day04; //현재 클래스의 패키지 위치 표시

import java.util.Random;
import java.util.Scanner; //해당 클래스를 사용하기 위한 패키지로 부터 클래스 가져오기

public class Ex1_가위바위보 { //클래스 시작

   public static void main(String[] args) {// 메인 시작
      
      // !!!!!!3.입력객체[클래스 위에 import java.util.Scanner;필수!!]
      Scanner scanner =new Scanner(System.in);
      
      
      //8.변수의 사용범위:지역변수 특중{}밖으로 못나감
      int pwin=0; int cwin=0; int play=0;
      	//*:while 안에서 선언된 변수는 반복문 돌때마다 초기화 [누적이 안됨] 그래서 밖에 만듬
      
      
      while(true) {//1.무한루프[종료조건:]
         //2.출력: syso+자동완성
         System.out.println("가위(0) 바위(1) 보(2) 종료(3):");
         
         //3.입력: Scanner 클래스-> 스캐너 객체 필요
         //4.저장[변수] 
         byte player=scanner.nextByte();//입력받은 데이터를 byte형으로 가져오기 
         System.out.println("player 낸수"+player);
         //5.제어문[흐름 제어- 경우의수(정상입력(0~2),종료(3)]
         if(player==3) {
            System.out.println("--종료");//반복문 탈출
            //최종승리자구하기
            if(pwin>cwin) {System.out.println("플레이어 최종승리!!");}
            else if (cwin>pwin) {System.out.println("컴퓨터의최종승리!!");}
            else {System.out.println("무승부");}
            break;
         }
         
         //6.난수 생성[1.Math 클래스 2.Random 클래스 ]
         Random random= new Random();
         int com=random.nextInt(3); //0~2사이의 int형 난수 생성
         System.out.println(">>com낸수"+com);
         
         //7.승리자 판단
         //[player 이기는수 p:0 c:2 /p:1 c:0 /p:2 c:1]
         //[com 이기는수 p:0 c:1 /p:1 c:2 /p:2 c:0]
         //[비기는 수 p:0 c:0 /p:1 c:1 /p:2 c:2]
         
         if(
        		 (player==0 && com==2)||
        		 (player==1 && com==0)||
        		 (player==2 && com==1) ) {
        	 System.out.println(">>>플레이어승리");pwin++;
         }else if(player==com) {
        	 System.out.println(">>>무승부");
         }else {
			System.out.println(">>>컴퓨터 승리");cwin++;;
		}
         
         play++;   
            
            
      }// while end
      
   }//메인 끝

}//클래스 끝