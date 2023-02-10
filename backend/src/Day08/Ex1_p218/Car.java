package Day08.Ex1_p218;

//클래스 선언
	//1. 첫글자 대문자인 영문
	//2. 띄어쓰기 x 숫자로 시작 x
	//3. 멤버 : 1.필드 2.생성자 3. 메소드
public class Car {//메인이 없는애들 설계도 c s
	
	//1.필드
	String model;
	String color;
	int maxSpeed;
	@Override
	public String toString() {
		return "Car [model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed + "]";
	}

	//2.생성자
		//1.생성자가 1개도 선언이 없을때 기본생성자
		//2.생성자 이름은 클래스 명과 동일!! 다를시 함수취급[메소드] 당한다
		//3.기본생성자[깡통] , 모든생성자(풀생성자)->관례적으로 만들고 시작 쓰던안쓰던 기본 베이스를 만들고간다
		//4.오버로딩: 이름이 동일할경우 시그니처(매개변수 갯수와 타입이 다르면 ) 구분을 해서 식별이 가능
		//	vs 오버라이딩 : 부모의 메소드를 재정의(리모델링)
	Car(){//1.기본생성자[깡통]=>객체 생성시 매개변수가 없다 즉->초기값이 없다
		
	}
	
	Car(String model,String color){
		//2 생성자=2개의 매개변수를 받는다. 이름이 같아도 오버로딩덕분에 식별가능해서 쓸수있다
		this.model=model; //this를 빼버리면 필드의 모델인지 생성자모델인지 모른다 이름 바꾸면 되긴하지만 관례적으로 잘안함 
			//this.내부필드명=매개변수
		this.color=color;
	}
	
	//2.생성자=3개의 매개변수를 받는다.
	Car(String model,String color,int maxSpeed){//생성자를 만들면 기본생성자는 사라진다
		this.model=model;
		this.color=color;
		this.maxSpeed=maxSpeed;
	}
	//3.메소드
	
	
}//c e
