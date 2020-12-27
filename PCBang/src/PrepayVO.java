
public class PrepayVO {

	private String loginTime;
	private String userId;
	private String prepayBool;
	private int prepayTime;
	
	public PrepayVO() {
		
	}
	
	public PrepayVO(String user_id) {
		this.userId = user_id;
	}
	public PrepayVO(int prepay_time) {
		this.prepayTime = prepay_time;
	}
	
	public PrepayVO(String user_id, String prepay_bool, int prepay_time) {
		
		this.userId = user_id;
		this.prepayBool = prepay_bool;
		this.prepayTime = prepay_time;
	}
	
	public PrepayVO(String login_time, String user_id, String prepay_bool, int prepay_time) {
		this(user_id, prepay_bool, prepay_time);
		this.loginTime = login_time;
	}
	
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPrepayBool() {
		return prepayBool;
	}
	public void setPrepayBool(String prepayBool) {
		this.prepayBool = prepayBool;
	}
	public int getPrepayTime() {
		return prepayTime;
	}
	public void setPrepayTime(int prepayTime) {
		this.prepayTime = prepayTime;
	}
	
	

}
