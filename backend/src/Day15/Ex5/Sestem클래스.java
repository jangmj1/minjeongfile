package Day15.Ex5;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Properties;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class Sestem클래스 {
	public static void main(String[] args) throws Exception {
		
		//p.517
		long time1=	System.nanoTime();
		System.out.println(time1);
		int sum=0;
		for(int i=1;i<=1000000000;i++) {//백만반복
			sum+=i; // i를 sum에 누적 합계 더하기
			
		}
		long time2= System.nanoTime();
		System.out.println( (time2-time1)+"나노초가 소요 되었습니다.");
		
		
		
		//p.518
		System.out.println("-------------------------------------");
		System.out.println("key :    value");
		Properties props=System.getProperties();
			//System.getProperties() 모든 시스템 속성 호출
		
		for(Object obj : props.keySet() ) { //시스템 속성들의 키를 반복문 돌리기
			System.out.println( (String)obj + "       ->       " +	//해당 키를 문자열로 변환
								System.getProperty((String)obj));	//해당 키를 이용한 시스템 속성 정보를 호출
		}
		
		//p.520
		String data="자바";//문자열을 저장하고 조작하는 클래스
		//문자열 -> 바이트열로 변환 getBytes();
		byte[] arr1=data.getBytes();//해당 문자열을 바이트열로 변환 getBytes();
		
		System.out.println(arr1);//주소값이 출력
		System.out.println(Arrays.toString(arr1));//배열내 데이터 출력 Arrays.toString(배열명)
		
		//문자열 -> 바이트열로 변환 getBytes();
		byte[]arr2=data.getBytes("EUC-KR");//인코딩 타입 : "EUC-KR"
		System.out.println(Arrays.toString(arr2));
		
		
		
		
		//배열명->문자열 new String(배열명);
		String str1=new String(arr1);
		System.out.println(str1);
		
		String str2=new String(arr2,"EUC-KR");
		System.out.println(str2);
		
		
		
		
		
		
		
		
		
		
	}
}
