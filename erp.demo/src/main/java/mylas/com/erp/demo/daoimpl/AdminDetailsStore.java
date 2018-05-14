package mylas.com.erp.demo.daoimpl;

import java.util.ArrayList;
import java.util.List;

import mylas.com.erp.demo.AdminDetails;
import mylas.com.erp.demo.dao.AdminDao;


public class AdminDetailsStore implements AdminDao{
	
	private static List<AdminDetails> admins = new ArrayList<AdminDetails>();
	
	static {
		AdminDetails admindetails = new AdminDetails();
		admindetails.setAdminID("Admin");
		admindetails.setAdminPswd("admi123");
		admindetails.setRole(false);
		admins.add(admindetails);
		
		admindetails = new AdminDetails();
		admindetails.setAdminID("AdminKrishna");
		admindetails.setAdminPswd("Krishna123");
		admindetails.setRole(false);
		admins.add(admindetails);
	}
	public List<AdminDetails> list() {
		return admins;
	}
	

}
