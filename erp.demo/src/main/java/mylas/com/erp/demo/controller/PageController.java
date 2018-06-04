package mylas.com.erp.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
import mylas.com.erp.demo.TblEmpLeavereq;
import mylas.com.erp.demo.appservices.UserServiceImpl;
import mylas.com.erp.demo.dao.EmpLeaveRequestDao;
import mylas.com.erp.demo.dao.EmpServicesDao;
import mylas.com.erp.demo.dao.ManagerServicesDao;
import mylas.com.erp.demo.dao.ServicesDao;
import mylas.com.erp.demo.daoimpl.EmpAttendanceDaoImpl;
import mylas.com.erp.demo.daoimpl.EmpLeaveRequestService;
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
	EmpLeaveRequestDao empleavereq;
	
	@Autowired
	EmpAttendanceDaoImpl empattreq;
	
	/*@Autowired
	DepartmentDao deptdao;*/
	DepartmentService deptdao =new DepartmentService();
	Client client = new Client();
	EmpAttendanceDaoImpl attimpl=new EmpAttendanceDaoImpl();
	DesignationService desser=new DesignationService();
	EmpLeaveRequestService ers = new EmpLeaveRequestService();	

	
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
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		EmpDetails user=null;
		if (principal instanceof EmpDetails) {
		user = ((EmpDetails)principal);
		}
		
		String role = user.getRole();
		mav.addObject("Role",role);
		mav.addObject("title", "Employee Regester Page");
		mav.addObject("userClickReg", true);
		Client cl = new Client();
		String mesg = "hi";
		List<EmpDetails> emp1 = cl.getDetails();
		mav.addObject("employees", emp1);
		mav.addObject("dupmsg", mesg);
		mav.addObject(user);
		cl.closeAllSessions();
		return mav;		
	}
	

	
	
	@RequestMapping(value="/admin/empdep/register")
	public ModelAndView empDepartmentPage() {
		ModelAndView mav = new ModelAndView("departments");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		EmpDetails user=null;
		if (principal instanceof EmpDetails) {
		user = ((EmpDetails)principal);
		}
		
		String role = user.getRole();
		mav.addObject("Role",role);
		mav.addObject("User", user);
		DepartmentService depdetails = new DepartmentService();
		List<TblDepartment> depts = depdetails.getDetails();
		mav.addObject("departments", depts);
		mav.addObject("services", servicesdao.list());
	
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
		ModelAndView mav = new ModelAndView("allempleaverequests");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		EmpDetails user=null;
		if (principal instanceof EmpDetails) {
		user = ((EmpDetails)principal);
		}
		
		String role = user.getRole();
		mav.addObject("Role",role);
		Client cl = new Client();
		List<EmpDetails> emp1 = cl.getDetails();
		List<TblEmpLeavereq> leavereq =  empleavereq.view();
		mav.addObject("employees", emp1);
		mav.addObject("empleave", leavereq);
		mav.addObject("services", servicesdao.list());
		mav.addObject("title", "Employee Holiday Page");
		mav.addObject("userClickReg", true);
		return mav;		
	}
	
	@RequestMapping(value="/admin/empatt/register")
	public ModelAndView empAttenedancePage() {
		ModelAndView mav = new ModelAndView("allemptimesheetrequests");
		mav.addObject("services", servicesdao.list());
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		EmpDetails user=null;
		if (principal instanceof EmpDetails) {
		user = ((EmpDetails)principal);
		}
		
		String role = user.getRole();
		mav.addObject("Role",role);
		Client cl = new Client();
		List<EmpDetails> emp1 = cl.getDetails();
		List<TblEmpAttendanceNew> attendances =  empattreq.getDetails();
		
		mav.addObject("employees", emp1);
		mav.addObject("attendancelist",attendances);
		return mav;		
	}
	

	
	@RequestMapping(value="/admin/empdesig/register")
	public ModelAndView empDesignationPage() {
		ModelAndView mav = new ModelAndView("designations");
		DesignationService depdetails = new DesignationService();
		List<TblDesignation> depts = depdetails.getDetails();
		mav.addObject("designations", depts);
		mav.addObject("services", servicesdao.list());
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		EmpDetails user=null;
		if (principal instanceof EmpDetails) {
		user = ((EmpDetails)principal);
		}
		
		String role = user.getRole();
		mav.addObject("Role",role);
		
		return mav;		
	}
	/*
	 * SlideBar Page handler Close
	 */
	
	/*
	 * Master Form Handlers
	 */
	
	@RequestMapping(value="/admin/allemp/register", method=RequestMethod.POST)
	public ModelAndView saveEmpPage(HttpServletRequest request, HttpServletResponse response) throws ConstraintViolationException{
		
		EmpDetails emp = new EmpDetails(null, request.getParameter("cpswd"), null, request.getParameter("empid"), request.getParameter("email"), request.getParameter("firstname"), null, request.getParameter("lastname"), false, null, request.getParameter("pswd"), null, request.getParameter("uname"));
		
		emp.setLoginStatus(UserServiceImpl.Login_Status_Active);
		emp.setRole("USER_ROLE");
		ModelAndView mav = new ModelAndView("employees");
		mav.addObject("services", servicesdao.list());
		System.out.println("before getconn");
		String mesg = "hi";
		mesg = client.getConnection(emp);
		
		mav.addObject("dupmsg", mesg);
		
		System.out.println("after getconn");
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
		ModelAndView mav = new ModelAndView("redirect:/admin/allemp/register");
		
		client.deleteDetails(id);
		return mav;
		
	}

	@RequestMapping(value="/admin/empdep/register", method=RequestMethod.POST)
	public ModelAndView addEmpDepartmentPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("departments");
		TblDepartment tbldep = new TblDepartment(request.getParameter("departmentname"));
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		EmpDetails user=null;
		if (principal instanceof EmpDetails) {
		user = ((EmpDetails)principal);
		}
		
		String role = user.getRole();
		mav.addObject("Role",role);
		DepartmentService depserv = new DepartmentService();
		depserv.saveDepartment(tbldep);
		List<TblDepartment> depts = depserv.getDetails();
		mav.addObject("departments", depts);
		mav.addObject("services", servicesdao.list());
		mav.addObject("User", user);
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
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		EmpDetails user=null;
		if (principal instanceof EmpDetails) {
		user = ((EmpDetails)principal);
		}
		
		String role = user.getRole();
		mav.addObject("Role",role);
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
		String msg = client.getConnection(emp);
		ModelAndView mav;
		if(msg.contains("Duplicate Entry")) {
			mav = new ModelAndView("register");	
		}else {
			mav = new ModelAndView("newlogin");
		}
		
		mav.addObject("title", "Register Page");
		mav.addObject("regmessage",msg);
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
	public ModelAndView loginPageView(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView mav = new ModelAndView("newlogin");
		if (error != null) {
			mav.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			mav.addObject("msg", "You've been logged out successfully.");
		}
		mav.addObject("loginoperations", new LoginOperations());
		return mav;
	}
	
	@RequestMapping(value= "/signin")
	public ModelAndView signinPageView(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView mav = new ModelAndView("lockscreen");
		if (error != null) {
			mav.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			mav.addObject("msg", "You've been logged out successfully.");
		}
		mav.addObject("loginoperations", new LoginOperations());
		return mav;
	}
	
	@RequestMapping(value= "/logout")
	public ModelAndView logoutPageView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("redirect:/login?logout");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
		return mav;
	}
	@RequestMapping(value="/admin/departments/delete/{id}")
	public ModelAndView deleteAdminDepartments(HttpServletRequest request, HttpServletResponse response,@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("redirect:/admin/empdep/register");
		
		deptdao.deleteDetails(id);
		return mav;
		
	}

	@RequestMapping(value="/admin/designations/delete/{id}")
	public ModelAndView deleteAdminDesignations(HttpServletRequest request, HttpServletResponse response,@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("redirect:/admin/empdesig/register");
		
		desser.deleteDetails(id);
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
		ers.viewbyStatusid(false);
		
		return mav;
	}
	@RequestMapping(value= "/mytest")
	public ModelAndView testmyPage() {
		ModelAndView mav = new ModelAndView("indvidtimesheet");
		return mav;
	}

	@RequestMapping(value= "/403")
	public ModelAndView Page403() {
		ModelAndView mav = new ModelAndView("403errorpage");
		return mav;
	}
	@RequestMapping(value= "/error/404")
	public ModelAndView Page404() {
		ModelAndView mav = new ModelAndView("404errorpage");
		return mav;
	}
	@RequestMapping(value= "/error/500")
	public ModelAndView Page500() {
		ModelAndView mav = new ModelAndView("500errorpage");

		return mav;
	}
		

}
