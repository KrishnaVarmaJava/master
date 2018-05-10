package mylas.com.erp.demo.dao;

import mylas.com.erp.demo.EmpDetails;

public interface EmployeeDao {
	
	public void getConnection(EmpDetails emp);
	public void getDetails(EmpDetails emp);
	public void updateDetails(EmpDetails emp);
	public void deleteDetails(EmpDetails emp);

}
