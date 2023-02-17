package Day13.Ex2;

public interface RemoteControl {
	
	//인터페이스는 변수 못써요 => 필드가 없다는뜻[1.인스턴스맴버 2.정적맴버 : 스태틱이 있고없고의 차이]
												
		//static final =>상수(상수는 무조건 대문자)
		//인터페이스는 생략한다 왜? 무조건 상수니까
	public static final int MAX_VOLUME=10;
	int MIN_VOLUME=0; 
	//상수는 무조건 초기값이있어야한다 
	//앞에 public static final 가 붙지만 안보이는것뿐
	//new 연산자 (생성자)가 없기때문에 객체가 없다
	//객체가 없다는것은 인스턴스 맴버가 없다 
	//인스턴스맴버가 없다는것은 스태틱밖에 못쓴다는것
	
	
	
	//추상메소드
		//리턴 타입, 메소드명, 매개변수 만 선언 해라
		//중갈호 하지말것
		//public abstract 는 생략 가능 추상이라는 뜻이 있다 생략시 자동으로 들어가지는거임 안보일뿐
	
	//1.
	public abstract void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	//디폴트 메소드
		//클래스에서 사용하는 매소드 동일
		//선언부 앞에 default선언
		//얘는 중갈호가 있고 리턴이있따
		//오버라이드를 안해도 오류가 안뜬다 껍데기가 아니기때문
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리 합니다.");
			setVolume(MIN_VOLUME);
		}else {
			System.out.println("무음해제");
		}
	}
	
	// 정적 메소드
		//구현 객체가 필요없다 => new 없이 가능 implements 없어도됨
		//static 선언
	static void changeBattery() {
		System.out.println("리모콘 건전지를 교환합니다.");
	}//이것이 정적 메소드
	
	
	//첫번째는 상수가 존재(static) 정적맴버임 
	
	//두번재는 추~상! 젤중요 =>선언만! 한게 추상, 구현 안했기 때문에 implements 했을때 오버라이딩일 필수다
		//추상은 내부에서 껍데기만들고  외부에서 오버라이드를 해야하기때문에 private을 쓸수가없다.. 
	
	//세번재는 디폴트=>선언과! 구현을! 했기때문에 오버라이딩 할 필요는 없다 본인꺼 쓰면된다 
		//세번째 디폴트와 네번째 정적은 implements 할필요없다 구현 했기때문에 private쓸수있다 외부에서 오버라이드가 필수가 아니기때문에
		
	//네번재는 정적메소드 =>구현 객체가 필요없다(implements)필요없음 오버라이드 목적으로 쓰는애가 아님
		//implements안하고 사용하는 메소드 구현 객체가 필요없다
		
}
