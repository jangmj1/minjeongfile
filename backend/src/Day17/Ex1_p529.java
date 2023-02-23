package Day17;

import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Ex1_p529 {
	public static void main(String[] args) {
		/*
		 * ceil : 올림[소수첫째자리]
		 * floor: 버림[소수첫째자리]
		 * round: 반올림[소수첫째자리] , String.format("%.소수자리수f", 실수값)
		 * max: (값1,값2) : 최대값
		 * min: (값1,값2) : 최소값
		 * 
		 * 
		 * 
		 */
		
		
		double v1=Math.ceil(5.3);	//static 이라 new가 필요없음 ceil 컨트롤 클릭해서 보면 들어가짐
		System.out.println("v1:"+v1);
		
		double v2=Math.floor(5.3);
		System.out.println("v2:"+v2);
		
		long v3=Math.max(3,7);
		System.out.println("v3:"+v3);
		
		long v4=Math.min(3,7);
		System.out.println("v4:"+v4);
		
		double v5=Math.round(5.357);
		System.out.println("v5:"+v5);
		
		double value=12.3456;
		double temp1=value*100;	//1234.56;
		long temp2=Math.round(temp1);	//1235;	=> 소수점 첫번째 밖에 안되기 때문에이짓을함..
		double v6=temp2/100.0;
		System.out.println("v6:"+v6);
		
		//한줄로 표현하면
		System.out.println("v6 한줄로:"+( (Math.round(12.3456*100)))/100.0   );
		
		System.out.println(String.format("%.2f", 3.14159));  //%d: 정수 , %s: 문자 , %f :실수
		
			//p531
				//클래스 : 서로다른 자료형/타입 한곳에 [객체] 저장
				//배열,리스트 : 동일한 자료형,타입의 데이터를 여러개 저장하기 위한 리스트,개열[객체]에 저장
		int[] selecNumber = new int[6];	//int 형 변수를 6개 저장할수 있는 배열[고정길이 , 메소드제공x]
				//vs
		
		//int 형 변수를 6개 저장할수 있는 리스트[가변길이,메소드제공 o ,기본길이=10 (기본길이 바꾸고싶으면 갈호안에 숫자넣어라 6 이렇게)]
		ArrayList<Integer> selecNumber2=new ArrayList<>(6); 
			//포장클래스 : 기본자료형=>클래스[*특정 api클래스중 기본 자료형 사용불가]
		
		
		Random random=new  Random(); //난수관련 메소드 제공하는 클래스
		System.out.println("선택번호");
		for(int i=0;i<6;i++) {
			selecNumber[i]=random.nextInt(45)+1;
			System.out.print(selecNumber[i]+" ");
		}
		//6개 랜덤
		int[] winningNumber = new int[6];
		random=new Random(5);
		System.out.println("당첨번호");
		//6개 당첨랜덤
		for(int i=0;i<6;i++) {
			winningNumber[i]=random.nextInt(45)+1;
			System.out.print(winningNumber[i]+" ");
		}
		
		
		//정렬
		Arrays.sort(selecNumber);
		System.out.println("\n"+Arrays.toString(selecNumber));
		
		Arrays.sort(winningNumber);
		System.out.println(Arrays.toString(winningNumber));
		boolean result=Arrays.equals(selecNumber, winningNumber);//1등찾기
		if(result) {System.out.println("1등");}
		else {
			System.out.println("1등아님");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
