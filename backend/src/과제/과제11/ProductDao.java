package 과제.과제11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {
	private Connection conn;
	private PreparedStatement ps;
	ResultSet rs;
	
	
	//싱글톤
	private static ProductDao dao=new ProductDao();
	
	private ProductDao() {
		
		try {
			conn=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/과제11","root","1234"
					);
		} catch (SQLException e) {
			System.out.println("연동실패"+e.getMessage());
		}
				
	}

	public static ProductDao getInstance() {
		return dao;
	}
	
	/************************************************************/
	
	
	
	public boolean newProduct(ProductDto dto) {
		
		String sql="insert into product(pname,pprice,pinven)value (?,?,?)";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,dto.getPname());
			ps.setInt(2, dto.getPprice());
			ps.setInt(3, dto.getPinven());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			System.out.println("db오류"+e);
		}
		return false;
		
	}
/******************************************************************/		
		
	public ArrayList<ProductDto>list(){
		ArrayList<ProductDto>list=new ArrayList<>();
		
		//1.sql 작성
		String sql="select*from product";
		
			try {
				//2.sql대입
				ps=conn.prepareStatement(sql);
				//3.sql조작
					//패스
				
				//4.sql실행
					rs=ps.executeQuery(); //rs가 결과 * 결과에 조작다된 ps를 대입
				
				//5.sql결과
					while (rs.next()) {
						ProductDto dto=new ProductDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
						list.add(dto);
					}
					return list;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
		
	}
	
/******************************************************************/	
	
	public boolean Update(int pno,String pname,int pprice) {
		//sql작성
		String sql="update product set pname=?, pprice=? where pmo=?";
		
		try {
			//2.연결db에 sql대입
			ps=conn.prepareStatement(sql);
			
			//3.sql조작
			ps.setString(1,pname);
			ps.setInt(2, pprice);
			ps.setInt(3, pno);
			
			//4.sql 실행
			ps.executeUpdate();
			
			//5.sql 결과
			return true;
			
			
		} catch (SQLException e) {
			System.out.println("db오류:"+e);
		}
		
		return false;
	}
	
/******************************************************************/	
	public boolean UpdateInven(int pno,int pinven) {
		//1.sql 작성
		String sql="update product set pinven=? where pmo=?";
		
		try {
			//2.sql연동
			ps=conn.prepareStatement(sql);
			
			//3.sql조작
			ps.setInt(1, pinven);
			ps.setInt(2, pno);
			
			//4.sql 실행
			ps.executeUpdate();
			
			//5.sql 결과
			return true;
		} catch (SQLException e) {
			System.out.println("금액수정오류"+e);
		}
		return false;
	}
/******************************************************************/	
	public boolean del(int pno) {
		//1.sql작성
		String sql="delete from product where pmo=?";
		
		try {
			//2.sql 대입
			ps=conn.prepareStatement(sql);
			
			//3.sql조작
			ps.setInt(1, pno);
			
			//4.sql실행
			ps.executeUpdate();
			
			//5.sql 결과
			return true;
		} catch (SQLException e) {
			System.out.println("삭제실패");
			e.printStackTrace();
		}
		return false;
	}
	//여기까지 관리자 함수
/******************************************************************/	
//여기서부터는 사용자함수
	
	
	ArrayList<ProductDto>cart=new ArrayList<>();
	
	public ArrayList<ProductDto> cart(int ch) {
		
		
		//int ch 의 ProductDto 를 cart에 담는다
		
		//1.sql작성
		String sql="select*from product where pmo=?";
		
		try {
			//2.sql 대입
			ps=conn.prepareStatement(sql);
			
			//3.sql조작
			ps.setInt(1, ch);
			
			//4.sql실행
			rs=ps.executeQuery();
			
			
			
			while (rs.next()) {
				ProductDto dto=new ProductDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				
				cart.add(dto);
				
			}
			
			//수량 뺴기.. 이게아니면   "update product set pinven= pinven-1 where pmo=?;" <이걸로 가는걸까?
			
			for(int i=0;i<cart.size();i++) {
				if(ch==cart.get(i).getPno()) {
					int 남은수량 = cart.get(i).getPinven();
					남은수량--;
					System.out.println("냉장고의남은수량은"+남은수량);
				}
			
			}
			
			
			return cart;
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return null;
		
	}
	
	
/******************************************************************/		
	
	
	
	
	
	
	
	
}
