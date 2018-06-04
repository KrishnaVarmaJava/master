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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mylas.com.erp.demo.EmpDetails;
import mylas.com.erp.demo.TblEmpAttendanceNew;
import mylas.com.erp.demo.TblEmpLeavereq;
import mylas.com.erp.demo.dao.EmpLeaveRequestDao;
import mylas.com.erp.demo.dao.ManagerServicesDao;
import mylas.com.erp.demo.daoimpl.EmpAttendanceDaoImpl;
import mylas.com.erp.demo.service.Client;

@Controller
public class ManagerPageController {

	@Autowired
	ManagerServicesDao mandao;
	
	@Autowired
	EmpLeaveRequestDao empleavereq;
	
	@Autowired
	EmpAttendanceDaoImpl empattreq;
	
	@RequestMapping(value= "/manager/leave/register")
	public ModelAndView empLeavePage(HttpSession session) {
		ModelAndView mav = new ModelAndView("empleaverequests");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		EmpDetails user=null;
		if (principal instanceof EmpDetails) {
		user = ((EmpDetails)principal);
		}
		
		String role = user.getRole();
		mav.addObject("Role",role);
		Client cl = new Client();
		
		List<TblEmpLeavereq> leavereq =  empleavereq.viewbyid(user.getEid());
		mav.addObject("User", user);
		mav.addObject("empleave", leavereq);
		mav.addObject("manservices", mandao.list());	
		return mav;
	}
	
	/*
	 * Post Method Handelling method
	 */
	@RequestMapping(value= "/manager/leave/register", method=RequestMethod.POST)
	public ModelAndView manLeaveRequestPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		
		ModelAndView mav = new ModelAndView("empleaverequests");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		EmpDetails user=null;
		if (principal instanceof EmpDetails) {
		user = ((EmpDetails)principal);
		}
		
		String role = user.getRole();
		mav.addObject("Role",role);
		Client cl = new Client();
		List<EmpDetails> emp1 = cl.getDetails();
		
		
		
		
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
		
		
		mav.addObject("employees", emp1);
		mav.addObject("User", user);
		mav.addObject("manservices", mandao.list());	
		mav.addObject("employees", emp1);
	
		
		TblEmpLeavereq empleave = new TblEmpLeavereq((int)daysNegative,null, request.getParameter("fromdate"),request.getParameter("leavereason"), request.getParameter("leavetype"), null, null,  request.getParameter("todate"),null);
		
		
		empleave.setManagerid(null);
		empleave.setEmployeeid(user.getEid());
		empleave.setStatus(null);
		try {
			empleavereq.save(empleave);	
			List<TblEmpLeavereq> leavereq =  empleavereq.viewbyid(user.getEid());
			mav.addObject("empleave", leavereq);
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
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		EmpDetails user=null;
		if (principal instanceof EmpDetails) {
		user = ((EmpDetails)principal);
		}
		
		String role = user.getRole();
		mav.addObject("Role",role);
		mav.addObject("User", user);
		mav.addObject("manservices", mandao.list());	
		return mav;
	}

	@RequestMapping(value= "/manager/timesheet/register")
	public ModelAndView indvidtimesheet(HttpSession session) {
		ModelAndView mav = new ModelAndView("emptimesheet");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		EmpDetails user=null;
		if (principal instanceof EmpDetails) {
		user = ((EmpDetails)principal);
		}
		
		String role = user.getRole();
		mav.addObject("Role",role);
		
		List<TblEmpAttendanceNew> attendances =  empattreq.viewbyid(user.getEid());
		mav.addObject("attendancelist",attendances);
		mav.addObject("manservices", mandao.list());	
		mav.addObject("User", user);
		return mav;
	}
	@RequestMapping(value= "/manager/timesheet/register", method=RequestMethod.POST)
	public ModelAndView timesheetSave(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("emptimesheet");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		EmpDetails user=null;
		if (principal instanceof EmpDetails) {
		user = ((EmpDetails)principal);
		}
		
		String role = user.getRole();
		mav.addObject("Role",role);
		
		TblEmpAttendanceNew attedance = new TblEmpAttendanceNew(null, null, null, null, Integer.parseInt(request.getParameter("day1")), Integer.parseInt(request.getParameter("day2")), Integer.parseInt(request.getParameter("day3")), Integer.parseInt(request.getParameter("day4")), Integer.parseInt(request.getParameter("day5")), Integer.parseInt(request.getParameter("day6")), Integer.parseInt(request.getParameter("day7")), Integer.parseInt(request.getParameter("day8")), Integer.parseInt(request.getParameter("day9")), Integer.parseInt(request.getParameter("day10")), Integer.parseInt(request.getParameter("day11")), Integer.parseInt(request.getParameter("day12")), Integer.parseInt(request.getParameter("day13")), Integer.parseInt(request.getParameter("day14")), Integer.parseInt(request.getParameter("day15")), Integer.parseInt(request.getParameter("day16")), Integer.parseInt(request.getParameter("day17")), Integer.parseInt(request.getParameter("day18")), Integer.parseInt(request.getParameter("day19")), Integer.parseInt(request.getParameter("day20")), Integer.parseInt(request.getParameter("day21")), Integer.parseInt(request.getParameter("day22")), Integer.parseInt(request.getParameter("day23")), Integer.parseInt(request.getParameter("day24")), Integer.parseInt(request.getParameter("day25")), Integer.parseInt(request.getParameter("day26")), Integer.parseInt(request.getParameter("day27")), Integer.parseInt(request.getParameter("day28")), Integer.parseInt(request.getParameter("day29")), Integer.parseInt(request.getParameter("day30")), Integer.parseInt(request.getParameter("day31")), null, null);
		attedance.setEmpid(user.getEid());
		attedance.setStatas(null);
		attedance.setMonth(request.getParameter("month"));
		attedance.setYear(Integer.parseInt(request.getParameter("year")));
		empattreq.save(attedance);
		List<TblEmpAttendanceNew> attendances =  empattreq.viewbyid(user.getEid());
		mav.addObject("attendancelist",attendances);
		mav.addObject("manservices", mandao.list());
		mav.addObject("User", user);
		return mav;
	}
	
	@RequestMapping(value= "manager/leaverequests/register")
	public ModelAndView allleaverequests(HttpSession session) {
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
		
		mav.addObject("manservices", mandao.list());	
		return mav;
	}
	
	
	@RequestMapping(value= "manager/employeetimesheets/register")
	public ModelAndView allAttRequests(HttpSession session) {
		ModelAndView mav = new ModelAndView("allemptimesheetrequests");
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
		
		mav.addObject("manservices", mandao.list());	
		return mav;
	}

	@RequestMapping(value= "/manager/leave/delete/{id}")
	public ModelAndView empLeavedeletePage(HttpSession session,@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("redirect:/manager/leave/register");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		EmpDetails user=null;
		if (principal instanceof EmpDetails) {
		user = ((EmpDetails)principal);
		}
		List<TblEmpLeavereq> leavereq =  empleavereq.viewbyid(user.getEid());
		String DelMsg = empleavereq.delete(id);
		mav.addObject("empleave", leavereq);
		mav.addObject("DelMsg", DelMsg);
		mav.addObject("manservices", mandao.list());	
		
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
		mav.addObject("manservices", mandao.list());	
		
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
		mav.addObject("manservices", mandao.list());	
		
		return mav;
	}
	
	/*
	 * Attendance TimeSheet Approve ans Decline
	 */
	
	@RequestMapping(value= "/manager/attendance/approve/{id}")
	public ModelAndView empTimesheetApprovePage(HttpSession session,@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("redirect:/manager/employeetimesheets/register");
		String reason = "Approved";
		boolean status = true;
		empattreq.update(status, id);		
		return mav;
	}
	@RequestMapping(value= "/manager/attendance/decline/{id}")
	public ModelAndView empTimesheetdeclinePage(HttpSession session,@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("redirect:/manager/employeetimesheets/register");
		String reason = "Decline";
		boolean status = false;
		empattreq.update(status, id);
		return mav;
	}
	
}
