package 과제.과제9.상속예제1;

public class 호랑이 extends 동물{
	public String 시속;

	public 호랑이(String 사냥메뉴, String 시속) {
		super(사냥메뉴);
		this.시속 = 시속;
	}

	public 호랑이() {
	}

	@Override
	public void 먹이() {
		// TODO Auto-generated method stub
		super.먹이();
	}
	
	public void 사냥() {
		System.out.println(시속+"km/h로\t"+사냥메뉴+"를 잡았습니다");
	}
	

}
