package mylas.com.erp.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TblEmpLeavereq generated by hbm2java
 */
@Entity
@Table(name = "tbl_emp_leavereq", schema = "krishna", catalog = "mylasfyt_krishna")
public class TblEmpLeavereq implements java.io.Serializable {

	private Integer id;
	private String leavetype;
	private String fromdate;
	private String todate;
	private Integer count;
	private String leavereason;
	private String managerid;
	private String employeeid;
	private Boolean status;

	public TblEmpLeavereq() {
	}

	public TblEmpLeavereq(String leavetype, String fromdate, String todate, Integer count, String leavereason,
			String managerid, String employeeid, Boolean status) {
		this.leavetype = leavetype;
		this.fromdate = fromdate;
		this.todate = todate;
		this.count = count;
		this.leavereason = leavereason;
		this.managerid = managerid;
		this.employeeid = employeeid;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "leavetype", length = 15)
	public String getLeavetype() {
		return this.leavetype;
	}

	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}

	@Column(name = "fromdate", length = 30)
	public String getFromdate() {
		return this.fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	@Column(name = "todate", length = 30)
	public String getTodate() {
		return this.todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	@Column(name = "count")
	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name = "leavereason", length = 100)
	public String getLeavereason() {
		return this.leavereason;
	}

	public void setLeavereason(String leavereason) {
		this.leavereason = leavereason;
	}

	@Column(name = "managerid", length = 50)
	public String getManagerid() {
		return this.managerid;
	}

	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}

	@Column(name = "employeeid", length = 50)
	public String getEmployeeid() {
		return this.employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	@Column(name = "status")
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}