package model.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.dto.ChatDto;
import model.dto.productDto;

public class productDao extends Dao{
	
	private static productDao dao=new productDao();
	
	public productDao() {
		// TODO Auto-generated constructor stub
	}

	public static productDao getInstance() {
		return dao;
	}
	
	//1.제품등록
	public boolean write(productDto dto) {
		//1.제품우선등록
		String sql="insert into product(pname,pcomment,pprice,plat,plng,mno)value(?,?,?,?,?,?)";
		try {
			//등록된 제품 pk번호 가져오기
			
			ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);//Statement.RETURN_GENERATED_KEYS : 방금전에생성된 pk번호=즉 pno
			ps.setString(1, dto.getPname());
			ps.setString(2, dto.getPcomment());
			ps.setLong(3, dto.getPprice());
			ps.setString(4, dto.getPlat());
			ps.setString(5, dto.getPlng());
			ps.setInt(6, dto.getMno());
			ps.executeUpdate();
			//insert 후 생성된 제품 pk번호 호출
			rs=ps.getGeneratedKeys();
			if(rs.next()) {
				for(String pimgname : dto.getPimglist()) {//전달된 파일의 개수만큼 인설트,인설트..
					//dto내 첨부파일명 리스트에서 하나씩 첨부파일명을 insert 하기
					sql="insert into pimg(pimgname,pno)values(?,?)";
					ps=con.prepareStatement(sql);
					ps.setString(1, pimgname);ps.setInt(2, rs.getInt(1));
					ps.executeUpdate();
				}
			}
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
		
	}
	
	//2.전체출력
	
	public ArrayList<productDto>getproductList(double 동,double 서,double 남,double 북){
		ArrayList<productDto>list=new ArrayList<>();
		String sql="select p.*, m.mid , m.mimg from product p natural join member m "
				+ " where "+동+" >=plng and "+서+" <=plng  and "+남+" <=plat and "+북+" >=plat ";
		try {
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			while (rs.next()) {
				//사진레코드호출 13번째꺼
				ArrayList<String>pimglist=new ArrayList<>();
				sql="select * from pimg where pno="+ rs.getInt(1);
				ps=con.prepareStatement(sql);
				ResultSet rs2=ps.executeQuery();//rs가 반복문에서 쓰고있기때문에 또select 쓰려면 rs2만들어야함
				while (rs2.next()) {
					pimglist.add(rs2.getString(2));//이미지의 이름
				}
				
				productDto dto=new productDto(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getInt(5), rs.getString(6),
						rs.getString(7), rs.getInt(8), rs.getString(9),
						rs.getInt(10), rs.getString(11), rs.getString(12),pimglist);
				
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
	
	
	//5.
	public boolean setchat(ChatDto dto) {
		String sql="insert into note(ncontent,pno,frommno,tomno)value(?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getNcontent());
			ps.setInt(2, dto.getPno());
			ps.setInt(3, dto.getFrommno());
			ps.setInt(4, dto.getTomno());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
		
	}
	//6. 제품에 등록된 채팅[제품번호 일치,현재 보고있는 회원 받거나 보낸내용들]
	public ArrayList<ChatDto>getchatlist(int pno, int mno){
		ArrayList<ChatDto> list=new ArrayList<>();
		String sql="select * from note where pno=? and (frommno =? or tomno=?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.setInt(2, mno);
			ps.setInt(3, mno);
			rs=ps.executeQuery();
			while (rs.next()) {
				list.add(new ChatDto(
						rs.getInt(1), rs.getString(2), rs.getString(3)
						, rs.getInt(4), rs.getInt(5), rs.getInt(6))	);
			}
					
		} catch (SQLException e) {
			System.out.println(e);
		}return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
