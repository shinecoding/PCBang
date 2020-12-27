import java.sql.SQLException;
import java.util.*;

public class SnackDAO extends DBConn {

	public SnackDAO() {
		
	}

	
	public List<SnackVO> selectSnack(){
		List<SnackVO> snackList = new ArrayList<SnackVO>();
	try {	
		getConn();
		String sql = "select snack_code, snack_name, snack_price, to_char(snack_date, 'MM-DD') snack_date from snack order by snack_code";
		pstmt = conn.prepareStatement(sql);
	
		//½ÇÇà
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			SnackVO svo = new SnackVO();
			svo.setSnackCode(rs.getInt(1));
			svo.setSnackName(rs.getString(2));
			svo.setSnackPrice(rs.getInt(3));
			svo.setSnackDate(rs.getString(4));
			
			snackList.add(svo);
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		getClose();
	}return snackList;
	
	}
}
