package Day09.Ex8_p263.package1;

public class A {//같은 내부안에서는 다쓸수있따
	
	/*
	 *  접근 제한자 : 해당 클래스,필드,생성자,메소드 접근을 제한하는
	 *  
	 *  	public		vs		private
	 *  모든곳에서 사용가능		현재 클래스에서만 사용가능(내부에서만)
	 *  
	 *  	defalut				protected
	 *  같은 패키지내에서	가능
	 *  .0000			같은패키지내에서
	 * 							+다른패키지일경우 자식클래스가능
	 */
	
	A a1=new A(true);
	A a2=new A(1);
	A a3=new A("문자열");
	
	//1.public 생성자
	public A(boolean b) {}
	
	//2. default 생성자
	A(int b){	}
	
	//3.private 생성자
	private A(String s) {}
	
	//1.public 필드
	public int field1;
	
	//2.default 필드
	int field2;
	
	//3.private 필드
	private int field3;
	
}
