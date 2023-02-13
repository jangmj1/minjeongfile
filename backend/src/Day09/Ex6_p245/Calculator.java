package Day09.Ex6_p245;



	/* 
	 * 정적맴버:
	 * 		1. static 키워드
	 * 		2. jvm메소드 영역 저장
	 * 		3. 객체 없이 사용 가능
	 * 		4. 사용방법
	 * 			-클래스명.정적멤버
	 * 		5. 프로그램 시작시 생성,프로그램 종료시 초기화
	 * 			-효율성 생각 : 모든 클래스에서 사용되는 메모리 사용시 효율성이좋다(공유가자유롭다)
	 * 		6.정적맴버는 인스턴스 맴버 사용할수 없다.
	 */

public class Calculator {
	//1.필드
		//1.인스턴스맴버
	int no;
		//2.정적맴버
			//-static 생성자없음
	static double pi=3.14159;
	
		//3. 메소드
			//1.인스턴스맴버
	int getNumber() {
		return no;
		
		//2.정적맴버
		
	}
	static int plus(int x,int y) {
		return x+y;
	}
	static int minus(int x,int y) {
		return x-y;
	}
	static String info;
	
	static {
		info=pi+"파이입니다.";
	}
	
	
}
