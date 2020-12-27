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
	
	
	
	public int joinMatchCustomer(String userId) { //회원가입 중복확인
		int result = 0;
		try {
			getConn(); //연결함
			String sql = "select user_id from customer where user_id=?"; //DB안에 같은 아이디가 있으면 선택함
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, userId); //입력한 아이디 넣기
			rs = pstmt.executeQuery(); //실행
			if(rs.next()) { //결과가 있으면 result를 1씩 올려서 결과수만큼 보여주기
				++result;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			getClose();
		}return result; 
		
	}

	
	
	public int insertCustomer(CustomerVO vo) { //회원가입
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
			//아이디, 비밀번호, 실명, 전화번호, 이메일, 주소
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
