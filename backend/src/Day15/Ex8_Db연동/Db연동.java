package Day15.Ex8_Db연동;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Db연동 {
	//DriverManager.getConnection() *해당 db주소와 연결 성공시 성혼한 db구현객체 반환
	private Connection conn;	// 1.db연결된 구현 객체를 받아서 다양한 메소드를 제공
	private PreparedStatement ps;	//2.연결된 sql조작 메소드 제공 [매개변수 ?(물음표) 사용가능]
	private ResultSet rs;			//3.sql결과 조작 메소드 제공
	
	public Db연동() {
		try {
			
			conn=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/java","root","1234");
			System.out.println("연동성공");
		} catch (SQLException e) {
			System.out.println("연동실패"+ e.getMessage());
		}
	}
	
	//연동시 준비물
		//1.db서버주소[localhost vs aws vs  개인 ip]
		//2.해당 db서버의 계정
		//3.해당 db서버의 비밀번호
	//자바에서 db 조작하는 클래스 및 인터페이스	
		//1.DriverManager.getConnection("db서버주소","계정명","비번"

	
	
	public static void main(String[] args) {
		
		Db연동 db연동=new Db연동();
		
	}
	
	
	
}
