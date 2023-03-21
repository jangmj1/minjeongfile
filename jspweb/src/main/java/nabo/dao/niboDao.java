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
		
		String sql="insert into mypage(myno,today,height,weight,bmi,eno)value(?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, dto.getMyno());
			ps.setString(2, dto.getToday());
			ps.setDouble(3, dto.getHeight());
			ps.setDouble(4, dto.getWeight());
			ps.setDouble(5, dto.getBmi());
			ps.setInt(6, dto.getEno());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
		
	}
	
	public ArrayList<niboDto> print(int type,int myno){
		ArrayList<niboDto>list=new ArrayList<>();
		String sql="";
		if(type==1) {
			sql="select myno,today,weight from mypage order by today desc limit 0 , 5 ";
			
				try {
					ps=con.prepareStatement(sql);
					rs=ps.executeQuery();
					while (rs.next()) {
						niboDto dto=new niboDto(rs.getInt(1), rs.getString(2), rs.getDouble(3));
						list.add(dto); 
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if (type==2) {
				
				sql="select m.height,m.weight,m.bmi,e.sports from mypage m natural join exercise e where myno=?";
				
					try {
						ps=con.prepareStatement(sql);
						ps.setInt(1, myno);
						rs=ps.executeQuery();
						while (rs.next()) {
							niboDto dto=new niboDto(rs.getDouble(1), rs.getDouble(2), rs.getDouble(3), rs.getString(4));
							list.add(dto);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}return list;
			
			
			
		
		
	}
	
	
	
	
	
	
	
	
}
