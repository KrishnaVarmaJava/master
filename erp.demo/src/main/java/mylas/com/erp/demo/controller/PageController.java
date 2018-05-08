package mylas.com.erp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mylas.com.erp.demo.dao.DepartmentDao;
import mylas.com.erp.demo.dao.EmployeeDao;
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
	
	@RequestMapping(value="/admin/regesteremp/register")
	public ModelAndView empRegesterPage() {
		ModelAndView mav = new ModelAndView("adminindex");
		mav.addObject("services", servicesdao.list());
		mav.addObject("title", "Employee Regester Page");
		mav.addObject("userClickReg", true);
		return mav;		
	}
	
/*	@RequestMapping(value="/admin/regesteremp/register", method=RequestMethod.POST)
	public ModelAndView saveempRegesterPage(@ModelAttribute("emp") Employee emp) {
		empdao.save(emp);
		ModelAndView mav = new ModelAndView("redirect:/adminindex");
		mav.addObject("services", servicesdao.list());
		mav.addObject("title", "Employee Regester Page");
		mav.addObject("userClickReg", true);
		return mav;		
	}*/
	
	 
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
