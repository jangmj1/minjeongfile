package Day02;//현재 클래스가 존재하는 패키지

//!:자바는 무조건 class단위
	//자바를 100% 객체 지향
	//클래스 기반으로 메모리 할당 : 객체
	//클래스:객체 설계도

public class Ex1_출력 {// class s
	
	//*메인스레드[스레드:실행주체]
	public static void main(String[] args) {//main s
		
		System.out.println();
			//System : 시스템 클래스[관련 메소드 제공]
			//out: 출력 vs in: 입력
			//println():출력후 자동 줄바꿈처리기능
			//print():출.력.만
			//printf() : 형식출력
		System.out.print("프린트함수1");
		System.out.print("프린트함수2");//print():출.력.만
		System.out.println("printin 함수1");
		System.out.println("printin 함수2");//println():출력후 자동 줄바꿈처리기능
		
		int value=123;
		System.out.println("상품의 가격 :"+value+"원");
		System.out.printf("상품의 가격 : %d원\n",value);
		System.out.printf("상품의 가격 : %6d원\n",value);
		System.out.printf("상품의 가격 : %-6d원\n",value);
		System.out.printf("상품의 가격 : %06d원\n",value);
		
		double area=3.14159;
		System.out.println("파이출력:"+area);
		System.out.printf("파이출력:%f\n",area);
		System.out.printf("파이출력:%.1f\n",area);
		System.out.printf("파이출력:%3.2f\n",area);
		System.out.printf("파이출력:%3.3f\n",area);
		System.out.printf("파이출력:%3.4f\n",area);
		
		String name="홍길동";
		String job="도적";
		System.out.printf("%6d|%-10s|%10s\n",1,name,job);
		
		/*
		 *%d 안에 value가 대입된다 
		 * %d= 정수
			 * %자리수d=자리수 오른쪽 자리수차지[만일 자릿수에 데이터 없으면 공백]
			 * %-자리수d=자리수 왼쪽 자리수차지[만일 자릿수에 데이터 없으면 공백]
		 * %f= 실수
		 * 	
		 * 
		 * %s= 문자열
		 * 
		 * */
		
		
		
	}//main e

}//class e









/*제어 / 이스케이프 문자
	\n : 줄바꿈
	\t : 들여쓰기
	\" : "출력
	\' : '출력
	
	
	
	
	
	
	
	
	*/
	
	