package mylas.com.erp.demo.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import mylas.com.erp.demo.dao.EmployeeDao;
import mylas.com.erp.demo.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao{


	private DataSource datasource;
	
	
	
	@Override
	public void save(Employee emp) {
		
		/*String query = "insert into Employee (FirstName, LastName, Email, Address1, Address2, City, state1, Pin ,panCardNum, reasonForTermination, maritalStatus, title, gender, employeeID, pin, aadharCard, hireDate, termDate, dOB) values (emp.getFirstName,emp.getLastName,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";*/
		return;
	}

	@Override
	public void getByID(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
