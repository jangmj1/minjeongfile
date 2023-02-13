package Day09.Ex3;

public class 실행 {
	public static void main(String[] args) {
		
			//1.객체의 필드를 초기화 하는방법
				//1.직접접근
		Car car=new Car();
		car.gas=5;
				//2.생성자[간접] : 객체의 필수 데이터
		Car yourCar=new Car(5);  
		
				//3.메소드[간접] : 객체생성후 데이터
		Car mycar=new Car();	//객체생성
		mycar.setGas(5);		//객체내 함수 호출 1.
		
		if(mycar.isLetfgas()) {//2.
			System.out.println("출발합니다");//3.
			mycar.run();//4.
		}
		
		System.out.println("가스를 주입하세요");//5.
	}
}
