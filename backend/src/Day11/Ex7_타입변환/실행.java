package Day11.Ex7_타입변환;

import java.util.ArrayList;

public class 실행 {
	public static void main(String[] args) {
		// 1. 기본타입의 자동타입 변환
		byte value1=10;
			short value2=value1;
				int value3=value2;
					long value4=value3;
						float value5=value4;
							double value6=value5;
							
		
		//2. 기본타입의 강제 타입 변환-->캐스팅( )
		double value7=10.111111;
			float value8=(float)value7;
				long value9=(long)value8;
					int value10=(int)value9;
						short value11=(short) value10;
							byte value12=(byte)value11;
	
		//3. 매개변수,리턴타입
	double result=	함수1(value1);	
	//double로 받아서 int 로 배출 하는 함수1===>더블이라는 상자(매개변수or인수)에 바이트 10을 대입하고(가능) ->더블이라는 상자에(result) 인트 값을 배출(가능)
	
	byte result2=(byte)함수2 ((byte)value3 );
	//바이트로 받아서 double로 배출하는 함수 2===>바이트라는 상자에(매개변수or인수) value3 (자료형 int)를 담아서 대입해야하는데 불가능-> int value3를 byte로 변환 하여 대입
	//배출도 마찬가지로 더블로 리턴하는데 result2는 자료형이 byte ==> 더블로 나온 결과값을 바이트에 담을수가 없어서 함수2를 바이트로 케스팅해준다
	
		//4. 배열 ,
	double[]배열=new double[3];
	배열[0]=3.3; 배열[1]=3;
	
	}// main e
	
	public static int 함수1(double 매개변수) { //double로 받아서 int 로 배출
		return 3;
	}
	public static double 함수2(byte 매개변수) {//바이트로 받아서 double로 배출
		return 3;
	}
	
	

}
/*
 * 타입 종류
 * 1. 기본타입
 * 		boolean,char,byte,short, int , long, float,double
 * 
 * 2. 참조타입-힙 저장->힙주소 스택 저장
 * 		배열,클래스[String],인터페이스
 * 
 * 	타입변환
 * 	1.자동타입 변환
 * 		
 * 	2.강제 타입 변환
 */
