package Day09.Ex7_p252;

public class 실행 {
	public static void main(String[] args) {
		//1.객체 생성
		Korea k1=new Korea("123456-1234567", "김자바");
		
		//2.객체 맴버 호출
		System.out.println(k1.nation);
		System.out.println(k1.ssn);
		System.out.println(k1.name);
		//3. 객체 맴버 변경
		//k1.nation="미국";//final 이라 변경이 불가능
		//k1.ssn="880420-1234568"//final 변경불가
		k1.name="장민정"; //final 아니기 때문에 가능!!
		
		//4.상수호출
		System.out.println(Korea.EARTH_RADIUS);
		System.out.println(Korea.EARTH_SUPFACE_AREA);
		
		
	}

}
