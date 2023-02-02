package Day02;

import java.util.Scanner;

public class Ex2_입력 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("x값 입력:");
		String 문자열1 = scanner.next(); //1. 문자열[띄어쓰기 불가능] 입력받기 함수
			System.out.println(문자열1);
		String 문자열2 = scanner.nextLine(); //2. 문자열[띄어쓰기가능] 입력받기 함수
			System.out.println(문자열2);
		boolean 논리 =scanner.nextBoolean(); //3.논리 입력받기 함수
			System.out.println(논리);
		char 문자 = scanner.next().charAt(0); //4. 한글자 입력받기 함수 .next() 물자열중에서 .charAT(0) 첫글자만 반
			System.out.println(문자);
		byte 바이트= scanner.nextByte(); //5. 정수형 입력받기
			System.out.println(바이트);
		short 쇼트= scanner.nextShort(); //6. 정수형 입력받기
			System.out.println(쇼트);
		int 인트= scanner.nextInt(); //7.int 정수형으로 입력 받기
			System.out.println(인트);
		long 롱= scanner.nextLong(); //8.정수형 입력받기
			System.out.println(롱);
		float 플롯 = scanner.nextFloat(); //9.실수형 입력받기
			System.out.println(플롯);
		double 더블 =  scanner.nextDouble(); //10.실수형 입력받기
			System.out.println(더블 );
			
			//기본자료형 비교 [비교 연산자 가능]
		int 비밀번호 = 1234;
			System.out.println(비밀번호 ==1234);
			
			// 문자열[String 객체] 비교[객체는 비교 연산자 불가능=> 문자열A.equals("문자열")]
		String 아이디="qwe";
			System.out.println(아이디.equals("qwe"));
			
			
			
			
			
			
			
		
	
	}
}
