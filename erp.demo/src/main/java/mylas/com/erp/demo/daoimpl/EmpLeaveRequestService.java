package mylas.com.erp.demo.daoimpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

import mylas.com.erp.demo.EmpDetails;
import mylas.com.erp.demo.TblEmpLeavereq;
import mylas.com.erp.demo.appservices.GetSession;
import mylas.com.erp.demo.dao.EmpLeaveRequestDao;


@Repository("empleavereq")
public class EmpLeaveRequestService implements EmpLeaveRequestDao {




	@Override
	public void save(TblEmpLeavereq empleave) {
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(empleave);
		System.out.println("Request Saved");
		session.getTransaction().commit();
	}

	@Override
	public List<TblEmpLeavereq> view() {
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query q = session.createQuery("from TblEmpLeavereq");
		List<TblEmpLeavereq> empleave = q.list();
		System.out.println("view Called");
		session.getTransaction().commit();
		return (empleave);
	}

	@Override
	public List<TblEmpLeavereq> viewbyid(String empid) {
		String sqlquery = "SELECT * FROM tbl_emp_leavereq WHERE employeeid ='"+empid+"'";
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<TblEmpLeavereq> map = null;
		SQLQuery query = session.createSQLQuery(sqlquery);
		query.addEntity(TblEmpLeavereq.class);
		List<TblEmpLeavereq> leaves = query.list();
		session.getTransaction().commit();
		return leaves;

	}
	public List<TblEmpLeavereq> viewbyManagerid(String mgrid){
		String sqlquery = "SELECT * FROM tbl_emp_leavereq WHERE managerid ='"+mgrid+"'";
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<TblEmpLeavereq> map = null;

		SQLQuery query = session.createSQLQuery(sqlquery);
		query.addEntity(TblEmpLeavereq.class);
		List<TblEmpLeavereq> leaves = query.list();
		session.getTransaction().commit();
		return leaves;

	}
	public List<TblEmpLeavereq> viewbyStatusid(Boolean statusid){
		String sqlquery = "SELECT * FROM tbl_emp_leavereq WHERE status ='"+statusid+"'";
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<TblEmpLeavereq> map = null;

		SQLQuery query = session.createSQLQuery(sqlquery);
		query.addEntity(TblEmpLeavereq.class);
		List<TblEmpLeavereq> leaves = query.list();
		System.out.println("list according to status");
		session.getTransaction().commit();
		return leaves;

	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub

	}

	@Override
	public TblEmpLeavereq view(int id) {
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		TblEmpLeavereq empleave = session.load(TblEmpLeavereq.class, id);
		session.getTransaction().commit();
		return empleave;
	}

	@Override
	public String delete(int id) {
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		TblEmpLeavereq empleave = session.load(TblEmpLeavereq.class, id);
		session.delete(empleave);
		System.out.println("Object Deleted successfully.....!!");
		session.getTransaction().commit();
		return "Deleted_Entry!";
	}

	@Override
	public String update(int id, String reason, boolean status) {
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		TblEmpLeavereq empleave = session.load(TblEmpLeavereq.class, id);
		empleave.setReason(reason);
		empleave.setStatus(status);
		session.update(empleave);
		session.getTransaction().commit();
		System.out.println("updated table");
		return "Request";
	}

	@Override
	public String updatetransManager(int id,String transmanid) {
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		TblEmpLeavereq employe = session.load(TblEmpLeavereq.class, id);
		employe.setMantrans(transmanid);
		try {
			session.update(employe);session.getTransaction().commit();return "Updated";
		}catch(Exception e){session.getTransaction().commit();return "error occured while updating";}

	}

	@Override
	public String ChangeManager(int id) {
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		TblEmpLeavereq employe = session.load(TblEmpLeavereq.class, id);
		employe.setMantrans(null);
		try {
			session.update(employe);session.getTransaction().commit();return "Updated";
		}catch(Exception e){session.getTransaction().commit();return "error occured while updating";}

	}

}
