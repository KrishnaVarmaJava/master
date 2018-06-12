package mylas.com.erp.demo.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;

import mylas.com.erp.demo.EmpDetails;
import mylas.com.erp.demo.TblEmpLeavereq;
import mylas.com.erp.demo.appservices.GetSession;
import mylas.com.erp.demo.dao.EmployeeDao;

@Repository("userDetails")
public class Client implements EmployeeDao {

	
	

	public String getConnection(EmpDetails emp) {
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
		int num = (Integer) session.save(emp);
		session.getTransaction().commit();
		if(num!=0) {
			System.out.println("Table Updated");
			return "Employee Saved";
		}else {
			System.out.println("Table Faied to Update");
		}
		
		}catch(ConstraintViolationException e) {
			System.out.println("Duplicate Entry");
			session.getTransaction().commit();return "This is a Duplicate Entry";
		}
		return null;
	}

	@Override
	public List<EmpDetails> getDetails() {
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query q = session.createQuery("from EmpDetails");
		List<EmpDetails> emp1 = q.list();
		session.getTransaction().commit();
		return (emp1);
		

	}

	@Override
	public void updateDetails(EmpDetails empl,int id) {
		// TODO Auto-generated method stub
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		EmpDetails emp = session.load(EmpDetails.class,id);


		emp.setCompName(empl.getCompName());

		session.update(emp);
		session.getTransaction().commit();
		System.out.println("updated table");

	}



	@Override
	public void deleteDetails(int id) {
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		EmpDetails empdel = session.load(EmpDetails.class, id);
		session.delete(empdel);
		System.out.println("Object Deleted successfully.....!!");
		session.getTransaction().commit();
		// return "Deleted_Entry!";

	}


	@Override
	public EmpDetails getById(int id) {
		EmpDetails user;
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		user =  session.get(EmpDetails.class, id);
		session.getTransaction().commit();
		return user;
		
	}


	@Override
	public EmpDetails getByUName(String empuname) {
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query q = session.createQuery("from EmpDetails");
		List<EmpDetails> emp1 = q.list();
		session.getTransaction().commit();
		for(EmpDetails user : emp1) {
			if(user.getUname().equals(empuname)) {
			 return user;	
			}
		}
		
		return null;
		
	}

	@Override
	public List<EmpDetails> getByManid(String managerid) {
		String sqlquery = "SELECT * FROM emp_details WHERE managerid ='"+managerid+"'";
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery(sqlquery);
		query.addEntity(EmpDetails.class);
		List<EmpDetails> emps = query.list();
		session.getTransaction().commit();
		return emps;
	}

	@Override
	public String TransferManager(int id,String mantrans) {
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		EmpDetails employe = session.load(EmpDetails.class, id);
		employe.setMantrans(mantrans);
		try {
			session.update(employe);session.getTransaction().commit();return "Updated";
		}catch(Exception e){session.getTransaction().commit();return "error occured while updating";}
		
	}

	@Override
	public List<EmpDetails> getByManIdAndTransManId(String managerid, String transmanid) {
		String sqlquery = "SELECT * FROM emp_details WHERE managerid ='"+managerid+"' AND mantrans='"+transmanid+"'";
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery(sqlquery);
		query.addEntity(EmpDetails.class);
		List<EmpDetails> emps = query.list();
		session.getTransaction().commit();
		return emps;
	}

	@Override
	public String ChangeManager(int id) {
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		EmpDetails employe = session.load(EmpDetails.class, id);
		employe.setMantrans(null);;
		try {
			session.update(employe);session.getTransaction().commit();return "Updated";
		}catch(Exception e){session.getTransaction().commit();return "error occured while updating";}
		
	}

	






}
