package mylas.com.erp.demo;

public class AdminDetails {
	
	String AdminID;
	String AdminPswd;
	boolean role;
	public String getAdminID() {
		return AdminID;
	}
	public void setAdminID(String adminID) {
		AdminID = adminID;
	}
	public String getAdminPswd() {
		return AdminPswd;
	}
	public void setAdminPswd(String adminPswd) {
		AdminPswd = adminPswd;
	}
	public boolean isRole() {
		return role;
	}
	public void setRole(boolean role) {
		this.role = role;
	}
	public AdminDetails(String adminID, String adminPswd, boolean role) {
		super();
		AdminID = adminID;
		AdminPswd = adminPswd;
		this.role = role;
	}
	public AdminDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
