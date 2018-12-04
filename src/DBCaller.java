import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCaller {
		Connection con;
		Statement stmt;
		
		
	public DBCaller() throws SQLException {
		
		
		String url = "jdbc:mysql://localhost/project?characterEncoding=UTF-8&serverTimezone=UTC";
		
		con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결중");
			con = DriverManager.getConnection(url,"root","rjsgml919");
			System.out.println("성공");
		}catch(ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}catch(SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}
		
		stmt = con.createStatement();
		
	}
}
