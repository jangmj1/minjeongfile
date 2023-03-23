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
	
	public boolean bodycheck(niboDto dto) {//기록하기
		
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
	
	public ArrayList<niboDto> print(int type,int myno){//출력하기
		ArrayList<niboDto>list=new ArrayList<>();
		String sql="";
		if(type==1) {//전체출력
			sql="select myno,today,weight from mypage order by today desc limit 0 , 7 ";
			
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
				
			}else if (type==2) {//상세출력
				
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
	//수정하기
	public boolean update(double upheight,double upweight,double bmi,int upeno,int myno) {
		String sql="update mypage set height=?, weight=?,bmi=?,eno=? where myno=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setDouble(1, upheight);
			ps.setDouble(2, upweight);
			ps.setDouble(3, bmi);
			ps.setInt(4, upeno);
			ps.setInt(5, myno);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
		
	}
	
	
	//삭제하기
	public boolean deletebody(int myno) {
		String sql="delete from mypage where myno =?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, myno);
			int count=ps.executeUpdate();
			if(count==1) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
		
	}
	
	
	
	
	
}
