package mylas.com.erp.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import mylas.com.erp.demo.EmpDetails;
import mylas.com.erp.demo.TblEmpLeavereq;
import mylas.com.erp.demo.dao.EmployeeDao;

public class Client implements EmployeeDao {

	static Session session;
	static SessionFactory fact;

	public static SessionFactory buildSessionFactory() {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml");
		
		fact = con.buildSessionFactory();
		return fact;

	}

	
	public void getConnection(EmpDetails emp) {
			buildSessionFactory();
			Session session = fact.openSession();
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
	public List<EmpDetails> getDetails() {
		buildSessionFactory();
		Session session = fact.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from EmpDetails");
		List<EmpDetails> emp1 = q.list();
		return (emp1);
		
	}
	
	public void closeAllSessions() {
		buildSessionFactory();
		Session session = fact.openSession();
		session.close();
	}

	@Override
	public void updateDetails(EmpDetails empl,int id) {
		// TODO Auto-generated method stub
		Configuration con = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory fact = con.buildSessionFactory();
		Session session = fact.openSession();
		Transaction tx2 = session.beginTransaction();
		EmpDetails emp = session.load(EmpDetails.class,id);
	
		 	
		 	emp.setCompName(empl.getCompName());

		 	session.update(emp);
		 	tx2.commit();
		 	System.out.println("updated table");
		 	
		
	}



	@Override
	public void deleteDetails(int id) {
		// TODO Auto-generated method stub
		Configuration con = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory fact = con.buildSessionFactory();
		Session session = fact.openSession();
		Transaction tx = session.beginTransaction();
		EmpDetails empdel = session.load(EmpDetails.class, id);
		session.delete(empdel);
        System.out.println("Object Deleted successfully.....!!");
        tx.commit();
        session.close();
        fact.close();
       // return "Deleted_Entry!";
		
	}


	@Override
	public EmpDetails getById(int id) {
		EmpDetails user;
		buildSessionFactory();
		Session session = fact.openSession();
		user =  session.load(EmpDetails.class,
                id);
		return user;
	}


	@Override
	public EmpDetails getByUName(String empuname) {
		buildSessionFactory();
		Session session = fact.openSession();
		session.load(EmpDetails.class, empuname);
		//System.out.println(user.getFname());
		return null;
	}


	

	
	
}
