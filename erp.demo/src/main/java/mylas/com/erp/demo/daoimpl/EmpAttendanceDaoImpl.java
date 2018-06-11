package mylas.com.erp.demo.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import mylas.com.erp.demo.EmpDetails;
import mylas.com.erp.demo.TblDepartment;
import mylas.com.erp.demo.TblEmpAttendanceNew;
import mylas.com.erp.demo.TblEmpLeavereq;
import mylas.com.erp.demo.appservices.GetSession;
import mylas.com.erp.demo.dao.EmpAttendenceDao;

@Repository("empattdao")
public class EmpAttendanceDaoImpl implements EmpAttendenceDao {




	@Override
	public void save(TblEmpAttendanceNew tbl) {

		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(tbl);

		session.getTransaction().commit();

	}

	@Override
	public void update(Boolean status, int id) {
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		TblEmpAttendanceNew emp = session.load(TblEmpAttendanceNew.class,id);

		emp.setStatas(status);
		session.update(emp);
		session.getTransaction().commit();

	}

	@Override
	public String delete(int id) {


		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		TblEmpAttendanceNew empdel = session.load(TblEmpAttendanceNew.class, id);
		session.delete(empdel);
		session.getTransaction().commit();
		System.out.println("Object Deleted successfully.....!!");

		return "Object Deleted successfully.....!!";

	}

	@Override
	public List<TblEmpAttendanceNew> getDetails() {
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query q = session.createQuery("from TblEmpAttendanceNew");
		List<TblEmpAttendanceNew> empatt = q.list();
		session.getTransaction().commit();
		return empatt;

	}

	@Override
	public List<TblEmpAttendanceNew> viewbyid(String empid) {
		String sqlquery = "SELECT * FROM tbl_emp_attendance_new WHERE empid ='"+empid+"'";
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<TblEmpAttendanceNew> map = null;

		SQLQuery query = session.createSQLQuery(sqlquery);
		query.addEntity(TblEmpAttendanceNew.class);
		List<TblEmpAttendanceNew> EmpAtt = query.list();
		session.getTransaction().commit();	
		return EmpAtt;
	}

	@Override
	public List<TblEmpAttendanceNew> viewbymanagerid(String manpid) {
		String sqlquery = "SELECT * FROM tbl_emp_attendance_new WHERE managerid ='"+manpid+"'";
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery(sqlquery);
		query.addEntity(TblEmpAttendanceNew.class);
		List<TblEmpAttendanceNew> emps = query.list();
		session.getTransaction().commit();
		return emps;
	}

	@Override
	public String updatetransManager(int id, String transmanid) {
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		TblEmpAttendanceNew employe = session.load(TblEmpAttendanceNew.class, id);
		employe.setMantrans(transmanid);
		try {
			session.update(employe);session.getTransaction().commit();return "Updated";
		}catch(Exception e){session.getTransaction().commit();return "error occured while updating";}

	}

	@Override
	public String ChangeManager(int id) {
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		TblEmpAttendanceNew employe = session.load(TblEmpAttendanceNew.class, id);
		employe.setMantrans(null);
		try {
			session.update(employe);session.getTransaction().commit();return "Updated";
		}catch(Exception e){session.getTransaction().commit();return "error occured while updating";}

	}



}
