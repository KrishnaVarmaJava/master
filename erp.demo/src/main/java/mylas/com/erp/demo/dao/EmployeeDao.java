package mylas.com.erp.demo.dao;

import java.util.List;

import org.hibernate.Query;

import mylas.com.erp.demo.EmpDetails;

public interface EmployeeDao {
	
	public void getConnection(EmpDetails emp);
	public List<EmpDetails> getDetails();
	public void updateDetails(EmpDetails emp);
	public void deleteDetails(int id);
	public EmpDetails getById(int id);
	public EmpDetails getByUName(String empuname);
	public List getEmpDetails();
}
