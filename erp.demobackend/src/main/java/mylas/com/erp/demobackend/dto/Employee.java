package mylas.com.erp.demobackend.dto;

import java.util.Date;

public class Employee {

	
	private String FirstName;
	private String LastName;
	private String EmpEmail;
	private String Address1;
	private String Address2;
	private String City;
	private String State;
	private String PanCardNum;
	private String ReasonForTermination;
	private String maritalStatus;
	private String Title;
	private boolean gender;
	private int EmployeeID;
	private int Pin;
	private int AadharCard;
	private Date HireDate;
	private Date TermDate;
	private Date DOB;
	public Employee(String firstName, String lastName, String empEmail, String address1, String address2, String city,
			String state, String panCardNum, String reasonForTermination, String maritalStatus, String title,
			boolean gender, int employeeID, int pin, int aadharCard, Date hireDate, Date termDate, Date dOB) {
		super();
		FirstName = firstName;
		LastName = lastName;
		EmpEmail = empEmail;
		Address1 = address1;
		Address2 = address2;
		City = city;
		State = state;
		PanCardNum = panCardNum;
		ReasonForTermination = reasonForTermination;
		this.maritalStatus = maritalStatus;
		Title = title;
		this.gender = gender;
		EmployeeID = employeeID;
		Pin = pin;
		AadharCard = aadharCard;
		HireDate = hireDate;
		TermDate = termDate;
		DOB = dOB;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmpEmail() {
		return EmpEmail;
	}
	public void setEmpEmail(String empEmail) {
		EmpEmail = empEmail;
	}
	public String getAddress1() {
		return Address1;
	}
	public void setAddress1(String address1) {
		Address1 = address1;
	}
	public String getAddress2() {
		return Address2;
	}
	public void setAddress2(String address2) {
		Address2 = address2;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getPanCardNum() {
		return PanCardNum;
	}
	public void setPanCardNum(String panCardNum) {
		PanCardNum = panCardNum;
	}
	public String getReasonForTermination() {
		return ReasonForTermination;
	}
	public void setReasonForTermination(String reasonForTermination) {
		ReasonForTermination = reasonForTermination;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public int getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}
	public int getPin() {
		return Pin;
	}
	public void setPin(int pin) {
		Pin = pin;
	}
	public int getAadharCard() {
		return AadharCard;
	}
	public void setAadharCard(int aadharCard) {
		AadharCard = aadharCard;
	}
	public Date getHireDate() {
		return HireDate;
	}
	public void setHireDate(Date hireDate) {
		HireDate = hireDate;
	}
	public Date getTermDate() {
		return TermDate;
	}
	public void setTermDate(Date termDate) {
		TermDate = termDate;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
