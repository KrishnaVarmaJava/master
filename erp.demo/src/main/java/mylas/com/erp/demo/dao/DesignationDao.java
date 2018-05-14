package mylas.com.erp.demo.dao;

import java.util.List;

import mylas.com.erp.demo.TblDesignation;



public interface DesignationDao {

	public void saveDetails(TblDesignation tbldesg);
	public List<TblDesignation> getDetails();
	public void updateDetails(TblDesignation tbldesg);
	public void deleteDetails(TblDesignation tbldesg);
}
