package 과제.과제1;

import java.io.Console;
import java.util.Scanner;

public class 연산자문제 {
 public static void main(String[] args) {
	String 강아지1="|\\_/|"; System.out.println(강아지1);//1행
	
	String a="|q";
	String b="p|";
	String c="/}";
	System.out.printf("%s %s %4s\n",a,b,c );//2행
	
	String d="(";
	String e="0";
	String f=")"+"\""+"\""+"\""+"\\";
	System.out.printf("%-1s %s %-1s\n",d,e,f );//3행
	
	String g="|\"^\"`";
	String h="|";
	System.out.printf("%s %4s \n",g,h);//4행
	
	String i="||_/=\\\\__|";
	System.out.println(i);//5행
	
/**********************************************************************/			
	
	//문제 2
	Scanner scanner=new Scanner(System.in);
	
	/*
	 * System.out.println("작성자 : "); String 작성자=scanner.next(); scanner.nextLine();
	 * System.out.println("내용 : "); String 내용=scanner.nextLine();
	 * System.out.println("날짜: "); String 날짜=scanner.next();
	 * 
	 * System.out.println("--------------방문록--------------------");
	 * System.out.printf("%3s |%6s | %15s | %6s |\n","번호","작성자","내용","날짜");
	 * System.out.printf("%4d |%6s | %15s | %6s |\n",1,작성자,내용,날짜);
	 */

/**********************************************************************/
	
	//문제3
	
	/*
	 * System.out.println("기본급 :"); int 기본급=scanner.nextInt();
	 * System.out.println("수당 :"); int 수당=scanner.nextInt(); int 실수령액=기본급+수당-
	 * (int)(기본급*0.1);// (기본급*0.1) =int*double 즉double! int 로 강제전환 해야함
	 * System.out.println("실수령액"+실수령액);
	 */
	
/**********************************************************************/	
	
/*
 * //문제4 System.out.println("금액 :"); int 금액=scanner.nextInt();
 * System.out.println("십만원:"+(금액/100000)+"장");
 * 
 * 금액-=(금액/100000)*100000; System.out.println("만원권:"+ 금액/10000+"장");
 * 
 * 금액-=(금액/10000)*10000; System.out.println("천원권:"+금액/1000+"장");
 * 
 * 금액-=(금액/1000)*1000; System.out.println("백원:"+금액/100+"개");
 */
	
/**********************************************************************/
	//문제5
	/*
	 * System.out.println("숫자를 입력하세요:"); int num= scanner.nextInt();
	 * System.out.println(num%7==0 ? "7의배수o" : "7의배수x" );
	 */
	
/**********************************************************************/	
	//문제6
	
	/*
	 * System.out.println("숫자를 입력하세요:"); int num1=scanner.nextInt();
	 * System.out.println(num1%2==1 ? "홀수o" : "짝수x");
	 */
	
	
/**********************************************************************/	
/*
 * //문제7 System.out.println("숫자를 입력하세요:"); int num2= scanner.nextInt();
 * System.out.println(num2%7==0 && num2%2==0 ? "7의배수이면서 짝수 o" : "x");
 */
	
/**********************************************************************/	
	//문제8	
	
	/*
	 * System.out.println("숫자를 입력하세요:"); int num3= scanner.nextInt();
	 * System.out.println(num3%7==0 || num3%2==1 ? "7의배수 이거나 홀수 o" : "x" );
	 */
/**********************************************************************/		
	
/*
 * //문제9 System.out.println("숫자를 입력하세요1"); int num4=scanner.nextInt();
 * System.out.println("숫자를 입력하세요2"); int num5=scanner.nextInt();
 * System.out.println(num4<num5 ? num5:num4); System.out.println(num4==num5 ?
 * "같습니다":"");
 */
	
/**********************************************************************/	
//문제 10	
	
/*
 * System.out.println("반지름을 입력하세요"); int 반지름= scanner.nextInt(); 
 * double 넓이=반지름*반지름*3.14; System.out.println("원의넓이는:"+넓이); //인트*인트*더블=> 더블
 */
/**********************************************************************/	

/*
 * //문제11 System.out.println("실수를 입력하세요1");double number1= scanner.nextDouble();
 * System.out.println("실수를 입력하세요2");double number2= scanner.nextDouble();
 * 
 * double 출력=(number1*100)/number2; System.out.println(출력+"%");
 */
	
/**********************************************************************/		
 
/*
 * //문제12 System.out.println("윗변을 입력하세요"); int num5=scanner.nextInt();
 * System.out.println("밑변을 입력하세요"); int num6=scanner.nextInt();
 * System.out.println("높이를 입력하세요"); int num7=scanner.nextInt();
 * 
 * System.out.println("사다리꼴 넓이는:"+(num5*num6)*num7/2);
 */
/**********************************************************************/	
	
	//문제 13
	/*
	 * System.out.println("키를 입력하세요");int 키= scanner.nextInt();
	 * System.out.println("표준체중:"+(키-100)*0.9+"kg");
	 */
	
/**********************************************************************/	
//문제14
/*
 * System.out.println("키를 입력하세요"); int 키1=scanner.nextInt();
 * System.out.println("몸무게를 입력하세요"); int 몸무게=scanner.nextInt();
 * System.out.println("BMI는"+몸무게/(키1/100)*(키1/100));
 */
/**********************************************************************/	
//문제15
	 System.out.println("inch를 입력하세요"); int inch=scanner.nextInt();
	 double 센치= inch*2.54;
	 System.out.println(inch+"인치는"+센치+"cm입니다");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
}