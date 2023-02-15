package Day11.Ex4.pacage2;

import Day11.Ex4.pacage1.A;

public class D extends A{
	//-----------------패키지2(A과 다른패키지)--------------------------
	
	public D() {
		// TODO Auto-generated constructor stub
	}
	public void method1() {//부모의 필드는 사용 가능
		this.field="value";
		super.field="value";
		
		this.method();
		super.method();
	}
	
	public void method2() {//부모의 필드외 새로 객체만들어서 사용은 안됨
		A a= new A();//직접 객체를 생성해서 사용되는건 안됨...
		a.field="value";// 안됨
		 a.method();// 안됨
	}
}
