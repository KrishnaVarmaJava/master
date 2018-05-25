package mylas.com.erp.demo.dao;

import java.util.List;

import mylas.com.erp.demo.TblEmpLeavereq;

public interface EmpLeaveRequestDao {

	public void save(TblEmpLeavereq empleavereq);
	public List<TblEmpLeavereq> view();
	public List<TblEmpLeavereq> viewbyid(String empid);
	public void edit();
	public TblEmpLeavereq view(int id);
	public String delete(int id);
}
