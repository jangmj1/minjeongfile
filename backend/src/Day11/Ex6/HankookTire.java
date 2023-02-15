package Day11.Ex6;
				//자식			부모
public class HankookTire extends Tire {//하위클래스
		//Tire라는 부모클래스를  extends 하고
	@Override//부모클래스의 메소드를 재 정의 
	public void roll() {
		System.out.println("한국타이어가 굴러갑니다");
	}@Override
	public void stop() {
		System.out.println("한국타이어가 멈춥니다");
						}
	
}
