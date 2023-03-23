package 팀프로젝트.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class dao {
	
	ResultSet rs;
	Connection con;
	PreparedStatement ps;
	
	public dao() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jsp_project",
					"root",
					"1234"
					);
			System.out.println("연동완!");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
