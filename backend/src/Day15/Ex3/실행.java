package Day15.Ex3;

public class 실행 {

	public static void main(String[] args) {
		
		
		SmartPhone myPhone=new SmartPhone("삼성전자", "안드로이드");
		System.out.println(myPhone.toString());
		System.out.println(myPhone); //toString 안보일뿐 원래 같이 들어간다
	}

}
