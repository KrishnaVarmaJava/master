package mylas.com.erp.demo.dao;

import java.util.List;

import mylas.com.erp.demo.dto.Employee;

public interface EmployeeDao {

	public void save(Employee employee);
	
	public void getByID(Employee employee);
	
	public void update(Employee employee);
	
	public void delete(Employee employee);
	
	public List<Employee> getAll();
}
