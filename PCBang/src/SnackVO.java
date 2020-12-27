
public class SnackVO {
private int snackCode;
private String snackName;
private int snackPrice;
private String snackDate;

	public SnackVO() {
		
	}
	public SnackVO(int snack_code, String snack_name, int snack_price) {
		this.snackCode = snack_code;
		this.snackName = snack_name;
		this.snackPrice = snack_price;
	}
	
	public SnackVO(int snack_code, String snack_name, int snack_price, String snack_date) {
		this(snack_code, snack_name, snack_price);
		this.snackDate = snack_date;
	}
	
	public int getSnackCode() {
		return snackCode;
	}
	public void setSnackCode(int snackCode) {
		this.snackCode = snackCode;
	}
	public String getSnackName() {
		return snackName;
	}
	public void setSnackName(String snackName) {
		this.snackName = snackName;
	}
	public int getSnackPrice() {
		return snackPrice;
	}
	public void setSnackPrice(int snackPrice) {
		this.snackPrice = snackPrice;
	}
	public String getSnackDate() {
		return snackDate;
	}
	public void setSnackDate(String snackDate) {
		this.snackDate = snackDate;
	}
	
	
	

}
