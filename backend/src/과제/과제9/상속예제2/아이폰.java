package 과제.과제9.상속예제2;

public class 아이폰 {
	
	public String pw;
	
	
	
	
	public 아이폰() {
		super();
	}
	public 아이폰(String pw) {
		super();
		this.pw = pw;
	}
	
	
	public int 지문인식(String pw) {
		System.out.println("지문인식을 시작합니다.");
		return 0;
	}
	public void 시리(아이폰 아이폰) {
		System.out.println("시리야~");
	}
	public void 카카오페이(String pw) {
		System.out.println("카카오페이로 결제를 시작합니다.");
	}

	

}
