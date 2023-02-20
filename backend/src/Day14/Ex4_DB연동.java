package Day14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ex4_DB연동 {
	public static void main(String[] args) {
		try {
		Connection con=DriverManager.getConnection(// java =>DB명 만들어줘야한다 mysql 에서 create database java; 
				"jdbc:mysql://localhost:3306/java",
				"root",
				"1234"		);
		System.out.println("db 연동 성공");
		//2.table 생성
		
		//2. table 생성 하는 sql구문을 문자열 변수에 저장
		String sql="create table member( mno int, mid varchar(20) , mpw varchar (20) )";
		
		//3.
		PreparedStatement ps= con.prepareStatement(sql);
		
		//4. 
		ps.execute();
		
		
		
		
		}catch (Exception e) {
			System.out.println("연동 실패 사유 :"+ e);
			
		}
		
	}

	
}
/*
	JDBC : 자바와 데이터베이스를 연결 하는 드라이브
		-해당  DBMS 마다 라이브러리파일 필요
		-보관장소 : C드라이브에 넣기 =>다른 사람들과 협업할떄 폴더 통일
		
	-1.라이브러리 추가
		1. 프로젝트 오른쪽 클릭-> build path-> configure bulid path
		2.libraries 탭에서 javaSE 버전변경
			[javaSE-1.8 일경우 생략 가능]
				1.javaSE-17 
				2.더블클릭 -> javaSE-1.8변경 -> apply
			1.add External jars
			2.해당 jdbc (c드라이브에있는거) 찾아서 추가
			
	-2. 
		Connection :db  연결 인터페이스로 다양한 객체를 제공
		DriverManager :DB 연결 클래스 구현 객체 제공
			1.DriverManager .getConnection(DB 주소 , 계정, 비밀번호);
				-일반예외 발생 =>예외처리는 필수 try catch
				-mysql server 주소 : jdbc:mysql://ip주소 : 포트번호/db명
								-로컬 pc기준 : jdbc:mysql://localhost:3306/db명
*/