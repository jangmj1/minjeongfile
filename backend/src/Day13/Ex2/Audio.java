package Day13.Ex2;

public class Audio implements RemoteControl{
	
	//필드
	private int volume;

	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다");
	}

	@Override
	public void turnOff() {
		System.out.println("Audio를 끕니다");
		
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
		System.out.println("현재 Audio 볼륨:"+this.volume);
	}
	
	private int memoryVolume;//추가 필드 선언
		//음소거 하기전 기존 소음을 저장하는 변수
	
	@Override
	public void setMute(boolean mute) {
		if(mute) {
			this.memoryVolume=this.volume;
			System.out.println("무음처리합니다");
			setVolume(RemoteControl.MIN_VOLUME);
		}else {
			System.out.println("무음 해제 합니다.");
			//기존 소음 가져오기
			setVolume(this.memoryVolume);
		}
	}
	
	
	
	
	
		
	

}
