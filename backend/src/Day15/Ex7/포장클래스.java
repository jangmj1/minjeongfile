package Day15.Ex7;

import java.util.ArrayList;

public class 포장클래스 {

	public static void main(String[] args) {
		
		//ArrayList<int> list = new ArrayList<>(); int 못넣는다
		ArrayList<Integer> list=new ArrayList<>();
		
		//int a=10; System.out.println(a.  ); 점 이하가 불가능
		Integer b=10; System.out.println(b.toString()); //점 이하가 가능
		
		
		
		Integer obj=100; //기본자료형을 객체화 시킴=>박싱
		System.out.println(obj.intValue()); 
		
		
		int value=obj;
		System.out.println(value);//객체를 기본자료형에 대입=>언박싱
		
		//연산시 박싱된 객체는 언박싱으로 변환후 연산처리
		int result=obj+10; System.out.println(result);
		
	}

}
