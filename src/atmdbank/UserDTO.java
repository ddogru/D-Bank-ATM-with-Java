package atmdbank;


public class UserDTO {

	private String userName ;
	private String userSurname;
	private int userID;
	private int userPass;
	private float userBalance;
	private int userIBAN;
	
	
	UserDTO(String userName,String userSurname,int userID, int userPass,float userBalance,int userIBAN){
		
		this.userName = userName;
		this.userSurname = userSurname;
		this.userID = userID;
		this.userPass = userPass;
		this.userBalance = userBalance;
		this.userIBAN = userIBAN;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return this.userName;
	}
	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}
	public String getUserSurname() {
		return this.userSurname;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getUserID() {
		return this.userID ;
	}
	public void setUserPass(int userPass) {
		this.userPass= userPass;
	}
	public int getUserPass() {
		return this.userPass;
	}
	public void setUserBalance(float userBalance) {
		this.userBalance = userBalance;
		
	}
	public float getUserBalance() {
		return this.userBalance;
	}
	public void setUserIBAN(int userIBAN) {
		
		this.userIBAN = userIBAN;
	}
	public int getUserIBAN() {
		
		return this.userIBAN;
	}
	
	public String toString() {
		
		return this.userName+","+this.userSurname+","+this.userID+","+this.userPass+","+this.userBalance+
				","+this.userIBAN;
	}
	
}
