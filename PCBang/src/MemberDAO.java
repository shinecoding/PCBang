import java.sql.SQLException;
import java.util.*;

public class MemberDAO extends DBConn {

	public MemberDAO() {

	}

	// 레코드 추가
	public int insertRecord(MemberVO vo) {
		int result = 0;
		try {
		getConn();
			String sql = "insert into member(user_id, user_password, user_name, tel, email, addr) values (?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getUserPassword());
			pstmt.setString(3, vo.getUserName());
			pstmt.setString(4, vo.getTel());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getAddr());
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			getClose();
		} return result;
	}
	
	

	// 레코드 수정
	public int editRecord(MemberVO vo) {
		int result = 0;
		try {
			getConn();
			String sql = "update member set user_password=?, user_name=?, tel=?, email=?, addr=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserPassword());
			pstmt.setString(2, vo.getUserName());
			pstmt.setString(3, vo.getTel());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getAddr());
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			getClose();
		} return result;
	}

	// 레코드 삭제
	public int deleteRecord(String userId) {
		int result = 0;
		try {
			getConn();
			String sql = "delete from member where user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			result = pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			getClose();
		} return result;
	}

	// 레코드 전체 셀렉
	public List<MemberVO> selectRecord() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			getConn();
			String sql = "select user_id, user_password, user_name, tel, email, addr, login_time, logout_time from member";
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			getClose();
		} return list;
	}

}
