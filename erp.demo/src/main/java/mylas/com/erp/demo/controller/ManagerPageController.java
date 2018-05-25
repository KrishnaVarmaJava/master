package mylas.com.erp.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mylas.com.erp.demo.EmpDetails;
import mylas.com.erp.demo.TblEmpLeavereq;
import mylas.com.erp.demo.dao.EmpLeaveRequestDao;
import mylas.com.erp.demo.dao.ManagerServicesDao;
import mylas.com.erp.demo.service.Client;

@Controller
public class ManagerPageController {

	@Autowired
	ManagerServicesDao mandao;
	
	@Autowired
	EmpLeaveRequestDao empleavereq;
	
	@RequestMapping(value= "/manager/leave/register")
	public ModelAndView empLeavePage(HttpSession session) {
		ModelAndView mav = new ModelAndView("empleaverequests");
		Client cl = new Client();
		String empname = (String) session.getAttribute("empuname");
		List<EmpDetails> emp1 = cl.getDetails();
		List<TblEmpLeavereq> leavereq =  empleavereq.viewbyid(empname);
		mav.addObject("employees", emp1);
		mav.addObject("empleave", leavereq);
		mav.addObject("services", mandao.list());	
		return mav;
	}
	
	/*
	 * Post Method Handelling method
	 */
	@RequestMapping(value= "/manager/leave/register", method=RequestMethod.POST)
	public ModelAndView manLeaveRequestPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		
		ModelAndView mav = new ModelAndView("empleaverequests");
		Client cl = new Client();
		List<EmpDetails> emp1 = cl.getDetails();
		String empname = (String) session.getAttribute("empuname");
		List<TblEmpLeavereq> leavereq =  empleavereq.viewbyid(empname);
		mav.addObject("employees", emp1);
		mav.addObject("empleave", leavereq);
		
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
		
		
	
		mav.addObject("services", mandao.list());	
		mav.addObject("employees", emp1);
		mav.addObject("empleave", leavereq);
		
		TblEmpLeavereq empleave = new TblEmpLeavereq((int)daysNegative,null, request.getParameter("fromdate"),request.getParameter("leavereason"), request.getParameter("leavetype"), null, null,  request.getParameter("todate"),null);
		
		
		empleave.setManagerid(null);
		empleave.setEmployeeid((String) session.getAttribute("empuname"));
		empleave.setStatus(null);
		try {
			empleavereq.save(empleave);		
			System.out.println("Req Sent to Save");
			mav.addObject("Submitmsg", "Your Leave Request Has Been Submitted Sucessfully! Please Wait for your Manager Approval");
			return mav;
		}catch(DateTimeParseException e){
			mav.addObject("errmsg", "Please enter the required fields");
			return mav;
		}
		
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
	
	@RequestMapping(value= "manager/leaverequests/register")
	public ModelAndView allleaverequests(HttpSession session) {
		ModelAndView mav = new ModelAndView("allempleaverequests");
		
		Client cl = new Client();
		cl.getEmpDetails();
		String empname = (String) session.getAttribute("empuname");
		List<EmpDetails> emp1 = cl.getDetails();
		List<TblEmpLeavereq> leavereq =  empleavereq.view();
		mav.addObject("employees", emp1);
		mav.addObject("empleave", leavereq);
		
		mav.addObject("services", mandao.list());	
		return mav;
	}
	
	/*
	 * Employee Leave Request Edit and Delete Operations
	 */
/*	@RequestMapping(value= "/manager/leave/edit/{id}")
	public ModelAndView empLeaveeditPage(HttpSession session,@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("empleavereqedit");
		String empname = (String) session.getAttribute("empuname");
		List<TblEmpLeavereq> leavereq =  empleavereq.viewbyid(empname);
		TblEmpLeavereq leaveobj = empleavereq.view(id);
		mav.addObject("empleave", leavereq);
		mav.addObject("leaveobj", leaveobj);
		mav.addObject("services", mandao.list());	
		
		return mav;
	}*/
	@RequestMapping(value= "/manager/leave/delete/{id}")
	public ModelAndView empLeavedeletePage(HttpSession session,@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("redirect:/manager/leave/register");
		String empname = (String) session.getAttribute("empuname");
		List<TblEmpLeavereq> leavereq =  empleavereq.viewbyid(empname);
		String DelMsg = empleavereq.delete(id);
		mav.addObject("empleave", leavereq);
		mav.addObject("DelMsg", DelMsg);
		mav.addObject("services", mandao.list());	
		
		return mav;
	}
	
	/*
	 * Leave Approve and Decline Handlers
	 */
	
	@RequestMapping(value= "/manager/leave/approve/{id}")
	public ModelAndView empLeaveApprovePage(HttpSession session,@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("redirect:/manager/leaverequests/register");
		List<TblEmpLeavereq> leavereq =  empleavereq.view();
		String reason = "Approved";
		boolean status = true;
		String UMsg = empleavereq.update(id,reason,status);
		mav.addObject("empleave", leavereq);
		mav.addObject("UMsg", UMsg+" "+reason);
		mav.addObject("services", mandao.list());	
		
		return mav;
	}
	@RequestMapping(value= "/manager/leave/decline/{id}")
	public ModelAndView empLeavedeclinePage(HttpSession session,@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("redirect:/manager/leaverequests/register");
		List<TblEmpLeavereq> leavereq =  empleavereq.view();
		String reason = "Decline";
		boolean status = false;
		String UMsg = empleavereq.update(id,reason,status);
		mav.addObject("empleave", leavereq);
		mav.addObject("UMsg", UMsg+" "+reason);
		mav.addObject("services", mandao.list());	
		
		return mav;
	}
}
