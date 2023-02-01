package Day01; //패키지

public class Ex2_변수 {//클래스 시작

	public static void main(String[] args) {//메인의 s
/*		
		int value; //변수 선언:자료형[타입] 변수명
		System.out.println(value); //이대로하면 오류발생
		
		int result=value+10;
		System.out.println(result);
		*/
		int hour =3; // 변수선언
		int minute=5; // 변수선언 : int 형 자료형 변수에 'minute'이름으로 5저장
		System.out.println(hour+"시간"+minute+"분");
		int totalMinute=(hour*60)+minute;
		System.out.println("총"+totalMinute+"분");
		
		int x=3;
		int y=5;
		System.out.println("x:"+x+"y:"+y);
		int temp=x;
		x=y;
		y=temp;
		System.out.println("x:"+x+"y:"+y);
		
		
	}//메인의 e
	
	
	
	
}//클래스 끝


/*
 * 변수 : 데이터 1개를 저장할수 있는 메모리공간
 * 
 * 	1. 자료형 타입
 * 	2. 변수명
 * 	3. 초기값
 * -변수선언
 * 자료형 변수명=초기값 값이 존재 하기 떄문에 사용 가능
 * 자료형 변수명=깡통 사용불가
 * java
 * int 변수명=10;
 * char 변수명='a'
 *  vs	
 * js: 자료형/타입 자동관리
 *  let 변수명=10;
 * 	let 변수명=a;
 */



