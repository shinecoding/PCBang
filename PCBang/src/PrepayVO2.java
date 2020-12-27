
public class PrepayVO2 {

	
	private String userId;
	private String loginTime;
	private String logoutTime;
	private int userHour; //���
	private String prepayBool;
	private int prepayTime;
	private int userCost; //���
	private int snackCost; //���
	private int totalCost; //���
	
	
	//"���̵�", "�α��νð�", "�α׾ƿ��ð�", "�̿�ð�H", "���ҿ���", "���ҽð�", "�̿�ݾ�", "���ıݾ�", "�� �ݾ�"
	public PrepayVO2() {
		
	}
	public PrepayVO2(String user_id, String login_time, String logout_time, int user_hour, String prepay_bool, int prepay_time, int user_cost, int snack_cost, int total_cost) {
		this.userId = user_id;
		this.loginTime = login_time;
		this.logoutTime = logout_time;
		this.userHour = user_hour;
		this.prepayBool = prepay_bool;
		this.prepayTime = prepay_time;
		this.userCost = user_cost;
		this.snackCost = snack_cost;
		this.totalCost = total_cost;
	}
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public int getUserHour() {
		return userHour;
	}
	public void setUserHour(int userHour) {
		this.userHour = userHour;
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
	public int getUserCost() {
		return userCost;
	}
	public void setUserCost(int userCost) {
		this.userCost = userCost;
	}
	public int getSnackCost() {
		return snackCost;
	}
	public void setSnackCost(int snackCost) {
		this.snackCost = snackCost;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	
	
	

}
