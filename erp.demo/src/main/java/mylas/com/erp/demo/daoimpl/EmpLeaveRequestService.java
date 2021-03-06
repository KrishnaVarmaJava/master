package mylas.com.erp.demo.daoimpl;

import java.util.Date;
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
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

import mylas.com.erp.demo.EmpDetails;
import mylas.com.erp.demo.TblEmpLeavereq;
import mylas.com.erp.demo.appservices.EmailSender;
import mylas.com.erp.demo.appservices.GetSession;
import mylas.com.erp.demo.dao.EmpLeaveRequestDao;


@Repository("ers")
public class EmpLeaveRequestService implements EmpLeaveRequestDao {

	EmailSender emailsender = new EmailSender();

	static String emailToRecipient, emailSubject, emailMessage;



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
		String sqlquery = "FROM TblEmpLeavereq WHERE employeeid ='"+empid+"'";
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<TblEmpLeavereq> map = null;
		Query query = session.createQuery(sqlquery);
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
		}catch(Exception e){			session.getTransaction().rollback();
return "error occured while updating";}

	}

	@Override
	public String ChangeManager(int id) {
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		TblEmpLeavereq employe = session.load(TblEmpLeavereq.class, id);
		employe.setMantrans(null);
		try {
			session.update(employe);session.getTransaction().commit();return "Updated";
		}catch(Exception e){			session.getTransaction().rollback();
return "error occured while updating";}

	}

	@Override
	public int countEmployee(String manid) {
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		  session.beginTransaction();
		  Criteria crit = session.createCriteria(TblEmpLeavereq.class);
		  crit.add( Restrictions.isNull("status"));
		  crit.add(Restrictions.ilike("managerid", manid));
		  List<TblEmpLeavereq> emps = crit.list();
		  session.getTransaction().commit();
		return emps.size();
	}

	@Override
	public List<TblEmpLeavereq> viewSearch(String firstname, String lastname, String month, String status) {
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query q = null;
		if(firstname!="" && lastname!="" && month!="" && status!="") {

			if(status.equals("1")||status.equals("0")) {
				q= session.createQuery("from TblEmpLeavereq where employeeid IN (select eid from EmpDetails where fname='"+firstname+"' AND lname='"+lastname+"') AND fromdate LIKE '%-"+month+"-%' AND status="+status);
			}else {
				q=session.createQuery("from TblEmpLeavereq where  employeeid IN (select eid from EmpDetails where fname='"+firstname+"' AND lname='"+lastname+"') AND fromdate LIKE '%-"+month+"-%' AND status is null");
			}
		}
		else if(firstname!="" && lastname!="" && month!="") {

				q=session.createQuery("from TblEmpLeavereq where employeeid IN (select eid from EmpDetails where fname='"+firstname+"' AND lname='"+lastname+"') AND fromdate LIKE '%-"+month+"-%'");
			}
		
		else if(firstname!="" && lastname!="" && status!="") {

			if(status.equals("1")||status.equals("0")) {
				q= session.createQuery("from TblEmpLeavereq where employeeid IN (select eid from EmpDetails where fname='"+firstname+"' AND lname='"+lastname+"') AND status="+status);
			}else {
				q=session.createQuery("from TblEmpLeavereq where employeeid IN (select eid from EmpDetails where fname='"+firstname+"' AND lname='"+lastname+"') AND status is null");
			}
		}
		else if(firstname!="" && month!="" && status!="") {

			if(status.equals("1")||status.equals("0")) {
				q= session.createQuery("from TblEmpLeavereq where  employeeid IN (select eid from EmpDetails where fname='"+firstname+"') AND fromdate LIKE '%-"+month+"-%' AND status="+status);
			}else {
				q=session.createQuery("from TblEmpLeavereq where employeeid IN (select eid from EmpDetails where fname='"+firstname+"') AND fromdate LIKE '%-"+month+"-%' AND status is null");
			}
		}
		else if(lastname!="" && month!="" && status!="") {

			if(status.equals("1")||status.equals("0")) {
				q= session.createQuery("from TblEmpLeavereq where  employeeid IN (select eid from EmpDetails where lname='"+lastname+"') AND fromdate LIKE '%-"+month+"-%' AND status="+status);
			}else {
				q=session.createQuery("from TblEmpLeavereq where employeeid IN (select eid from EmpDetails where lname='"+lastname+"') AND fromdate LIKE '%-"+month+"-%' AND status is null");
			}
		}
		else if(firstname!="" && month!="") {
			q=session.createQuery("from TblEmpLeavereq where employeeid IN (select eid from EmpDetails where fname='"+firstname+"') AND fromdate LIKE '%-"+month+"-%'");
		}
		else if(firstname!="" && lastname!="") {
			q=session.createQuery("from TblEmpLeavereq where employeeid IN (select eid from EmpDetails where fname='"+firstname+"' AND lname='"+lastname+"')");
		}
		else if(firstname!="" && status!="") {
			if(status.equals("1")||status.equals("0")) {
				q= session.createQuery("from TblEmpLeavereq where employeeid IN (select eid from EmpDetails where fname='"+firstname+"') AND status="+status);
			}else {
				q=session.createQuery("from TblEmpLeavereq where employeeid IN (select eid from EmpDetails where fname='"+firstname+"') AND status is null");
			}
		}
		else if(lastname!="" && month!="") {
			q=session.createQuery("from TblEmpLeavereq where employeeid IN (select eid from EmpDetails where lname='"+lastname+"') AND fromdate LIKE '%-"+month+"-%'");
		}
		else if(lastname!="" && status!="") {
			if(status.equals("1")||status.equals("0")) {
				q= session.createQuery("from TblEmpLeavereq where employeeid IN (select eid from EmpDetails where lname='"+lastname+"') AND status="+status);
			}else {
				q=session.createQuery("from TblEmpLeavereq where employeeid IN (select eid from EmpDetails where lname='"+lastname+"') AND status is null");
			}
		}
		else if(month!="" && status!="") {
			if(status.equals("1")||status.equals("0")) {
				q= session.createQuery("from TblEmpLeavereq where fromdate LIKE '%-"+month+"-%' AND status="+status);
			}else {
				q=session.createQuery("from TblEmpLeavereq where fromdate LIKE '%-"+month+"-%' AND status is null");
			}

		}
		else if(firstname!="")
		{

			q = session.createQuery("from TblEmpLeavereq where employeeid IN (select eid from EmpDetails where fname='"+firstname+"')");	
		}
		else if(lastname!="")
		{

			q = session.createQuery("from TblEmpLeavereq where employeeid IN (select eid from EmpDetails where lname='"+lastname+"')");	
		}
		else if(month!="")
		{

			q = session.createQuery("from TblEmpLeavereq where fromdate LIKE '%-"+month+"-%'");	
		}
		else if(status!="")
		{
			if(status.equals("1")||status.equals("0")) {
				q= session.createQuery("from TblEmpLeavereq where status="+status);
			}else {
				q=session.createQuery("from TblEmpLeavereq where status is null");
			}
		}
		List<TblEmpLeavereq> empleave = q.list();
		
		session.getTransaction().commit();
		return (empleave);
	}

	@Override
	public List<TblEmpLeavereq> empLeaveSearch(String uname, String month, String status) {
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query q = null;
		if(uname!="" && month!="" && status!="") {

			if(status.equals("1")||status.equals("0")) {
				q= session.createQuery("from TblEmpLeavereq where employeeid='"+uname+"'AND fromdate LIKE '%-"+month+"-%' AND status="+status);
			}else {
				q=session.createQuery("from TblEmpLeavereq where employeeid='"+uname+"'AND fromdate LIKE '%-"+month+"-%' AND status is null");
			}
		}
		else if(uname!="" && month!="") {
			q=session.createQuery("from TblEmpLeavereq where employeeid='"+uname+"'AND fromdate LIKE '%-"+month+"-%'");
		}
		else if(uname!="" && status!="") {
			if(status.equals("1")||status.equals("0")) {
				q= session.createQuery("from TblEmpLeavereq where employeeid='"+uname+"'AND status="+status);
			}else {
				q=session.createQuery("from TblEmpLeavereq where employeeid='"+uname+"'AND status is null");
			}
		}
		else if(month!="" && status!="") {
			if(status.equals("1")||status.equals("0")) {
				q= session.createQuery("from TblEmpLeavereq where fromdate LIKE '%-"+month+"-%' AND status="+status);
			}else {
				q=session.createQuery("from TblEmpLeavereq where fromdate LIKE '%-"+month+"-%' AND status is null");
			}

		}
		else if(uname!="")
		{

			q = session.createQuery("from TblEmpLeavereq where employeeid='"+uname+"'");	
		}
		else if(month!="")
		{

			q = session.createQuery("from TblEmpLeavereq where fromdate LIKE '%-"+month+"-%'");	
		}
		else if(status!="")
		{
			if(status.equals("1")||status.equals("0")) {
				q= session.createQuery("from TblEmpLeavereq where status="+status);
			}else {
				q=session.createQuery("from TblEmpLeavereq where status is null");
			}
		}
		List<TblEmpLeavereq> empleave = q.list();

		session.getTransaction().commit();
		return (empleave);	
	}
	@Override
	public TblEmpLeavereq getById(int id) {
		TblEmpLeavereq user;
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		user =  session.get(TblEmpLeavereq.class, id);
		session.getTransaction().commit();
		return user;

}


	@Override
	public String updateLeave(int id, String leavetype, String fdate, String tdate, String reasion,int count,
			String status) {
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		TblEmpLeavereq update= session.load(TblEmpLeavereq.class, id);
		update.setReferenceid(0);
		TblEmpLeavereq newLeaveEntryByManager = new TblEmpLeavereq();
		newLeaveEntryByManager.setEmployeeid(update.getEmployeeid());
		newLeaveEntryByManager.setLeavetype(leavetype);newLeaveEntryByManager.setFromdate(fdate);newLeaveEntryByManager.setTodate(tdate);newLeaveEntryByManager.setLeavereason(reasion);
		newLeaveEntryByManager.setCount(count);newLeaveEntryByManager.setReferenceid(id);newLeaveEntryByManager.setStatus(true);
		newLeaveEntryByManager.setManagerid(update.getManagerid());newLeaveEntryByManager.setReason(status);
		try {
			session.update(update);
			session.save(newLeaveEntryByManager);session.getTransaction().commit();return "Updated";
		}catch(Exception e){
			
			
			session.getTransaction().rollback();
return "error occured while updating";}
		
		
	}

	@Override
	public void EmailSend(int id, int count) {
			// TODO Auto-generated method stub
		Session session = GetSession.buildSession().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		TblEmpLeavereq employe = session.load(TblEmpLeavereq.class, id);
		count=count-1;
		employe.setDaycount(count);
		try {
			session.update(employe);session.getTransaction().commit();
		}catch(Exception e){session.getTransaction().rollback();}
			emailSubject = "New Time Sheet For:";
			emailMessage = "A Remaindere Request For Approval has Been Sent to :"+employe.getFromdate()+"to"+employe.getTodate()+"On: "+new Date();
			emailToRecipient ="kpraveen@mylastech.com";
			//System.out.println("\nReceipient?= " + emailToRecipient + ", Subject?= " + emailSubject + ", Message?= " + emailMessage + "\n");
			emailsender.javaMailService("bgrao@mylastech.com", "Bganga@07", emailToRecipient, emailMessage, emailSubject);
			System.out.println("send mail");
			
			
	
		
	}
}
