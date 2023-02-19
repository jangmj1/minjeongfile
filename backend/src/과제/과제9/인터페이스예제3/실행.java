package 과제.과제9.인터페이스예제3;

import java.util.Scanner;

public class 실행 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("당신의 부서는?1.관리부 2.설계부 3.영업부");
		int ch=scanner.nextInt();
		if(ch==1) {
			
			출결 관리부출결=new 관리부();
			관리부출결.출근();
			관리부출결.퇴근();
			
		}else if (ch==2) {
			
			출결 설계부출결=new 설계부();
			설계부출결.출근();
			설계부출결.퇴근();
		}else if (ch==3) {
			
			출결 영업부출결=new 영업부();
			영업부출결.출근();
			영업부출결.퇴근();
		}
		
	
	}

}
