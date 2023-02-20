package Day14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex2_p468 {

	public static void main(String[] args) {
		//1.외울필요는 없지만 첫글자는 C 대문자 Class.forName("패키지명.클래스")
		try { Class.forName("java.lang.String");//클래스 찾기 (일반예외에 속한다)
			System.out.println("클래스존재");
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//----------
		System.out.println();
		
		try {
			Class.forName("java.lang.String2");
			System.out.println("클래스 존재");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//배열 : 타입[] 배열명={데이터,데이터,데이터}
		String[] array= {"100","1oo"};
			//배열 for : 인덱스 0 , 길이 :1
	
			for(int i=0;i<=array.length;i++) {
				try {
					
					int value=Integer.parseInt(array[i]); // 문자를 숫자로 
					//예외발생 : "100"->100  가능  ,  "1oo"-> ?  불가능
					System.out.println("array["+i+"]:"+value);
				}
				
				catch (NumberFormatException e) {
					System.out.println("숫자로 반환 할수없음:"+e);
				 }
				catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("인덱스초과"+e);
				}
				catch(Exception e) {
					System.out.println("예오발생:"+e);
				}//예외 클래스 중에서 최상위 클래스는 가장 아래에 작성
				
		}
			
			
		//3.책에없음
			while (true) {
				
				try {
					Scanner scanner=new Scanner(System.in);
					int ch=scanner.nextInt();
					
				} catch (InputMismatchException e) {
					System.out.println("잘못된 입력입니다.");
				}
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
						
			
		
	}
}
