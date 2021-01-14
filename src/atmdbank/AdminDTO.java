package atmdbank;


public class AdminDTO {

	private String adminName ;
	private String adminSurname;
	private int adminID;
	private int adminPass;
	
	
	AdminDTO(String adminName,String adminSurname,int adminID, int adminPass){
		
		this.adminName = adminName;
		this.adminSurname = adminSurname;
		this.adminID = adminID;
		this.adminPass = adminPass;
		
	}
	
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminName() {
		return this.adminName;
	}
	public void setAdminSurname(String adminSurname) {
		this.adminSurname = adminSurname;
	}
	public String getAdminSurname() {
		return this.adminSurname;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public int getAdminID() {
		return this.adminID ;
	}
	public void setAdminPass(int adminPass) {
		this.adminPass= adminPass;
	}
	public int getAdminPass() {
		return this.adminPass;
	}
	
	public String toString() {
		
		return this.adminName+"," +this.adminSurname+"," +this.adminID+","+this.adminPass;
				
	}
	
}



