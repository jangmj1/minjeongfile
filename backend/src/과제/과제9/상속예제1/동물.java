package 과제.과제9.상속예제1;

public class 동물 {
	public String 사냥메뉴;

	
	
	public 동물(String 사냥메뉴) {
		this.사냥메뉴 = 사냥메뉴;
	}



	public 동물() {
	}



	public void 먹이() {
		System.out.println(사냥메뉴+"를잡아먹습니다.");
		
	}
	
}
