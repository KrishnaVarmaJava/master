package mylas.com.erp.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mylas.com.erp.demo.dao.DepartmentDao;
import mylas.com.erp.demo.dao.ServicesDao;
import mylas.com.erp.demo.dto.Employee;



@Controller
public class PageController {
	
	@Autowired
	DepartmentDao departmentdao;
	
	@Autowired
	ServicesDao servicesdao;
		
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
	public ModelAndView allEmpPage(@ModelAttribute("emp") Employee emp) {
		ModelAndView mav = new ModelAndView("employees");
		mav.addObject("services", servicesdao.list());
		mav.addObject("title", "Employee Regester Page");
		mav.addObject("userClickReg", true);
		return mav;		
	}
	

	
	
	@RequestMapping(value="/admin/empdep/register")
	public ModelAndView empDepartmentPage(@ModelAttribute("emp") Employee emp) {
		ModelAndView mav = new ModelAndView("departments");
		mav.addObject("services", servicesdao.list());
		mav.addObject("title", "Employee Departments Page");
		mav.addObject("userClickReg", true);
		return mav;		
	}
	
	@RequestMapping(value="/admin/empholidays/register")
	public ModelAndView empHolidayPage(@ModelAttribute("emp") Employee emp) {
		ModelAndView mav = new ModelAndView("holidays");
		mav.addObject("services", servicesdao.list());
		mav.addObject("title", "Employee Holiday Page");
		mav.addObject("userClickReg", true);
		return mav;		
	}
	
	@RequestMapping(value="/admin/empleavereq/register")
	public ModelAndView empLeaveReqPage(@ModelAttribute("emp") Employee emp) {
		ModelAndView mav = new ModelAndView("leaverequests");
		mav.addObject("services", servicesdao.list());
		mav.addObject("title", "Employee Holiday Page");
		mav.addObject("userClickReg", true);
		return mav;		
	}
	
	@RequestMapping(value="/admin/empatt/register")
	public ModelAndView empAttenedancePage(@ModelAttribute("emp") Employee emp) {
		ModelAndView mav = new ModelAndView("attenedance");
		mav.addObject("services", servicesdao.list());
		mav.addObject("title", "Employee Holiday Page");
		mav.addObject("userClickReg", true);
		return mav;		
	}
	
	@RequestMapping(value="/admin/empdesig/register")
	public ModelAndView empDesignationPage(@ModelAttribute("emp") Employee emp) {
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
		Employee emp = new Employee();
		emp.setFirstName(request.getParameter("firstname"));
		emp.setLastName(request.getParameter("lastname"));
		ModelAndView mav = new ModelAndView("newfile");
		mav.addObject("employee", emp);
		return mav;		
	}
	
	 
	@RequestMapping(value= "/admin", method=RequestMethod.POST)
	public ModelAndView regesterEmpIndexPage(
			@RequestParam(name="firstname", required=false) String firstname,
			@RequestParam(name="lastname", required=false) String lastname			
			) {
		ModelAndView mav = new ModelAndView("newfile");
		mav.addObject("firstname", firstname);
		mav.addObject("lastname", lastname);
		return mav;
	}

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
