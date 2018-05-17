package mylas.com.erp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mylas.com.erp.demo.dao.EmpServicesDao;

/*
 * This Controller will Handle all the Employee Related Pages.
 */

@Controller
public class EmployeePageController {

	@Autowired
	EmpServicesDao empservicesdao;
	/*
	 * Employee Regestration Page Get Method
	 */
	@RequestMapping(value= "/employee/leave/register")
	public ModelAndView empLeavePage() {
		ModelAndView mav = new ModelAndView("empleaverequests");
		mav.addObject("services", empservicesdao.list());	
		return mav;
	}
	
	@RequestMapping(value= "/employee/profile/register")
	public ModelAndView empProfilePage() {
		ModelAndView mav = new ModelAndView("useremployee");
		mav.addObject("services", empservicesdao.list());	
		return mav;
	}
	
	/*
	 * Test Comment
	 */
	@RequestMapping(value= "/employee/timesheet/register")
	public ModelAndView indvidtimesheet() {
		ModelAndView mav = new ModelAndView("indvidtimesheet");
		mav.addObject("services", empservicesdao.list());	
		return mav;
	}
	
	@RequestMapping(value= "/employee/leave/empleaverequest")
	public ModelAndView empLeaveRequest() {
		ModelAndView mav = new ModelAndView("empleaverequests");
		mav.addObject("services", empservicesdao.list());	
		return mav;
	}
	
}
