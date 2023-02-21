package Day15.Ex1;

public class 실행 {
	public static void main(String[] args) {
		
		Member obj1=new Member("blue");
			System.out.println(obj1);
		Member obj2=new Member("blue");
			System.out.println(obj2);
		Member obj3=new Member("red");
			System.out.println(obj3);
		
		System.out.println(obj1.equals(obj2));//new 연사자쓸때마다 주소값이다르기때문에 false
		System.out.println(obj1.equals(obj3));
		
	}
}
