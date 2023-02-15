package 과제.과제7;

import java.util.Scanner;

public class 실행 {
		
	public static void main(String[] args) {
		
		
		 Scanner scanner=new Scanner(System.in );
		 Bank bank=new Bank();
		 
		 while (true) {
			
			 System.out.println("1.우리 2.신한 3.국민");
			 
			 int ch=scanner.nextInt();
			 
			 
			 if(ch==1) {
				 bank.join();
				
			 }else if (ch==2) {
				
			}else if (ch==3) {
				
			}else {
				System.out.println("없는은행정보 입니다.");
			}
			 
			 
			
		}
		 
		
		
		
	}
		
		
		
		



}
