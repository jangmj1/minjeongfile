package Day13.Ex2;

public class Television implements RemoteControl{
	private int volume;
	
	//해당 클래스가 인터페이스에서 추상된 메소드를 구현하겠다!
		//오버라이딩 필수 왜? 구현한다고 했기때문에
		

	@Override
	public void turnOn() {
		System.out.println("tv를 켭니다");
	}

	@Override
	public void turnOff() {
		System.out.println("tv를 끕니다");
		
	}

	@Override
	public void setVolume(int volume) {
		if(volume>RemoteControl.MAX_VOLUME) {//만약에요청한 소음이 최대소음보다 크면
			this.volume=RemoteControl.MAX_VOLUME;//현재 소음에 최대 소음을 대입
			System.out.println("최대 소음보다 커질수 없읍니다.최대소음으로 설정");
		}
		else if (volume<RemoteControl.MIN_VOLUME) {//만약에 요청한 소음이 최소소음보다 작으면
			this.volume=RemoteControl.MIN_VOLUME;//현재 소음에 최소 소음인 0으로 대입
			System.out.println("최소 소음보다 0보다 작을수 없읍니다.최소소음으로 설정");
			
		}else {
			this.volume=volume;
		}
		System.out.println("현재 tv볼륨:"+this.volume);
	}
	


}
