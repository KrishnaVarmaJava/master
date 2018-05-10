package mylas.com.erp.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mylas.com.erp.demo.EmpDetails;
import mylas.com.erp.demo.dao.DepartmentDao;

import mylas.com.erp.demo.dao.ServicesDao;
import mylas.com.erp.demo.service.Client;




@Controller
public class PageController {
	
	@Autowired
	DepartmentDao departmentdao;
	
	@Autowired
	ServicesDao servicesdao;
	
	
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
		return mav;		
	}
	

	
	
	@RequestMapping(value="/admin/empdep/register")
	public ModelAndView empDepartmentPage() {
		ModelAndView mav = new ModelAndView("departments");
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
		EmpDetails emp = new EmpDetails(request.getParameter("firstname"), request.getParameter("lastname"), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		/*client.getConnection(emp);*/
		ModelAndView mav = new ModelAndView("newfile");
		
		mav.addObject("employee", emp);
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
	@RequestMapping(value= "/login", method=RequestMethod.GET)
	public ModelAndView loginPageView() {
		ModelAndView mav = new ModelAndView("log_in");
		return mav;
	}
	
}
