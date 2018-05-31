package mylas.com.erp.demo.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import mylas.com.erp.demo.EmpDetails;
import mylas.com.erp.demo.dao.EmployeeDao;

@Repository("userDetails")
public class Client implements EmployeeDao {

	static Session session;
	static SessionFactory fact;


	public void getConnection(EmpDetails emp) {
		Configuration con = new Configuration().configure("hibernate.cfg.xml");

		fact = con.buildSessionFactory();
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
		Configuration con = new Configuration().configure("hibernate.cfg.xml");

		fact = con.buildSessionFactory();
		Session session = fact.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from EmpDetails");
		List<EmpDetails> emp1 = q.list();
		return (emp1);

	}

	public void closeAllSessions() {
		Configuration con = new Configuration().configure("hibernate.cfg.xml");

		fact = con.buildSessionFactory();
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
		Configuration con = new Configuration().configure("hibernate.cfg.xml");

		fact = con.buildSessionFactory();
		Session session = fact.openSession();
		user =  session.load(EmpDetails.class,
				id);
		return user;
	}


	@Override
	public EmpDetails getByUName(String empuname) {
		System.out.println("in getbyname method");
		Configuration con = new Configuration().configure("hibernate.cfg.xml");
		System.out.println("cfg file");
		SessionFactory fact = con.buildSessionFactory();
		System.out.println("built session");
		Session session = fact.openSession();
		System.out.println("open sesion");
		Query q = session.createQuery("from EmpDetails");
		List<EmpDetails> emp1 = q.list();
		System.out.println("load session");
		for(EmpDetails user : emp1) {
			System.out.println(user.getUname());
			if(user.getUname().equals(empuname)) {
			 return user;	
			}
		}
		return null;
		
	}






}
