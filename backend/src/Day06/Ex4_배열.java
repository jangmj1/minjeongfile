package Day06;

import java.util.Iterator;

public class Ex4_배열 { //c s

	public static void main(String[] args) { //m s
			//String 변수 여러개를 저장할수있는 String 배열 선언
			//String 4개 데이터를 하나의 배열에 저장
		//1.
		String[] season= {"spring","summer","fall","winter"};
		
		//2.호출
		System.out.println("배열호출:"+season);//오류남
		System.out.println("배열 첫번째:"+season[0]);
		System.out.println("배열 두첫번째:"+season[1]);
		System.out.println("배열 세번째:"+season[2]);
		System.out.println("배열 네번째:"+season[3]);
		
		//3.인덱스내 데이터 변경
		season[1]="여름";
		System.out.println("배열 두첫번째:"+season[1]);
		
		
		//4.반복문
		for(int i=0;i<season.length;i++) {
			System.out.println(i+":"+season[i]);
		}
		
			//1.선언
		int[] scores= {83,90,87};
		int sum=0;
		
		for(int i=0; i<scores.length; i++){
			sum+=scores[i];
			
		}
		System.out.println("총합:"+sum);
		System.out.println("총합:"+sum/scores.length);
		
			//2. 173p
			//1.int 형 변수 3개를 저장할수 있는 배열 선언
			//고정길이 
		int[] arr1=new int[3];
			//2.확인
		for( int i=0; i<arr1.length;i++) {
			System.out.println(arr1[0]);
		}
			//3.해당 인덱스에 데이터 넣기
		arr1[0]=10; arr1[1]=20; arr1[2]=30;
			//4.확인
		for(int i=0;i<arr1.length;i++) {
			System.out.println(arr1[i]);
		}
		
		
		double[] arr2=new double[3];
		for(double value : arr2) {
			System.out.println(value);
		}
		
		arr2[0]=0.1; arr2[1]=0.2; arr2[2]=0.3;
		for(double value : arr2) {
			System.out.println(value);
		}
		
		String[] arr3=new String[3];
		for(String value:arr3) {System.out.println(value);}
		
		arr3[0]="1월" ; arr3[1]="2월"; arr3[2]="3월";
		for(String value:arr3) {System.out.println(value);}
		
		
		
		
		
		
		
		
		
		
		/* p165
		 	변수 : 데이터 1개 스택영역
		 	배열: 데이터 여려개 힙 영역
		 	
		 	[js ]			vs			[java]
		 	다른타입가능				같은타입만가능
		 	가변길이					고정길이
		 	
		 	-선언차이
		 	let 배열명=[]				int[]배열명={} 
		 	
		 	-배열과 반복문 활용
		 		[js]
		 		for(let 변수 in 배열명){}
		 		for(let 변수 of 배열명){}
		 		배열명.forEach ( (v)=>{})
		 		배열명.map ((v)=>{return  반환값;})
		 		
		 		[java]
		 		for(자료형 변수 : 배열명) {}
		 		
		 	
		 	-1.선언
		 		1.자료형타입[ ] 배열명={허용범위1,허용범위2...}
		 		2.자료형타입[ ] 배열명=new 자료형타입[길이];
		 			
		 			초기값
		 				-int[] scores = new int [3]
		 				자료형 : int int int 
		 				데이터 : 0	0	0
		 				인덱스 : 0	1	2
		 				
		 				-string[] names=new String[3];
		 				자료형 : String	String	String
		 				데이터 : null		null	null
		 				인덱스 : 0		1		2
		 	
		 	
		 	-2.호출, 인덱스
		 		배열명		: 첫번째 값의 주소
		 		배열명[인덱스]	:	해당 인덱스의 위치한 데이터
		 		
		 	-3. 데이터 변경
		 		배열명[인덱스]=새로운데이터
		 	
		 	-4. 배열의 길이
		 		배열명.length		: 4
		 		인덱스길이			:0~3
		 	
		 		
		 
		 */
		
		
		
		
		
		
		
	}//m e

} //c e
