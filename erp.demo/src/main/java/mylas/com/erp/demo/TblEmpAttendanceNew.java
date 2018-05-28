package mylas.com.erp.demo;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TblEmpAttendanceNew generated by hbm2java
 */
@Entity
@Table(name = "tbl_emp_attendance_new", schema = "krishna", catalog = "mylasfyt_krishna")
public class TblEmpAttendanceNew implements java.io.Serializable {

	private TblEmpAttendanceNewId id;

	public TblEmpAttendanceNew() {
	}

	public TblEmpAttendanceNew(TblEmpAttendanceNewId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "managerid", column = @Column(name = "managerid", length = 1)),
			@AttributeOverride(name = "empid", column = @Column(name = "empid", length = 1)),
			@AttributeOverride(name = "month", column = @Column(name = "month", length = 1)),
			@AttributeOverride(name = "year", column = @Column(name = "year")),
			@AttributeOverride(name = "day1", column = @Column(name = "day1")),
			@AttributeOverride(name = "day2", column = @Column(name = "day2")),
			@AttributeOverride(name = "day3", column = @Column(name = "day3")),
			@AttributeOverride(name = "day4", column = @Column(name = "day4")),
			@AttributeOverride(name = "day5", column = @Column(name = "day5")),
			@AttributeOverride(name = "day6", column = @Column(name = "day6")),
			@AttributeOverride(name = "day7", column = @Column(name = "day7")),
			@AttributeOverride(name = "day8", column = @Column(name = "day8")),
			@AttributeOverride(name = "day9", column = @Column(name = "day9")),
			@AttributeOverride(name = "day10", column = @Column(name = "day10")),
			@AttributeOverride(name = "day11", column = @Column(name = "day11")),
			@AttributeOverride(name = "day12", column = @Column(name = "day12")),
			@AttributeOverride(name = "day13", column = @Column(name = "day13")),
			@AttributeOverride(name = "day14", column = @Column(name = "day14")),
			@AttributeOverride(name = "day15", column = @Column(name = "day15")),
			@AttributeOverride(name = "day16", column = @Column(name = "day16")),
			@AttributeOverride(name = "day17", column = @Column(name = "day17")),
			@AttributeOverride(name = "day18", column = @Column(name = "day18")),
			@AttributeOverride(name = "day19", column = @Column(name = "day19")),
			@AttributeOverride(name = "day20", column = @Column(name = "day20")),
			@AttributeOverride(name = "day21", column = @Column(name = "day21")),
			@AttributeOverride(name = "day22", column = @Column(name = "day22")),
			@AttributeOverride(name = "day23", column = @Column(name = "day23")),
			@AttributeOverride(name = "day24", column = @Column(name = "day24")),
			@AttributeOverride(name = "day25", column = @Column(name = "day25")),
			@AttributeOverride(name = "day26", column = @Column(name = "day26")),
			@AttributeOverride(name = "day27", column = @Column(name = "day27")),
			@AttributeOverride(name = "day28", column = @Column(name = "day28")),
			@AttributeOverride(name = "day29", column = @Column(name = "day29")),
			@AttributeOverride(name = "day30", column = @Column(name = "day30")),
			@AttributeOverride(name = "day31", column = @Column(name = "day31")),
			@AttributeOverride(name = "statas", column = @Column(name = "statas")),
			@AttributeOverride(name = "reasion", column = @Column(name = "reasion", length = 1)) })
	public TblEmpAttendanceNewId getId() {
		return this.id;
	}

	public void setId(TblEmpAttendanceNewId id) {
		this.id = id;
	}

}