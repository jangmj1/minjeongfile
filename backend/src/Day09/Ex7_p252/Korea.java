package Day09.Ex7_p252;



/*
 * 		final 필드 : 최종적 뜻
 * 			-수정 불가 만들기
 * 			-무조건 초기화가 있어야한다
 * 			-필드에 직접입력 초기화, 생성자 이용한 초기화
 * 
 * 		static final 필드 : 상수 (고정된수)
 * 			-수정도 불가능,공유 메모리 쓴다 
 * 			-상수이름 : 관례적으로 대문자 사용
 * 			
 */

public class Korea {
	//1.final : 수정불가[공유 메모리 x]
	final String nation="대한민국";
	final String ssn;//final 은 무조건 초기화가 존재 해야한다.
	
	String name;
	
	
	public Korea(String ssn,String name) {
		this.name=name;
		this.ssn=ssn;
	}
	
	
	//2.static : 수정불가[공유 메모리 o]->여러곳에서 하나의 메모리를 같이쓰겠다
	static final double EARTH_RADIUS=6400;
	static final double EARTH_SUPFACE_AREA;//초기값이 없어서 처음에 빨간줄
	
	static {
		EARTH_SUPFACE_AREA=4*Math.PI*EARTH_RADIUS*EARTH_RADIUS;
	}
	
	
	

}
