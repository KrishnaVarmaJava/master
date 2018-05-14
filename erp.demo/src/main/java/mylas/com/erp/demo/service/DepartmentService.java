package mylas.com.erp.demo.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import mylas.com.erp.demo.TblDepartment;
import mylas.com.erp.demo.dao.DepartmentDao;


public class DepartmentService implements DepartmentDao {
	


	static Session session;
	static SessionFactory fact;

	private static SessionFactory buildSessionFactory() {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml");
		
		fact = con.buildSessionFactory();
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		fact = con.buildSessionFactory(serviceRegistryObj);
		return fact;

	}
	
	
	@Override
	public void saveDepartment(TblDepartment tbl) {
		buildSessionFactory();
		Session session = fact.openSession();
		Transaction tx = session.beginTransaction();
		Integer num = (Integer) session.save(tbl);
		if(num!=0) {
			System.out.println("Table Updated");
		}else {
			System.out.println("Table Faied to Update");
		}
		tx.commit();
		
	}

	@Override
	public List<TblDepartment> getDetails() {
		buildSessionFactory();
		Session session = fact.openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("from TblDepartment");
		List<TblDepartment> emp1 = q.list();
		for(TblDepartment emp2:emp1) {
			System.out.println(emp2.getDepartment());
		}
		return (emp1);
	}

	@Override
	public void updateDetails(TblDepartment tbl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDetails(TblDepartment tbl) {
		// TODO Auto-generated method stub
		
	}

}
