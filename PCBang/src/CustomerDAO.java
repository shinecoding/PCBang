import java.sql.SQLException;
import java.util.*;

public class CustomerDAO extends DBConn {

	public CustomerDAO() {
		
	}

	public int loginCustomer(String userId, String userPassword) {
		int result = 0;
		try {
			getConn();
			String sql = "select user_id, user_password from customer where user_id=? and user_password =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPassword);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				++result;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			getClose();
		}return result;
	}
	
	
	
	public int joinMatchCustomer(String userId) { //ȸ������ �ߺ�Ȯ��
		int result = 0;
		try {
			getConn(); //������
			String sql = "select user_id from customer where user_id=?"; //DB�ȿ� ���� ���̵� ������ ������
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, userId); //�Է��� ���̵� �ֱ�
			rs = pstmt.executeQuery(); //����
			if(rs.next()) { //����� ������ result�� 1�� �÷��� �������ŭ �����ֱ�
				++result;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			getClose();
		}return result; 
		
	}

	
	
	public int insertCustomer(CustomerVO vo) { //ȸ������
		int result = 0;
		try {
			getConn();
			String sql = "insert into customer(user_id, user_password, user_name, tel, email, addr, login_time, logout_time) values(?,?,?,?,?,?,sysdate,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getUserPassword());
			pstmt.setString(3, vo.getUserName());
			pstmt.setString(4, vo.getTel());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getAddr());
			pstmt.setString(7, vo.getLogoutTime());
			
			result = pstmt.executeUpdate();
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			getClose();
		}return result;
		
	}
	
	
	public List<CustomerVO> selectCustomer() {
		List<CustomerVO> customerList = new ArrayList<CustomerVO>();

		try {
			getConn();
			String sql = "select user_id, user_password, user_name, tel, email, addr from customer";
			//���̵�, ��й�ȣ, �Ǹ�, ��ȭ��ȣ, �̸���, �ּ�
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				CustomerVO cvo = new CustomerVO();
			cvo.setUserId(rs.getString(1));
			cvo.setUserPassword(rs.getString(2));
			cvo.setUserName(rs.getString(3));
			cvo.setTel(rs.getString(4));
			cvo.setEmail(rs.getString(5));
			cvo.setAddr(rs.getString(6));
			customerList.add(cvo);
			
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			getClose();
		}return customerList;
			
			}
			
}
