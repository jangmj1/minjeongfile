package 과제.과제7;

public class Kb extends Bank{
	
	public String no ;//사실 필드도 다똑같음..
	//필드가 없으니까 생성자가 안만들어지더라.. 사실필요없음





public Kb(String number, String pw, String name, int money, String no) {
	super(number, pw, name, money);
	this.no = no;
}
public Kb() { }

@Override
public void join() {
	super.join();
	System.out.println("국민은행 계설완료!");
	System.out.println("계좌:"+number);
}







}