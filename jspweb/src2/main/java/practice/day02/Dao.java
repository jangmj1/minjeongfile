package practice.day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao {
	
	private static Dao dao=new Dao();
	
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	private Dao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jspweb",
					"root",
					"1234"
					);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static Dao getInstance() {
		return dao;
	}
	
	
	
	public boolean setData(
			String data1,
			String data2,
			Double data3,
			int data4,
			String data5,
			String data6,
			String data7,
			boolean data8,
			String data9,
			String data10
				
			) {
		String sql="insert into ex2 value(?,?,?,?,?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, data1);
			ps.setString(2, data2);
			ps.setDouble(3, data3);
			ps.setInt(4, data4);
			ps.setString(5, data5);
			ps.setString(6, data6);
			ps.setString(7, data7);
			ps.setBoolean(8, data8);
			ps.setString(9, data9);
			ps.setString(10, data10);
			ps.executeUpdate();return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean setData2(Dto dto) {
		String sql="insert into ex2 value(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getData1());
			ps.setString(2, dto.getData2());
			ps.setDouble(3, dto.getData3());
			ps.setInt(4, dto.getData4());
			ps.setString(5, dto.getData5());
			ps.setString(6, dto.getData6());
			ps.setString(7, dto.getData7());
			ps.setBoolean(8, dto.isData8());	//boolean => get~~~[x] , is~~~[o]
			ps.setString(9, dto.getData9());
			ps.setString(10, dto.getData10());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//dto가 없는 출력함수
	public ArrayList<Object>getData(){
		ArrayList<Object>list=new ArrayList<>();
		String sql="select*from ex2";
		
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while (rs.next()) {
				//레코드 별로 필드 1번~필드10을 리스트에 담기
				list.add(rs.getString(1));list.add(rs.getString(2));list.add(rs.getDouble(3));
				list.add(rs.getInt(4));list.add(rs.getString(5));list.add(rs.getString(6));
				list.add(rs.getString(7));list.add(rs.getBoolean(8));list.add(rs.getString(9));
				list.add(rs.getString(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Dto>getData2(){
		ArrayList<Dto> list=new ArrayList<>();
		
		String sql="select*from ex2";
		
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				Dto dto=new Dto(rs.getString(1), rs.getString(2), rs.getDouble(3),
						rs.getInt(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getBoolean(8), rs.getString(9), rs.getString(10));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	public boolean setData_2(Dto_2 dto_2) { //과제 입력
		String sql="insert into ex2_2 values(?,?,?,?,?,?,?,?,?)";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, dto_2.getData11());
			ps.setString(2, dto_2.getData12());
			ps.setDouble(3, dto_2.getData13());
			ps.setInt(4, dto_2.getData14());
			ps.setString(5, dto_2.getData15());
			ps.setString(6, dto_2.getData16());
			ps.setBoolean(7, dto_2.isData17());
			ps.setString(8, dto_2.getData18());
			ps.setString(9, dto_2.getData19());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
		
	}
	
	public ArrayList<Dto_2> list2(){//과제출력
		ArrayList<Dto_2> list2=new ArrayList<>();
		
		String sql="select*from ex2_2";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				Dto_2 dto_2=new Dto_2(rs.getString(1), rs.getString(2), rs.getDouble(3),
						rs.getInt(4), rs.getString(5), rs.getString(6), 
						rs.getBoolean(7), rs.getString(8), rs.getString(9));
				list2.add(dto_2);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return list2;
	}
	
	
	
	
	
	
	
	//여러개 자료형 ==> 하나의 자료형[클래스]
	//동일한 자료형 ==> 하나의 자료형[리스트 혹은 배열]
	
	
	
	
	
	
	

}
