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
	
	//글의 총 갯수 구하는 함수
	public int gettotalsize(String key,String keyword ,int cno) {
		String sql="";
		if(key.equals("") && key.equals("") ) { //만약에 검색이 없으면
			
			 sql="select count(*) from member m natural join board b where b.cno= "+cno; //글의 총 갯수가 나온다 
		
		}else {//검색을 했을때
			 sql="select count(*) from member m natural join board b where "+key+" like '% "+keyword+ "%' and b.cno="+cno;
		}
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	//한 페이지당 출력되는 함수 (3개씩 출력되는함수)
	public ArrayList<boardDto>getboardList(int startrow,int listsize,String key,String keyword, int cno){
		String sql="";
		ArrayList<boardDto>list=new ArrayList<>();
		
		if(key.equals("") && key.equals("")) { //만약에 검색이 없으면
			 sql="select b.*,m.mid from member m natural join board b where b.cno = "+cno
					+ " order by b.bdate desc limit ?,?";
			
		}else {//검색을 했을때
			 sql="select b.*,m.mid from member m natural join board b "
					+ " where " +key+ " like '%"+ keyword +"%'and b.cno= "+cno
							+ " order by b.bdate desc limit ?,?";
		}
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, startrow);
			ps.setInt(2, listsize);
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
	
	//4.조회수 좋아요 싫어요 업데이트
	public boolean bincrease(int type,int bno) {
		String sql="";
		
		if(type==1) {
			sql="update board set bview=bview+1 where bno="+bno;
			
		}if(type==2) {
			sql="update board set bup=bup+1 where bno="+bno;
			
		}if(type==3) {
			sql="update board set bdown=bdown+1 where bno="+bno;
			
		}
		try {
			ps=con.prepareStatement(sql);
			ps.executeUpdate();return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
		
	}
	
	//삭제함수
	
	public boolean bdelete(int bno) {
		String sql="delete from board where bno="+bno;
		
		try {
			ps=con.prepareStatement(sql);
			int count =ps.executeUpdate();
			if(count==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
		
		
	}
	
	//6.게시물 수정
	public boolean bupdate(boardDto updatedto) {
		String sql="update board set btitle=?,bcontent=?,bfile=? , cno=? where bno=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, updatedto.getBtitle());
			ps.setString(2, updatedto.getBcontent());
			ps.setString(3, updatedto.getBfile());
			ps.setInt(4, updatedto.getCno());
			ps.setInt(5, updatedto.getBno());
			int count=ps.executeUpdate();
			if(count==1) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
		
		
	}
	
	//7.파일 만 삭제 수정
	public boolean bfiledelete(int bno) {
		String sql="update board set bfile=null where bno="+bno; //해당번호의 파일을 비운다
		
		try {
			ps=con.prepareStatement(sql);
			int count=ps.executeUpdate(); //어쩔때 count쓰는건지?? 업데이트가 실제로 되면 1이될때?
			if(count==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
	}
	
	
	
	
	
	

}
