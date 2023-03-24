package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.productDto;

public class productDao extends Dao{
	
	private static productDao dao=new productDao();
	
	public productDao() {
		// TODO Auto-generated constructor stub
	}

	public static productDao getInstance() {
		return dao;
	}
	
	
	public boolean write(productDto dto) {
		String sql="insert into product(pname,pcomment,pprice,plat,plng)value(?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getPname());
			ps.setString(2, dto.getPcomment());
			ps.setLong(3, dto.getPprice());
			ps.setString(4, dto.getPlat());
			ps.setString(5, dto.getPlng());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
		
	}
	
	//2.전체출력
	
	public ArrayList<productDto>getproductList(double 동,double 서,double 남,double 북){
		ArrayList<productDto>list=new ArrayList<>();
		String sql="select * from jspweb.product where "+동+" >=plng and "+서+" <=plng  and "+남+" <=plat and "+북+" >=plat ";
		try {
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			while (rs.next()) {
				productDto dto=new productDto(
						rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getLong(4), rs.getInt(5), rs.getString(6),
						rs.getString(7), rs.getInt(8), rs.getString(9));
				
				list.add(dto);		
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return list;
		
	}
	
	//3.찜하기
	public boolean setplike(int pno, int mno) {
			//등록할지 취소할지 검색 먼저하기
		String sql="select * from plike where pno =? and mno = ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.setInt(2, mno);
			
			rs=ps.executeQuery();
			if(rs.next()) {//해당 회원이 이미 찜하기를 한 제품-->취소하기
				
				sql="delete from plike where pno = "+ pno+" and mno = "+mno;
				ps=con.prepareStatement(sql);
				ps.executeUpdate();
				return false;
			}else {//해당 회원이 찜하기를 하지 않은 제품 레코드가없음-->등록하기
				sql="insert into plike(pno,mno)values( ?,? )";
				ps=con.prepareStatement(sql);
				ps.setInt(1, pno);
				ps.setInt(2, mno);
				ps.executeUpdate();
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
		
	}
	
	//4.해당 회원이 해당 제품의 찜하기 상태 확인
	public boolean getplike(int pno, int mno) {
		String sql="select * from plike where pno =? and mno = ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.setInt(2, mno);
			
			rs=ps.executeQuery();
			if(rs.next()) {//찜한상태
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
