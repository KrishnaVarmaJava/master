package mylas.com.erp.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView indexPage() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("title", "HomePage");
		mav.addObject("userClickHome", true);
		return mav;
	}
	@RequestMapping(value= {"/add"})
	public ModelAndView indexPagemsg(
			@RequestParam(value="message", required=false)String message
			) {
		if(message==null) {
			message="Default Message";
		}
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("message", message);
		return mav;
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
