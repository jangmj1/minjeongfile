package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class Dao {
	
	//1.문항지에 있는 db 연동 함수
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
		return con;
	}
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public Dao() {
		try {
			con=getConnection();
			System.out.println("연동성공");
		} catch (Exception e) {
			System.out.println("연동실패"+e);
		}
	}
	
	public List<Dto>getList(){
		List<Dto> list=new ArrayList<>();
		String sql="select * from student_tbl_03";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Dto dto=new Dto(rs.getString(1), rs.getString(2)
						, rs.getString(3), rs.getString(4), rs.getString(5));
				
				list.add(dto);
			}
		} catch (SQLException e) {System.out.println("연동실패"+e);}
		return list;
	}
	
	//4-2
	public boolean add(Dto dto) {
		
		String sql="insert into exam_tbl_03 values (?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getSno());ps.setInt(2, dto.getEkor());
			ps.setInt(3, dto.getEmath());ps.setInt(4, dto.getEeng());
			ps.setInt(5, dto.getEhist()); ps.executeUpdate();return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//4-3
	public List<Dto>getExamList(){
		
		List<Dto> list=new ArrayList<>();
		String sql="select \r\n"
				+ "substr( a.sno ,1,1) 학년 , "
				+ "substr( a.sno ,2,2) 반, "
				+ "substr( a.sno ,4,2) 번호, "
				+ "a.sname 이름,b.ekor 국어 ,b.emath 수학 ,b.eeng 영어,b.ehist 역사,(b.ekor+b.emath+b.eeng+b.ehist)합계, "
				+ "(b.ekor+b.emath+b.eeng+b.ehist)/4 평균, "
				+ "rank()over(order by ( nvl(b.ekor,0)+nvl(b.emath,0)+nvl(b.eeng,0)+nvl(b.ehist,0)) desc) 순위 "
				+ "from student_tbl_03 A full outer join  exam_tbl_03 B on a.sno=b.sno "
				+ "order by  nvl(b.ekor,0)+nvl(b.emath,0)+nvl(b.eeng,0)+nvl(b.ehist,0) desc ";
				
			try {
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				while(rs.next()) {
					Dto dto=new Dto(
							rs.getString(4), rs.getInt(5),rs.getInt(6),
							rs.getInt(7), rs.getInt(8), rs.getInt(9),
							rs.getInt(10), rs.getInt(11), rs.getString(1),
							rs.getString(2), rs.getString(3));
					list.add(dto);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}return list;
			
	}
	
	
}
