package practice.day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDao {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static BoardDao boardDao=new  BoardDao();
	
	private BoardDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jspweb","root","1234");
		} catch (Exception e) {
			System.out.println("");
		}
		
	}

	
	
	public static BoardDao getInstance() {
		return boardDao;
	}



	//1.등록
	public boolean onwrite(BoardDto dto) {
		String sql="insert into ex3(bcontent,bwriter) value (?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getBcontent());
			ps.setString(2, dto.getBwriter());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			
		}return false;
	}
	
	
	//출력
	public ArrayList<BoardDto>onlist(){
		ArrayList<BoardDto>list=new ArrayList<>();
		
		String sql="select * from ex3";
		
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while (rs.next()) {
				BoardDto boardDto=new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(boardDto);
				
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return list;
	}
	
	//삭제
	public boolean Delete(int bno) {
		String sql="delete from ex3 where bno =?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, bno);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean onupdate(int bno,String newContent) {
		String sql="update ex3 set bcontent=? where bno=?"; 
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, newContent);
			ps.setInt(2, bno);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	
}
