package Day15.Ex9_MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberDao {
	//싱글톤 : dao 싱글톤 하는 이유 => db연동 1번만 하려고
	
	//내부에서 객체만들기
	private static MemberDao dto =new MemberDao();
	//2. 생성자는 private-> 외부에서 new 사용금지
	//생성자[연동코드-> 객체 생성시 바로 연동될수 있게 할려고]
	
	private Connection conn;

	private MemberDao() {
		
		try {
			conn=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/day15","root","1234"
					);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	//3.외부에서 내부객체 사용할수 있게 내부객체 반환 메소드[getInstance()]
	public static MemberDao getInstance() {
		return dto;
	}
	
	

	private PreparedStatement ps;
	ResultSet rs;
	
	
	//1.회원가입 메소드 [ 인수 : dto(id,pw) , 반환 : 성공[true] ,실패[false
	Scanner scanner=new Scanner(System.in);
	
/******************************************************************************/	
	public boolean signup(MemberDto dto) {
		String sql="insert into member(mid,mpw)"+"values(?,?)";
		
		//conn :연동된 db
		//ps 를 쓰는이유는 매개변수가 조작이 되니까
	
		try {
			ps=conn.prepareStatement(sql);
				//3.ps는 매개변수에 대한 조작 가능
			
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpw());
				//4.ps 가 sql 실행
			
			ps.executeUpdate();
				//5.결과반환
			return true; //여기까지 문제가 없었으면 저장 성공
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("db오류:"+e);
		}
			return false;// try 에서 문제가 있으면 밖으로 나와서 펄스
	}
/***************************************************************/	
	public ArrayList<MemberDto> list() { //출력함수	
			//여러명의 회원 dto 객체를 저장하기 위한 리스트 선언
		ArrayList<MemberDto>list=new ArrayList<>();
		
		//1. sql 작성
		String sql="select*from member";
		
		//2. 연결된 db에 작성된 sql을 대입
		try {
			
		/*여기서 ps! =>조작가능하게 ..
			conn! =>db와 연결상태
			즉 ! => "select*from member"; 를 대입한 디비연결상태에 넣고 조작가능하게..(?)
		*/
			ps=conn.prepareStatement(sql);
			
			//3.sql조작
				//매개변수 없으면 패스~
			
			//4. sql실행
			rs=ps.executeQuery();//ps가 결과를 실행시키는데 sql결과를 rs 인터페이스에 저장한다
			
			/*
			 * executeUpdate : 수정한걸 업데이트해줘
			 * executeQuery : 보여줘 ! 컨트롤엔터와 같은것
			 */
			
			
			
			//5. sql결과
			//레코드를 -->자바형태로 바꿔야함--->객체 dto // 레코드 1개가->DTO 1개 ->회원1개
			//[DB에서]	[자바에서]	[현실에서]
			
			while (rs.next()) {	//rs.next() : 다음 레코드 이동[없으면 false] =>마지막 행까지 돈다
				
				//자바는 레코드(행)를 못쓰니까 레코드를 객체화 하는중 [rs.get~~~(필드 순서 번호)
				MemberDto dto=new MemberDto(rs.getInt(1), rs.getString(2), rs.getString(3));
				System.out.println("회원마다 :"+dto);
				
				list.add(dto); //1행(레코드) 만들어서 객체화 --next-->2행(레코드) 만들어서 객체화--next-->3행(레코드) 만들어서 객체화
			}
			 return list; //중간로직이 뭔진 모르겠지만 결국엔 list를 Controller로 보낸다 거기서 호출함
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	//비밀번호 수정 무엇을 인수로 받을지 판단[인수 : 누구의 비밀번호를 무엇으로 바꿀것인지 , 반환 : 성공 실패]
/***************************************************************/											//mno ,새로운 newmpw				
	public boolean Update(int mno, String mpw) {
		//1. sql 작성
		String sql="update member set mpw=? where mno=?";
		
		try {
					
			//2. 연결db에 sql 대입
			ps=conn.prepareStatement(sql);
					
			//3. sql 조작
			ps.setString(1, mpw);//첫번째 물음표
			ps.setInt(2, mno);//두번째 물음표
					
			//4. sql 실행
			ps.executeUpdate(); //insert,update,delete->executeUpdate(); =>결과 1개
								//select(db에서 전체출력하는거)->executeQuery(); =>결과여러개
					
			//5. sql결과
			return true;
		} catch (Exception e) {
			System.out.println("db오류 :"+ e);
		}
		
		return false;
		
	}
	
		
/***************************************************************/			
	//4.회원삭제 [인수:누구의 회원을[mno] 삭제할것인가 반환 : 성공 or 실패]
	public boolean delete(int mno) {
		//1.sql작성
			String sql="delete from member where mno=?";
			try {
		//2.연결db에 sql대입
				ps=conn.prepareStatement(sql);
				
		//3.sql조작
				ps.setInt(1, mno);
		//4.sql실행
				ps.executeUpdate();//insert , update , delete 
		//5.sql결과
				return true;
			} catch (Exception e) {
				System.out.println("db오류:"+e);
			}
			return false;
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
