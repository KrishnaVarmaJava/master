package mylas.com.erp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mylas.com.erp.demo.dao.ManagerServicesDao;

@Controller
public class ManagerPageController {

	@Autowired
	ManagerServicesDao mandao;
	
	
	@RequestMapping(value= "/manager/leave/register")
	public ModelAndView empLeavePage() {
		ModelAndView mav = new ModelAndView("empleaverequests");
		mav.addObject("services", mandao.list());	
		return mav;
	}
	
	@RequestMapping(value= "/manager/profile/register")
	public ModelAndView empProfilePage() {
		ModelAndView mav = new ModelAndView("useremployee");
		mav.addObject("services", mandao.list());	
		return mav;
	}

	@RequestMapping(value= "/manager/timesheet/register")
	public ModelAndView indvidtimesheet() {
		ModelAndView mav = new ModelAndView("indvidtimesheet");
		mav.addObject("services", mandao.list());	
		return mav;
	}
	
}
