package Day06;

public class Ex1_참조타입 {// class s
	public static void main(String[] args) {//m s
		
		int[] arr1;//int 형 배열선언 [스택영역에 변수 만들기]
		int[] arr2;//int 형 배열선언 [스택영역에 변수 만들기]
		int[] arr3;//int 형 배열선언 [스택영역에 변수 만들기]

		arr1=new int[] {1,2,3}; //new 쓰면 힙! [힙영역에 1,2,3 메모리3개]
		arr2=new int[] {1,2,3}; //new 쓰면 힙! [배열은 첫번째 메모리('1')주소를 스택영역에 대입]
		arr3=arr2;				//arr2가 가지고 있떤 메모리주소를 arr3 대입
		System.out.println(arr1==arr2);// ==스택영역의 데이터 비교 같은값을 넣엇지만 주소가 다르다 펄스
		System.out.println(arr2==arr3);// 주소가 동일하다 
		
		/*
		 * int[] inArray=null; //int형 배열 선언 [스택영업 변수 만들기]
		 * System.out.println(inArray[0]); //java.lang.NullPointerException: 오류
		 * inArray[0]=10; //오류발생:힙영역이 없기때문에 저장 불가능
		 * 
		 * String str=null; System.out.println(str.length());// 오류 발생:힙영역이 없기 때문에 길이 불가능
		 */
		//3.p153
		
		/*
		 * String hobby="여행"; String hobby=null; //hobby 변수의 null 변경하하면 합의 있떤 여행 메모리 제거
		 */		
		String kind1="자동차"; //자동차 힙의 메모리 32번지를 스택영역에 kind1저장
		String kind2=kind1;	//kind1가지고 있떤 32 번지 kind2에게 대입
		kind1=null;	//kind1지우기
		System.out.println(kind2);
		
		
/*		
		
			스택영역					힙영역
			arr1	<==주소대입== new int[] {1,2,3}
			arr2	<==주소대입== new int[] {1,2,3}
			arr3	 
		
		*new : 힙영역에 메모리를 생성하는 연산자
		
		
	*/	
	}//m e
}//class e
