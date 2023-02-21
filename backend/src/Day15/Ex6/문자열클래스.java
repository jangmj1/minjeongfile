package Day15.Ex6;

import java.util.Arrays;
import java.util.StringTokenizer;

public class 문자열클래스 {
	
	public static void main(String[] args) {
		
		//String vs Stringbuilder
		
		String data="ABC";
			System.out.println(data.hashCode());
		data +="DEF"; //변경된것 처럼 보이지만 새로운 참조할당 [효율성 떨어짐]
			System.out.println(data.hashCode());	//서로다른 주소
		String data2=new StringBuilder()
				.append("def")	//문자열 끝에 추가
				.insert(0, "abc")	//해당 인덱스위치에 추가
				.delete(3, 4)		//해당 인덱스 삭제
				.toString();		//완성된 문자열을 리턴
		System.out.println(data2);
		
		StringBuilder data3=new StringBuilder();
			System.out.println(data3.hashCode());
		data3.append("abc");
			System.out.println(data3.hashCode());
		data3.append("def");
			System.out.println(data3.hashCode());
		System.out.println(data3);
		
		
		String data4="홍길동&장민정-박연수";
		String[]arr= data4.split("&|-");
		
		System.out.println(Arrays.toString(arr));
		
		String data5="홍길동/장민정/박연수";
		StringTokenizer st=new StringTokenizer(data5,"/");
		System.out.println(st.toString());//주소값이 나온다 st는 객체로나옴
		System.out.println(st.countTokens());//조각수
		for(int i=1;i<=st.countTokens() ;i++) {
			System.out.println(st.nextToken());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
				
		
		
	}
	
}
