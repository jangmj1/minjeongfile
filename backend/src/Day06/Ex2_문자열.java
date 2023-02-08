package Day06;

public class Ex2_문자열 {
	public static void main(String[] args) {
		
		//1. 자바 문자열을 사용하는 방법
			//1.배열
		/*char[]문자열1= new char{'안','녕'}; //char는 한개밖에 못담음
			//2.클래스[객체]
		String 문자열2=new String("안녕");
			//3.문자리터럴""
		String 문자열3="안녕";*/
		
		//2.156
		String strVar1="홍길동"; //10번지
		String strVar2="홍길동";	//10번지
		if(strVar1==strVar2) {
			System.out.println("참조[주소]같음");
			
		}else {
			System.out.println("참조[주소]다름");
		}if(strVar1.equals(strVar2)) {//20번지
			System.out.println("내부도 같음");
		}
		String strVar3="홍길동";//20번지
		String strVar4="홍길동";//30qjswl
		if(strVar3==strVar4) {
			System.out.println("참조[주소]같음");
			
		}else {
			System.out.println("참조[주소]다름");
		}if(strVar3.equals(strVar4)) {//20번지
			System.out.println("내부도 같음");
		}
		
		
		//3.p157
		String hobby="";//""vs null
		if(hobby.equals("")) {System.out.println("\"\"의 객체");}
		 String hobby2=null; 
		/* if(hobby2.equals(null))
		  {System.out.println("null의 객체의 데이터");}
		 */
		
		if(hobby2==null) {System.out.println("null 주소확인");}
		
		//문자열 관련 api 함수
		//1. 158p
		String ssn="9506241230123";
		char sex=ssn.charAt(6); //6번째 인덱스의 값을 가져오겠다
		System.out.println(sex);
		if(sex=='1'||sex=='3') {System.out.println("남자");}//char 로 만들어서 '' 쓸것
		else {
			System.out.println("여자");
		}
		
		//2. 159p length()
		int length=ssn.length();
		if( length==13) {
			System.out.println("주민등록번호 자리수 맞음");
		}else {
			System.out.println("주민등록번호 자리수가 다름");
		}
		
		//3. 160p replace()//기존에 되어 
		String oldStr = "자바 문자열 불변입니다.자바 문자열은  String 입니다.";
		String newStr= oldStr.replace("자바","jave");//치환 했으면 다른 변수에 옮겨라
		System.out.println(oldStr);
		System.out.println(newStr);
		
		//4.161 substring(인덱스) vs split(기준문자)
		String ssn2="880815-1234567";
		System.out.println(ssn2.substring(7)); //인덱스 까지 삭제
		System.out.println(ssn2.substring(0,6));//0~6인덱스 전 까지 가지고오겠다	
		System.out.println(ssn2.split("-"));//"-"을 기준으로 뚝자르면 2조각 인덱스
		System.out.println(ssn2.split("-")[0]);//1번째 조각 확인
		System.out.println(ssn2.split("-")[1]);//2번째 조각 확인
		
		String borad="1,자바 학습,참조 타입 String을 학습합니다., 홍길동";// 하나의 문자열이지만 쉼표를 써서 나눔
		String[] tokens= borad.split(","); // ,기준으로 분리했을때 4조각 나옴 즉 인덱스 4개가 있다[0,1,2,3]
		System.out.println("번호:"+tokens[0]);
		System.out.println("제목:"+tokens[1]);
		System.out.println("내용:"+tokens[2]);
		System.out.println("성명:"+tokens[3]);
		
		
		//5.163p indexOf(찾을문자) vs contains(찾을문자)
		String subject="자바 프로그래밍";//띄어쓰기도 문자
		System.out.println(subject.indexOf("자바"));//찾으면 0
		System.out.println(subject.indexOf("파이썬"));//없으면-1
		
		System.out.println(subject.contains("자바"));//찾으면 true
		System.out.println(subject.contains("파이썬"));//찾으면 true
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
		









/*
 * 
 * 	자바 문자열을 사용하는 방법
 * 		1.배열,클래스,문자리터럴
 * 		2.클래스
 * 			-new 연산자[객체 메모리 생성]
 * 
 * 		2.문자 리터럴
 * 			-문자리터럴이 동일한 경우 객체 공유[주소같다]
 * 				String 문자열3="안녕"; 
 * 				String 문자열4="안녕"; 
 * 				문자열3==문자열4
 * 				-문자리터럴이 동일한 경우 객체 공유
 * 
 * 		자바 문자열의 함수들
 * 		1. .charAt(인덱스)					:인덱스 위치의 문자 1개 추출
 * 		2. .length()						:문자열의 길이
 * 		3. .replace("기존문자","새로운문자");	:기존문자를 새로운문자로 치환/교체
 * 		4. .subString(인덱스);				:0~인덱스자르기
 * 			.subString(s인덱스,e인덱스);		:s인덱스~e인덱스 번호 반환
 * 		5. .split("자를기준")					:기준문자 기준으로 자르기
 * 		6. .indexOf("찾을문자")				:찾을 문자의 찾은 인덱스 번호 반환
 * 		7. .contains("찾을문자")				:찾을 문자가 존개하면 true/false
 * 
 * 
 * */
 