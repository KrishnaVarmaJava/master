<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<spring:url var="plugins" value="/resources/plugins" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Amp Demo</title>
    <!-- Favicon-->
    <link rel="icon" href="${images}/favicon.png" type="image/x-icon">

    <!--REQUIRED PLUGIN CSS-->
    <link href="${plugins}/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="${plugins}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="${plugins}/node-waves/waves.css" rel="stylesheet" />
    <link href="${plugins}/animate-css/animate.css" rel="stylesheet" />
    <link href="${plugins}/spinkit/spinkit.css" rel="stylesheet">

    <!--THIS PAGE LEVEL CSS-->
    <link href="${plugins}/tablesaw/css/tablesaw.min.css" rel="stylesheet">
	  <link href="${plugins}/nifty-modal/component.css" rel="stylesheet" />
	

    <!--REQUIRED THEME CSS -->
    <link href="${css}/style.css" rel="stylesheet">
    <link href="${css}/layout.css" rel="stylesheet">
    <link href="${css}/themes/main_theme.css" rel="stylesheet" />
		 <link href="${css}/custom_style.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
    .wdth td{
    min-width:80px;
    }
    .selected {
    background:red;
	}
}
    </style>
</head>
<body class="theme-indigo light layout-fixed">
<div class="wrapper">

    <!-- top navbar-->
    <header class="topnavbar-wrapper">
        <nav role="navigation" class="navbar topnavbar">
            <!-- START navbar header-->
                 <%@include file="shared/navbar.jsp" %>
      <!-- END Top Navbar-->
    </header>
    <!-- sidebar-->
    <aside class="aside">
        <!-- START Sidebar (left)-->
       <%@include file="shared/slidebar.jsp" %>
              <!-- #END# Sidebar (left)-->
    </aside>
    <!-- offsidebar-->
    <aside class="offsidebar hide">
        <!-- START Off Sidebar (right)-->
         <%@include file="shared/offslidebar.jsp" %>
        <!-- #END# Off Sidebar (right)-->
    </aside>
    <!-- Main section-->
    <section>
        <!-- Page content-->
        <div class="content-wrapper">
            <div class="container-fluid">
			
			 <div class="row clearfix">
                
				<div class="">
				
			
				 <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 topbar">
				 
	             <div class="col-md-6">
				 <div class="row pagetitle">
				<span > Attendance Sheet </span>
				 </div>
				  </div>
			 
			
                </div>
			
				</div>
				</div>
					</div>
					
					
                <div class="row clearfix">
                
				
		
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ">
                    
					

                        <!-- Table Kitchen Sink -->
                       



                        
                        <form action="${contextRoot}/${sessionScope.emprole}/timesheet/register" method="post" onsubmit="return validate()" >
                        <div class="card">
                        		
                            <div class="body">
                               <table class="tablesaw table-striped table-hover table-bordered wdth" data-tablesaw-mode="swipe" data-tablesaw-minimap>
                                    <thead class="tableheding ">
                                    <tr>
                                        <th data-tablesaw-sortable-col data-tablesaw-sortable-default-col data-tablesaw-priority="persist">Employee</th>
										 <th data-tablesaw-sortable-col data-tablesaw-sortable-default-col data-tablesaw-priority="persist">Year</th>
										  <th data-tablesaw-sortable-col data-tablesaw-sortable-default-col data-tablesaw-priority="persist">Month</th>
				
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="3">1</th>
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="2">2</th>
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="4">3 </th>
										 
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="4">4</th>
										   <th data-tablesaw-sortable-col data-tablesaw-priority="2">5</th>
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="4">6</th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">7 </th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">8 </th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">9 </th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">10 </th>
										           <th data-tablesaw-sortable-col data-tablesaw-priority="3">11</th>
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="2">12</th>
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="4">13 </th>
										 
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="4">14</th>
										   <th data-tablesaw-sortable-col data-tablesaw-priority="2">15</th>
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="4">16</th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">17 </th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">18 </th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">19 </th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">20 </th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="3">21</th>
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="2">22</th>
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="4">23 </th>
										 
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="4">24</th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="2">25</th>
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="4">26</th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">27 </th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">28 </th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">29 </th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">30 </th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">31 </th>
                                      
                                    </tr>
                                    </thead>
									
								
								
                                    <tbody>
										
										
									
                                         <tr>
                                        <th><a href="${contextRoot}/employee/profile/register">${sessionScope.empfname} ${sessionScope.emplname}</a></th>
                                     
                                        <td> <select class="form-control" size="1" name="year" id="year" required>
                                            <option value="0">Please select</option>
                                            <option value="2018">2018</option>
                                            <option value="2019">2019</option>
                                            <option value="2020">2020</option>
                                        </select></td>
                                          <td> <select class="form-control" size="1" name="month" id="month" required>
                                            <option value="0">Please select</option>
                                            <option value="January">January</option>
                                            <option value="February">February</option>
                                            <option value="March">March</option>
                                            <option value="April">April</option>
                                            <option value="May">May</option>
                                            <option value="June">June</option>
                                            <option value="July">July</option>
                                            <option value="August">August</option>
                                            <option value="September">September</option>
                                            <option value="October">October</option>
                                            <option value="November">November</option>
                                            <option value="December">December</option>
                                        </select></td>
                                        <c:forEach begin="1" end="31" varStatus="loop">
                                      

											<td>
										 <select class="form-control"  size="1" name="day${loop.index}"  id="day${loop.index}" required>
                                            <option value="0">Please select</option>
                                            <option value="1">Present</option>
                                            <option value="2">Absent Or Leave</option>
                                            <option value="3">WeekEnd Or Holiday</option>
</select>


<% String str="day${loop.index}"; %>
				 <script>
                 
                 
                        function validate() {
                            //alert("hai");
                        	// var opt= document.getElementById("day${loop.index}").value; // or in jQuery use: select = this;
                        	 var opt=document.getElementById("day${loop.index}").value;
                        	 var name=document.getElementsByName("day${loop.index}");
                                if (opt==0) {
                              alert("plese select the option");
                             // document.getElementById("day${loop.index}").focus();
                            

                             $("name").addClass("selected");
                             alert("ffg");
                              document.getElementById("day${loop.index}").style.backgroundColor = "lightblue";
                              return false;
                            } 
                             
                        }
                        </script>
</td></c:forEach>
											  
                                    </tr>

                                   
                                    </tbody>
                                   </table>
                                    <div class="pull-right" style="margin-bottom: 10px;margin-top:10px;">
                                   <button type="submit"  class="btn btn-primary"  >Submit123</button>
                                </div>
                                   </div>
                                   <div class="clearfix"></div>
                             
                            
                         
                            
                        </div>
                        <!-- #END# Kitchen Sink -->
</form>
                   
                </div>
            </div>
            
            
                   <div class="row clearfix">
                
				
		
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ">
                    
					

                        <!-- Table Kitchen Sink -->
                        <div class="card">
                        		 
                            <div class="body">
                               <table class="tablesaw table-striped table-hover table-bordered" data-tablesaw-mode="swipe" data-tablesaw-minimap>
                                    <thead class="tableheding">
                                    <tr>
                                        <th data-tablesaw-sortable-col data-tablesaw-sortable-default-col data-tablesaw-priority="persist">Month</th>
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="3">1</th>
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="2">2</th>
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="4">3 </th>
										 
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="4">4</th>
										   <th data-tablesaw-sortable-col data-tablesaw-priority="2">5</th>
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="4">6</th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">7 </th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">8 </th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">9 </th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">10 </th>
										           <th data-tablesaw-sortable-col data-tablesaw-priority="3">11</th>
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="2">12</th>
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="4">13 </th>
										 
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="4">14</th>
										   <th data-tablesaw-sortable-col data-tablesaw-priority="2">15</th>
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="4">16</th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">17 </th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">18 </th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">19 </th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">20 </th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="3">21</th>
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="2">22</th>
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="4">23 </th>
										 
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="4">24</th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="2">25</th>
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="4">26</th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">27 </th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">28 </th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">29 </th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">30 </th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1">31 </th>
                                      <th data-tablesaw-sortable-col data-tablesaw-sortable-default-col data-tablesaw-priority="persist" style="width: 11%;">STATUS </th>
                                      <th data-tablesaw-sortable-col data-tablesaw-sortable-default-col data-tablesaw-priority="persist">Edit </th>
                                    </tr>
                                    </thead>
									<div class="clearfix"></div>
								
								<c:forEach var="attlist" items="${attendancelist}">
                                    <tbody>
									<c:set var="green" value="icon-display  fa fa-check attenedance_check_green"/>
									<c:set var="red" value="icon-display  fa fa-close  attenedance_check_red"/>
									<c:set var="gray" value="icon-display  fa fa-bullseye attenedance_check_darkgrey"/>
									
                        		 
									
                                         <tr>
                                        <th><a href="javascript:void(0)">${attlist.getMonth()} ${attlist.getYear()}</a></th>
                                     <c:if test="${attlist.getDay1() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay1() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay1() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
                                            <c:if test="${attlist.getDay2() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay2() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay2() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
                                           <c:if test="${attlist.getDay3() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay3() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay3() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
                                         
                                         <c:if test="${attlist.getDay4() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay4() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay4() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
                                         
                                            <c:if test="${attlist.getDay5() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay5() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay5() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
                                            <c:if test="${attlist.getDay6() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay6() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay6() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
                                    <c:if test="${attlist.getDay7() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay7() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay7() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
                                          <c:if test="${attlist.getDay8() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay8() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay8() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
										      <c:if test="${attlist.getDay9() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay9() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay9() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
										   <c:if test="${attlist.getDay10() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay10() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay10() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
                                              <c:if test="${attlist.getDay11() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay11() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay11() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
                                            <c:if test="${attlist.getDay12() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay12() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay12() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
                                     <c:if test="${attlist.getDay13() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay13() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay13() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
                                              <c:if test="${attlist.getDay14() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay14() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay14() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
                                             <c:if test="${attlist.getDay15() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay15() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay15() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
                                          <c:if test="${attlist.getDay16() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay16() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay16() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
                                              <c:if test="${attlist.getDay17() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay17() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay17() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
                                    <c:if test="${attlist.getDay18() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay18() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay18() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
										        <c:if test="${attlist.getDay19() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay19() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay19() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
										          <c:if test="${attlist.getDay20() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay20() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay20() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
                                             <c:if test="${attlist.getDay21() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay21() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay21() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
                                         <c:if test="${attlist.getDay22() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay22() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay22() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
                                            <c:if test="${attlist.getDay23() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay23() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay23() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
                                             <c:if test="${attlist.getDay24() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay24() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay24() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
                                            <c:if test="${attlist.getDay25() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay25() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay25() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
                                             <c:if test="${attlist.getDay26() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay26() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay26() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
                                            <c:if test="${attlist.getDay27() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay27() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay27() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
                                             <c:if test="${attlist.getDay28() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay28() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay28() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
										       <c:if test="${attlist.getDay29() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay29() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay29() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
										        <c:if test="${attlist.getDay30() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay30() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay30() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
                                          <c:if test="${attlist.getDay31() == 1}">
                                        <td><i class="${green}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay31() == 2}">
                                        <td><i class="${red}" ></i></td>
                                        </c:if>
                                        <c:if test="${attlist.getDay31() == 3}">
                                        <td><i class="${gray}" ></i></td>
                                        </c:if>
                                    
                                    <td>
									<div class="btn-group">
													<c:if test="${attlist.getStatas() == null}">
														<button type="button"
															class="btn btn-primary btn-outline btn-rounded waves-effect"
															data-toggle="dropdown" aria-haspopup="true"
															aria-expanded="false">Panding 
														</button>
														</c:if><c:if test="${attlist.getStatas() == false}">
																<button type="button"
															class="btn btn-primary  btn-outline btn-rounded waves-effect colorred"
															>Declined 
														</button></c:if><c:if test="${attlist.getStatas() == true}">
																<button type="button"
															class="btn btn-primary colorgreen btn-outline btn-rounded waves-effect "
															data-toggle="dropdown" aria-haspopup="true"
															aria-expanded="false">Approved 
														</button>
												</c:if>
													</div>
												</td>
												<td>
													<ul class="tabelaction">
														<li class="dropdown"><a href="javascript:void(0);"
															class="dropdown-toggle" data-toggle="dropdown"
															role="button" aria-haspopup="true" aria-expanded="false">
																<i class="material-icons">more_vert</i>
														</a>
															<ul class="dropdown-menu pull-right">
															<c:if test="${attlist.getStatas() == null}">
																<li><a href="${contextRoot}/${sessionScope.emprole}/timesheet/delete/${attlist.getId()}"><i
																		class="material-icons">delete</i>Delete</a></li>
																</c:if>
															</ul></li>
													</ul>
												</td>
									  </tr>
               
                                   </tbody>
                                    </c:forEach>
                                </table>
                                
                            </div>
                            
                        </div>
                        
                        <!-- #END# Kitchen Sink -->

                   
                </div>
            </div>
            
        </div>
			<div class="md-overlay custom-overlay"></div>
    </section>
    <!-- FOOTER-->
    <footer>
        <span>&copy; 2018 -  <b class="col-blue">Amp</b></span>
    </footer>
</div>
<!-- CORE PLUGIN JS -->
<script src="${plugins}/jquery/jquery.min.js"></script>
<script src="${plugins}/bootstrap/js/bootstrap.js"></script>
<script src="${plugins}/modernizr/modernizr.custom.js"></script>
<script src="${plugins}/screenfull/dist/screenfull.js"></script>
<script src="${plugins}/jQuery-Storage-API/jquery.storageapi.js"></script>
<script src="${plugins}/jquery-slimscroll/jquery.slimscroll.js"></script>
<script src="${plugins}/node-waves/waves.js"></script>

<!--THIS PAGE LEVEL JS-->
<script src="${plugins}/tablesaw/js/tablesaw.js"></script>
<script src="${plugins}/tablesaw/js/tablesaw-init.js"></script>
<script src="${js}/pages/ui/modals.js"></script>
<script src="${plugins}/bootstrap-notify/bootstrap-notify.js"></script>
<script src="${plugins}/nifty-modal/modalEffects.js"></script>
<script src="${plugins}/nifty-modal/classie.js"></script>

<!-- LAYOUT JS -->
<script src="${js}/demo.js"></script>
<script src="${js}/layout.js"></script>






</body>

</html>