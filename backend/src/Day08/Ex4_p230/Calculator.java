package Day08.Ex4_p230;

public class Calculator {

	//1.필드
	//2.실행
	//3.메소드
		//1.반환 x 인수 x
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}
		//2.반환 x 인수 x
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
		//3.인수 : x,y / 반환 : int (인수도있고 반환도있고)
	int plus(int x, int y) {
		int result=x+y;
		return result;
	}
		//4.인수 : x,y / 반환 : double 예)x=3 y=5 3/5
	double divide(int x,int y) {
		double result=(double)x/(double)y;
		return result;
	}
		//5.인수 x,y / 반환 : x
	void multiply(int x,int y) {
		double result=(double)x*(double)y;
		System.out.println(result);
	}
		//6.인수 x / 반환 o
	String info() {
		return "이젠 계산기";
	}
	
	void 함수호출 () {
		powerOn();//내부에서 함수 호출시:함수명()
	}
}

/*
	함수=메소드 
		js 선언부					vs				java 선언
	function 함수명(인수명){}					리턴타입 함수명(인수1,인수2){}
	
		js호출									js호출
	함수명(인수 1 ,인수 2)						함수명(인수1,인수2)		

											외부호출-객체명 필요
											객체명.함수명(인수1,인수2)
											
	
											
	1. 인수 x 반환 x
		void 함수명(){ }
											
	2. 인수 0 반환 x
		void 함수명(인수 1, 인수 2){ }
											
	3. 인수 x 반환 0
		리턴타입 함수명() {return 값;}
											
	4. 인수 0 반환 0
		리턴타입 함수명(인수1,인수2) {return 값;}				
											
											
											
											
											
											
*/