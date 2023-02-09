package Day07.Ex1;

public class 실행 {
	public static void main(String[] args) {
		//1.클래스 이용한 객체 만들기
		Student s1= new Student();
		//클래스 변수명
			//new(인스턴스호: 힙영역에 메모리 생성후 주소 변환)
			//Student():객체 생성시 사용되는 메소드
			
		System.out.println( s1);
		Student s2= new Student();
		System.out.println( s2); 
		// 설계는 하난데 값은 다르게 나온다 
		
		/*객체를 어떻게 생성[생성자] 하고 
			 객체가 가져야 할 데이터[필드] 무엇이고
			 객체의 동작[메소드]는 무엇인지 정의	
			 	
			*/
		
	}
}
