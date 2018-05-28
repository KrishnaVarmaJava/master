package mylas.com.erp.demo.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import mylas.com.erp.demo.TblEmpAttendanceNew;
import mylas.com.erp.demo.TblEmpAttendanceNewId;
import mylas.com.erp.demo.dao.EmpAttendenceDao;

@Repository("empattdao")
public class EmpAttendanceDaoImpl implements EmpAttendenceDao {

	

	static Session session;
	static SessionFactory fact;

	private static SessionFactory buildSessionFactory() {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml");
		
		fact = con.buildSessionFactory();
		return fact;

	}

	@Override
	public void save(TblEmpAttendanceNew tbl) {
		buildSessionFactory();
		Session session = fact.openSession();
		Transaction tx = session.beginTransaction();
		session.save(tbl);
		
		tx.commit();
		System.out.println("Table Saved");
		
	}

	@Override
	public void update(Boolean status, int id) {
		buildSessionFactory();
		Session session = fact.openSession();
		Transaction tx2 = session.beginTransaction();
		TblEmpAttendanceNew emp = session.load(TblEmpAttendanceNew.class,id);
		TblEmpAttendanceNewId empid = new TblEmpAttendanceNewId(); 
		empid.setStatas(status);
		 	emp.setId(empid);
		 	session.update(emp);
		 	tx2.commit();
		 	System.out.println("updated table");
		 	
	}

	@Override
	public void delete(int id) {
		buildSessionFactory();
		
		Session session = fact.openSession();
		Transaction tx = session.beginTransaction();
		TblEmpAttendanceNew empdel = session.load(TblEmpAttendanceNew.class, id);
		session.delete(empdel);
        System.out.println("Object Deleted successfully.....!!");
        tx.commit();
        session.close();
        fact.close();
    
	}

	@Override
	public void listAll(TblEmpAttendanceNew tbl) {
		buildSessionFactory();
		Session session = fact.openSession();
		Transaction tx = session.beginTransaction();
		tx.commit();
	}

}
