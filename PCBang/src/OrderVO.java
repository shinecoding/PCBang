
public class OrderVO {
private String orderCode;
private String userId;
private int snackCode;
private int quantity;
private String orderDate;
private String orderBool;

	public OrderVO() {
		
	}
	
	public OrderVO(String order_code, String user_id, int snack_code, int quantity, String order_date, String order_bool) {
		this.orderCode = order_code;
		this.userId = user_id;
		this.snackCode = snack_code;
		this.quantity = quantity;
		this.orderDate = order_date;
		this.orderBool = order_bool;
	}

	
	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getSnackCode() {
		return snackCode;
	}

	public void setSnackCode(int snackCode) {
		this.snackCode = snackCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderBool() {
		return orderBool;
	}

	public void setOrderBool(String orderBool) {
		this.orderBool = orderBool;
	}

	
	
	
	
}
