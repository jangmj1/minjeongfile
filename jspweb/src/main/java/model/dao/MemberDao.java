package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.MemberDto;

public class MemberDao extends Dao{
	
	private static MemberDao dao=new MemberDao();
	
	private MemberDao() {
		// TODO Auto-generated constructor stub
	}

	public static MemberDao getInstance() {
		return dao;
	}


	//회원가입
	public boolean signup(MemberDto dto) {
		
		String sql="insert into member(mid,mpwd,memail,mimg) values (?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
						
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpwd());
			ps.setString(3, dto.getMemail());
			ps.setString(4, dto.getMimg());
			ps.executeUpdate(); return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
	}
	
	
	
	public ArrayList<MemberDto>getMemberList() {
		ArrayList<MemberDto> list=new ArrayList<>();
		
		String sql="select * from member"; //sql 명령어 작성
		
		try {
			ps=con.prepareStatement(sql); //연결된 con에 sql대입해서 ps
			rs=ps.executeQuery();	//sql실행후 결과 rs담고
			
			while (rs.next()) {	//rs.next : 다음레코드 [t/f]
				MemberDto dto=new MemberDto(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), rs.getString(5));
				list.add(dto); //dto 리스트에 담기
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return list;
	}
	
	public boolean idCheck(String mid) {
		
		String sql="select * from member where mid=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, mid);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				return true; //만약에 검색 결과가 있으면 아이디중복이다
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false; //만약에 검색 결과가 없으면 중복이 아니다
		
	}
	
	public boolean login(String mid, String mpwd) {
		String sql="select * from member where mid=? and mpwd=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpwd);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
	}
	
	
	
	public MemberDto getMember(String mid){
		String sql="select*from member where mid=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, mid);
			rs=ps.executeQuery();
			if(rs.next()) {
				MemberDto dto=new MemberDto(rs.getInt(1), rs.getString(2),
						null, rs.getString(4), rs.getString(3)); //비밀번호는 가져오면안되서 null
				return dto; //로그인 하면 정보가 비번빼고 넘어감
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return null; //없다
		
		
		
		
	}
	
	//아이디찾기함수
	public String findid(String memail) {
		
		String sql="select mid from member where memail=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, memail);
			rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "false";
		
	}

	//비밀번호찾기함수
	public String findpwd(String memail,String mid, String updatepwd ) {
		String sql="select mno from member where memail=? and mid=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, memail);
			ps.setString(2, mid);
			rs=ps.executeQuery();
			if(rs.next()) {
				sql="update member set mpwd=? where mno=?" ; // 비밀번호가 나오면! 회원 정보가 있으면..
				ps=con.prepareStatement(sql);
				ps.setString(1, updatepwd);
				ps.setInt(2, rs.getInt(1));
				int result=ps.executeUpdate(); //업데이트한 레코드 개수 반환
				if(result==1) { // 업데이트 한 레코드가 1개이면
					new MemberDto().sendEmail(memail, updatepwd);
					return "true";
				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "false";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
