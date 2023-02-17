package Day13.Ex2;
//실행창 : 사용자 입장 ->인터페이스 ->티비 or 오디오
				//인터페이스는 호출 방법만->오디오 티비가 기능을 다한다 (자녀가)
public class 실행 {
	public static void main(String[] args) {
		//new 없이 그냥 뽑아오면 됨 상수호출
		System.out.println("리모콘 최대 볼륨:"+RemoteControl.MAX_VOLUME);
		System.out.println("리모콘 최소 볼륨:"+RemoteControl.MIN_VOLUME);
		
		//1.인터페이스 변수 선언
		RemoteControl rc;
		
		//2. 인터페이스[리모콘]에 텔레비전[구현객체]연결 리모콘 넣기
		rc=new Television();
		
		//3. 인터페이스[리모콘] 기능[메소드] 사용 구현객체 연결
		rc.turnOn();
		rc.setVolume(8);
		rc.turnOff();
		
		//4. 인터페이스[리모콘]에 오디오를 꽂아보자 
		
		rc=new Audio();
		
		//4-1 구현된 메쏘드 사용
		rc.turnOn();
		rc.setVolume(10); // -5를 넣어도 min을 0으로 설정해놔서 0이됨
		rc.turnOff();
		
		
		
		//5. 디폴트 메소드 호출
		rc.setMute(true);
		rc.setMute(false);
		
		//rc 가 필요없다
		RemoteControl.changeBattery();//정적메소드
		
		
		
		
		
	}

}
