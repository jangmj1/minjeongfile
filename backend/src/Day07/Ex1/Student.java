package Day07.Ex1;// 현재 클래스가 위치한 패키지명

public class Student {// 클래스 시작

		//필드[저장소],생성자[객체초기화],메소드[동작] 구성
		//-생성자 생략시 기본생성 자동 생성
	
}//클래스 끝

/*
	객체(object):식별 가능한 상태[상태=필드, 행동=메소드/함수]
	객체지향프로그래밍[oop]:부품[객체] 먼저 만들고, 부품[객체]들을 조립해서 하나의 제픔[프로그램]만듬
	
	클래스 : 설게또(객체의 설계도)
	인스턴스화(new)
	
	인스턴스 : 
	객체 : 
	
	jvm관점
		(스택영역)		=		(힙영역)
		클래스명 변수명			new 생성자();	
		String str	=		new String("유재석")
		[ 변수 ]					[인스턴스화]
		[객							체	]
				<---new가 주소값넘겨 스택이 힙을 찾아감-
				
		스택에서 사용된애는 변수 , 힙영역은 인스턴스 , 인스턴스화!시키는건 new 이걸 다 묶어서 객체
		인스턴스화 되지않아도 그자체로 객체		
 */
