package 과제.과제7;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

	
	
		
		
		//필드
		public String number;//계좌번호
		public String pw;
		public String name;
		public int money;
		
		
		
		//생성자
		public Bank() {//빈깡통 생성자
		}

		public Bank(String number, String pw, String name, int money) {
			this.number = number;
			this.pw = pw;
			this.name = name;
			this.money = money; //풀생성자
			
		}


		
	Scanner scanner=new Scanner(System.in);
	
	
	
//	ArrayList<bank>bankDb= new ArrayList<>();// 한페이지에서 왜안만들어지는걸까
	public void join() {
		
		
		System.out.println("1.계좌생성 2.예금");
		 int ch=scanner.nextInt();
		 if(ch==1) {
			 System.out.println("성함:"); String name=scanner.next();
			 System.out.println("비밀번호:"); String pw=scanner.next();
			 
			 System.out.println("계좌를 생성합니다");
			 String no = "11";
			 int random1=(int)((Math.random()*99)+10);
			 int random2=(int)((Math.random()*99)+10);
			number=no+"-"+random1+"-"+random2;
			System.out.println("당신의 계좌는:"+number);
			
			//ArrayList 안만들어져서 애드를 못한다..
		
		 
		 }else if (ch==2) {
			
		}
		
	
		
		
		
		
	}
	
}
	

	


