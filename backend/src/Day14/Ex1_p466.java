package Day14;

public class Ex1_p466 {
	
	
	//2.함수선언
	//접근제한자 키워드 반환타입 함수명(타입 매개변수1,타입 매개변수2....){ return 데이터}
		//접근제한자 : public , private , default[생ㄹ약] , protected
		//키워드[생략] : static[정적] , final [ 오버리이딩금지 ]
		//반환타입 : return을 하고자 하는 데이터의 타입
		//함수명 : 카멜표기법
		//매개변수 : 타입에 맞춰서 선언
		//static 쓴이유 : 스테틱은(정적) 스테틱(정적) 끼리만 사용가능 인스턴스를 못씀
		//스테틱이있거나, 객체가 있거나, 싱글톤이있거나 해야 불러올수잇다
	public static void printLength(String data) {
		try {//예외가 발생 할것 같은 코드를 try {} 안에 넣기 ->경험뿐
			int result=data.length();
			System.out.println("문자열수:"+result);
		}
		catch (NullPointerException e) {
			//만약에 try 중갈호 안에서 오류가 발생됐다면 캐치해라 예외발생안하면 실행을 안한다
			//e는 아무거나 가능 예외 객체명 e에는 예외 정보가 담겨져 있다
			System.out.println(e.getMessage());
		}
		
		finally {
			//예외가 있던 말던 실행 되는 코드임
			System.out.println("마무리실행");
		}
		
	}
	//1.main 함수 선언 : main 스레드가 포함된 함수 -> 스레드 : 코드를 읽어주는 흐름단위
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		printLength("ThisIsJava");
		printLength(null);//실행예외가 발생 할것 같은 코드 ,일반 예외는 빨간줄이 생기지만 실행하고나서 생기는 오류
			//NullPointerException 오류 발생 : 데이터가 null이라서 length 를 못쓴다는 뜻
		System.out.println("프로그램종료");
		
	}
	
	

}
/*
 *	에러 :컴퓨터 하드웨어의 고장으로 인해 응용 프로그램 실행 오류(외부)
 *	예외 :에러 이외 예외라는 오류
 *		*잘못된 사용[사용자] 또는 코딩[개발자]으로 인한발생
 *		*잘못된 사용 : 코딩은 문제가 없는데 사용자가 븅신같이쓰면 오류남-파악못함 경험뿐
 *	 	1.일반예외: f11 실행하기전에(컴퍼일전) 빨간 밑줄 쳐지는거[*스트림]
 *		2.실행예외: f11 실행 후에 생기는 오류
 *
 *	예외클래스
 *		Exception 클래스 : 모든예외를 받을수 있는 예외중에 최상위 클래스 *사용자가 어떤 오류를 낼지 모르기때문에 if를 쓰는건 한계가 있땅
 *
 *	문법
 *		try{ }	1.예외가 발생 할것 같은 코드[경험]
 *
 *		catch(  예외  e ){ }	2.try{ } 에서 예외가 발생했을때 실행되는 코드 [ 만일 예외발생했을때 이후 실행코드]
 *
 *		finally{ }	3. 예외 있던말던 실행되는 코드[*생략가능]
 * 
 */
