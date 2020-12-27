
public class CustomerVO {
private String userId;
private String userPassword;
private String userName;
private String tel;
private String email;
private String addr;
private String loginTime;
private String logoutTime;

	public CustomerVO() {
		
	}
	
	public CustomerVO(String user_id, String user_password, String user_name, String tel, String email, String addr) {
		this.userId = user_id;
		this.userPassword = user_password;
		this.userName = user_name;
		this.tel = tel;
		this.addr = addr;
		
	}
	
	public CustomerVO(String user_id, String user_password, String user_name, String tel, String email, String addr, String login_time, String logout_time) {
		this.userId = user_id;
		this.userPassword = user_password;
		this.userName = user_name;
		this.tel = tel;
		this.addr = addr;
		this.loginTime = login_time;
		this.logoutTime = logout_time;
	}
	
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}

	
	
	
}
