package 과제.과제9.상속예제3;

public class 엘지냉장고 extends 냉장고{

	String 도어;

	public 엘지냉장고(String 금액, String 등급, String 제조사, String 도어) {
		super(금액, 등급, 제조사);
		this.도어 = 도어;
	}
	
	

	public 엘지냉장고() {
		super();
	}



	@Override
	public void 등록() {
		// TODO Auto-generated method stub
		System.out.println("등록하실 냉장고의 도어는?");
		String 도어=실행.get실행().scanner.next();
		super.등록();
	}

}
