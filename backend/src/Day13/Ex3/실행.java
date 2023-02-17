package Day13.Ex3;

public class 실행 {
	public static void main(String[] args) {
		Remotecontrol rc=new SmartTelevision();
		//껍데기만 있는 rc=메소드가 오버라이드 되어있는 스마트티비
		
		rc.turnOn(); //Remotecontrol 만 나온다
		rc.turnOff();
		rc.search(null);
		
		//2.구현객체
		Searchable searchable=new SmartTelevision();
		searchable.search("youtube"); //Searchable 것만 나온다
		
	}

}
