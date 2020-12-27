import java.sql.SQLException;
import java.util.*;

public class PrepayDAO2 extends DBConn {

	public PrepayDAO2() {

	}

	public List<PrepayVO> selectPrepay() {
		List<CustomerDAO> customerList = new ArrayList<CustomerDAO>();
		List<OrderDAO> orderList = new ArrayList<OrderDAO>();
		List<PrepayVO> prepayList = new ArrayList<PrepayVO>();
		List<SnackDAO> snackList = new ArrayList<SnackDAO>();
		
		CustomerDAO cDao = new CustomerDAO();
		PrepayDAO pDao = new PrepayDAO();
		OrderDAO oDao = new OrderDAO();
		SnackDAO sDao = new SnackDAO();
		
		
		
		try {
			getConn();
			String sql = "select c.user_id, c.login_time, c.logout_time, c.logout_time-c.login-time as user_hour, p.prepay_bool, p.prepay_time, if prepay_bool!='T' then (c.logout_time-c.login-time) * 1000 else if prepay_bool = 'T'then prepay_time as user_cost from customer c join prepay p on c.user_id = p.user_id join ";
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
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			getClose();
		} return prepayList;

	}
}
