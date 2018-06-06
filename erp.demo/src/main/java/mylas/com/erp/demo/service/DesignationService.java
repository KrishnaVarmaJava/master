package mylas.com.erp.demo.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import mylas.com.erp.demo.TblDesignation;
import mylas.com.erp.demo.dao.DesignationDao;

public class DesignationService implements DesignationDao {

	
	static Session session;
	static SessionFactory fact;

	private static SessionFactory buildSessionFactory() {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml");
		
		fact = con.buildSessionFactory();
		return fact;

	}
	
	@Override
	public void saveDetails(TblDesignation tbldesg) {
		buildSessionFactory();
		Session session = fact.openSession();
		Transaction tx = session.beginTransaction();
		Integer num = (Integer) session.save(tbldesg);
		if(num!=0) {
			System.out.println("Table Updated");
		}else {
			System.out.println("Table Faied to Update");
		}
		tx.commit();
		
	}

	@Override
	public List<TblDesignation> getDetails() {
		buildSessionFactory();
		Session session = fact.openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("from TblDesignation");
		List<TblDesignation> emp1 = q.list();
		return (emp1);
	}

	@Override
	public void updateDetails(TblDesignation tbldesg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDetails(int id) {
		// TODO Auto-generated method stub
		buildSessionFactory();
		Session session = fact.openSession();
		Transaction tx = session.beginTransaction();
		TblDesignation desdel = session.load(TblDesignation.class, id);
		session.delete(desdel);
		System.out.println("Object Deleted successfully.....!!");
		tx.commit();
		session.close();
		fact.close();
		
	}



}
