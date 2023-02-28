package Day20.gallery.model.Dao;

import java.sql.SQLException;

import Day20.gallery.model.Dto.MemberDto;

public class MemberDao extends Dao{
	private static MemberDao dao=new MemberDao();
	private MemberDao() {};
	public static MemberDao getInstance () {
		return dao;
	}
	
	//1.아이디 중복체크
	public Boolean idCheck(String mid) {
		String wql="select*from member where mid=?";
		
		try {
			ps=con.prepareStatement(wql);
			ps.setString(1, mid);
			rs=ps.executeQuery(); //셀렉트는쿼리 ->rs는 무조건임
			
			if(rs.next()) {return true;}  //만약에 레코드가 있으면 트로 = 이미 아이디가 있다
			else {
				return false; // 레코드가 없으면 펄스 = 같은 아이디가 없다
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		}
	}
	
	//2.회원가입
	public int signup(MemberDto dto) {
		String sql="insert into member(mid,mpw,mname,mphone) value(?,?,?,?)";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpw());
			ps.setString(3, dto.getMname());
			ps.setString(4, dto.getMphone());
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 3;
		}
	}
	
	
	//3. 로그인[반환 : 로그인 성공한 회원번호 반환]
		//-로그인[로그인이 되어있는동안 저장되는공간] 1. 회원번호 2.logindto [회원번호,]
	public int login(String mid,String mpw) {
		String sql="select*from member where mid=? and mpw=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpw);
			rs=ps.executeQuery();
			if(rs.next()) {
				//만약에 다음 레코드가 존재하면 즉 로그인 성공
				return rs.getInt(1);
			}else {
				return rs.getInt(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
		
	}

}
