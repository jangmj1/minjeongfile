package 과제.과제7;

public class Sinhan extends Bank{
	
	public String no ;

	
	public Sinhan(String number, String pw, String name, int money, String no) {
		super(number, pw, name, money);
		this.no = no;
	}


	public Sinhan() {
	}


	@Override
	public void join() {
		super.join();
		System.out.println("우리은행 계설완료!");
		System.out.println("계좌:"+number);
	}
	
	
}
