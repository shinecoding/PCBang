import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DBConn {
	//jdbc 드라이브 로딩
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("JDBC Driver 로딩 에러-->" + cnfe.getMessage());
		}
	}
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##scott";
	String password = "tiger";
	
	public DBConn() {
		
	}

	
	//DB연결
	public void getConn() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException se) {
			System.out.println("DB연결에 에러발생-->" + se.getMessage());
		}
	}


//DB받기
public void getClose() {
	try {
	if(conn!=null) conn.close();
	if(pstmt!=null) pstmt.close();
	if(rs!=null) rs.close();
		} catch (SQLException se) {
			System.out.println("DB닫기 에러발생-->" + se.getMessage());
		}
}

}