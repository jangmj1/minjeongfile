package 과제.과제8;

public class 립스틱 extends 화장품{
	private String 칼라;
	private String 제형;
	public 립스틱(String 제품명, int 가격, String 칼라, String 제형) {
		super(제품명, 가격);
		this.칼라 = 칼라;
		this.제형 = 제형;
	}
	
	public 립스틱() {
	}

	public String get칼라() {
		return 칼라;
	}

	public void set칼라(String 칼라) {
		this.칼라 = 칼라;
	}

	public String get제형() {
		return 제형;
	}

	public void set제형(String 제형) {
		this.제형 = 제형;
	}
	
	@Override
	public boolean 등록() {
		
		if(제형 == null || 칼라 == null ) {
			return false;
		}
		System.out.println("립스틱 등록했습니다.");
		return super.등록();
	}
	@Override
	public void 상세보기() {
		// TODO Auto-generated method stub
		System.out.println("상품분류 : 립스틱");
		super.상세보기();
		
		System.out.println( "제형 : "+ 제형  );
		System.out.println( "칼라 : "+칼라  );
	}
	
	
	
	
}
