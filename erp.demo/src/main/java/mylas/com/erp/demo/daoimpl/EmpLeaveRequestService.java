package mylas.com.erp.demo.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;


import mylas.com.erp.demo.TblEmpLeavereq;
import mylas.com.erp.demo.dao.EmpLeaveRequestDao;


@Repository("empleavereq")
public class EmpLeaveRequestService implements EmpLeaveRequestDao {

	Session session;
	SessionFactory fact;

	//public static SessionFactory buildSessionFactory() {
	static {

		Configuration con = new Configuration().configure("hibernate.cfg.xml");		

		ServiceRegistry regObj = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory fact = con.buildSessionFactory(regObj);
		/*return fact;*/

	}

	@Override
	public void save(TblEmpLeavereq empleave) {
		Configuration con = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory fact = con.buildSessionFactory();
		Session session = fact.openSession();
		Transaction tx = session.beginTransaction();
		session.save(empleave);
		session.close();
	}

	@Override
	public List<TblEmpLeavereq> view() {
		Configuration con = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory fact = con.buildSessionFactory();
		Session session = fact.openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("from TblEmpLeavereq");
		List<TblEmpLeavereq> empleave = q.list();
		System.out.println("view Called");
		return (empleave);
	}

	@Override
	public List<TblEmpLeavereq> viewbyid() {
		// TODO Auto-generated method stub
		return null;
	}

}
