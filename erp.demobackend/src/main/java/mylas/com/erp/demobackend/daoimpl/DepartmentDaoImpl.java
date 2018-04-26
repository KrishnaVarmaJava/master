package mylas.com.erp.demobackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import mylas.com.erp.demobackend.dao.DepartmentDao;
import mylas.com.erp.demobackend.dto.Department;

public class DepartmentDaoImpl implements DepartmentDao {

	private static List<Department> departments = new ArrayList<Department>();
	
	static {
		
		Department dep = new Department();
		//Adding new Departments
		dep.setId(1);
		dep.setDepName("Finance");
		dep.setDepdescription("This is the Finance Department");
		dep.setActive(true);
		dep.setUrl("//");
		
		departments.add(dep);
		
		dep = new Department();
		//Adding new Departments
		dep.setId(2);
		dep.setDepName("Human Resources");
		dep.setDepdescription("This is the HR Department");
		dep.setActive(true);
		dep.setUrl("//");
		
		departments.add(dep);
		
		dep = new Department();
		//Adding new Departments
		dep.setId(3);
		dep.setDepName("Operation");
		dep.setDepdescription("This is the Operations Department");
		dep.setActive(true);
		dep.setUrl("//");
		
		departments.add(dep);
	}
	
	public List<Department> list() {
		// TODO Auto-generated method stub
		return departments;
	}

}
