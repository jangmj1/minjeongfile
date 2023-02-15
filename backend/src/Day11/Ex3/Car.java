package Day11.Ex3;

public class Car {
	
	
	//필드
	public int speed;
	
	//메소드 선언
	public void sppdUp() {
		speed+=1;
	}
	//final 메소드
	public final void stop() {
		System.out.println("차를멈춤");
		speed=0;
	}

}
