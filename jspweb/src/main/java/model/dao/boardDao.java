package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.boardDto;

public class boardDao extends Dao{
	
	
	private static boardDao dao=new boardDao();
	
	private boardDao() {
		// TODO Auto-generated constructor stub
	}

	public static boardDao getInstance() {
		return dao;
	}
	
	//글쓰기.
	public boolean bwrite (boardDto dto) {
		String sql="insert into board(btitle,bcontent,bfile,mno,cno)value(?,?,?,?,?)";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getBtitle());
			ps.setString(2, dto.getBcontent());
			ps.setString(3, dto.getBfile());
			ps.setInt(4, dto.getMno());
			ps.setInt(5, dto.getCno());
			ps.executeUpdate(); return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
	}
	
	public ArrayList<boardDto>getboardList(){
		ArrayList<boardDto>list=new ArrayList<>();
		String sql="select board.* , member.mid from member natural join board";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				boardDto dto=new boardDto(
						rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getInt(6),  rs.getInt(7), 
						 rs.getInt(8), rs.getInt(9),  rs.getInt(10), rs.getString(11)
						);
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return list;
		
	}
	
	//3. 개별 개시물 조회 
	public boardDto getBoard(int bno) {
		String sql="select board.*,member.mid,member.mimg from board natural join member where board.bno=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, bno);
			rs=ps.executeQuery();
			if(rs.next()) {
				boardDto dto=new boardDto(
						rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getInt(6),  rs.getInt(7), 
						 rs.getInt(8), rs.getInt(9),  rs.getInt(10), rs.getString(11)
						);
				return dto;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
