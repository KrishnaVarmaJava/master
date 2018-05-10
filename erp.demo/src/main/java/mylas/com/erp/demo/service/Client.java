package mylas.com.erp.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import mylas.com.erp.demo.EmpDetails;
import mylas.com.erp.demo.dao.EmployeeDao;

public class Client implements EmployeeDao {

	static Session session;
	static SessionFactory sessionFactoryObj;

	private static SessionFactory buildSessionFactory() {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml");
		
		SessionFactory fact = con.buildSessionFactory();
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		sessionFactoryObj = con.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;

	}

	
	public void getConnection(EmpDetails emp) {
			
			Transaction tx = session.beginTransaction();
			Integer num = (Integer) session.save(emp);
			if(num!=0) {
				System.out.println("Table Updated");
			}else {
				System.out.println("Table Faied to Update");
			}
			tx.commit();
	}

	@Override
	public void getDetails(EmpDetails emp) {
		List<EmpDetails> employees = new ArrayList<EmpDetails>();
		String query = "select * from emp_details";
		Transaction tx = session.beginTransaction();
		employees = (List<EmpDetails>) session.createQuery(query);
		
		
	}

	@Override
	public void updateDetails(EmpDetails emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDetails(EmpDetails emp) {
		// TODO Auto-generated method stub
		
	}
	
}
