package Day08.Ex1_p218;

public class 실행 {//c s
	public static void main(String[] args) {// m s 메인이 잇는애=실행파일
		
		//1.Car 클래스를 이용한 객체 생성
		// 클래스명 변수명=new 생성자명();
		
		//1.기본생성자 깡통을 만들고 추후에 다이렉트로 필드에 접근
		Car car = new Car();
		 car.model="그랜저";
		 car.color="노랑";
		 car.maxSpeed=200;
		 System.out.println(car.toString()); 
		
		//2. 3개의 매개변수 생성자 
		 //* 생성자로 이동하여 값을 전달하고 생성자에서 필드로 이동
		Car car2 = new Car("그랜저", "검정", 250);
		System.out.println(car2.toString());
		
		//3. 2개의 매개변수 성성자
		Car car3 =new Car("그랜저", "검정");
		System.out.println(car3.toString());
		
		
		
		
		
	}// m e

}// c e
