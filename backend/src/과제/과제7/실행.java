package 과제.과제7;

import java.util.ArrayList;
import java.util.Scanner;

public class 실행 {

		 Scanner scanner=new Scanner(System.in );
		 Bank bank=new Bank();
		 
		 private static 실행 실행=new 실행();
		 private 실행() {};
		 public static 실행 get실행() {
			return 실행;
		 	}

		 ArrayList<Bank>BankDb =new ArrayList<>();



	public void index() {
		while (true) {
			출력();
			 System.out.println("1.우리 2.신한 3.국민");
			 
			 int ch=scanner.nextInt();
			 
			 
			 if(ch==1) {//우리
				 우리은행();
			 }else if (ch==2) {//신한
				 신한은행();
			}else if (ch==3) {//국민
				국민은행();
			}else {
				System.out.println("없는은행정보 입니다.");
			}
			 
			 
		}

	}
	
	public void 국민은행() {
		System.out.println("1.계좌계설 2.예금");
		int ch=scanner.nextInt();
		if(ch==1) {
		
			String no = null;
			int random1=(int)((Math.random()*99)+1);
			int random2=(int)((Math.random()*99)+1);
			
			System.out.println("-----국민은행 계좌 계설-----");
		
			System.out.println("성함:"); String name=scanner.next();
			System.out.println("비밀번호:"); String pw=scanner.next();
			 no = "04";
			 
				String 랜덤1 = Integer.toString( random1);
				String 랜덤2 = Integer.toString( random2);
				String 문자영="0";
				
				 if(랜덤1.length()<2) {
					 System.out.println( "랜덤1111!!"+랜덤1);
					 랜덤1=문자영+랜덤1;
				 }
				 if(랜덤2.length()<2) {
					 System.out.println( "랜덤222!!"+랜덤2);
					 랜덤2=문자영+랜덤2;
				 }
			 
			 String number=no+"-"+랜덤1+"-"+랜덤2;
			System.out.println("계좌를 생성합니다");
			int money=0;
			
			
			Kb kb=new Kb(number, pw, name, money, no);
			kb.join();
		
		}else if (ch==2) {
			예금();
		}
	}
	
	public void 우리은행() {
		
		System.out.println("1.계좌계설 2.예금");
		int ch=scanner.nextInt();
		if(ch==1) {
			String no = null;
			int random1=(int)((Math.random()*99)+1);
			int random2=(int)((Math.random()*99)+1);
			
			System.out.println("-----우리은행 계좌 계설-----");
			
			System.out.println("성함:"); String name=scanner.next();
			System.out.println("비밀번호:"); String pw=scanner.next();
			no = "05";
			
			String 랜덤1 = Integer.toString( random1);
			String 랜덤2 = Integer.toString( random2);
			String 문자영="0";
			
			if(랜덤1.length()<2) {
				System.out.println( "랜덤1111!!"+랜덤1);
				랜덤1=문자영+랜덤1;
			}
			if(랜덤2.length()<2) {
				System.out.println( "랜덤222!!"+랜덤2);
				랜덤2=문자영+랜덤2;
			}
			
			String number=no+"-"+랜덤1+"-"+랜덤2;
			System.out.println("계좌를 생성합니다");
			int money=0;
			
			Won won =new Won(number, pw, name, money, no);
			won.join();
			
			}else if (ch==2) {
				예금();
			}
		
		}
	
	public void 신한은행() {
		System.out.println("1.계좌계설 2.예금");
		int ch=scanner.nextInt();
		if(ch==1) {
			String no = null;
			int random1=(int)((Math.random()*99)+1);
			int random2=(int)((Math.random()*99)+1);
			
			System.out.println("-----우리은행 계좌 계설-----");
			
			System.out.println("성함:"); String name=scanner.next();
			System.out.println("비밀번호:"); String pw=scanner.next();
			no = "04";
			
			String 랜덤1 = Integer.toString( random1);
			String 랜덤2 = Integer.toString( random2);
			String 문자영="0";
			
			if(랜덤1.length()<2) {
				System.out.println( "랜덤1111!!"+랜덤1);
				랜덤1=문자영+랜덤1;
			}
			if(랜덤2.length()<2) {
				System.out.println( "랜덤222!!"+랜덤2);
				랜덤2=문자영+랜덤2;
			}
			
			String number=no+"-"+랜덤1+"-"+랜덤2;
			System.out.println("계좌를 생성합니다");
			int money=0;
			
			Sinhan sinhan=new Sinhan(number, pw, name, money, no);
			sinhan.join();
			
		}else if (ch==2) {
			예금();
		}
	}
	public void 출력() {
		System.out.println("번호\t계좌번호\t\t예금주\t예금액");
		for(int i=0;i<BankDb.size();i++) {
			System.out.println(i+"\t"+BankDb.get(i).number+"\t"+BankDb.get(i).name+"\t"+BankDb.get(i).money);
		}
		
	}
	
	
	
	
	public void 예금() {
		
		if(BankDb.size()<1) {
			System.err.println("계좌생성을 먼저 해주세요");
		}else {
			System.out.println("예금하실 계좌를 선택해주세요");
			int ch2=scanner.nextInt();
			System.out.println("예금액 : ");
			int money=scanner.nextInt();
			
			BankDb.get(ch2).money+=money;
			
			System.out.println("예금완료");
			
			
			
			
			
			
		}
		
		
	}
	
	
	//선택한 은행 보여주기, 예금시 유효성 걸기(비밀번호작성,은행명같아야하는거 등등)
	
	
	
	
	
	
	
}




















