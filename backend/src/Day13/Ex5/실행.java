package Day13.Ex5;

public class 실행 {
	public static void main(String[] args) {
		
		Car myCar=new Car();
		
		myCar.run();
		
		myCar.tire1=new KumhoTire();//한국 타이어 였던 tire1 에 금호 타이어 껴넘
		myCar.tire2=new HankookTire();//금호 타이어 였던 tire1 에 한국 타이어 껴넘
		
		myCar.run();
		
		
		
		
	}
}
