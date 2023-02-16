package 과제.과제8;

public class 파운데이션 extends 화장품{
	private int 호수;
	private String 제형;
	
	
	public 파운데이션(String 제품명, int 가격, int 칼라, String 제형) {
		super(제품명, 가격);
		this.호수 = 칼라;
		this.제형 = 제형;
	}

	public 파운데이션() {
	}

	
	
	@Override
	public boolean 등록() {
		// 파운데이션 유효성검사
		if( 호수 == 0 || 제형 == null  ) {
			return false;
		}
		System.out.println("파운데이션 등록했습니다.");
		return super.등록();
	}
	@Override
	public void 상세보기() {
		System.out.println("상품분류 : 파운데이션");
		super.상세보기();
		
		System.out.println( "제형 : "+제형  );
		System.out.println( "호수 : "+호수 +"호" );
	}

	
	
	public int get호수() {
		return 호수;
	}

	public void set호수(int 호수) {
		this.호수 = 호수;
	}

	public String get제형() {
		return 제형;
	}

	public void set제형(String 제형) {
		this.제형 = 제형;
	}

	

	
	
	
	
	
}
