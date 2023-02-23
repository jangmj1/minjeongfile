package Day17;

import java.util.Calendar;
import java.util.Scanner;

public class Ex3_달력 {
	public static void main(String[] args) {
			//static 정적 맴버는 인스턴스 맴버를 호출 못한다 run() 그냥은 못부름
				//방법
				 // 1.run 메소드도 static 으로 바꾸자 정적맴버로
				 	run2();
				 // 2.해당맴버[메소드/필드]가 인스턴스 맴버 객체 만들어서 매소드 호출하자
				 	Ex3_달력 ex3_달력=new Ex3_달력();
					ex3_달력.run();
				
		//1.달력함수만들기
		
		
		
		
	}
	
	static void run2() {}
	
	void run() {
		Calendar cal=Calendar.getInstance();
		
		//2.현재연도
		int year=cal.get(Calendar.YEAR);
		
		//3.현재월
		int month=cal.get(Calendar.MONTH)+1;
		
		//4.현재일
		int day=cal.get(Calendar.DAY_OF_MONTH);
		
		Scanner scanner =new Scanner(System.in);
		
		while (true) {
			
		
			System.out.printf("=====================%d년 %d월====================\n",year,month);
			System.out.println(" 일\t월\t화\t수\t목\t금\t토");
			
			//*** 1. 현재 월의 1일 날짜 요일
			cal.set(year, month-1,1);	//년 월 일 !/ 월 의 1일 날짜 형식으로 변경 (공백을 넣기위해 1일의 요일을 알아야한다)
			int sweek=cal.get(Calendar.DAY_OF_WEEK);//2023-02-01요일 =>4
			//*** 2. 현재 월의 마지막 일
			int eday=cal.getActualMaximum(Calendar.DAY_OF_MONTH);//2023-02 월의 일수의 최대수=마지막일
			
			
			
			//***출력
			//*** 해당 월 1일 전까지 공백 채우기
			for(int i=1;i<sweek;i++) {
				System.out.printf("\t");
			}
			
			
			
			for(int i=1;i<=eday;i++) {
				System.out.printf("%2d\t",i);
				
				if(sweek %7==0) {
					System.out.println();
				}
				sweek++;
			}
			
			System.out.println("\n===============================================");
			System.out.println("1.이전달: 2.다음달: 3.검색 : ");int ch=scanner.nextInt();
			
			if(ch==1) {	
				month--;
					if(month<1) {month=12; year--;}
				}
			if(ch==2) {	
				month++;
				if(month>12) {month=1;year++;}
				}
			if(ch==3) {
				System.out.println("연도:");int inputy=scanner.nextInt();
				System.out.println("월:");int inputm=scanner.nextInt();
				if(inputy >=1900 && inputy <= 9999 &&inputm >=1 && inputm<=12) {//정상이면
					year=inputy;month=inputm;
				}
				else {
					System.out.println("[*]출력할수 없는 달력 입니다");
				}
			}
			
		}
		
	}
		
	
}
