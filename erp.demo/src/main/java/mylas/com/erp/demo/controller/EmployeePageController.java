
package mylas.com.erp.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mylas.com.erp.demo.EmpDetails;
import mylas.com.erp.demo.TblEmpLeavereq;
import mylas.com.erp.demo.dao.EmpLeaveRequestDao;
import mylas.com.erp.demo.dao.EmpServicesDao;
import mylas.com.erp.demo.daoimpl.EmpLeaveRequestService;
import mylas.com.erp.demo.service.Client;

/*
 * This Controller will Handle all the Employee Related Pages.
 */

@Controller
public class EmployeePageController {

	@Autowired
	EmpServicesDao empservicesdao;
	
	@Autowired
	EmpLeaveRequestDao empleavereq;
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
	
	/*
	 * Handling EMployee Requests
	 * 
	 */
	
	@RequestMapping(value= "/employee/leave/register", method=RequestMethod.POST)
	public ModelAndView empLeaveRequestPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		/**
		 * Handling request from empleaverequests.jsp form with post action.
		 */
		
		String fromdate = request.getParameter("fromdate");
		String[] date = fromdate.split("-");
		String todate = request.getParameter("todate");
		SimpleDateFormat formatfromdate = new SimpleDateFormat("yyyy-mm-dd");
		Date reqfromDate = null;
		Date reqtoDate = null;
		try {
			reqfromDate = formatfromdate.parse(fromdate);
			reqtoDate = formatfromdate.parse(todate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		LocalDate Day1 = LocalDate.parse(fromdate);
		LocalDate Day2 = LocalDate.parse(todate);
		
		long daysNegative = ChronoUnit.DAYS.between(Day1, Day2);
		Client cl = new Client();
		List<EmpDetails> emp1 = cl.getDetails();
		List<TblEmpLeavereq> leavereq =  empleavereq.view();
		ModelAndView mav = new ModelAndView("empleaverequests");
		TblEmpLeavereq empleave = new TblEmpLeavereq();
		empleave.setLeavetype(request.getParameter("leavetype"));
		empleave.setFromdate(request.getParameter("fromdate"));
		empleave.setTodate(request.getParameter("todate"));
		empleave.setId(1);
		empleave.setCount((int)daysNegative);
		empleave.setLeavereason(request.getParameter("leavereason"));
		empleave.setManagerid(null);
		empleave.setEmployeeid(null);
		empleave.setStatus(null);
		System.out.println(empleave.getLeavetype() + empleave.getFromdate() + empleave.getTodate() + empleave.getLeavereason()+ empleave.getManagerid());
		empleavereq.save(empleave);
		
		
		mav.addObject("employees", emp1);
		mav.addObject("empleave", leavereq);	
		mav.addObject("services", empservicesdao.list());	
		return mav;
	}
	

	

	
}
