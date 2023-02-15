package Day11.Ex1;

public class Phone {//부모!!
	//클래스맴버
		//1. 인스턴스 맴버 : new 연산자 이후에  객체를 이용한 맴버사용
			//클래스 객체명 = new 생성자()---> 객체명.맴버
		//2. 정적맴버[static] : 객체 없이 이용하는 맴버
			//클래스명.맴버
	//1.맴버 종류
		//1.필드 : 객체의 데이터 저장하는곳(인스턴스필드 , 정적필드)-전역변수
			//접근 연산자 쓰고 (static/final 써도되고안써도됨 ) 등 키워드를 쓰고 타입 변수명!
	public String model;
	public String color;
	
			
		//2.생성자 : 객체 생성시 초기화 담당[지역변수가 들어간다] new 연산자를 썼을때 초기화 하는것
			// 접근제한자 클래스명(매개변수1,매개변수2) {}
			
	//*생성자안만들었지만 아무것도 없는게 아니다 기본이 들어가있따
	//생성자가 1개도 없을때 기본 생성자 자동 추가
	//생성자가 1개 이상이면 기본 생성자 직접 추가
	//생성자가 1개도 없으면 기본생성자 자동 추가
	public Phone() {}
	public Phone(String model,String color) {//
		this.model=model;
		this.color=color;
		System.out.println("--부모 클래스 생성자 실행");
	}
	
	
		//3.메소드 : 객체의 행위[지역변수가 들어간다]
			//접근제한자(public or private ) 반환타입 메소드명(매개변수1,매개변수2) {}
	public void bell() {
		System.out.println("벨이 울립니다.");//모든곳에서 호출이 가능한 매개변수도 리턴도 없는 메소드
	}
	public void sendVoice(String message) {//모든곳에서 호출이 가능하고 매개변수는 있고 리턴값은 없다
		System.out.println("자기:"+message);
	}
	public void receiveVoice(String message) {
		System.out.println("상대방:"+message);
	}
	public void hangUp() {
		System.out.println("전화를 끊습니다.");
	}
	
	
	/*
	 * 2.멤버 접근 제한자
	 * public => 패키지랑 상관없이 모든곳에서 호출이가능하다
	 * private=> 선언된 클래스 에서만 사용이(호출) 가능하다(밖으로 못나감)
	 * defalut=> 생략했을때! 기본적으로 들어가는값(패키지내에서만 호출이 가능)
	 * protected=>얘도 동일한 패키지 내에서만 호출이 가능[자식은 예외] 자식은 패키지가 달라도 부모한테 갈수있다                                                
	 */
	
}	
