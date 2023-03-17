package model.dao;

import java.sql.SQLException;

public class admindao extends Dao{
	
	private static admindao admindao=new admindao();
	
	public admindao() {
		// TODO Auto-generated constructor stub
	}
	
	
	//모든 회원의 총 수를 구하는 함수
	
	public static admindao getInstance() {
		return admindao;
	}


	public int mtotalsize() {
		String sql="select count(*) from member";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next())return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return 0;
		
	}
}
