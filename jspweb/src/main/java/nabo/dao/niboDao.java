package nabo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import nabo.dto.niboDto;

public class niboDao {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	private static niboDao dao=new niboDao();
	
	public niboDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/nibo",
					"root",
					"1234"
					);
			System.out.println("연동성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
				
	}

	public static niboDao getInstance() {
		return dao;
	}
	
	
	//------------------------------------------------------------
	
	public boolean bodycheck(niboDto dto) {
		
		String sql="insert into mypage(today,height,weight,bmi,eno)value(?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getToday());
			ps.setDouble(2, dto.getHeight());
			ps.setDouble(3, dto.getWeight());
			ps.setDouble(4, dto.getBmi());
			ps.setInt(5, dto.getEno());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
		
	}
	
	public ArrayList<niboDto> print(int type){
		ArrayList<niboDto>list=new ArrayList<>();
		String sql="";
		if(type==1) {
			sql="select today,weight from mypage;";
			try {
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				while (rs.next()) {
					niboDto dto=new niboDto(rs.getString(1), rs.getInt(2));
					list.add(dto);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}return list;
		
	}
	
	
	
	
	
	
}
