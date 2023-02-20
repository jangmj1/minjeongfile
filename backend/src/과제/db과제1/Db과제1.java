package 과제.db과제1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

public class Db과제1 {
	public static void main(String[] args) {
		
		
		Scanner scanner=new Scanner(System.in);
		Connection con=null;
		
		while (true) {
			try {
				System.out.println("1.db 연결 2. sql문구작성  3. 매개변수입력");
				int ch=scanner.nextInt();
				if(ch==1) {
					System.out.println("연동할 db 명 선택 : ");
					String Dbname=scanner.next();
					System.out.println(Dbname+"에 연결합니다");
					
					//연동하기
					con=DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/"+Dbname,"root","1234");
					
				}else if (ch==2) {
					System.out.println("--생성할 table sql 입력:");
					scanner.nextLine();
					String sql=scanner.nextLine();
					
					PreparedStatement ps=con.prepareStatement(sql);
					
					ps.execute();
				}else if (ch==3) {
					System.out.println("번호:"); int no=scanner.nextInt();
					System.out.println("제품명:"); String pname=scanner.next();
					System.out.println("제품설명"); String pcon=scanner.next();
					System.out.println("제품금액");	int price=scanner.nextInt();
					
					String sql="insert into product values(?,?,?,?);";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1, no);
					ps.setString(2, pname);
					ps.setString(3, pcon);
					ps.setInt(4, price);
					
					ps.execute();
					
					
					
				}
				
			}catch (InputMismatchException e) {
				System.out.println("알수없는 번호 입니다");
				scanner=new Scanner(System.in);
				
			} catch(SQLException e) {
				System.out.println("sql오류:"+e);
			}catch (Exception e) {
				System.out.println("db연결후 다시 실행");
			}
			
		}
		
		
		
	}
}
