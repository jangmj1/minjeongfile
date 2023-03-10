package Day15.Ex9_MVC;

public class Start {
public static void main(String[] args) {
	
	View.getInstance().index();
	
	}
}
/*	내부에서 메소드를 호출하는 방법
 * 		단순히 메소드명();
 *	외부에서 메소드[맴버] 호출하는 방법
 *		1.객체를 만들기 :인스턴스 메소드인경우
 *				*인스턴스=실물
 *			클래스명 객체명 =new 생성자();[new 쓰는순간->힙에 데이터가 들어간다]
 *			객체명.메소드();
 *	
 *		2.정적 메소드
 *			클래스명.메소드명();
 *
 *		3.싱글톤내 메소드 호출(내부에 만들어논 new를 외부에서 불러쓸때)
 *			클래스명.get싱글톤.메소드 [new 쓰는순간->힙에 데이터가 들어간다]
 *
 *
 *		4.
 *			new View().index(); <=이렇게 쓸수있음 단점은 이름이 없기떄문에 (스택영역) 다시못쓴다 오로지 힙만있음
 *	
 *
 *			JVM
 *				[현재사용중인 영역 : 컴파일한 파일과(클래스) + import(클래스)]
 *		메소드영역 :									[스택의 기능은 힙에 영역이 들어있는데 이름이없다 그때 스택으로 이름을 만들어줌 스택은 주소값을 가지고있다]
 *		클래스 맴버 정보가 들어간다 먼저 싹 다 읽어옴			스택영역		힙 영역(new 쓰면 다 힙으로들어감)										
 *  												클래스명 객체명 = new 생성자()
 *		static													new 생성자.메소드();
 *		클래스명.메소드명()
 *
 *			-정적필드
 *		static 타입 필드명
 *		static View view							= new View();
 *		
 *		메소드의 기능은 단순히 함수..가아니라 서로다른 클래스를 연결 인수 리턴을 통해
 *		
 *
 *
 *
 *
 *
 */
