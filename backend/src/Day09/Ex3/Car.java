package Day09.Ex3;

public class Car {

	
	//1.필드
	int gas;
	//2.생성자
	Car(){}
	Car(int gas){this.gas=gas;}
	//3.메소드
	
	void setGas(int gas) {
		this.gas=gas;
	}
	//2.리턴타입o[boolean] 인수 x
	boolean isLetfgas() {
		if(gas==0) {
			System.out.println("gas가 없습니다.");
			return false;
		}
		System.out.println("gas가 있습니다.");
		return true;
		
	}	
		//3.리턴타입 x 인수 x
	void run() {
		while (true) {	//무한루프[종료조건:gas0이면 return]
			if(gas>0) {//만약에 gas 가 0보다 크면 달린다
				System.out.println("달립니다.(gas잔량:"+gas+")");
				gas--;// gas 줄이기
			}else {
				System.out.println("멈춤니다.(gas잔량:"+gas+")");
				return;//함수종료 [while 종료]
			}
			
		}
	}
}
