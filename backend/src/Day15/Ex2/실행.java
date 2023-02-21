package Day15.Ex2;

public class 실행 {

	public static void main(String[] args) {
		System.out.println("홍길동".hashCode());
		System.out.println("홍길동".hashCode());
		System.out.println("홍길동".hashCode()=="홍길동".hashCode());
		//문자열일땐 동일true 객체(new)일떈 false
		
		Student s1=new Student(1,"홍길동");
			System.out.println(s1);
		Student s2=new Student(1, "홍길동");
			System.out.println(s2);
			//new 연산자쓰면 필드가 같더라도 주소값이 달라진다
		System.out.println(s1.hashCode());	
		System.out.println(s2.hashCode());	
		System.out.println(s1.hashCode()==s2.hashCode());
		System.out.println(s1.equals(s2));
		//문자열일땐 동일 객체(new)일떈 false
	}

}
