package Day13.Ex3;

public class SmartTelevision implements Remotecontrol,Searchable{//Searchable 지워도 되는거 아닌가??
			//클래스명 		implements 인터페이스1,인터페이스2
	//구현해야함
	
	@Override
	public void search(String url) {
		// TODO Auto-generated method stub
		System.out.println( url+"을 검색합니다");
		
	}

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("tv를 켭니다");
		
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("tv를 끕니다");
		
	}
	
	
	

}
