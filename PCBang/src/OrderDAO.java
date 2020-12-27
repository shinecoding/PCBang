import java.sql.SQLException;
import java.util.*;

public class OrderDAO extends DBConn{

	public OrderDAO() {
		
		
	}
	
	public List<OrderVO> selectOrder(){
		List<OrderVO> orderList = new ArrayList<OrderVO>();
		try {
			getConn();
		String sql = "select order_code, user_id, snack_code, quantity, to_char(order_date, 'MM-DD HH24:MI:SS'), order_bool from order_snack";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			OrderVO ovo = new OrderVO();
			ovo.setOrderCode(rs.getString(1));
			ovo.setUserId(rs.getString(2));
			ovo.setSnackCode(rs.getInt(3));
			ovo.setQuantity(rs.getInt(4));
			ovo.setOrderDate(rs.getString(5));
			ovo.setOrderBool(rs.getString(6));
			orderList.add(ovo);
		}
		
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			getClose();
		}return orderList;
	}

}
