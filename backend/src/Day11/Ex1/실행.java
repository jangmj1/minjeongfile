package Day11.Ex1;

public class 실행 {
	public static void main(String[] args) {
		
		//1.phone 객체
			Phone phone=new Phone();
			
		//2.phone 객체의 인스턴스맴버 호출
			phone.color="빨강";
			System.out.println(phone.color);
			phone.bell();
			phone.sendVoice("안녕하세요");
			
		//3. phone 클래스는 smartPhone 멤버 호출
			//phone.wifi ; x
			//부모객체는 자식 객체의 맴보 호출 할수 없다
			
					
		//1.
			SmartPhone smartPhone=new SmartPhone();
			
			//2.smartPhone 클래스는 phone 멤버 호출
			//* 자식객체는 부모클래스의 맴버 호출 할수 있따.
			smartPhone.color="은색";
			System.out.println(smartPhone.color);
			smartPhone.bell();
			System.out.println("안녕하세요");
			
			//1.자식 클래스로 객체 만들기
			SmartPhone myPhone=new SmartPhone("갤럭시","은색");  
			
			//2.자식 클래스로 부모 클래스의 맴버를 호출
			System.out.println("모델:"+myPhone.model);
			System.out.println("색상:"+myPhone.color);
			
			
			//3.자식클래스가 본인 맴버 호출
			System.out.println("와이파이 상태:"+myPhone.wifi);
			
			//4.자식 클래스로 부모 클래스의 맴버 호출
			myPhone.bell();
			myPhone.sendVoice("안녕하세요");
			myPhone.receiveVoice("안녕하세요 저 홍길동인데요");
			myPhone.sendVoice("아~ 네! 반갑습니다");
			myPhone.hangUp();
			
			//5.자식 클래스 본인 맴버 호출
			myPhone.setWifr(true);
			myPhone.internet();
			
			
			
			
			
			
			
			
			
			
			
			
		
	}
}
/*
 * 자동완성 메뉴
 *  필드 : 필드명,
 *  메소드: 함수명
 * 
 */
