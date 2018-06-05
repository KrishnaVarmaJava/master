package mylas.com.erp.demo.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;

import mylas.com.erp.demo.EmpDetails;
import mylas.com.erp.demo.dao.EmployeeDao;

@Repository("userDetails")
public class Client implements EmployeeDao {

	


	public String getConnection(EmpDetails emp) {
		Configuration con = new Configuration().configure("hibernate.cfg.xml");
		Integer num = 0;
		SessionFactory fact = con.buildSessionFactory();
		Session session = fact.openSession();
		Transaction tx = session.beginTransaction();
		try {
		num = (Integer) session.save(emp);
		tx.commit();
		if(num!=0) {
			System.out.println("Table Updated");
			session.close();
			return "Employee Saved";
		}else {
			System.out.println("Table Faied to Update");
			session.close();
		}
		
		}catch(ConstraintViolationException e) {
			System.out.println("Duplicate Entry");
			session.close();
			return "This is a Duplicate Entry";
		}
		session.close();
		return null;
	}

	@Override
	public List<EmpDetails> getDetails() {
		Configuration con = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory fact = con.buildSessionFactory();
		Session session = fact.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from EmpDetails");
		List<EmpDetails> emp1 = q.list();
		session.close();
		return (emp1);
		

	}

	public void closeAllSessions() {
		Configuration con = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory fact = con.buildSessionFactory();
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
		session.close();

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

		SessionFactory fact = con.buildSessionFactory();
		Session session = fact.openSession();
		Transaction tx = session.beginTransaction();
		user =  session.load(EmpDetails.class, id);
		
		tx.commit();
		return user;
		
	}


	@Override
	public EmpDetails getByUName(String empuname) {
		Configuration con = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory fact = con.buildSessionFactory();
		Session session = fact.openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("from EmpDetails");
		List<EmpDetails> emp1 = q.list();
		System.out.println("load session");
		for(EmpDetails user : emp1) {
			System.out.println(user.getUname());
			if(user.getUname().equals(empuname)) {
			 return user;	
			}
		}
		session.close();
		tx.commit();
		return null;
		
	}






}
