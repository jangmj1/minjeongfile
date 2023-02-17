package Day13.Ex4;

public class 실행 {
	public static void main(String[] args) {
		//1.구현 객체
		InterfaceCImpl impl=new InterfaceCImpl();
		//클래스는 자료형이 맞추거나 상속관계일때만 대입가능
	
//-------------------바로 객체에서 뽑아오지 않는 이유---------------	
		
		impl.methodC();//이렇게 바로 써도 결과값은 같지만 다른 클래스로 변환이 불가함
		// impl=new InterfaceCImpl2() 이게안된다
	
		
		InterfaceC icc = impl;
		//부모			자식
		
		icc.methodC();
		
		icc = new InterfaceCImpl2();
		//부모는 담을수있다 자녀 2를  다른것들도 교체를 하기위해 
		// InterfaceC icc = impl; => icc.methodC();귀찮아도 이런방식으로 한다
			//부모 icc에 자식 impl을 담고  메쏘드를 불러오기
		
//--------------------------밑에방법으로..---------------------------------		
		
		//2.인터페이스 변수에 구현 객체 대입
		InterfaceA ia=impl;
		
		ia.methodA(); //본인 추상메소드는 호출이 가능
		//ia.methodB();//이웃집꺼안됨
		//ia.methodD();//자식꺼 안됨
		
		InterfaceB ib=impl;
		ib.methodB();//본인 추상메소드는 호출이 가능
		//ib.methodA();//이웃집꺼안됨
		//ib.methodC();//자식꺼 안됨
		
		InterfaceC ic=impl;
		ic.methodA(); //부모1꺼 가능
		ic.methodB(); //부모2꺼 가능	
		ic.methodC(); //본인꺼 호출도 가능
		
		ic = new InterfaceCImpl2();
		
	
	}
}
