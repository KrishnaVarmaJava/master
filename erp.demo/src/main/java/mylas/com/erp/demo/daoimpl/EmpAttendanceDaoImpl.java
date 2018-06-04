package mylas.com.erp.demo.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import mylas.com.erp.demo.TblDepartment;
import mylas.com.erp.demo.TblEmpAttendanceNew;
import mylas.com.erp.demo.TblEmpLeavereq;
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
		
		emp.setStatas(status);
		 	session.update(emp);
		 	tx2.commit();
		 	System.out.println("updated table");
		 	
	}

	@Override
	public String delete(int id) {
		buildSessionFactory();
		
		Session session = fact.openSession();
		Transaction tx = session.beginTransaction();
		TblEmpAttendanceNew empdel = session.load(TblEmpAttendanceNew.class, id);
		session.delete(empdel);
        tx.commit();
        System.out.println("Object Deleted successfully.....!!");
        session.close();
        fact.close();
        return "Object Deleted successfully.....!!";
    
	}

	@Override
	public List<TblEmpAttendanceNew> getDetails() {
		// TODO Auto-generated method stub
		Configuration con = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory fact = con.buildSessionFactory();
		Session session = fact.openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("from TblEmpAttendanceNew");
		List<TblEmpAttendanceNew> empatt = q.list();
		System.out.println("view Called");
		return empatt;
	
	}

	@Override
	public List<TblEmpAttendanceNew> viewbyid(String empid) {
		String sqlquery = "SELECT * FROM tbl_emp_attendance_new WHERE empid ='"+empid+"'";
		Configuration con = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory fact = con.buildSessionFactory();
		Session session = fact.openSession();
		Transaction tx = session.beginTransaction();
		List<TblEmpAttendanceNew> map = null;

			SQLQuery query = session.createSQLQuery(sqlquery);
			query.addEntity(TblEmpAttendanceNew.class);
			List<TblEmpAttendanceNew> EmpAtt = query.list();
			
		return EmpAtt;
	}



}
