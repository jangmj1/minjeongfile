package 과제.과제9.상속예제3;

public class 냉장고 {
	String 금액;
	String 등급;
	String 제조사;
	
	public 냉장고(String 금액, String 등급 , String 제조사) {
		this.금액 = 금액;
		this.등급 = 등급;
		this.제조사 = 제조사;
	}
	public 냉장고() {
	}
	
	public void 등록() {
		System.out.println("등록하실 냉장고의 등급은?");
		String 등급1=실행.get실행().scanner.next();
		System.out.println("등록하실 냉장고의 금액은?");
		String 금액2=실행.get실행().scanner.next();
		System.out.println("등록하실 냉장고의 제조사는?");
		String 제조사3=실행.get실행().scanner.next();
		
		
	
	
	}
	
	
}
