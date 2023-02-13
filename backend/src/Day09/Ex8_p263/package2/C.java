package Day09.Ex8_p263.package2;

import Day09.Ex8_p263.package1.A;

public class C {
	
	//1.A클래스가 public 일때 가능
	A a;	//가능 : 같은 패키지 아니지만 import 해서 가능해짐
	//2. A클래스가 public 아닐때
			//불가능 : default 는 같은 패키지만 가능
	
	A a1=new A(true);	//public 어디든 가능
//	A a2=new A(1);		//default는 다른 패키지일경우 불가능
//	A a2=new A("문자열"); //private는 내부 외엔 다 불가능
	
	public static void main(String[] args) {
		A a4=new A(true);
		a4.field1=10;	//public o
		//a4.field2=10;	//default x
		//a4.field3=10;	//private x
	}

}
