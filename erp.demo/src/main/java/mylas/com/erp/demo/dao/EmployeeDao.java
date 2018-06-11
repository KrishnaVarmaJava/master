package mylas.com.erp.demo.dao;

import java.util.List;

import org.hibernate.Query;

import mylas.com.erp.demo.EmpDetails;

public interface EmployeeDao {
	
	public String getConnection(EmpDetails emp);
	public List<EmpDetails> getDetails();
	public void updateDetails(EmpDetails emp, int id);
	public void deleteDetails(int id);
	public EmpDetails getById(int id);
	public EmpDetails getByUName(String empuname);
	public List<EmpDetails> getByManid(String managerid);
	public List<EmpDetails> getByManIdAndTransManId(String managerid,String transmanid);
	public String TransferManager(int id,String mantrans);
	public String ChangeManager(int id);
	
	
}
