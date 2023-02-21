package Day15.Ex9_MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberDao {
	//싱글톤 : dao 싱글톤 하는 이유 => db연동 1번만 하려고
	
	//내부에서 객체만들기
	private static MemberDao dto =new MemberDao();
	//2. 생성자는 private-> 외부에서 new 사용금지
	//3.외부에서 내부객체 사용할수 있게 내부객체 반환 메소드[getInstance()]
	public static MemberDao getInstance() {
		return dto;
	}
	
	private Connection conn;


	private PreparedStatement ps;
	ResultSet rs;
	
	//생성자[연동코드-> 객체 생성시 바로 연동될수 있게 할려고]
	private MemberDao() {
		
		try {
			conn=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/day15","root","1234"
					);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				
	}
	
	//1.회원가입 메소드 [ 인수 : dto(id,pw) , 반환 : 성공[true] ,실패[false
	Scanner scanner=new Scanner(System.in);
	public boolean signup(MemberDto dto) {
		String sql="insert into member(mid,mpw)"+"values(?,?)";
		
		//conn :연동된 db
		//ps 를 쓰는이유는 매개변수가 조작이 되니까
	
		try {
			ps=conn.prepareStatement(sql);
				//3.ps는 매개변수에 대한 조작 가능
			
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpw());
				//4.ps 가 sql 실행
			
			ps.executeUpdate();
				//5.결과반환
			return true; //여기까지 문제가 없었으면 저장 성공
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("db오류:"+e);
		}
			return false;// try 에서 문제가 있으면 밖으로 나와서 펄스
	}
	
	public ArrayList<MemberDto> list() {
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
