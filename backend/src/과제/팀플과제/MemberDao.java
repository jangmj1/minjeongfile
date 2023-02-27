package 과제.팀플과제;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class MemberDao {
	
	//싱글톤
	private static MemberDao dao=new MemberDao();
	private Connection conn;
	private PreparedStatement ps;
	ResultSet rs;
	
	private MemberDao() {
		try {
			conn=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/console","root","1234"
					);
		} catch (SQLException e) {
			System.out.println("연동실패"+e);
		}
				
		
	}

	public static MemberDao getInstance() {
		return dao;
	}
/*****************************************************************************************/	
	Scanner scanner=new Scanner(System.in);

	 ArrayList<회원>회원DB=new ArrayList<>();
	//회원가입
	public boolean signup(회원 회원) {
		
		String sql="insert into 회원(아이디,비밀번호,전화번호,이름,등급) "
				+ "values(?,?,?,?,?)";
		
		
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, 회원.get아이디());
			ps.setString(2, 회원.get비밀번호());
			ps.setString(3, 회원.get전화번호());
			ps.setString(4, 회원.get이름());
			ps.setInt(5, 회원.get등급());
			
			ps.executeUpdate();
			회원DB.add(회원);
			
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("DB입력실패"+e);
		}
		
		
		return false;
		
		
	}
	
	
	public int login(String 아이디,String 비밀번호) {
		
		String sql="select 비밀번호,등급 from 회원 where 아이디=? ";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, 아이디);
			rs=ps.executeQuery();
			
			if(rs.next()) {//출력이면..출력이 트루이면(?)
				if(rs.getString(1).contentEquals(비밀번호)) {//출력된 rs1번과 작성하는 비밀번호와 같을시
					if(rs.getInt(2)==1) {
						return 1; //1번이면 일반회원 로그인 성공
					}else if (rs.getInt(2)==2) {
						return 2; //2번이면 관리자 회원 로그인 성공
					}
				}else {
					return 0; //비밀번호 틀림
				}
			}
			return -1; //없는회원(아이디없음)
			
		} catch (SQLException e) {
			System.out.println("없는회원입니다."+e);
		}
		
		return -2;//db오류 필요없는리턴값이지만 리턴안해주면 오류남
		
		
		
		
		
		
	}
	
	
	
}
