package Day09.Ex6_p245;

public class 실행 {
	public static void main(String[] args) {
		
		//1. 인스턴스 맴버 호출
		
		Calculator myCalcu=new Calculator();
		System.out.println(myCalcu.no);
		myCalcu.no=10;
		System.out.println( myCalcu.getNumber() );
		
		
		double result1=10*10*Calculator.pi;
		System.out.println(result1);
		
		Calculator.plus(10, 5);
		Calculator.minus(10,5);
		
		System.out.println(Calculator.info);
		
	}

}
