package Day13.Ex1;

public  class  Television implements RemoteControl{

	
			//클래스명 implements 인터페이스명:구현하다
				//인터페이스 안에 추상된 메소드를 해당 클래스가 구현하겠다는뜻
				//필수작업 : 추상 메소드를 구현 해야한다
			//상속은 해도되고 안해도 된다 그치만 추상메소드는 꼭 구현 해야한다
	
	//가장중요한! 1.인터페이스 추상 메소드를 구현
	@Override
	public void turnOn() {	
		System.out.println("TV를 켭니다.");
	}
	
}
