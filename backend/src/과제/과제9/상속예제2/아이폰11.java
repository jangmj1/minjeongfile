package 과제.과제9.상속예제2;

public class 아이폰11 extends 아이폰{
	public String 용량;
	public String 카메라;
	public String pw="1234";
	
	

	


	public 아이폰11(String 용량, String 카메라, String pw) {
		super();
		this.용량 = 용량;
		this.카메라 = 카메라;
		this.pw = pw;
	}

	public 아이폰11() {
		super();
	}

	@Override
	public int 지문인식(String pw) {
		
		super.지문인식(pw);
		if(this.pw.equals(pw)) {
			return 1;
		}else {
			return 2;
		}
	}

	@Override
	public void 시리(아이폰 아이폰) {
		// TODO Auto-generated method stub
		super.시리(아이폰);
		System.out.println(아이폰+"님어서오세요");
	}//안씀

	@Override
	public void 카카오페이(String pw) {
		// TODO Auto-generated method stub
		super.카카오페이(pw);
		if(this.pw.equals(pw)) {
			System.out.println("결제를 시작합니다.");
		}else if (!this.pw.equals(pw)) {
			System.out.println("비밀번호오류");
			return;
		}
		
		
	}
	
	public void 정보(String 카메라,String 용량) {
		
			System.out.println("--------------정보보기--------------");
			System.out.println("용량 :"+용량 +"GB"+"\t 카메라 줌:"+카메라+"배");
			
		
	}
	
	
	
	
	

}
