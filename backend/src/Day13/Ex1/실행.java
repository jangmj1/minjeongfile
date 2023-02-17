package Day13.Ex1;

public class 실행 {
	public static void main(String[] args) {
	//인터페이스를 사용하는 구현객체를 만들것
		//1. 인터페이스는 타입 이므로 변수처럼 사용 가능
		//2. 참조하지 않고 있는 변수는  null 대입
		RemoteControl control1=null; //가능
		
		//3.해당 인터페이스를 implements 선언한 객체의 주소 대입 가능
		RemoteControl control2=new Television();
		
		//RemoteControl control2=new Audio(); 불가
			// 해당 인터페이스를 implements 선언하지않은 객체의 주소 대입 불가
		
		RemoteControl rc;
		rc=new Television();
			//new Television(); [힙 영역에 객체를 선언하고 주소를 반환]
			//반환한 주소 'rc' 스택영역에 변수 대입;
		
		rc.turnOn();
		
		new Television().turnOn(); //짧게 이렇게 써도 가능하다
		
		rc=new Audio();//객체를 텔레비젼에서 오디오로 바꾼거임
		rc.turnOn();//그럼 턴온 메소드가 오디오 턴온이 실행된다
		//인터페이스의 가장 주 목적은 동일한 목적 하의 동일한 기능을 수행 하게끔 하는거 즉
			// 오디오와 tv는 전원 버튼이 있지만 서로다른 기능을 실행하겠다
			//비행기게임에서 첫번째 버튼은 미사일이나가고 테트리스에서 첫번째키는 막대기가 나간다 
			//목적은 버튼을 누르는거 기능은 서로다름 
		
	}
}
