package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {
	
	public static Connection getConnection() throws Exception {
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection
				("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
		
		return con;
	}
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Dao() {
		try {
			con=getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<Dto> getlist(){//후보조회
		
		String sql="select  A.m_no, A.m_name, B.p_name, A.p_school, A.m_jumin, A.m_city, B.p_tel1, B.p_tel2, B.p_tel3 "
				+ "from tbl_member_202005 A natural join tbl_party_202005 B";
		List<Dto> list=new ArrayList<>();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Dto dto=new Dto(
						rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8), rs.getString(9));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean vote(Dto dto) {//투표하기
		String sql="insert into tbl_vote_202005 values (?, ?, ?, ?, ?, ?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getV_jumin());ps.setString(2, dto.getV_name());;
			ps.setString(3, dto.getM_no());ps.setString(4, dto.getV_time());
			ps.setString(5, dto.getV_area());ps.setString(6, dto.getV_confirm());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
		
		
	}
	
	public List<Dto> getvoteConfirm(){
		String sql="select * from tbl_vote_202005 where  V_AREA='제1투표장'";
		List<Dto> list=new ArrayList<>();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				Dto dto=new Dto(
						rs.getString(3), rs.getString(1),
						rs.getString(2), rs.getString(4), rs.getString(6)) ;
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return list;
	}
	
	public List<Dto> getvoteTop(){
		String sql="select b.m_no,b. m_name,count(*) v_total from tbl_vote_202005 a inner join  tbl_member_202005 b "
				+ "	on a.m_no=b.m_no where a.v_confirm='Y' group by b.m_no, b.m_name  order by v_total DESC";
		List<Dto> list=new ArrayList<>();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				Dto dto=new Dto(rs.getString(1), rs.getString(2), rs.getInt(3));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return list;
		
		
	}
}
