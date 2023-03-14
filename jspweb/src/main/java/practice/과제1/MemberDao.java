package practice.과제1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {

	public Connection con;
	public PreparedStatement ps;
	public ResultSet rs;
	
	
	private static MemberDao dao=new MemberDao(); //싱글톤
	

	public static MemberDao getInstance() {
		return dao;
	}


	public MemberDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/proj"
					,"root","1234");
			System.out.println("[연동성공]");
		} catch (Exception e) {System.out.println(e);}
		
		
	}
	
	public boolean signup(MemberDto dto) {
		
		String sql="insert into member(mimg, name,mrank,employment,division,idate,edate,resign) "
				+ "values(?,?,?,?,?,?,?,?)";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getMimg());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getMrank());
			ps.setString(4, dto.getEmployment());
			ps.setString(5, dto.getDivision());
			ps.setString(6, dto.getIdate());
			ps.setString(7, dto.getEdate());
			ps.setString(8, dto.getResign());
		
			ps.executeUpdate();	return true;
		} catch (SQLException e) {System.out.println(e);}return false;
	}
	
	
	public ArrayList<MemberDto> hiprint(){
		ArrayList<MemberDto>list=new ArrayList<>();
		String sql="select*from member";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				MemberDto dto=new MemberDto(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getString(8), rs.getString(9));
				list.add(dto);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public MemberDto oneprint(int no){
		String sql="select*from member where no=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, no);
			rs=ps.executeQuery();
			
			if (rs.next()) {
				MemberDto dto=new MemberDto(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getString(8), rs.getString(9));
				return dto;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public boolean newupdate(String newmname,String newmrank,String newemployment,String newdivision,
			String newidate,String newmimg,String newedate,String newresign ,int no) {
		String sql="update member set mimg=?,name=?,mrank=?,employment=?,division=?,idate=?,edate=?,resign=? "
				+ " where no=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, newmimg);
			ps.setString(2, newmname);
			ps.setString(3, newmrank);
			ps.setString(4, newemployment);
			ps.setString(5, newdivision);
			ps.setString(6, newidate);
			ps.setString(7, newedate);
			ps.setString(8, newresign);
			ps.setInt(9, no);
			int count=ps.executeUpdate();
			if(count==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
	}
	
	public boolean del(int no) {
		
		String sql="delete from member where no=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, no);
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
		
	}
	
	
	
	
	
}
