package mylas.com.erp.demo.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import mylas.com.erp.demo.dao.ServicesDao;
import mylas.com.erp.demo.dto.Services;

@Repository("servicesdao")
public class ServicesDaoImpl implements ServicesDao{

	private static List<Services> services = new ArrayList<Services>();
	
	
	static {
		
		Services service = new Services();
		service.setServiceID("regesteremp");
		service.setServiceName("Regester Employees");
		service.setServiceSescription("Regestration Of Employee");
		services.add(service);
		
		service = new Services();
		service.setServiceID("allemp");
		service.setServiceName("All Employees");
		service.setServiceSescription("List Of All the Employee");
		services.add(service);
		
		service = new Services();
		service.setServiceID("empholidays");
		service.setServiceName("Holidays");
		service.setServiceSescription("Holidays for Employee");
		services.add(service);
		
		service = new Services();
		service.setServiceID("empleavereq");
		service.setServiceName("Leave Requests");
		service.setServiceSescription("List Of Employee Leave Requests");
		services.add(service);
		
		service = new Services();
		service.setServiceID("empatt");
		service.setServiceName("Attenedance");
		service.setServiceSescription("List Of Employee Attenedance");
		services.add(service);
		
		service = new Services();
		service.setServiceID("empdep");
		service.setServiceName("Department");
		service.setServiceSescription("List Of Departments");
		services.add(service);
		
		service = new Services();
		service.setServiceID("empdesig");
		service.setServiceName("Designation");
		service.setServiceSescription("Employee Designation List");
		services.add(service);
		
	}
	@Override
	public List<Services> list() {
		// TODO Auto-generated method stub
		return services;
	}

}
