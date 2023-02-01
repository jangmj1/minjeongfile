package Day01;

public class Ex3_자료형 { //클래스 s
	public static void main(String[] args) { //메인 s
		
		//1.java 에서 진수를 표현하는 방법
		int var1=0b1011; System.out.println("2진수:"+var1); //0b 
			//1011[2진수]---->11[10진수]
		int var2=0206;	System.out.println("8진수:"+var2); //0
			//206[8진수]---->134[10진수]
		int var3=365;	System.out.println("10진수:"+var3);//int=10진수
			//365[10진수]---->365[10진수]
		int var4=0xb3;	System.out.println("16진수:"+var4);//0x
			//B3[16진수]---->179[10진수]
		
		//2. byte 자료형
		byte b1=-128; System.out.println("byte자료형:"+b1);
		byte b2=127; System.out.println("byte자료형:"+b2);
		/* byte b3=128; System.out.println("byte자료형:"+b3); */ // 오류발생 byte= -128~127  까지 숫자사용가능 
		
		//3. short 자료형
		short s1=32000; System.out.println("short자료형:"+s1);
		/* short s2=33000; System.out.println("short자료형"+s2) */;	//범위를 벗어난 데이터 
		
		//4.int 자료형
		int i1=2000000000;System.out.println("int자료형:"+i1);
		/* int i2=3000000000;System.out.println("int자료형"+i2); */ //범위를 벗어난 데이터 
		
		
		//5.long 자료형
		long l1=10;	System.out.println("longl1:"+l1);
		long l2=10000000000L;	System.out.println("longl2:"+l2);//백억 숫자만 쓰면안됨 기본 인트이기때문에 숫자 뒤에 L붙혀줌
		//long l2 < 이게 롱인거지 ,10000000000 얘는 아직 인트임! 
		//인트는 21억 까지밖에못써서 100억을 못씀! int값 뒤에 L붙히므로써  long이 된다 즉! long12=long10000000000L
		
		
		//6. char 자료형
		char c1='A' ;//문자를 쓸때는 ' '  문자열을쓸떄는 " "
		System.out.println("char자료형: "+ c1);
		
		char c2=65;//문자를 쓸때는 ' '  문자열을쓸떄는 " "
		System.out.println("char자료형: "+ c2);
		
		char c3='가';//문자를 쓸때는 ' '  문자열을쓸떄는 " "
		System.out.println("char자료형: "+ c3);
		
		char c4=44032;//문자를 쓸때는 ' '  문자열을쓸떄는 " "
		System.out.println("char자료형: "+ c4);
		
		
		//7.String 클래스[문자 여러개 저장 큰따옴표사용]
		String str1="안녕하세요";System.out.println("String클래스 : "+ str1);
		
		//8. float/double 자료형
		float f1=0.1234567891345679f;System.out.println("float자료형:"+f1);
		// 소수점을 쓰는것은 무조건 더블.. float(작은상자)에 더블(큰상자)를 넣을수없다 그래서 f를 붙혀서 더블을 f로 바꿔준다. 8자리까지만 나온다
		
		double d1=0.1234567894561231234;System.out.println("double자료형"+d1); //17자리 까지만 나온다
		
		
		//9.boolean 
		boolean bool1=true; System.out.println("boolean자료형: "+bool1);
		//boolean bool2=1; //오류 발생 : true 혹은 false 만 저장 가능
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//메인 e
}// 클래스 e
