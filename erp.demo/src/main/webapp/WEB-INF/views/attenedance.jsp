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
 <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

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
			<!-- END Top Navbar-->
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
					
					</div>
					<div class="col-md-2 padding_col">
				   
					</div>
					<div class="col-md-2 ">
					 <button type="button" class="btn btn-primary  pull-right waves-effect ">  Search</button>
					</div>
				</div>
                            <div class="body">
                               <table class="tablesaw table-striped table-hover table-bordered" data-tablesaw-mode="swipe" data-tablesaw-minimap>
                                    <thead class="tableheding">
                                    <tr>
                                        <th data-tablesaw-sortable-col data-tablesaw-sortable-default-col data-tablesaw-priority="persist">Employee</th>
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
									<div class="clearfix"></div>
								
								
                                    <tbody>
									
									
                                         <tr>
                                        <th><a href="javascript:void(0)">Daniel</a></th>
                                     
                                        <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                         <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                         <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                  <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                        <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
										    <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
										 <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                            <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                   <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                            <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                           <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                        <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                            <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                  <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
										      <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
										        <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                           <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                       <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                           <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                           <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                           <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
										     <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
										      <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                    </tr>
									  <tr>
                                        <th><a href="javascript:void(0)">Richard Miles</a></th>
                                     
                                        <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                         <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                         <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                  <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                        <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
										    <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
										 <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                            <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                   <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                            <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                           <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                        <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                            <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                  <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
										      <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
										        <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                           <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                       <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                           <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                           <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                           <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
										     <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
										      <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                    </tr>
                                   
								     <tr>
                                        <th><a href="javascript:void(0)">John Smith</a></th>
                                     
                                        <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                         <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                         <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                  <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                        <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
										    <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
										 <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                            <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                   <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                            <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                           <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                        <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                            <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                  <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
										      <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
										        <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                           <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                       <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                           <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                           <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                           <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
										     <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
										      <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                    </tr>
                                   
								     <tr>
                                        <th><a href="javascript:void(0)">Mike Litorus</a></th>
                                     
                                        <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                         <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                         <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                  <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                        <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
										    <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
										 <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                            <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                   <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                            <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                           <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                        <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                            <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                  <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
										      <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
										        <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                           <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                       <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                           <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                           <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                           <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
										     <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
										      <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                    </tr>
                                   
								     <tr>
                                        <th><a href="javascript:void(0)">Wilmer Deluna</a></th>
                                     
                                        <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                         <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                         <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                  <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                        <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
										    <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
										 <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                            <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                   <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                            <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                           <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                        <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                            <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                  <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
										      <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
										        <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                           <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                       <td><i class="icon-display  fa fa-close  attenedance_check_red" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                           <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                           <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                          <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                           <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
										     <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
										      <td><i class="icon-display  fa fa-check attenedance_check_green" ></i></td>
                                    </tr>
                                   
                                   
                                    </tbody>
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