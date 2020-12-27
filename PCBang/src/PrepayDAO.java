import java.sql.SQLException;
import java.util.*;

public class PrepayDAO extends DBConn {

	public PrepayDAO() {

	}

	
	
	public int insertPrepay(PrepayVO pvo) {
		int result = 0;
		try {
			getConn();
			String sql = "insert into prepay(login_time, user_id, prepay_bool, prepay_time) values(sysdate,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pvo.getUserId());
			pstmt.setString(2, pvo.getPrepayBool());
			pstmt.setInt(3, pvo.getPrepayTime());
			
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			getClose();
		}return result;
		
	}
	
	
	public List<PrepayVO> selectPrepay() {
		List<PrepayVO> prepayList = new ArrayList<PrepayVO>();
		try {
			getConn();
			String sql = "select login_time, user_id, prepay_bool, prepay_time from prepay";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				PrepayVO pvo = new PrepayVO();
				pvo.setLoginTime(rs.getString(1));
				pvo.setUserId(rs.getString(2));
				pvo.setPrepayBool(rs.getString(3));
				pvo.setPrepayTime(rs.getInt(4));
				prepayList.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		} return prepayList;

	}
	
	
	
	public int selectPrepayHour() {
		int pHour = 0;
		try {
			getConn();
			String sql = "select prepay_time from prepay where rownum <=1 and user_id=? order by login_time desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, LoginLayout.loginId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pHour = rs.getInt(1);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			getClose();
		}return pHour;
	}
}
