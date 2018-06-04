package mylas.com.erp.demo.dao;

import java.util.List;

import mylas.com.erp.demo.TblDepartment;
import mylas.com.erp.demo.TblEmpAttendanceNew;
import mylas.com.erp.demo.TblEmpLeavereq;

public interface EmpAttendenceDao {
	public void save(TblEmpAttendanceNew tbl);
	public void update(Boolean status,int id);
	public String delete(int id);
	public List<TblEmpAttendanceNew> viewbyid(String empid);
	public List<TblEmpAttendanceNew> getDetails();

}
