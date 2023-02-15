package Day11.Ex7_타입변환;

import java.util.ArrayList;

import Day11.Ex6.HankookTire;
import Day11.Ex6.KumhoTire;
import Day11.Ex6.Tire;

public class 실행2 {

	public static void main(String[] args) {
		
		Tire tire=new Tire();
		KumhoTire kumhoTire=new KumhoTire();
		HankookTire hankookTire=new HankookTire();
		
		//1.참조타입의 자동타입 변환
		Tire temp=tire;
			Tire temp2=kumhoTire;
				Tire temp3=hankookTire;
					Object temp4=temp3;
					
		//2.강제 타입 변환=>강제
		Tire tire2=(Tire)temp4;			
			KumhoTire kumhoTire2=(KumhoTire)tire;
				HankookTire hankookTire2=(HankookTire)tire;
				
		//3.매개변수,리턴타입
		Tire result=함수1(kumhoTire2);//1.
			//매개변수 :kumhoTire2<tire -->함수1은 매개변수 자료형이  Tire 라는 큰 상자-->Tire보다 더 작은kumhoTire2 을 받아서 가능
			//result의 자료형이 Tire 으로 큰 상자-->KumhoTire라는 자료형을 가지고  Tire 라는 큰상자에 담겨져서 자동으로 변환 가능
		
		KumhoTire result2=(KumhoTire)함수2((KumhoTire)temp2); //2.
			//매개변수 :kumhoTire<temp2의 자료형은 tire -->함수2는 매개변수 자료형이  KumhoTire 라는 작은 상자-->KumhoTire보다 더큰 tire 를 받을수 없어서 temp2의 자료형을 캐스팅해준다(KumhoTire)로
			//result2의 자료형이 KumhoTire 으로 작은 상자-->함수 2는 Tire로 배출함 KumhoTire에 Tire 를 담을수없음-->그래서 캐스팅을 통해 (KumhoTire)로 자료형을 변환
		
		
		
		ArrayList<KumhoTire> kumhoList=new ArrayList<>();
		kumhoList.add(kumhoTire);
		//kumhoList.add(hankookTire)  x
		//kumhoList.add(tire)  x
		
		ArrayList<Tire> TireList=new ArrayList<>();
		TireList.add(kumhoTire);
		TireList.add(hankookTire);
		TireList.add(tire);
		
				
	}//main e
	
	public static  KumhoTire 함수1(Tire tire) {//1.Tire의 자료형을 가진 인수를 받아서 KumhoTire 자료형을 가진 KumhoTire로 리턴(배출)한다
		return new KumhoTire();
	}
	
	public static Tire 함수2(KumhoTire kumhoTire) {//2.KumhoTire의 자료형을 가진 인수를 받아서 Tire의 자료형을 가진 Tire로 리턴(배출)한다 =>작은상자만 담을수 있고 큰걸 배출
		return new Tire();
	}
	
	
	
	
	
	
	
}
