package Day09.Ex9;




/*
 * 	싱글콘 : 프로그램내 하나의객체를 가지는 패턴
 * 		-1.클래스 내부에 객체 만들기
 * 		-2.생성자 private
 * 		-3.내부 객체 반환 해주는 함수 :  getInstance()
 * 		-*함수 호출시 객체가 필요한데 외부에서 객체 금지 -> satic
 */
public class Member {
	//1. 자신의 타입으로 객체 생성한다.
	private	static Member mem=new Member();
	
	//2. private
	//3.생성자도 private 
	private Member() {}
	
	//4.
	public static Member getInstance() {
		return mem;
	}
	
	//5.static
	
	
}
