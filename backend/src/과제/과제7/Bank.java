package 과제.과제7;

import java.util.Scanner;

public class Bank {
	
	Scanner scanner=new Scanner(System.in);
	
	//필드
	public String number;//계좌번호
	public String pw;
	public String name;
	public int money;
	public String no;
	
	
	//생성자
	public Bank() {//빈깡통 생성자
	}

	public Bank(String number, String pw, String name, int money,String no) {
		this.number = number;
		this.pw = pw;
		this.name = name;
		this.money = money; //풀생성자
		this.no = no;
	}

	public boolean join() {
		
		int ch=scanner.nextInt();
		if(ch==1) {
			System.out.println("");
		}
	
		
		return true;
		
		
		
	}
	
	
	
	

}
