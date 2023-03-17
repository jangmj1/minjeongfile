package model.dao;

import java.sql.SQLException;
import java.sql.Statement;
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
			ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS); //pk값 꺼내오기
						
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpwd());
			ps.setString(3, dto.getMemail());
			ps.setString(4, dto.getMimg());
			ps.executeUpdate(); 
			rs=ps.getGeneratedKeys(); //방금 생성된 pk값을 ps로 받아서 rs에 담기
			if(rs.next()) {
				int pk=rs.getInt(1);
				setPoint("회원가입축하", 100,pk );
					}
			
			//포인트 지급[내용 , 개수 , 방금 회원 가입한 회원번호의 pk]
			/*
			   1.insert 이후에 자동으로 생성된 auto key 찾기
			  ps=con.prepareStatement(sql) 을 ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS); 로변경
			  												             --------- 이거import는 sql껄로 쓰기
			 */
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
	}
	
	
	//멤버 출력함수
	public ArrayList<MemberDto>getMemberList(int startrow,int listsize,String key,String keyword,int type ) {
		ArrayList<MemberDto> list=new ArrayList<>();
		
		String sql="";
		
		if(type==1) {
			 sql="select * from member limit ?,?;"; //sql 명령어 작성
			 try {
					ps=con.prepareStatement(sql); //연결된 con에 sql대입해서 ps
					ps.setInt(1, startrow);
					ps.setInt(2, listsize);
					rs=ps.executeQuery();	//sql실행후 결과 rs담고
					
					while (rs.next()) {	//rs.next : 다음레코드 [t/f]
						MemberDto dto=new MemberDto(rs.getInt(1), rs.getString(2), 
								rs.getString(3), rs.getString(4), rs.getString(5));
						list.add(dto); //dto 리스트에 담기
						
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}else if(type==2){
			sql="select * from member where "+key+ "='"+keyword+"'" ;
			try {
				ps=con.prepareStatement(sql); //연결된 con에 sql대입해서 ps
				rs=ps.executeQuery();	//sql실행후 결과 rs담고
				
				if (rs.next()) {	//rs.next : 다음레코드 [t/f]
					MemberDto dto=new MemberDto(rs.getInt(1), rs.getString(2), 
							rs.getString(3), rs.getString(4), rs.getString(5));
					list.add(dto); //dto 리스트에 담기
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("리스트"+list);
		return list;
		
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
	
	
	//5. 특정 회원 1명 찾기 = 아이디에 해당하는 회원정보 호출
	public MemberDto getMember(String mid){
		String sql="select m.mno , m.mid, m.mimg, m.memail ,sum(p.mpamount)as mpoint "
				+ "from member m, mpoint p "
				+ "where m.mno=p.mno and m.mid=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, mid);
			rs=ps.executeQuery();
			if(rs.next()) { //검색 성공하든 실패하든 무조건 하나는 나온다 성공하면 객체값, 실패하면 null
				MemberDto dto=new MemberDto(rs.getInt(1), rs.getString(2),
						null, rs.getString(3), rs.getString(4)); //비밀번호는 가져오면안되서 null
				dto.setMpoint(rs.getInt(5));
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
	
	
	//8.포인트 함수[1. 지급 내용 2. 지급개수 3.대상]
	public boolean setPoint(String content, int point , int mno) {
		String sql="insert into mpoint(mpcomment ,mpamount ,mno) value (?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, content);
			ps.setInt(2, point);
			ps.setInt(3, mno);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
	}
	
	//9.회원탈퇴[인수 : mid , 반환 : 성공,실패]
	public boolean delete(String mid,String mpwd) {
		String sql="delete from member where mid=? and mpwd=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpwd);
			int count=ps.executeUpdate(); //삭제된 레코드 갯수,,  executeUpdate반환값이 인트이다
			if(count==1) { //레코드1개삭제 성공시 true
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}return false;
		
	}
	
	
	//10.회원수정[인수 : mid, mpawd, memail 만 수정하게 , 반환 : 성공 실패]
	public boolean update(String mid,String mpwd,String newpwd ,String memail,String newmimg ) {
		String sql="update member set mpwd=?,memail=?,mimg=? where mid=? and mpwd=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, newpwd);
			ps.setString(2, memail);
			ps.setString(3, newmimg);
			ps.setString(4, mid);
			ps.setString(5, mpwd);
			int count=ps.executeUpdate();
			if(count==1) {//수정된 레코드 수가 반환
				return true; // 레코드1개 수정 성공시 true
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
	}
	
	//11 회원 아이디로 회원 넘버를 반환하는 함수 , 사실 5번 함수를 사용해도됨
	public int getMno(String mid) {
		String sql="select mno from member where mid=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, mid);
			rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
