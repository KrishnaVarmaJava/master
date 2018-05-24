package mylas.com.erp.demo.dao;

import java.util.List;

import mylas.com.erp.demo.TblEmpLeavereq;

public interface EmpLeaveRequestDao {

	public void save(TblEmpLeavereq empleavereq);
	public List<TblEmpLeavereq> view();
	public List<TblEmpLeavereq> viewbyid(String empid);
}
