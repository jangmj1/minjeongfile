package Day11.Ex4.pacage2;

public class C {
	//-----------------패키지2(A과 다른패키지)--------------------------
	public void name() {
		A a=new A();// 안됨 protected로 생성자 선언 했기때문
		 a.field="value";// 안됨
		 a.method();// 안됨
		
	}

}
