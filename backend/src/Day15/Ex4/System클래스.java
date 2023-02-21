package Day15.Ex4;

public class System클래스 {

	public static void main(String[] args) {
		
		System.out.println("출력");
		System.err.println("에러");
		
		int value=100;	//이상없다.
		//int value2="100"; //문자 ->문제있음
		int value3=Integer.parseInt("100");
		
		try {//에러가 발생 할것 같은애
			int value4=Integer.parseInt("1oo"); //이딴건 안된다 
			
		} catch (Exception e) { //try 에서 에러가(예외) 발생 했을때 캣츠가 실행됨
			System.err.println("에러내용");
			System.err.println(e.getMessage());
		
			
		}
		
		
		//2.514p
		
		int speed=0;
		int keycode=0;
		
		while (true) {
			if(keycode !=13 && keycode !=10) {//13,10 =>enter
				if(keycode==49) {//49는 숫자 1
					speed++;
				}else if (keycode==50) {//50는 숫자 2
					speed--;
					
				}else if (keycode==51) {//51는 숫자 3
					//break; => 와일문 탈출후 와일문 바깥에 있는애들 정상 실행
					System.exit(0); //0:정상종료 1or-1은 : 비정상종료
					
				}
				
				System.out.println("현재속도:"+speed);
				System.out.println("1.증속 2.감속 3.중지:");
				
			}
			
				try {
					keycode=System.in.read();	//입력받기->엔터단위로 읽어옴[*예외처리필수]
					
				} catch (Exception e) {
					
				}
		}
		
		
		
	}

}
