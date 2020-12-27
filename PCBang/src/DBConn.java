import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DBConn {
	//jdbc ����̺� �ε�
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("JDBC Driver �ε� ����-->" + cnfe.getMessage());
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

	
	//DB����
	public void getConn() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException se) {
			System.out.println("DB���ῡ �����߻�-->" + se.getMessage());
		}
	}


//DB�ޱ�
public void getClose() {
	try {
	if(conn!=null) conn.close();
	if(pstmt!=null) pstmt.close();
	if(rs!=null) rs.close();
		} catch (SQLException se) {
			System.out.println("DB�ݱ� �����߻�-->" + se.getMessage());
		}
}

}