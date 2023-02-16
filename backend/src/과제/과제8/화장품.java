package 과제.과제8;

public class 화장품 extends 화장품서비스 {
	
	private String 제품명;
	private int 가격;
	
	public 화장품(String 제품명, int 가격) {
		this.제품명 = 제품명;
		this.가격 = 가격;
	}
	public 화장품() {
	}
	public String get제품명() {
		return 제품명;
	}
	public void set제품명(String 제품명) {
		this.제품명 = 제품명;
	}
	public int get가격() {
		return 가격;
	}
	public void set가격(int 가격) {
		this.가격 = 가격;
	}

	
	
	

}
