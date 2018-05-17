package mylas.com.erp.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mylas.com.erp.demo.EmpDetails;
import mylas.com.erp.demo.TblDepartment;
import mylas.com.erp.demo.TblDesignation;
import mylas.com.erp.demo.appservices.User;
import mylas.com.erp.demo.appservices.UserServiceImpl;
import mylas.com.erp.demo.dao.EmpServicesDao;
import mylas.com.erp.demo.dao.ManagerServicesDao;
import mylas.com.erp.demo.dao.ServicesDao;
import mylas.com.erp.demo.daoimpl.EmpServiceDaoImpl;
import mylas.com.erp.demo.exceptions.UserBlockedException;
import mylas.com.erp.demo.operations.LoginOperations;
import mylas.com.erp.demo.service.Client;
import mylas.com.erp.demo.service.DepartmentService;
import mylas.com.erp.demo.service.DesignationService;




@Controller
public class PageController {
	
	@Autowired
	ServicesDao servicesdao;
	
	@Autowired
	EmpServicesDao empservicesdao;
	
	@Autowired
	ManagerServicesDao mandao;

	Client client = new Client();
	
		
	@RequestMapping(value= "/admin", method=RequestMethod.GET)
	public ModelAndView adminIndexPage() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("title", "HomePage");
		
		mav.addObject("services", servicesdao.list());
		
		mav.addObject("userClickHome", true);
		return mav;
	}
	
	
	/*
	 * Slide Bar Page Handlers Start
	 */
	
	@RequestMapping(value="/admin/regesteremp/register")
	public ModelAndView empRegesterPage() {
		ModelAndView mav = new ModelAndView("adminindex");
		mav.addObject("services", servicesdao.list());
		mav.addObject("title", "Employee Regester Page");
		mav.addObject("userClickReg", true);
		return mav;		
	}
	
	@RequestMapping(value="/admin/allemp/register")
	public ModelAndView allEmpPage() {
		ModelAndView mav = new ModelAndView("employees");
		mav.addObject("services", servicesdao.list());
		mav.addObject("title", "Employee Regester Page");
		mav.addObject("userClickReg", true);
		Client cl = new Client();
		List<EmpDetails> emp1 = cl.getDetails();
		mav.addObject("employees", emp1);
		cl.closeAllSessions();
		return mav;		
	}
	

	
	
	@RequestMapping(value="/admin/empdep/register")
	public ModelAndView empDepartmentPage() {
		ModelAndView mav = new ModelAndView("departments");
		DepartmentService depdetails = new DepartmentService();
		List<TblDepartment> depts = depdetails.getDetails();
		mav.addObject("departments", depts);
		mav.addObject("services", servicesdao.list());
		mav.addObject("title", "Employee Departments Page");
		mav.addObject("userClickReg", true);
		return mav;		
	}
	
	@RequestMapping(value="/admin/empholidays/register")
	public ModelAndView empHolidayPage() {
		ModelAndView mav = new ModelAndView("holidays");
		mav.addObject("services", servicesdao.list());
		mav.addObject("title", "Employee Holiday Page");
		mav.addObject("userClickReg", true);
		return mav;		
	}
	
	@RequestMapping(value="/admin/empleavereq/register")
	public ModelAndView empLeaveReqPage() {
		ModelAndView mav = new ModelAndView("leaverequests");
		mav.addObject("services", servicesdao.list());
		mav.addObject("title", "Employee Holiday Page");
		mav.addObject("userClickReg", true);
		return mav;		
	}
	
	@RequestMapping(value="/admin/empatt/register")
	public ModelAndView empAttenedancePage() {
		ModelAndView mav = new ModelAndView("attenedance");
		mav.addObject("services", servicesdao.list());
		mav.addObject("title", "Employee Holiday Page");
		mav.addObject("userClickReg", true);
		return mav;		
	}
	

	
	@RequestMapping(value="/admin/empdesig/register")
	public ModelAndView empDesignationPage() {
		ModelAndView mav = new ModelAndView("designations");
		DesignationService depdetails = new DesignationService();
		List<TblDesignation> depts = depdetails.getDetails();
		mav.addObject("designations", depts);
		mav.addObject("services", servicesdao.list());
		mav.addObject("title", "Employee Holiday Page");
		mav.addObject("userClickReg", true);
		return mav;		
	}
	/*
	 * SlideBar Page handler Close
	 */
	
	/*
	 * Master Form Handlers
	 */
	
	@RequestMapping(value="/admin/allemp/register", method=RequestMethod.POST)
	public ModelAndView saveEmpPage(HttpServletRequest request, HttpServletResponse response) {
		EmpDetails emp = new EmpDetails(request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("uname"), request.getParameter("email"), request.getParameter("pswd"), request.getParameter("cpswd"), request.getParameter("empid"), null, null, null, null, false, false, null);
		emp.setLoginStatus(UserServiceImpl.Login_Status_Active);
		emp.setUsrmanrole(null);
		emp.setRole(UserServiceImpl.Role_User);
		ModelAndView mav = new ModelAndView("employees");
		mav.addObject("services", servicesdao.list());
		mav.addObject("title", "Employee Regester Page");
		mav.addObject("userClickReg", true);
		client.getConnection(emp);
		Client cl = new Client();
		List<EmpDetails> emp1 = cl.getDetails();
		mav.addObject("employees", emp1);
		request.setAttribute("Sempl", emp1);
		mav.addObject("employee", emp);
		cl.closeAllSessions();
		return mav;		
	}


	@RequestMapping(value="/admin/empdep/register", method=RequestMethod.POST)
	public ModelAndView addEmpDepartmentPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("departments");
		TblDepartment tbldep = new TblDepartment(request.getParameter("departmentname"));
		DepartmentService depserv = new DepartmentService();
		depserv.saveDepartment(tbldep);
		List<TblDepartment> depts = depserv.getDetails();
		mav.addObject("departments", depts);
		mav.addObject("services", servicesdao.list());
		mav.addObject("title", "Employee Departments Page");
		mav.addObject("userClickReg", true);
		return mav;		
	}
	
	@RequestMapping(value="/admin/empdesig/register", method=RequestMethod.POST)
	public ModelAndView AddEmpDesignationPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("designations");
		TblDesignation tbldes = new TblDesignation(request.getParameter("designationname"));
		DesignationService depdetails = new DesignationService();
		depdetails.saveDetails(tbldes);
		List<TblDesignation> depts = depdetails.getDetails();
		mav.addObject("designations", depts);
		mav.addObject("services", servicesdao.list());
		mav.addObject("title", "Employee Holiday Page");
		mav.addObject("userClickReg", true);
		return mav;		
	}
	
/*	@RequestMapping(value="/admin/allemp/register/employee")
	public ModelAndView empDetailsPage(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("employee");
		EmpDetails Edetails = null;
		Client cl = new Client();
		Edetails = cl.getById(id);
		mav.addObject("empID", id);
		mav.addObject("employee",Edetails);
		mav.addObject("services", servicesdao.list());
		mav.addObject("title", "Employee Holiday Page");
		mav.addObject("userClickReg", true);
		return mav;		
	}*/
	@RequestMapping(value="/admin/allemp/register/{id}/employeedetails")
	public ModelAndView eachEmpDetailsPage(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("employeedetails");
		EmpDetails Edetails = null;
		Client cl = new Client();
		Edetails = cl.getById(id);
		mav.addObject("empID", id);
		mav.addObject("employee",Edetails);
		mav.addObject("services", servicesdao.list());
		return mav;		
	}
		 
/*
 * Default Pages
 */
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView indexPage() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("services", servicesdao.list());
		mav.addObject("title", "HomePage");
		mav.addObject("userClickHome", true);
		return mav;
	}
	@RequestMapping(value= "/forgot-password")
	public ModelAndView forgotPasswordPage() {
		ModelAndView mav = new ModelAndView("forgot-password");
		mav.addObject("title", "Forgot Password Page");
		mav.addObject("userClickForgotPassword", true);
		return mav;
	}
	@RequestMapping(value= "/register")
	public ModelAndView registerPage() {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("title", "Register Page");
		mav.addObject("userClickCreatNewAcc", true);
		return mav;
	}
	@RequestMapping(value= "/register", method=RequestMethod.POST)
	public ModelAndView adminRegisterPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws UserBlockedException {
		EmpDetails emp = new EmpDetails(null, null, request.getParameter("username"), request.getParameter("email"), request.getParameter("password"), request.getParameter("confirm"), request.getParameter("empid"), null, null, null, null, false, false, null);
		emp.setLoginStatus(UserServiceImpl.Login_Status_Active);
		emp.setUsrmanrole(null);
		emp.setRole(UserServiceImpl.Role_Admin);
		emp.setFname("Admin");
		emp.setLname("Admin");
		client.getConnection(emp);
		ModelAndView mav = new ModelAndView("log_in");
		mav.addObject("title", "Register Page");
		mav.addObject("regmessage","Regesterd Successfully! Please Login.");
		return mav;
	}
	
	/**\
	 * 
	 * User Login and Other Operations
	 * 
	 * 
	 */
	
	UserServiceImpl userservice = new UserServiceImpl();
	
	@RequestMapping(value= "/login")
	public ModelAndView loginPageView() {
		ModelAndView mav = new ModelAndView("log_in");
		mav.addObject("loginoperations", new LoginOperations());
		return mav;
	}
	@RequestMapping(value= "/login", method=RequestMethod.POST)
	public ModelAndView loginPageAction(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws UserBlockedException {
		ModelAndView mav = new ModelAndView("log_in");
		LoginOperations loginop = new LoginOperations(request.getParameter("username"), request.getParameter("password"));
		try {
			List<EmpDetails> employee = userservice.Login(loginop.getLoginName(), loginop.getLoginPassword());
			Map map = null;
			for(Object usr : employee) {
				map = (Map) usr;
			}
			if(employee == null) {
				mav.addObject("loginerrmssg", "Login Failed! Please Enter Valid Credentials");
			}
			else {
				/*
				 *Redirect to the appropriate page 
				 */
				
				if(map.get("role").equals(User.Role_Admin)) {
					ModelAndView mav2 = new ModelAndView("index");
					session.setAttribute("empfname", map.get("fname"));
					session.setAttribute("emplname", map.get("lname"));
					session.setAttribute("empuname", map.get("uname"));
					session.setAttribute("empemail", map.get("email"));
					session.setAttribute("empeid", map.get("eid"));
					session.setAttribute("empjdate", map.get("jdate"));
					session.setAttribute("empphone", map.get("phone"));
					session.setAttribute("empcompName", map.get("compName"));
					session.setAttribute("empdesignation", map.get("designation"));
					mav2.addObject("title", "HomePage");
					
					mav2.addObject("services", servicesdao.list());
					
					mav2.addObject("userClickHome", true);
					return mav2;
					
				}
				else if(map.get("role").equals(User.Role_User) && map.get("usrmanrole").equals(User.Emp_Role)) {
					ModelAndView mav2 = new ModelAndView("empindex");
					session.setAttribute("empfname", map.get("fname"));
					session.setAttribute("emplname", map.get("lname"));
					session.setAttribute("empuname", map.get("uname"));
					session.setAttribute("empemail", map.get("email"));
					session.setAttribute("empeid", map.get("eid"));
					session.setAttribute("empjdate", map.get("jdate"));
					session.setAttribute("empphone", map.get("phone"));
					session.setAttribute("empcompName", map.get("compName"));
					session.setAttribute("empdesignation", map.get("designation"));
					EmpServiceDaoImpl empService = new EmpServiceDaoImpl();
					mav2.addObject("services", empservicesdao.list());	
					return mav2;
					
				}
				else if(map.get("role").equals(User.Role_User) && map.get("usrmanrole").equals(User.Man_Role)) {
					ModelAndView mav2 = new ModelAndView("empindex");
					session.setAttribute("empfname", map.get("fname"));
					session.setAttribute("emplname", map.get("lname"));
					session.setAttribute("empuname", map.get("uname"));
					session.setAttribute("empemail", map.get("email"));
					session.setAttribute("empeid", map.get("eid"));
					session.setAttribute("empjdate", map.get("jdate"));
					session.setAttribute("empphone", map.get("phone"));
					session.setAttribute("empcompName", map.get("compName"));
					session.setAttribute("empdesignation", map.get("designation"));
					EmpServiceDaoImpl empService = new EmpServiceDaoImpl();
					mav2.addObject("services", mandao.list());	
					return mav2;
					
				}else {
					mav.addObject("errmsg", "No Such Role Found!!!");
					return mav;
				}
				}
		} catch (NullPointerException e) {
			
			
				mav.addObject("errmsg", "Invalid User! Please Regester Yourself then Login.");
				return mav;
	
			
			}
		return mav;
	}
	@RequestMapping(value= "/testpage")
	public ModelAndView testpage() {
		ModelAndView mav = new ModelAndView("indvidtimesheet");
		mav.addObject("services", mandao.list());	
		return mav;
	}
	@RequestMapping(value= "/test")
	public ModelAndView testPage() {
		ModelAndView mav = new ModelAndView("empindex");
		return mav;
	}
	@RequestMapping(value= "/mytest")
	public ModelAndView testmyPage() {
		ModelAndView mav = new ModelAndView("empleaverequests");
		return mav;
	}
		

}
