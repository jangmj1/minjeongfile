package Day17;

import java.sql.Time;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Ex2_p532 {
	
	
	public static void main(String[] args) {
		
			//1.데이트함수는 주로 date 객체명=new Date();
		Date now=new Date(); //현재 컴퓨터에 날짜를 갖고온다
		System.out.println(now);
			//2.simpleDateFormat 객체명=new SimpleDateFormat(패턴);
			/*객체명.format(날짜객체) : 해당 날짜 객체가 패턴 형식으로 바뀐다 문자로해야함
			 *  y : 연도		M : 월		d:일
			 * 	H : 시		m : 분		s:초
			 * 
			 * 
			 */
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 d일 H: m: s:"	); //패턴을 만드는애임
		System.out.println(sdf.format(now));
		
		//2. Calender 클래스
		Calendar cal= Calendar.getInstance();//일반적으로 내부객체(싱글톤)써서 사용
		System.out.println(cal);
		
		System.out.println("현재년도:"+cal.get(Calendar.YEAR));
		System.out.println("현재년도"+cal.get(1));
	
		System.out.println("현재년도:"+ (cal.get(Calendar.MONTH)+1 ) ); // 1월: 0 , 2월: 1 ,.. 12월 : 11  나오니까 +1
		System.out.println("현재년도:"+ cal.get(Calendar.DAY_OF_YEAR) ); 
		System.out.println("현재년도:"+ cal.get(Calendar.DAY_OF_MONTH) ); 
		System.out.println("현재년도:"+ cal.get(Calendar.DAY_OF_WEEK) ); 
		
		//주=> 일:1~ 토:7
		int week = cal.get(Calendar.DAY_OF_WEEK);
		if(week==Calendar.MONDAY) {System.out.println("월");}
		if(week==3) {System.out.println("화");}
		if(week==Calendar.WEDNESDAY) {System.out.println("수");}
		if(week==Calendar.TUESDAY) {System.out.println("목");}
		if(week==6) {System.out.println("금");}
		if(week==Calendar.SATURDAY) {System.out.println("토");}
		if(week==1) {System.out.println("일");}
		
	
		System.out.println("현재 오전/오후"+cal.get(Calendar.AM_PM));
		int ampm=cal.get(Calendar.AM_PM);
		if(ampm==0) System.out.println("오전");
		else {System.out.println("오후");}
		
		System.out.println("현재 시 : "+cal.get(Calendar.HOUR));
		System.out.println("현재 분 : "+cal.get(Calendar.MINUTE));
		System.out.println("현재 초시 : "+cal.get(Calendar.SECOND));
	
	
		//3.
		for(String timeid:TimeZone.getAvailableIDs()) {
			System.out.println(timeid);
		}
	
	
	
		//4.LocalDateTime
		LocalDateTime dateTime=LocalDateTime.now();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy MM dd a HH:mm:ss");
		System.out.println("현재시간"+dateTime.format(dtf));
	
		//데이트는 못하지만 LocalDateTime 는 덧셈뺄셈이 가능하다
		System.out.println("1년후:"+dateTime.plusYears(1));
		System.out.println("2개월전:"+dateTime.minusMonths(2));
		System.out.println("7일후:"+dateTime.plusDays(7));
	
	
		//5.
		LocalDateTime 시작일=LocalDateTime.of(2021, 1, 2, 10, 3,45);
		LocalDateTime 종료일=LocalDateTime.of(2021, 12,31,0,0,0);
		System.out.println( "종료일이 시작이 이후:" +시작일.isBefore(종료일));
		System.out.println( "종료일이 시작이 이전:" +시작일.isAfter(종료일));
		System.out.println("종료일과 시작일이 같은지:"+시작일.isEqual(종료일));
		System.out.println("연도 차 : "+(시작일.until(종료일, ChronoUnit.YEARS)));
		System.out.println("월 차 : "+(시작일.until(종료일, ChronoUnit.MONTHS)));
		System.out.println("일 차 : "+(시작일.until(종료일, ChronoUnit.DAYS)));
		System.out.println("시 차 : "+(시작일.until(종료일, ChronoUnit.HOURS)));
		System.out.println("시 차 : "+(시작일.until(종료일, ChronoUnit.MINUTES)));
		System.out.println("시 차 : "+(시작일.until(종료일, ChronoUnit.SECONDS)));
	
		//6.
		double num=1234567.89;
		
		DecimalFormat df;
		
		//*천단위 쉼표 만들기
		df= new DecimalFormat("#,###");
		System.out.println(df.format(num));// 천단위로 컴마 넣기 소수점은 반올림 올라감
		
		//*무조건 소수 첫째 자리 표기[없으면0]
			//0:만일 숫자가 없는 자리면 0채움
			//# : 만일 숫자가 없는 자리면 공백
		df=new DecimalFormat("#,###.0");
		System.out.println(df.format(123456.7));
		System.out.println(df.format(123456));
		
		//*금액의 천단위 쉼표 : #,##0
		df=new DecimalFormat("#,##0원");
		System.out.println(df.format(123456));
		System.out.println(df.format(1));
		
	
		//2.SimpleDateFormat(패턴)
		Date date=new Date();
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd");
		System.out.println(dateFormat.format(date));
		
		dateFormat=new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println(dateFormat.format(date));
		
		dateFormat=new SimpleDateFormat("yyyy.MM.dd a HH:mm:ss");
		System.out.println(dateFormat.format(date));
	
		dateFormat=new SimpleDateFormat("오늘은 E요일");
		System.out.println(dateFormat.format(date));
	
		dateFormat=new SimpleDateFormat("[연기준]오늘은 D번째날");//일년기준 365일
		System.out.println(dateFormat.format(date));
		
		dateFormat=new SimpleDateFormat("[월기준]오늘은 d번째날");//일년기준 365일
		System.out.println(dateFormat.format(date));
		
	}
	
	
	
}
