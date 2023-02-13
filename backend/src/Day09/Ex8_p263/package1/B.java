package Day09.Ex8_p263.package1;

public class B {
	A a;	// 같은패키지니까 임폴트값이 없어도 가능
	
	A a1= new A(true);	// public은 가능
	A a2= new A(1);	//default는 같은 패키지 까지는 가능
	//A a3= new A("문자열"); //private은 무조건 다른 클래스 에서 사용 불가능
	
	public static void main(String[] args) {
		A a4=new A(true);
		a4.field1=10;	//public 어디든 가능
		a4.field2=10;	//default 는 같은 패키지 가능
	//	a4.field3=10;	//private 은 외부에서 사용 불가능
		
		
	}

}
