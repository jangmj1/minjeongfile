package Day01;

public class Ex4_자료형변환 {//클래스 시작
	public static void main(String[] args) {//메인 시작
	
	//1. 자동 타입 변환
		byte b1=10; int i1=b1;			//byte ==> int 가는것은 가능!
		char c1='가'; i1=c1;				//char ==> int 가는것은 가능!
		int i2=50;	long l1=i2;			//int ==> long 가는것은 가능!
		long l2=100; float f1=l2;		//long ==> float 가는것은 가능!
		float f2=100.5f; double d1=f2;	//float==>double 가는것은 가능
	
	//2. 강제 타입 변환
		int i3=2000000; 	byte b2=(byte)i3;		//int ==> byte 불가능[강제는가능]
		System.out.println(b2);
		
		long l3=300;		int i4=(int)l3;			//long==>int 불가능[강제는가능]
		System.out.println(i4);
		
		int i5=65;		char c2=(char)i5;			//int==>char 불가능[강제는가능]				
		System.out.println(c2);
		
		double d2=3.14;		int i6=(int)d2;			//double==>int 불가능[강제는 가능] : 소수점 짤려서 정수만 나온다
		System.out.println(i6);
		
		
		
	//3. 연산시 타입 자동 변환 예제없음
	
	//4.문자열 타입 변환
		String str1="10";						//문자 10이다 int 10아님
		int 정수1=Integer.parseInt(str1);			//String==>int				
			System.out.println("정수1:"+정수1);
			
		byte 바이트1=Byte.parseByte(str1);		//String==>byte
			System.out.println("바이트1:"+바이트1);
			
		short 쇼트1=Short.parseShort(str1);		//String==>short
			System.out.println("쇼트1:"+쇼트1);
			
		long 롱1=Long.parseLong(str1);			//String==>long
			System.out.println("롱1:"+롱1);
			
		float 플릇1=Float.parseFloat(str1);		//String==>float
			System.out.println("플릇1:"+플릇1);
			
		double 더블1=Double.parseDouble(str1);	//String==>double
			System.out.println("더블1:"+더블1);
		
		
		/*
		 * String str2="안녕"; int 인트2=Integer.parseInt(str2); // 이런건 불가능함
		 */		
		
		
		
		
		
		
		
		
		
		
		
		
	}//메인 끝
}//클래스 끝

/*

1. 자동 타입 변환 작은 타입==> 큰 타입 자동
	
2.강제 타입 변환[캐스팅]
	-손실이 있더라도 해야할경우 or 손실이 생기지 않는상황일경우
	
3.연산시 자동 타입 변환
	-피연산자중 큰 타입을 결과로 반환한다(단 바이트와 쇼트는 제외 ==> int로 변환됨)
	1.정수
		1.int 보다 작은 byte,short 연산시 무조건 int 결과
			byte+byte	==>		int
			short+int	==>		int
		2.long 연산시
			int+long	==>		long
	
	2.실수
		float+float		==>		float
		float+double	==>		double
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	*/
