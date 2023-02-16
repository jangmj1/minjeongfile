package 과제.과제8;

public class 로션 extends 화장품  {
	//필드
	private String 피부타입;
	
	
	//생성자
	public 로션() {	}

	public 로션(String 제품명, int 가격, String 피부타입) {
		super(제품명, 가격);
		this.피부타입 = 피부타입;
	}

	
	
	@Override
	public boolean 등록() {
	if(피부타입==null) {
		return false;
		
	}else {
		System.out.println("로션이 등록되었습니다.");
		return super.등록();
		
	}
	}

	//메소드
	public String get피부타입() {
		return 피부타입;
	}

	public void set피부타입(String 피부타입) {
		this.피부타입 = 피부타입;
	}

	@Override
	public void 상세보기() {
		System.out.println("상품분류 : 로션");
		super.상세보기();
		
		System.out.println("피부타입 : "+피부타입);
	}
	
	
	
	
	
}
