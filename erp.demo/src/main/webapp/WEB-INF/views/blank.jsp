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
    <title>Blank Page | Material Design Admin - Eagle</title>
    <!-- Favicon-->
    <link rel="icon" href="../../favicon.png" type="image/x-icon">

    <!--REQUIRED PLUGIN CSS-->
    <link href="../../${plugins}/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="../../${plugins}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="../../${plugins}/node-waves/waves.css" rel="stylesheet" />
    <link href="../../${plugins}/animate-css/animate.css" rel="stylesheet" />
    <link href="../../${plugins}/spinkit/spinkit.css" rel="stylesheet">

    <!--REQUIRED THEME CSS -->
    <link href="../../${css}/style.css" rel="stylesheet">
    <link href="../../${css}/layout.css" rel="stylesheet">
    <link href="../../${css}/themes/main_theme.css" rel="stylesheet" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body class="theme-indigo light layout-fixed">
<div class="wrapper">
    <div class="page-loader-wrapper">
        <div class="loader">
            <div class="sk-wave">
                <div class="sk-rect sk-rect1 bg-cyan"></div>
                <div class="sk-rect sk-rect2 bg-cyan"></div>
                <div class="sk-rect sk-rect3 bg-cyan"></div>
                <div class="sk-rect sk-rect4 bg-cyan"></div>
                <div class="sk-rect sk-rect5 bg-cyan"></div>
            </div>
            <p>Please wait...</p>
        </div>
    </div>
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
                <div class="page-header">
                    <h2>Blank Page</h2>
                    <ol class="breadcrumb">
                        <li><a href="../../index.html">Home</a></li>
                        <li class="active">Pages</li>
                    </ol>
                </div>

            </div>
        </div>
    </section>
    <!-- FOOTER-->
    <footer>
        <span>&copy; 2017 - Eagle Template By <b class="col-blue">Bylancer</b></span>
    </footer>
</div>
<!-- CORE PLUGIN JS -->
<script src="../../${plugins}/jquery/jquery.min.js"></script>
<script src="../../${plugins}/bootstrap/js/bootstrap.js"></script>
<script src="../../${plugins}/modernizr/modernizr.custom.js"></script>
<script src="../../${plugins}/screenfull/dist/screenfull.js"></script>
<script src="../../${plugins}/jQuery-Storage-API/jquery.storageapi.js"></script>
<script src="../../${plugins}/jquery-slimscroll/jquery.slimscroll.js"></script>
<script src="../../${plugins}/node-waves/waves.js"></script>

<!-- LAYOUT JS -->
<script src="../../${js}/demo.js"></script>
<script src="../../${js}/layout.js"></script>

</body>

</html>