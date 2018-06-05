
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
import mylas.com.erp.demo.dao.EmpServicesDao;
import mylas.com.erp.demo.daoimpl.EmpAttendanceDaoImpl;
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

	@Autowired
	EmpAttendanceDaoImpl empattreq;
	/*
	 * Employee Regestration Page Get Method
	 */
	@RequestMapping(value= "/employee/leave/register")
	public ModelAndView empLeavePage(HttpSession session) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		EmpDetails user=null;
		if (principal instanceof EmpDetails) {
		user = ((EmpDetails)principal);
		}
		String role = user.getRole();
		ModelAndView mav = new ModelAndView("empleaverequests");
		Client cl = new Client();
		/*List<EmpDetails> emp1 = cl.getDetails();*/
		List<TblEmpLeavereq> leavereq =  empleavereq.viewbyid(user.getEid());
		mav.addObject("Role",role);
		mav.addObject("User", user);
		mav.addObject("empleave", leavereq);
		mav.addObject("empservices", empservicesdao.list());
		return mav;
	}

	@RequestMapping(value= "/employee/profile/register")
	public ModelAndView empProfilePage() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		EmpDetails user=null;
		if (principal instanceof EmpDetails) {
		user = ((EmpDetails)principal);
		}
		String role = user.getRole();
		ModelAndView mav = new ModelAndView("useremployee");
		mav.addObject("Role", role);
		mav.addObject("User", user);
		mav.addObject("empservices", empservicesdao.list());	
		return mav;
	}

	/*
	 * Test Comment
	 */
	@RequestMapping(value= "/employee/timesheet/register")
	public ModelAndView indvidtimesheet() {
		ModelAndView mav = new ModelAndView("emptimesheet");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		EmpDetails user=null;
		if (principal instanceof EmpDetails) {
		user = ((EmpDetails)principal);
		}
	 
		String role = user.getRole();
		List<TblEmpAttendanceNew> attendances =  empattreq.viewbyid(user.getEid());
		mav.addObject("attendancelist",attendances);
		mav.addObject("empservices", empservicesdao.list());
		mav.addObject("Role",role);
		mav.addObject("User", user);
		return mav;
	}

	@RequestMapping(value= "/employee/timesheet/register", method=RequestMethod.POST)
	public ModelAndView indvidtimesheetsubmit(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mav = new ModelAndView("emptimesheet");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		EmpDetails user=null;
		if (principal instanceof EmpDetails) {
		user = ((EmpDetails)principal);
		}
	 
		String role = user.getRole();
		
		TblEmpAttendanceNew attedance = new TblEmpAttendanceNew(null, null, null, null, Integer.parseInt(request.getParameter("day1")), Integer.parseInt(request.getParameter("day2")), Integer.parseInt(request.getParameter("day3")), Integer.parseInt(request.getParameter("day4")), Integer.parseInt(request.getParameter("day5")), Integer.parseInt(request.getParameter("day6")), Integer.parseInt(request.getParameter("day7")), Integer.parseInt(request.getParameter("day8")), Integer.parseInt(request.getParameter("day9")), Integer.parseInt(request.getParameter("day10")), Integer.parseInt(request.getParameter("day11")), Integer.parseInt(request.getParameter("day12")), Integer.parseInt(request.getParameter("day13")), Integer.parseInt(request.getParameter("day14")), Integer.parseInt(request.getParameter("day15")), Integer.parseInt(request.getParameter("day16")), Integer.parseInt(request.getParameter("day17")), Integer.parseInt(request.getParameter("day18")), Integer.parseInt(request.getParameter("day19")), Integer.parseInt(request.getParameter("day20")), Integer.parseInt(request.getParameter("day21")), Integer.parseInt(request.getParameter("day22")), Integer.parseInt(request.getParameter("day23")), Integer.parseInt(request.getParameter("day24")), Integer.parseInt(request.getParameter("day25")), Integer.parseInt(request.getParameter("day26")), Integer.parseInt(request.getParameter("day27")), Integer.parseInt(request.getParameter("day28")), Integer.parseInt(request.getParameter("day29")), Integer.parseInt(request.getParameter("day30")), Integer.parseInt(request.getParameter("day31")), null, null);
		attedance.setEmpid(user.getEid());
		attedance.setStatas(null);
		attedance.setManagerid(user.getManagerid());
		attedance.setMonth(request.getParameter("month"));
		attedance.setYear(Integer.parseInt(request.getParameter("year")));
		empattreq.save(attedance);
		List<TblEmpAttendanceNew> attendances =  empattreq.viewbyid(user.getEid());
		mav.addObject("attendancelist",attendances);
		mav.addObject("empservices", empservicesdao.list());	
		mav.addObject("Role",role);
		mav.addObject("User", user);
		return mav;
	}

	/*
	 * Handling EMployee Requests
	 * 
	 */

	@RequestMapping(value= "/employee/leave/register", method=RequestMethod.POST)
	public ModelAndView empLeaveRequestPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		EmpDetails user=null;
		if (principal instanceof EmpDetails) {
		user = ((EmpDetails)principal);
		}
	 
		String role = user.getRole();

		ModelAndView mav = new ModelAndView("empleaverequests");
		Client cl = new Client();
		
		
		mav.addObject("Role",role);
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



		

		TblEmpLeavereq empleave = new TblEmpLeavereq((int)daysNegative,null, request.getParameter("fromdate"),request.getParameter("leavereason"), request.getParameter("leavetype"), null, null,  request.getParameter("todate"),null);
		empleave.setManagerid(user.getManagerid());
		empleave.setEmployeeid(user.getEid());
		empleave.setStatus(null);
		empleavereq.save(empleave);		
		System.out.println("Req Sent to Save");
		List<EmpDetails> emp1 = cl.getDetails();
		List<TblEmpLeavereq> leavereq =  empleavereq.viewbyid(user.getEid());
		mav.addObject("employees", emp1);
		mav.addObject("empleave", leavereq);
		mav.addObject("empservices", empservicesdao.list());	
		mav.addObject("employees", emp1);
		mav.addObject("empleave", leavereq);
		mav.addObject("Submitmsg", "Your Leave Request Has Been Submitted Sucessfully! Please Wait for your Manager Approval");
		mav.addObject("Role",role);
		return mav;
	}


	/*
	 * Employee Leave Request Edit and Delete Operations
	 */
	

	@RequestMapping(value= "/employee/leave/delete/{id}")
	public ModelAndView empLeavedeletePage(HttpSession session,@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("redirect:/employee/leave/register");
		String DelMsg = empleavereq.delete(id);
		return mav;
	}
	@RequestMapping(value= "/employee/timesheet/delete/{id}")
	public ModelAndView empTimeSheetdeletePage(HttpSession session,@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("redirect:/employee/timesheet/register");
		String DelMsg = empattreq.delete(id);
		return mav;
	}

}
