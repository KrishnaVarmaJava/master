package mylas.com.erp.demobackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import mylas.com.erp.demobackend.dao.EmployeeDao;
import mylas.com.erp.demobackend.dto.Employee;
@Repository("empdao")
public class EmployeeDaoImpl implements EmployeeDao {

	private static List<Employee> emps = new ArrayList<Employee>();
	static{
		
		Employee emp = new Employee();
		emp.setFirstName("Krishna");
		emp.setLastName("Varma");
		emps.add(emp);
		
		emp = new Employee();
		emp.setFirstName("Vaishnavi");
		emp.setLastName("Varma");
		emps.add(emp);
		
		emp = new Employee();
		emp.setFirstName("Lalitha");
		emp.setLastName("Varma");
		emps.add(emp);
		
		
	}
	public java.util.List<Employee> List() {
		// TODO Auto-generated method stub
		return null;
	}

}
