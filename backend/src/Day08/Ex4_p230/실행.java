package Day08.Ex4_p230;

public class 실행 {//c s
	public static void main(String[] args) {//m s
		
		//1.외부에서 함수 호출-> 객체 필요
		Calculator mycalc=new Calculator();
		
		//2. 객체를 통한 맴버 함수 호출
		mycalc.powerOn();
		
		//3.
		int result1= mycalc.plus(5, 6);
		System.out.println(result1);
		
		//4.
		int x=10;
		int y=4;
		double result2=mycalc.divide(x, y);
		System.out.println(result2);
		
		//5.
		mycalc.powerOff();
		
		//6.
		System.out.println( mycalc.info() );
		
	}//m e

}//c e
