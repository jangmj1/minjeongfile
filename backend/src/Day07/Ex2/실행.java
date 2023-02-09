//클래스는 두가지의 사용목적 : 2.실행
package Day07.Ex2;

public class 실행 {
	
	public static void main(String[] args) {
		//*설계도는 동일 하지만 1번 3번 과 같이 서로다른 메모리를 만들수있다!!
		
		//1. 클래스를 이용한 객체 생성
		Car mycar=new Car();	// 32번지 메모리
		//클래스명 변수명=new 생성자명();
		
		//2.객체의 필드 호출
		System.out.println("모델명:"+mycar.model);
		System.out.println("시동여부:"+mycar.start);
		System.out.println("현재속도:"+mycar.speed);
		
		
		//3.두번째 차
		Car mycar2=new Car();	// 33번지 메모리
		mycar2.model="현대자동차";
		
		System.out.println("mycar1:"+mycar.model);
		System.out.println("mycar2:"+mycar2.model);
		
	}

}
