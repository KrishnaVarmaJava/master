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
</head>

<body class="theme-indigo light layout-fixed">
<div class="wrapper">

		<!-- top navbar-->
		<header class="topnavbar-wrapper">
		
			<%@include file="shared/navbar.jsp"%>
		</header>
		<!-- sidebar-->
		<%@include file="shared/slidebar.jsp"%>
		<!-- offsidebar-->
		<%@include file="shared/offslidebar.jsp"%>
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
				<span > Leave Request </span>
				 </div>
				  </div>
				  

		
	         
	             <div class="col-md-6">
				 <div class="row pagetitle">
				<span class="pull-right" > 	 <button type="button" class="btn btn-primary btn-rounded waves-effect">Add Leave </button> </span>
				 </div>
				  </div>
				     
				 
				 <div>
				 
				 
				 </div>
			   
                   
                </div>
			
				</div>
				</div>
					</div>
					
					<div class="col-md-12 card">
				<div class="custom_title">	
				<h2> Add Leave Request</h2>
				</div>
				<form action="${contextRoot}/employee/leave/register" method="post">
				<hr class="custom_line">	
                            <div class="body">
                        
						 <div class="col-md-6">
						    <div class="form-group">
                                                <div class="form-line">
                                                    <label>Leave Type</label>
                                                    <select class="form-control" size="1" name="leavetype" id="leavetype">
                                                        <option value="0">Please select</option>
                                                        <option value="LOP">Loss of Pay</option>
                                                        <option value="CL">Casual Leave 12 Days</option>
                                                        <option value="ML">Medical Leave</option>
                                                    </select>
                                                </div>
                                            </div>
						 </div>
						 <div class="col-md-6">
						      <div class="form-group">
                                                                <div class="input-group addon-line">
                                                                    <div class="form-line">
																	   <label>From </label>
                                                                        <input type="date" name="fromdate" id="fromdate" class="form-control" placeholder="From Date">
                                                                    </div>
                                                                    <span class="input-group-addon"><i class="material-icons">date_range
</i></span>
                                                                </div>
                                                            </div>
					
						 </div>
						 
						 			 <div class="col-md-6">
						      <div class="form-group">
                                                                <div class="input-group addon-line">
                                                                    <div class="form-line">
																	   <label>To </label>
                                                                        <input type="date" name="todate" id="todate" class="form-control" placeholder="To Date">
                                                                    </div>
                                                                    <span class="input-group-addon"><i class="material-icons">date_range
</i></span>
                                                                </div>
                                                            </div>
					
						 </div>
						 
						 	 <div class="col-md-6">
						     <div class="form-group">
                                                <div class="form-line">
                                                    <label>Leave Reason </label>
                                                    <textarea name="leavereason" id="leavereason" class="form-control" rows="3"></textarea>
                                                </div>
                                            </div>
					
						 </div>
						 <div class="col-md-6">
						    <div class="form-group">
                                                <div class="form-line">
                                                    <label>Manager</label>
                                                    <select class="form-control" size="1" name="manager" id="manager">
                                                        <option value="0">Please select</option>
                                                        <option value="Man1">Manager1</option>
                                                        <option value="Man2">Manager2</option>
                                                        <option value="Man3">Manager3</option>
                                                    </select>
                                                </div>
                                            </div>
						 </div>
						 <div class="clearfix"> </div>
						 <div style="text-align:center;">
					 <button type="submit" class="btn btn-primary btn-rounded waves-effect">Send Leave Request</button>
					 </div>
					</div>
					</form>
					</div>
				
                <div class="row clearfix">
                
				
		
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ">
                    
					

                        <!-- Table Kitchen Sink -->
                        <div class="card">
                        		 <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 search_leav">
				<div class="col-md-2 padding_col">
					  <div class="form-group">
                                        
                                        <input type="text" class="form-control" placeholder="Username" />
                                    </div>
					</div>
					<div class="col-md-2 padding_col">
					     <div class="form-group">
                                       
                                        <select class="form-control" size="1">
                                            <option value="0">Please select</option>
                                            <option value="1">Option #1</option>
                                            <option value="2">Option #2</option>
                                            <option value="3">Option #3</option>
                                        </select>
                                    </div>
					</div>
					<div class="col-md-2 padding_col">
					     <div class="form-group">
                                       
                                        <select class="form-control" size="1">
                                            <option value="0">Please select</option>
                                            <option value="1">Option #1</option>
                                            <option value="2">Option #2</option>
                                            <option value="3">Option #3</option>
                                        </select>
                                    </div>
					</div>
					<div class="col-md-2 padding_col">
					    <div class="input-group">
                                                    <input type="text" class="form-control" data-provide="datepicker">
                                                    <span class="input-group-addon bg"><i class="fa fa-calendar"></i></span>
                                                </div>
					</div>
					<div class="col-md-2 padding_col">
				     <div class="input-group">
                                                    <input type="text" class="form-control" data-provide="datepicker">
                                                    <span class="input-group-addon bg"><i class="fa fa-calendar"></i></span>
                                                </div>
					</div>
					<div class="col-md-2 ">
					 <button type="button" class="btn btn-primary  pull-right waves-effect ">  Search</button>
					</div>
				</div>
                            <div class="body">
                                <table class="tablesaw table-striped table-bordered table-hover">
                                    <thead class="tableheding">
                                    <tr>
                                        <th data-tablesaw-sortable-col data-tablesaw-sortable-default-col data-tablesaw-priority="persist">Employee</th>
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="3">
Leave Type </th>
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="2">From</th>
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="4">To </th>
										 
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="4">No of Days</th>
										   <th data-tablesaw-sortable-col data-tablesaw-priority="2">
Reason</th>
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="4">Status </th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1" class="actiontabel" >Action </th>
                                      
                                    </tr>
                                    </thead>
									<div class="clearfix"></div>
								<c:set var="empleaves" scope="session" value="${empleave}"/>
								<c:if test="${empleaves != null}" >
								<c:forEach items="${empleave}" var="empleaveslist">
								${empleaveslist.getLeavetype()}
								${empleaveslist.getFromdate()}
                                    <tbody>
									
									
                                    <tr>
                                        <td>   
										<div class="chip">
                                                    <img src="${images}/mail/one.jpg" alt="Contact Person">
                                                    <span>${sessionScope.empfname} ${sessionScope.emplname}</span>
													<div style="text-align:center">${sessionScope.empdesignation}</div>
                                                </div></td>
                                        <td>${empleaveslist.getLeavetype()}</td>
                                        <td>${empleaveslist.getFromdate()}</td>
                                        <td>${empleaveslist.getTodate()}</td>
										 <td>${empleaveslist.getCount()} days</td>
										  <td>${empleaveslist.getLeavereason()}</td>
										  <td>

  <div class="btn-group">
                                                    <button type="button" class="btn btn-primary btn-outline btn-rounded waves-effect" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                        Panding <span class="caret"></span>
                                                    </button>
                                                    <ul class="dropdown-menu bullet">
													<li><a href="javascript:void(0);"><i class="material-icons">assistant_photo</i>New</a></li>
                                                        <li><a href="javascript:void(0);"><i class="material-icons">assistant_photo</i>Panding</a></li>
                                                        <li><a href="javascript:void(0);"><i class="material-icons">print</i>Approved</a></li>
                                                        <li><a href="javascript:void(0);"><i class="material-icons">favorite</i>Declined</a></li>
                                                    </ul>
                                                </div>										  </td>
										<td>
										<ul class="tabelaction">
                                    <li class="dropdown">
                                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                            <i class="material-icons">more_vert</i>
                                        </a>
                                        <ul class="dropdown-menu pull-right">
                                            <li><a href="javascript:void(0);"><i class="material-icons">edit</i>Edit</a></li>
                                            <li><a href="javascript:void(0);"><i class="material-icons">delete</i>Delete</a></li>
                                       
                                        </ul>
                                    </li>
                                </ul>
								</td>
                                   
                                    </tr>
                                   
                                    </tbody>
                                </c:forEach>
                                    </c:if>
                                
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