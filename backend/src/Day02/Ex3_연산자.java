package Day02;

public class Ex3_연산자 {
	public static void main(String[] args) {
		
		//1. 부호/증감연산자
		int x = +10;
		int y = -10;
		System.out.println("x:"+x);
		System.out.println("y:"+y);
		System.out.println("x++:"+(x++));
		System.out.println("x:"+x);
		System.out.println("++x:"+(++x));
		
		System.out.println("y--:"+(y--));
		System.out.println("y:"+y);
		System.out.println("--y:"+(--y));
		
		//2.산술연산자
		System.out.println("x+y:"+(x+y));
		System.out.println("x-y:"+(x-y)); //증감되어서 24가 나온다
		System.out.println("x*y:"+(x*y));
		System.out.println("5/3:"+(5/3)); //int 에서 int 나누기때문에 몫만 나온다
		System.out.println("5%3:"+5%3);
		
		//3.비교연산자
		System.out.println("x==y"+(x==y));
		System.out.println("x!=y"+(x!=y));
		System.out.println("x>y"+(x>y));
		System.out.println("x>=y"+(x>=y));
		System.out.println("x<y"+(x<y));
		System.out.println("x<=y"+(x<=y));
		
		/* System.out.println("abc==abc"); 이렇게 쓰지말라는것 */
		System.out.println("str1.equals(str2):"+ ("유재석".equals("유재석") )  );
		System.out.println("str1.equals(str2):"+(!"유재석".equals("유재석") )  );
		
		
		//4.논리연산자
		System.out.println("5<x<20"+ (x>5 && x<20 )); //x=12 true and true = true
		System.out.println("5<x<10"+ (x>5 && x<10 )); //x=12 true and false = false
		System.out.println("0<=x x>=20" + (x<=0 || x>=20 ));//x=12 false or false = false
		System.out.println("0<=x x>=10" + (x<=0 || x>=10 ));//x=12 true or false = true
		System.out.println("!(x==y)" + !(x==y));// false=>true
		
		//5.대입연산자
		int z=30;
		z+= x; // 30+=12 1.30+12=>42 2. 30=42 =>42
		System.out.println("z+=x:"+(z));
		z-=x;  z*=x;  z/=x;  x%=x;
		
		//6.삼항연산자 조건 ? 참 : 거짓
		String 결과 =  (x >= 20) ? "합격" : "불합격";	System.out.println(결과);	//x=12
		
		//7.연결연산자
		String 연결문자1 = "유재석"+"10";			System.out.println(연결문자1);
		String 연결문자2 = "유재석"+10;				System.out.println(연결문자2);
		String 연결문자3 = "유재석"+10+20;			System.out.println(연결문자3);
		String 연결문자4 = "유재석"+(10+20);			System.out.println(연결문자4);
		
	}
}
