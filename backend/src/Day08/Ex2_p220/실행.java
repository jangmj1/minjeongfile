package Day08.Ex2_p220;

public class 실행 {
	public static void main(String[] args) {
		//1.객체생성[빈상자]
		Korea k1=new Korea();
			//1. 객체정보확인[객체명.toString()] 출력
		System.out.println(k1);
			//2. 객체 필드 호출[객체명.필드명]
		System.out.println(k1.nation);
		System.out.println(k1.name);
		System.out.println(k1.ssn);
		
		//2. 객체생성
		Korea k2=new Korea("박자바", "011225-1111222");
		System.out.println(k2);
			
		System.out.println(k2.nation);
		System.out.println(k2.name);
		System.out.println(k2.ssn);
		
		
	}

}
