package mylas.com.erp.demo.dao;

import java.util.List;

import mylas.com.erp.demo.TblEmpLeavereq;

public interface EmpLeaveRequestDao {

	public void save(TblEmpLeavereq empleavereq);
	public List<TblEmpLeavereq> view();
	public List<TblEmpLeavereq> viewbyid(String empid);
	public List<TblEmpLeavereq> viewbyManagerid(String mgrid);
	public List<TblEmpLeavereq> viewbyStatusid(Boolean statusid);
	public void edit();
	public TblEmpLeavereq view(int id);
	public String delete(int id);
	public String update(int id,String reason,boolean status);
	public String updatetransManager(int id,String transmanid);
	public String ChangeManager(int id);
	public int countEmployee(String manid);
	public List<TblEmpLeavereq> viewSearch(String firstname, String lnamename, String month, String status);
	public List<TblEmpLeavereq> empLeaveSearch(String uname, String month, String status); 
	public String updateLeave(int id, String leavetype, String fdate, String tdate, String reasion,int count,
			String status);
	public TblEmpLeavereq getById(int id);
	public void EmailSend(int id,int count);
}
