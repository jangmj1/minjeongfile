package Day14;

public class Ex3_p477 {
	
	public static void findClass() throws Exception {
		//1. 일부러 일반예외
		Class.forName("java.lang.String2"); //여기서 트라이 캐치 할수는 있지만..모두 할수없으니  throws Exception 를 사용하여 던진다
	}
	
	
	public static void main(String[] args) throws Exception {
		try {
			
			findClass();
		} catch (Exception e) {
			System.out.println("확인");
		}
		// throws Exception  사용하여 던짐받기떄문에 여기에 밑줄이 생긴다 
		//throws Exception 메인도 이걸 써서 던진다 어디로? 자바 클레스가 받아준다
		
		
	}
	

}//class e

/*
 * 예외 떠넘기기
 * 	-메소드 내부에서 예외 발생했을때 메소드 호출했던 곳으로 예외를 떠넘기기
 * 	-throws
 * 	-메소드 마다 예외 처리를 하면 코드가 많아짐-> 이동후 한곳에서 처리
 */
