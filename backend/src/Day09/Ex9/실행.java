package Day09.Ex9;

public class 실행 {
	public static void main(String[] args) {
		
		//1. 생성자가 private 이라서 객체 생성 불가능
		
		//2. 객체 없이 메소드호출하려면 무조건 [static]이어야함
		
	Member m1=	 Member.getInstance(m1);
	Member m2=	 Member.getInstance(m2);
		System.out.println(m1);
		System.out.println(m2);
	}

}
