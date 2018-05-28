package mylas.com.erp.demo.dao;

import mylas.com.erp.demo.TblDepartment;
import mylas.com.erp.demo.TblEmpAttendanceNew;

public interface EmpAttendenceDao {
	public void save(TblEmpAttendanceNew tbl);
	public void update(Boolean status,int id);
	public void delete(int id);
	public void listAll(TblEmpAttendanceNew tbl);

}
