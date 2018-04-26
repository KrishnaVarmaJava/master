package mylas.com.erp.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mylas.com.erp.demo.services.LoginService;

@Controller
public class PageController {
	
	LoginService service;

	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView indexPage() {
		ModelAndView mav = new ModelAndView("index");
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
	


	@RequestMapping(value= "/login", method=RequestMethod.POST)
	public ModelAndView loginPageValidation(
			@RequestParam String username,
			@RequestParam String password
			) {
		boolean isValidUser = service.validateUser(username, password);
		if(isValidUser==true) {

			ModelAndView mav = new ModelAndView("index");
			return mav;
		}else {
			ModelAndView mav = new ModelAndView("log_in");
			mav.addObject("errorMessage", "Please Enter Valid Cerdentials");
			return mav;
		}
	}
	
	@RequestMapping(value= "/addvar/{message}")
	public ModelAndView indexPagemsgreqvar(
			@PathVariable("message")String message
			) {
		if(message==null) {
			message="Default Message";
		}
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("message", message);
		return mav;
	}
}
