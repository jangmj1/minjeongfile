package Day09.Ex5;

public class Car {
	
	//인스턴스 멤버
	
	//1.필드
	String model;
	int speed;
	
	//2.생성자
	Car(String model){//model:매개변수
		this.model=model;//맴버필드
		//맴버필드=매개변수 
		}
	//3.메소드
		void setSpeed(int speed) {
			this.speed=speed;
		}
		
		
		void run() {
			this.setSpeed(100);
			System.out.println(this.model+"가 달립니다.(시속:"+this.speed+"km/h)");
		}
		
		
		
		
		
		
	}

