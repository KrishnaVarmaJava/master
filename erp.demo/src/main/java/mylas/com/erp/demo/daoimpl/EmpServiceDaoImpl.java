package mylas.com.erp.demo.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import mylas.com.erp.demo.dao.EmpServicesDao;
import mylas.com.erp.demo.dto.EmpServices;

@Repository("empservicesdao")
public class EmpServiceDaoImpl implements EmpServicesDao{
	
	public static List<EmpServices> services = new ArrayList<EmpServices>();
	static {
		EmpServices empserv = new EmpServices();
		empserv.setActive(true);
		empserv.setServiceID("leave");
		empserv.setServiceName("Leave");
		empserv.setServiceDescription("Employee Can Apply for Leave");
		services.add(empserv);
		
		empserv = new EmpServices();
		empserv.setActive(true);
		empserv.setServiceID("timesheet");
		empserv.setServiceName("TimeSheet");
		empserv.setServiceDescription("Employee Can Apply for Leave");
		services.add(empserv);
	}

	@Override
	public List<EmpServices> list() {
		// TODO Auto-generated method stub
		return services;
	}

}
