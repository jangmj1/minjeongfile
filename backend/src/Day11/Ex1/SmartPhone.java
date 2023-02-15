package Day11.Ex1;
//스마트폰 자식!!!
public class SmartPhone extends Phone{
			//자식		상속		부모
			//부모클래스의 맴버들을 자식 클래스가 사용할수 잇다.
	//1.필드
		public boolean wifi;
		
	//2.생성자
		public SmartPhone() {	}

		public SmartPhone(String model,String color) {
			super(model, color);
			System.out.println("--자식 클래스 생성자 실행");
		}
		
	//3.메소드
		public void setWifr(boolean wifi) {
			this.wifi=wifi;
			System.out.println("와이파이 상태를 변경했습니다.");
		}
		
		public void internet() {
			System.out.println("인터넷에 연결합니다");
		}
		
	
	
}
