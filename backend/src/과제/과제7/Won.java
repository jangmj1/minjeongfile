package 과제.과제7;

public class Won extends Bank{
	
	public String no ;

	
	

	public Won(String number, String pw, String name, int money, String no) {
		super(number, pw, name, money);
		this.no = no;
	}

	public Won() {	}

	@Override
	public void join() {
		super.join();
		System.out.println("우리은행 계설완료!");
		System.out.println("계좌:"+number);
	}
	
}

