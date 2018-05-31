package mylas.com.erp.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import mylas.com.erp.demo.EmpDetails;
import mylas.com.erp.demo.TblDepartment;
import mylas.com.erp.demo.TblDesignation;
import mylas.com.erp.demo.TblEmpAttendanceNew;
import mylas.com.erp.demo.appservices.UserServiceImpl;
import mylas.com.erp.demo.dao.EmpAttendenceDao;
import mylas.com.erp.demo.dao.EmpServicesDao;
import mylas.com.erp.demo.dao.ManagerServicesDao;
import mylas.com.erp.demo.dao.ServicesDao;
import mylas.com.erp.demo.daoimpl.EmpAttendanceDaoImpl;
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
	@Autowired
	EmpAttendenceDao empattdao;

	Client client = new Client();
	EmpAttendanceDaoImpl attimpl=new EmpAttendanceDaoImpl();
	
		
	@RequestMapping(value= "/admin")
	public ModelAndView adminIndexPage() {
		ModelAndView mav = new ModelAndView("index");
	/*	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		EmpDetails user=null;
		if (principal instanceof EmpDetails) {
		user = ((EmpDetails)principal);
		}
	 
	String name = user.getUname();*/
		mav.addObject("title", "HomePage");
		
		mav.addObject("services", servicesdao.list());
		
		mav.addObject("userClickHome", true);
		return mav;
	}
/*	@RequestMapping(value= "/adminindex", method=RequestMethod.GET)
	public ModelAndView AdminIndexPage() {
		ModelAndView mav = new ModelAndView("empindex");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		EmpDetails user=null;
		if (principal instanceof EmpDetails) {
		user = ((EmpDetails)principal);
		}
	 
		String role = user.getRole();
		System.out.println(user.getRole());
		mav.addObject("title", "HomePage");
		mav.addObject("Role",role);
		mav.addObject("services", servicesdao.list());
		mav.addObject("empservices", empservicesdao.list());
		mav.addObject("manservices", mandao.list());
		mav.addObject("userClickHome", true);
		return mav;
	}*/
	
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
		
		EmpDetails emp = new EmpDetails(null, request.getParameter("cpswd"), null, request.getParameter("empid"), request.getParameter("email"), request.getParameter("firstname"), null, request.getParameter("lastname"), false, null, request.getParameter("pswd"), null, request.getParameter("uname"));
		
		emp.setLoginStatus(UserServiceImpl.Login_Status_Active);
		emp.setRole("USER_ROLE");
		ModelAndView mav = new ModelAndView("employees");
		mav.addObject("services", servicesdao.list());
		client.getConnection(emp);
		Client cl = new Client();
		List<EmpDetails> emp1 = cl.getDetails();
		mav.addObject("employees", emp1);
		
		mav.addObject("employee", emp);
		cl.closeAllSessions();
		return mav;		
	}
	@RequestMapping(value="/admin/allemp/update/{id}", method=RequestMethod.POST)
	public ModelAndView updateEmpPage(HttpServletRequest request, HttpServletResponse response,@PathVariable("id") int id) {
		
		EmpDetails emp = new EmpDetails(null, request.getParameter("cpswd"), null, request.getParameter("empid"), request.getParameter("email"), request.getParameter("firstname"), null, request.getParameter("lastname"), false, null, request.getParameter("pswd"), null, request.getParameter("uname"));
		emp.setLoginStatus(UserServiceImpl.Login_Status_Active);
		emp.setRole("USER_ROLE");
		ModelAndView mav = new ModelAndView("employees");
		mav.addObject("services", servicesdao.list());
		mav.addObject("title", "Employee Regester Page");
		mav.addObject("userClickReg", true);
		client.updateDetails(emp, id);
		Client cl = new Client();
		List<EmpDetails> emp1 = cl.getDetails();
		mav.addObject("employees", emp1);
		request.setAttribute("Sempl", emp1);
		mav.addObject("employee", emp);
		cl.closeAllSessions();
		return mav;		
	}
	@RequestMapping(value="/admin/allemp/delete/{id}")
	public ModelAndView deleteEmpPage(HttpServletRequest request, HttpServletResponse response,@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("employees");
		mav.addObject("services", servicesdao.list());
		mav.addObject("title", "Employee Regester Page");
		client.deleteDetails(id);
		Client cl = new Client();
		List<EmpDetails> emp1 = cl.getDetails();
		mav.addObject("employees", emp1);
		request.setAttribute("Sempl", emp1);
		
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
		ModelAndView mav = new ModelAndView("empindex");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		EmpDetails user=null;
		if (principal instanceof EmpDetails) {
		user = ((EmpDetails)principal);
		}
	 
		String role = user.getRole();
		System.out.println(user.getRole());
		mav.addObject("title", "HomePage");
		mav.addObject("Role",role);
		mav.addObject("services", servicesdao.list());
		mav.addObject("empservices", empservicesdao.list());
		mav.addObject("manservices", mandao.list());
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
		EmpDetails emp = new EmpDetails(null, request.getParameter("confirm"), null, request.getParameter("empid"), request.getParameter("email"), null, null, null, false, null, request.getParameter("password"), null, request.getParameter("username"));
		
		emp.setLoginStatus(UserServiceImpl.Login_Status_Active);
		emp.setRole("ADMIN_ROLE");
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
		ModelAndView mav = new ModelAndView("newlogin");
		mav.addObject("loginoperations", new LoginOperations());
		return mav;
	}
	
	@RequestMapping(value= "/testpage")
	public ModelAndView testpage() {
		ModelAndView mav = new ModelAndView("emptimesheet");
		mav.addObject("services", mandao.list());	
		return mav;
	}
	@RequestMapping(value= "/test")
	public ModelAndView testPage() {
		ModelAndView mav = new ModelAndView("empindex");
		//TblEmpAttendanceNew tbl = new TblEmpAttendanceNew(null, null, null, null, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true,true, true, true, true, true, true, true, true, true, true, true, true, true, true, null, null);
		
		
		//attimpl.save(tbl);
		//attimpl.update(false,4);
		//attimpl.delete(4);
		attimpl.getDetails();
		
		
		return mav;
	}
	@RequestMapping(value= "/mytest")
	public ModelAndView testmyPage() {
		ModelAndView mav = new ModelAndView("indvidtimesheet");
		return mav;
	}
		

}
