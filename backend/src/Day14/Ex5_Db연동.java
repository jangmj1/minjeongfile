package Day14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex5_Db연동 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Connection conn=null;//여러 if { } 에서 사용할려고
				
		
		while (true) {
			try {
				System.out.println("1.db 연결  2.SQL구문 삽입: 3.매개변수 구문삽입");
				int ch=scanner.nextInt();
				if(ch==1) {
					System.out.println("연동할 db 명 선택 : ");
					String dbname=scanner.next();
					System.out.println(dbname+"에 연결 합니다");
					
					//연동하기
					conn=DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/"+dbname,"root","1234");
							
							
					
				}else if (ch==2) {
					System.out.println("--생성할 table sql 입력 :");
					scanner.nextLine(); //넥스트라인 앞에 다른 next 있ㅇ을경우 오류 방지
					String sql=scanner.nextLine();
					
					//연결된 db 객체에 sql대입[PreparedStatement 매개변수처리]
					PreparedStatement ps =conn.prepareStatement(sql);
					
					//실행
					ps.execute();
					
					
				}
				
				else if (ch==3) {
					System.out.println("번호:"); int mno=scanner.nextInt();
					System.out.println("아이디:"); String mid=scanner.next();
					System.out.println("비번:");	String mpw=scanner.next();
					//* sql 구문 작성 [?:변수가 들어갈 자리 뜻]
					String sql="insert into member values(?,?,?);";
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setInt(1, mno); // 1: sql 구문에서 첫번쨰 ? 자리
					ps.setString(2, mid);
					ps.setString(3, mpw);
					
					ps.execute();
					
				}
			}
			catch (InputMismatchException e) {
				System.out.println("알수없는 번호입니다");
				scanner=new Scanner(System.in);
				
			}catch (SQLException e) {
				System.out.println("sql 오류 : "+e);
			}catch(Exception e) {
				System.out.println("db연결후 다시 실행");
			}
		}
	}

}
