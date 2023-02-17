package Day13.Ex5;

public class Car {
	//타입 : 인터페이스[해당 인터페이스를 구현한 클래스들의 구현 객체를 여러개하려고]
	Tire tire1=new HankookTire();
	Tire tire2=new KumhoTire();
	
	
	void run() {
		tire1.roll();
		tire2.roll();
	}
}
