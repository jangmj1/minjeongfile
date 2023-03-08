package practice.day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class productDao {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static productDao dao=new productDao();
	
	private productDao() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jspweb","root","1234");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static productDao getInstance() {
		return dao;
	}
	
	
	public boolean 등록(productDto dto) {
		String sql="insert into ex4(pproduct,pprice) value (?,?)";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getPproduct());
			ps.setString(2, dto.getPprice());
			ps.executeUpdate();
			
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
	}
	
	public ArrayList<productDto>출력(){
		
		ArrayList<productDto>list=new ArrayList<>();
		
		String spl="select * from ex4";
		try {
			ps=con.prepareStatement(spl);
			rs=ps.executeQuery();
			
			while (rs.next()) {
				productDto dto=new productDto(rs.getInt(1), rs.getString(2), rs.getString(3));
				list.add(dto);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return list;
		
		
		
		
	}
	
	public boolean pdelete (int pno) {
		String sql="delete from ex4 where pno =?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
	}
	
	public boolean pupdate(int pno ,String newpproduct ,String newprice) {
		String sql="update ex4 set pproduct=? , pprice=? where pno=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, newpproduct);
			ps.setString(2, newprice);
			ps.setInt(3, pno);
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
		
	}
	
	
	
	

}
