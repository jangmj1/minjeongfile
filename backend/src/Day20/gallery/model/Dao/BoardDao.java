package Day20.gallery.model.Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import Day20.gallery.model.Dto.BoardDto;
import Day20.gallery.model.Dto.CategoryDto;

public class BoardDao extends Dao{

	
		private static BoardDao dao=new BoardDao();
		private BoardDao() {};
		public static BoardDao getInstance () {
			return dao;
	
		
		}
		
		
		//1. 카테고리 추가 sql
		public boolean categoryAdd(String cname) {
			
			String sql="insert into category(cname) value (?)";
			
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1, cname);
				ps.executeUpdate();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}return false;
			
		}
		
		//2.모든 카테고리 호출 sql
		public ArrayList<CategoryDto> categoryPrint(){
			
			ArrayList<CategoryDto> clist=new ArrayList<>(); // 여러개 cdto 담을 리스트 선언
			
			String sql="select*from category";
			try {
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				
				while (rs.next()) { //rs.next() :다음 레코드 존재하면 true / 없으면 false
					//레코드 =>dto
					CategoryDto dto=new CategoryDto(rs.getInt(1), rs.getString(2));
					clist.add(dto);
				}
				return clist;
			} catch (SQLException e) {
				e.printStackTrace();
			}return null;
		}
		
		//3.게시물 등록
		public boolean boardAdd(String btitle,String bcontent,int mno , int cno) {
			
			String sql="insert into board(btitle,bcontent,mno,cno) values(?,?,?,?)";
			
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1, btitle);
				ps.setString(2, bcontent);
				ps.setInt(3, mno);
				ps.setInt(4, cno);
				ps.executeUpdate();
				return true;
				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}return false;
			
			
			
		}
		
		//4.최신 게시물 3개 출력
		public ArrayList<BoardDto>boardPrintRecent(){
			ArrayList<BoardDto>blist=new ArrayList<>();
			String sql=
					" select b.bno,b.btitle,b.bcontent, b.bdate,b.bview,m.mid,c.cname "
					+ "  from board b, member m,category c "
					+ "	where b.mno=m.mno and b.cno=c.cno "
					+ "  order by b.bdate desc limit 3;";
			
			try {
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				
				while (rs.next()) {
					BoardDto dto=new BoardDto(rs.getInt(1), rs.getString(2), 
							rs.getString(3), rs.getString(4), rs.getInt(5), 
							rs.getString(6), rs.getString(7));
					blist.add(dto);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return blist;
			
		}
		
		
		//5.해당 카테고리 모든 게시물 출력
		public ArrayList<BoardDto>boardPrint(int cno ){
			ArrayList<BoardDto> blist = new ArrayList<>();
			String sql = " select b.bno , b.btitle , b.bcontent , b.bdate , b.bview , m.mid , c.cname "
					+ "	from board b , member m , category c "
					+ "	where b.mno = m.mno and b.cno = c.cno and b.cno = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setInt( 1 , cno );
				rs = ps.executeQuery();
				while( rs.next() ) {
					BoardDto dto = new BoardDto( rs.getInt(1), rs.getString(2), rs.getString(3), 
							rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));
					blist.add(dto);
				}
			}catch (Exception e) {System.out.println(e);}
			return blist;
			
		}
		
		//6. 해당 게시물 출력
}
