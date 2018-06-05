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
<c:if test="${Role.equals('ADMIN_ROLE')}">
			<c:set var="role" value="admin" />
		</c:if>

		<c:if test="${Role.equals('MANAGER_ROLE')}">
			<c:set var="role" value="manager" />
		</c:if>

		<c:if test="${Role.equals('EMPLOYEE_ROLE')}">
			<c:set var="role" value="employee" />
		</c:if>

    <!-- top navbar-->
    <header class="topnavbar-wrapper">
        <nav role="navigation" class="navbar topnavbar">
            <!-- START navbar header-->
          <div class="navbar-header">
                <a href="index.html" class="navbar-brand">
                    <div class="brand-logo">
					<h3 style="color:#fff">Amp Demo</h3>
                      
                    </div>
                    <div class="brand-logo-collapsed">
                       <h3 style="color:#fff">Amp </h3>
                    </div>
                </a>
            </div>
            <!-- END navbar header-->
            <!-- START Nav wrapper-->
            <div class="nav-wrapper">
                <!-- START Left navbar-->
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#" data-trigger-resize="" data-toggle-state="aside-collapsed" class="hidden-xs">
                            <em class="material-icons">menu</em>
                        </a>
                        <a href="#" data-toggle-state="aside-toggled" data-no-persist="true" class="visible-xs sidebar-toggle">
                            <em class="material-icons">menu</em>
                        </a>
                    </li>
                </ul>
                <!-- END Left navbar-->
                <!-- START Right Navbar-->
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="#" data-search-open="">
                            <em class="material-icons">search</em>
                        </a>
                    </li>
                    <li class="visible-lg">
                        <a href="#" data-toggle-fullscreen="">
                            <em class="material-icons">fullscreen</em>
                        </a>
                    </li>
                    <!-- Notifications -->
                    <li class="dropdown">
                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button">
                            <i class="material-icons">notifications</i>
                            <span class="badge badge-success">7</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">NOTIFICATIONS</li>
                            <li class="body">
                                <ul class="menu">
                                    <li class="media">
                                        <a href="#">
                                            <div class="media-left">
                                                <div class="icon-circle bg-red">
                                                    <i class="material-icons">done</i>
                                                </div>
                                            </div>
                                            <div class="media-body menu-note">
                                                <p class="pull-right">Just Now</p>
                                                <h4> Privacy settings changed</h4>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="media">
                                        <a href="#">
                                            <div class="media-left">
                                                <div class="icon-circle bg-indigo">
                                                    <i class="material-icons">add</i>
                                                </div>
                                            </div>
                                            <div class="media-body menu-note">
                                                <p class="pull-right">2 mins</p>
                                                <h4> Mike has added you as friend</h4>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="media">
                                        <a href="#">
                                            <div class="media-left">
                                                <div class="icon-circle bg-blue">
                                                    <i class="material-icons">alarm</i>
                                                </div>
                                            </div>
                                            <div class="media-body menu-note">
                                                <p class="pull-right">20 mins</p>
                                                <h4> New item added</h4>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="media">
                                        <a href="#">
                                            <div class="media-left">
                                                <div class="icon-circle bg-orange">
                                                    <i class="material-icons">thumb_up</i>
                                                </div>
                                            </div>
                                            <div class="media-body menu-note">
                                                <p class="pull-right">2 hrs</p>
                                                <h4> Ketty like your photo</h4>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="media">
                                        <a href="#">
                                            <div class="media-left">
                                                <div class="icon-circle bg-green">
                                                    <i class="material-icons">cached</i>
                                                </div>
                                            </div>
                                            <div class="media-body menu-note">
                                                <p class="pull-right">3 days</p>
                                                <h4> Server 10 is not working Properly</h4>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="media">
                                        <a href="#">
                                            <div class="media-left">
                                                <div class="icon-circle bg-grey">
                                                    <i class="material-icons">settings</i>
                                                </div>
                                            </div>
                                            <div class="media-body menu-note">
                                                <p class="pull-right">5 days</p>
                                                <h4> Restart your system</h4>
                                            </div>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="footer">
                                <a href="javascript:void(0);">View All Notifications</a>
                            </li>
                        </ul>
                    </li>
                    <!-- #END# Notifications -->
                    <!-- Task -->
                    <li class="dropdown">
                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button">
                            <i class="material-icons">mail</i>
                            <span class="badge badge-danger">7</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">
                                You have
                                <span class="font-bold">7 New</span> Messages
                            </li>
                            <li class="body">
                                <ul class="menu media-list">
                                    <li class="media unread">
                                        <a href="#">
                                            <div class="media-left">
                                                <img class="media-object img-circle" width="32" src="${images}/mail/nine.jpg" alt="user">
                                            </div>
                                            <div class="media-body">
                                                <p class="pull-right"><small>Just Now</small></p>
                                                <h4 class="media-heading body-text">Lisa Headon</h4>
                                                <p class="font-12">Cras justo odio, dapibus ac facilisis in.</p>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="media">
                                        <a href="#">
                                            <div class="media-left">
                                                <img class="media-object img-circle" width="32" src="${images}/mail/2.jpg" alt="user">
                                            </div>
                                            <div class="media-body">
                                                <p class="pull-right"><small>2 hour ago</small></p>
                                                <h4 class="media-heading body-text">Lucy Doe</h4>
                                                <p class="font-12">Duis mollis, est non commodo luctus, nisi erat</p>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="media">
                                        <a href="#">
                                            <div class="media-left">
                                                <img class="media-object img-circle" width="32" src="${images}/mail/five.jpg" alt="user">
                                            </div>
                                            <div class="media-body">
                                                <p class="pull-right"><small>12 hour ago</small></p>
                                                <h4 class="media-heading body-text">Jhon Doe</h4>
                                                <p class="font-12">Aenean lacinia bibendum nulla sed consectetur. </p>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="media">
                                        <a href="#">
                                            <div class="media-left">
                                                <img class="media-object img-circle" width="32" src="${images}/mail/1.jpg" alt="user">
                                            </div>
                                            <div class="media-body">
                                                <p class="pull-right"><small>2 days ago</small></p>
                                                <h4 class="media-heading body-text">Daniel Richard</h4>
                                                <p class="font-12">Donec id elit non mi porta gravida at eget metus. </p>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="media">
                                        <a href="#">
                                            <div class="media-left">
                                                <img class="media-object img-circle" width="32" src="${images}/mail/seven.jpg" alt="user">
                                            </div>
                                            <div class="media-body">
                                                <p class="pull-right"><small>3 days ago</small></p>
                                                <h4 class="media-heading body-text">Kelly Brook</h4>
                                                <p class="font-12">Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="media unread">
                                        <a href="#">
                                            <div class="media-left">
                                                <img class="media-object img-circle" width="32" src="${images}/mail/three.jpg" alt="user">
                                            </div>
                                            <div class="media-body">
                                                <p class="pull-right"><small>4 days ago</small></p>
                                                <h4 class="media-heading body-text">Olivia Wild</h4>
                                                <p class="font-12">Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh</p>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="media">
                                        <a href="#">
                                            <div class="media-left">
                                                <img class="media-object img-circle" width="32" src="${images}/mail/two.jpg" alt="user">
                                            </div>
                                            <div class="media-body">
                                                <p class="pull-right"><small>2 weeks ago</small></p>
                                                <h4 class="media-heading body-text">Andrew Smith</h4>
                                                <p class="font-12">Nulla vitae elit libero, a pharetra augue.</p>
                                            </div>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="footer">
                                <a href="javascript:void(0);">View All Messages</a>
                            </li>
                        </ul>
                    </li>
                    <!-- #END# Task -->
                    <li>
                        <a href="#" data-toggle-state="offsidebar-open" data-no-persist="true">
                            <em class="material-icons">more_vert</em>
                        </a>
                    </li>
                </ul>
                <!-- #END# Right Navbar-->
            </div>
            <!-- #END# Nav wrapper-->
            <!-- START Search form-->
            <form role="search" action="#" class="navbar-form">
                <div class="form-group has-feedback">
                    <input type="text" placeholder="Type and search ..." class="form-control">
                    <em data-search-dismiss="" class="form-control-feedback material-icons">close</em>
                </div>
                <button type="submit" class="hidden btn btn-info">Submit</button>
            </form>
            <!-- #END# Search form-->
        </nav>
        <!-- END Top Navbar-->
    </header>
    <!-- sidebar-->
    <aside class="aside">
        <!-- START Sidebar (left)-->
        <div class="aside-inner">
            <nav data-sidebar-anyclick-close="" class="sidebar">
                <!-- START sidebar nav-->
                <ul class="nav menu">
                    <!-- Iterates over all sidebar items-->
                    <li class="nav-heading ">
                        <span>MAIN NAVIGATION</span>
                    </li>
                    <li class="">
                        <a href="#employees" title="Dashboard" data-toggle="collapse" class="menu-toggle">
                            <em class="material-icons">dashboard</em>
                            <span>Employees</span>
                        </a>
                        <ul id="employees" class="nav sidebar-subnav collapse">
                           
                          <c:forEach items="${services}" var="service">
                            <li>
                               <a href="${contextRoot}/admin/${service.getServiceID()}/register" title="${service}">
                                    <span>${service.getServiceName()}</span>
                                </a>
                            </li>
							</c:forEach>


                           
                        </ul>
                    </li>
                    <li>
                        <a href="#layout" title="Layouts" data-toggle="collapse" class="menu-toggle">
                            <em class="material-icons">computer</em>
                            <span>Layouts</span>
                        </a>
                        <ul id="layout" class="nav sidebar-subnav collapse">
                            <li class="sidebar-subnav-header">Layouts</li>
                            <li>
                                <a href="../../pages/layout/l_sidebar_light.html" title="Light Sidebar">
                                    <span>Light Sidebar</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/layout/l_sidebar_dark.html" title="Dark Sidebar">
                                    <span>Dark Sidebar</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/layout/l_no_fixed.html" title="No Fixed">
                                    <span>Layout No Fixed</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/layout/l_fixed.html" title="Fixed All">
                                    <span>Layout Fixed</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/layout/l_boxed.html" title="Layout Boxed">
                                    <span>Layout Boxed</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/layout/l_collapsed.html" title="Sidebar Collapsed">
                                    <span>Sidebar Collapsed</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/layout/l_collapsed_T.html" title="Collapsed Text">
                                    <span>Collapsed Text</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/layout/l_float.html" title="Layout Float">
                                    <span>Layout Float</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/layout/l_scrollbar.html" title="Menu Scrollbar">
                                    <span>Menu Scrollbar</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-heading ">
                        <span>UI COMPONENTS</span>
                    </li>
                    <li>
                        <a href="#components" title="Components" data-toggle="collapse" class="menu-toggle">
                            <em class="material-icons">border_color</em>
                            <span>Basic UI</span>
                        </a>
                        <ul id="components" class="nav sidebar-subnav collapse">
                            <li class="sidebar-subnav-header">Basic UI</li>
                            <li>
                                <a href="../../pages/basic-ui/alerts.html" title="Alerts">
                                    <span>Alerts</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/basic-ui/badges.html" title="Badges">
                                    <span>Badges</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/basic-ui/breadcrumbs.html" title="Breadcrumbs">
                                    <span>Breadcrumbs</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/basic-ui/buttons.html" title="Buttons">
                                    <span>Buttons</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/basic-ui/cards.html" title="Card">
                                    <span>Card</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/basic-ui/card-draggable.html" title="Card Draggable">
                                    <span>Card Draggable</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/basic-ui/collapse.html" title="Collapse">
                                    <span>Collapse</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/basic-ui/colors.html" title="Colors">
                                    <span>Colors</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/basic-ui/dropdown.html" title="Dropdown">
                                    <span>Dropdown</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/basic-ui/helper-classes.html" title="Helper Classes">
                                    <span>Helper Classes</span>
                                </a>
                            </li>
                            <li>
                                <a href="#icon" title="Icons" data-toggle="collapse" class="menu-toggle">
                                    <span>Icons</span>
                                </a>
                                <ul id="icon" class="nav sidebar-subnav collapse">
                                    <li class="sidebar-subnav-header">Icons</li>
                                    <li>
                                        <a href="../../pages/basic-ui/icon/font-awesome.html" title="Font Awesome">
                                            <span>Font Awesome</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="../../pages/basic-ui/icon/glyphicon.html" title="Glyphicon">
                                            <span>Glyphicon</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="../../pages/basic-ui/icon/ionicons.html" title="Ionicons">
                                            <span>Ionicons</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="../../pages/basic-ui/icon/material-icons.html" title="Material Icons">
                                            <span>Material Icons</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="../../pages/basic-ui/icon/simple-line-icon.html" title="Simple Line Icon">
                                            <span>Simple Line Icon</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="../../pages/basic-ui/icon/themify-icons.html" title="Themify Icons">
                                            <span>Themify Icons</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="../../pages/basic-ui/icon/weather-icons.html" title="Weather Icons">
                                            <span>Weather Icons</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="../../pages/basic-ui/icon/7-stroke.html" title="7 Stroke">
                                            <span>7 Stroke</span>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="../../pages/basic-ui/labels.html" title="Labels">
                                    <span>Labels</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/basic-ui/list-group.html" title="List Group">
                                    <span>List Group</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/basic-ui/media-object-thumbnails.html" title="Media Object & Thumbnails">
                                    <span>Media Object & Thumbnails</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/basic-ui/pagination.html" title="Pagination">
                                    <span>Pagination</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/basic-ui/preloaders.html" title="Preloaders">
                                    <span>Preloaders</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/basic-ui/progressbars.html" title="Progress Bars">
                                    <span>Progress Bars</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/basic-ui/nouislider.html" title="Nouislider">
                                    <span>Nouislider</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/basic-ui/range-sliders.html" title="Range Sliders">
                                    <span>Range Sliders</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/basic-ui/spinner-button.html" title="Spinner Button">
                                    <span>Spinner Button</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/basic-ui/tabs.html" title="Tabs">
                                    <span>Tabs</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/basic-ui/tooltips-popovers.html" title="Tooltips Popovers">
                                    <span>Tooltips Popovers</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/basic-ui/treeview.html" title="Treeview">
                                    <span>Treeview</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/basic-ui/typography.html" title="Typography">
                                    <span>Typography</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#advanceui" title="Advance UI" data-toggle="collapse" class="menu-toggle">
                            <em class="material-icons">format_color_fill</em>
                            <span>Advance UI</span>
                        </a>
                        <ul id="advanceui" class="nav sidebar-subnav collapse">
                            <li class="sidebar-subnav-header">Advance UI</li>
                            <li>
                                <a href="../../pages/advance-ui/alertify.html" title="Alertify">
                                    <span>Alertify</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/advance-ui/animations.html" title="Animations">
                                    <span>Animations</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/advance-ui/bootbox.html" title="Bootbox">
                                    <span>Bootbox</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/advance-ui/carousel.html" title="Carousel">
                                    <span>Carousel</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/advance-ui/chips.html" title="Chips">
                                    <span>Chips</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/advance-ui/contextmenu.html" title="Context Menu">
                                    <span>Context Menu</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/advance-ui/image-gallery.html" title="Image Gallery">
                                    <span>Image Gallery</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/advance-ui/lightbox.html" title="Lightbox">
                                    <span>Lightbox</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/advance-ui/masonry.html" title="Masonry">
                                    <span>Masonry</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/advance-ui/modals.html" title="Modals">
                                    <span>Modals</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/advance-ui/notifications.html" title="Notifications">
                                    <span>Notifications</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/advance-ui/scroll-1.html" title="Scroll 1">
                                    <span>Scroll 1</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/advance-ui/scroll-2.html" title="Scroll 2">
                                    <span>Scroll 2</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/advance-ui/session-timeout.html" title="Session Timeout">
                                    <span>Session Timeout</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/advance-ui/session-idle-timeout.html" title="Session Idle Timeout">
                                    <span>Session Idle Timeout</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/advance-ui/sortable-nestable.html" title="Sortable Nestable">
                                    <span>Sortable Nestable</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/advance-ui/sweetalert.html" title="Sweet Alert">
                                    <span>Sweet Alert</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/advance-ui/timeline-basic.html" title="Timeline Basic">
                                    <span>Timeline Basic</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/advance-ui/timeline-horizontal.html" title="Timeline Horizontal">
                                    <span>Timeline Horizontal</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/advance-ui/timeline-single.html" title="Timeline Single">
                                    <span>Timeline Single</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/advance-ui/toastr.html" title="Toastr">
                                    <span>Toastr</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/advance-ui/tour.html" title="Tour">
                                    <span>Tour</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/advance-ui/waves.html" title="Waves">
                                    <span>Waves</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#elements" title="Elements" data-toggle="collapse"  class="menu-toggle">
                            <em class="material-icons">extension</em>
                            <span>Elements</span>
                        </a>
                        <ul id="elements" class="nav sidebar-subnav collapse">
                            <li class="sidebar-subnav-header">Elements</li>
                            <li>
                                <a href="../../pages/elements/hoverideas.html" title="Hover Ideas">
                                    <span>Hover Ideas</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/elements/hoverideas-set2.html" title="Hover Ideas 2">
                                    <span>Hover Ideas 2</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/elements/pricing.html" title="Pricing">
                                    <span>Pricing</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/elements/pricing-2.html" title="Pricing 2">
                                    <span>Pricing 2</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/elements/rating.html" title="Rating">
                                    <span>Rating</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/elements/ribbons.html" title="Ribbons">
                                    <span>Ribbons</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/elements/steps.html" title="Steps">
                                    <span>Steps</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/elements/user-card.html" title="User Card">
                                    <span>User Card</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#forms" title="Forms" data-toggle="collapse" class="menu-toggle">
                            <em class="material-icons">assignment</em>
                            <span>Forms</span>
                        </a>
                        <ul id="forms" class="nav sidebar-subnav collapse">
                            <li class="sidebar-subnav-header">Forms</li>
                            <li>
                                <a href="../../pages/forms/basic-form-elements.html" title="Basic Elements">
                                    <span>Basic Elements</span>
                                </a>
                            </li>
                            <li>
                                <a href="#advanceform" title="Advance Element" data-toggle="collapse" class="menu-toggle">
                                    <span>Advance Element</span>
                                </a>
                                <ul id="advanceform" class="nav sidebar-subnav collapse">
                                    <li class="sidebar-subnav-header">Advance Element</li>
                                    <li>
                                        <a href="../../pages/forms/advance-form-elements/bootstrap-select.html" title="Bootstrap Select">
                                            <span>Bootstrap Select</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="../../pages/forms/advance-form-elements/masked-input.html" title="Masked Input">
                                            <span>Masked Input</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="../../pages/forms/advance-form-elements/color-picker.html" title="Color Picker">
                                            <span>Color Picker</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="../../pages/forms/advance-form-elements/datetimepicker.html" title="Date & Time Picker">
                                            <span>Date & Time Picker</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="../../pages/forms/advance-form-elements/advanced-form-elements.html" title="Advance Form Elements">
                                            <span>Advance Form Elements</span>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="../../pages/forms/material-form-elements.html" title="Material Elements">
                                    <span>Material Elements</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/forms/form-layouts.html" title="Form Layout">
                                    <span>Form Layout</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/forms/form-validation.html" title="Form Validation">
                                    <span>Form Validation</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/forms/form-wizard.html" title="Form Wizard">
                                    <span>Form Wizard</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/forms/form-editable.html" title="Form Editable">
                                    <span>Form Editable</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/forms/dropify.html" title="Dropify File Upload">
                                    <span>Dropify File Upload</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/forms/dropzone-fileupload.html" title="Dropzone File Upload">
                                    <span>Dropzone File Upload</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/forms/multiple-fileupload.html" title="Multiple File Upload">
                                    <span>Multiple File Upload</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/forms/image-crop.html" title="Image Cropper">
                                    <span>Image Cropper</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/forms/markdown.html" title="Markdown Form Editor">
                                    <span>Markdown Form Editor</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/forms/ckeditors.html" title="CK Editor">
                                    <span>CK Editor</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/forms/summernote.html" title="Summernote">
                                    <span>Summernote</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/forms/tinymce-editor.html" title="Tinymce Editor">
                                    <span>Tinymce Editor</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#charts" title="Charts" data-toggle="collapse" class="menu-toggle">
                            <em class="material-icons">insert_chart</em>
                            <span>Charts</span>
                        </a>
                        <ul id="charts" class="nav sidebar-subnav collapse">
                            <li class="sidebar-subnav-header">Charts</li>
                            <li>
                                <a href="../../pages/charts/chartjs.html" title="ChartJs">
                                    <span>ChartJs</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/charts/chartist-bar.html" title="Chartist Bar">
                                    <span>Chartist Bar</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/charts/chartist-line-area.html" title="Chartist Line Area">
                                    <span>Chartist Line Area</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/charts/chartist-pie.html" title="Chartist Pie">
                                    <span>Chartist Pie</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/charts/c3.html" title="C3 Charts">
                                    <span>C3 Charts</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/charts/flot.html" title="Flot">
                                    <span>Flot Chart</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/charts/morris.html" title="Morris">
                                    <span>Morris</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/charts/nvd3.html" title="NVD3">
                                    <span>NVD3</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/charts/sparkline.html" title="Sparkline">
                                    <span>Sparkline</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/charts/jquery-knob.html" title="Jquery Knob">
                                    <span>Jquery Knob</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#tables" title="Tables" data-toggle="collapse" class="menu-toggle">
                            <em class="material-icons">border_all</em>
                            <span>Tables</span>
                        </a>
                        <ul id="tables" class="nav sidebar-subnav collapse">
                            <li class="sidebar-subnav-header">Tables</li>
                            <li>
                                <a href="../../pages/tables/normal-tables.html" title="Basic Tables">
                                    <span>Basic Tables</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/tables/responsive-table.html" title="Responsive Table">
                                    <span>Responsive Table</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/tables/footable.html" title="Footable">
                                    <span>Footable</span>
                                </a>
                            </li>
                            <li class="active">
                                <a href="../../pages/tables/editable-table.html" title="Editable">
                                    <span>Editable</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/tables/jquery-datatable.html" title="Jquery Data Tables">
                                    <span>Jquery Data Tables</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/tables/jsgrid.html" title="Jsgrid">
                                    <span>Jsgrid</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#widgets" title="Widgets" data-toggle="collapse" class="menu-toggle">
                            <em class="material-icons">widgets</em>
                            <span>Widgets</span>
                        </a>
                        <ul id="widgets" class="nav sidebar-subnav collapse">
                            <li class="sidebar-subnav-header">Widgets</li>
                            <li>
                                <a href="../../pages/widgets/box-widget.html" title="Box Widget">
                                    <span>Box Widget</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/widgets/blog-widget.html" title="Blog Widget">
                                    <span>Blog Widget</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/widgets/chart-widget.html" title="Chart Widget">
                                    <span>Chart Widget</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/widgets/data-widget.html" title="Data Widget">
                                    <span>Data Widget</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/widgets/social-widget.html" title="Social Widget">
                                    <span>Social Widget</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/widgets/weather-widget.html" title="Weather Widget">
                                    <span>Weather Widget</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-heading ">
                        <span>DEVELOPMENT</span>
                    </li>
                    <li>
                        <a href="#appview" title="App Views" data-toggle="collapse" class="menu-toggle">
                            <em class="material-icons">apps</em>
                            <span>App Views</span>
                        </a>
                        <ul id="appview" class="nav sidebar-subnav collapse">
                            <li class="sidebar-subnav-header">App Views</li>
                            <li>
                                <a href="../../pages/app-views/article.html" title="Article">
                                    <span>Article</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/app-views/calendar.html" title="Calendar">
                                    <span>Calendar</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/app-views/contacts.html" title="Contacts">
                                    <span>Contacts</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/app-views/chat.html" title="Chat">
                                    <span>Chat</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/app-views/faq.html" title="FAQ">
                                    <span>FAQ</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/app-views/forum.html" title="Forum">
                                    <span>Forum</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/app-views/filemanager.html" title="File Manager">
                                    <span>File Manager</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/app-views/inbox.html" title="Inbox">
                                    <span>Inbox</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/app-views/invoice.html" title="Invoice">
                                    <span>Invoice</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/app-views/search_result.html" title="Search Result">
                                    <span>Search Result</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/app-views/social_board.html" title="Social Board">
                                    <span>Social Board</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/app-views/task_board.html" title="Task Board">
                                    <span>Task Board</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/app-views/to_do.html" title="To Do">
                                    <span>To Do</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#ecommerce" title="Ecommerce" data-toggle="collapse" class="menu-toggle">
                            <em class="material-icons">shopping_cart</em>
                            <span>Ecommerce</span>
                        </a>
                        <ul id="ecommerce" class="nav sidebar-subnav collapse">
                            <li class="sidebar-subnav-header">Ecommerce</li>
                            <li>
                                <a href="../../pages/ecommerce/product-grid.html" title="Product Grid">
                                    <span>Product Grid</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/ecommerce/product-list.html" title="Product List">
                                    <span>Product List</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/ecommerce/checkout.html" title="Checkout">
                                    <span>Checkout</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/ecommerce/product-detail.html" title="Product Detail">
                                    <span>Product Detail</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/ecommerce/ec-cart.html" title="Cart">
                                    <span>Cart</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/ecommerce/ec-order.html" title="Order">
                                    <span>Order</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#pages" title="Pages" data-toggle="collapse" class="menu-toggle">
                            <em class="material-icons">pages</em>
                            <span>Pages</span>
                        </a>
                        <ul id="pages" class="nav sidebar-subnav collapse">
                            <li class="sidebar-subnav-header">Pages</li>
                            <li>
                                <a href="../../pages/extra-page/profile.html" title="Profile">
                                    <span>Profile</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/extra-page/lock-screen.html" title="Lock Screen">
                                    <span>Lock Screen</span>
                                </a>
                            </li>
                            <li>
                                <a href="../extra-page/log_in.html" title="Log In">
                                    <span>Log In</span>
                                </a>
                            </li>
                            <li>
                                <a href="../extra-page/register.html" title="Register">
                                    <span>Register</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/extra-page/forgot-password.html" title="Forgot Password">
                                    <span>Forgot Password</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/extra-page/404.html" title="400 Page">
                                    <span>404 Page</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/extra-page/500.html" title="500 Page">
                                    <span>500 Page</span>
                                </a>
                            </li>
                            <li>
                                <a href="../../pages/extra-page/blank.html" title="Blank Page">
                                    <span>Blank Page</span>
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li>
                        <a href="#multilevel" title="Multilevel" data-toggle="collapse" class="menu-toggle">
                            <em class="material-icons">menu</em>
                            <span>Multilevel</span>
                        </a>
                        <ul id="multilevel" class="nav sidebar-subnav collapse">
                            <li class="sidebar-subnav-header">Multilevel</li>
                            <li>
                                <a href="#level1" title="Level 1" data-toggle="collapse"  class="menu-toggle">
                                    <span>Level 1</span>
                                </a>
                                <ul id="level1" class="nav sidebar-subnav collapse">
                                    <li class="sidebar-subnav-header">Level 1</li>
                                    <li>
                                        <a href="#" title="Level1 Item">
                                            <span>Level1 Item</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#level2" title="Level 2" data-toggle="collapse" class="menu-toggle">
                                            <span>Level 2</span>
                                        </a>
                                        <ul id="level2" class="nav sidebar-subnav collapse">
                                            <li class="sidebar-subnav-header">Level 2</li>
                                            <li>
                                                <a href="#" title="Level2 Item">
                                                    <span>Level2 Item</span>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#level3" title="Level 3" data-toggle="collapse" class="menu-toggle">
                                                    <span>Level 3</span>
                                                </a>
                                                <ul id="level3" class="nav sidebar-subnav collapse">
                                                    <li class="sidebar-subnav-header">Level 3</li>
                                                    <li>
                                                        <a href="#" title="Level3 Item">
                                                            <span>Level3 Item</span>
                                                        </a>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>

                </ul>
                <!-- END sidebar nav-->
            </nav>
        </div>
        <!-- #END# Sidebar (left)-->
    </aside>
    <!-- offsidebar-->
    <aside class="offsidebar hide">
        <!-- START Off Sidebar (right)-->
        <nav>
            <div role="tabpanel">
                <!-- Nav tabs-->
                <ul role="tablist" class="nav nav-tabs nav-tabs-inline nav-justified">
                    <li role="presentation" class="active">
                        <a href="#app-skins" aria-controls="app-settings" role="tab" data-toggle="tab">
                            <em class="material-icons">color_lens</em>
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="#app-settings" aria-controls="app-chat" role="tab" data-toggle="tab">
                            <em class="material-icons">settings</em>
                        </a>
                    </li>
                </ul>
                <!-- Tab panes-->
                <div class="tab-content">
                    <div id="app-skins" role="tabpanel" class="tab-pane fade in active">
                        <ul class="skin_selector" id="sidebar_clr_selector">
                            <h2>Sidebar Skins</h2>
                            <li data-theme="light" class="active">
                                <div class="grey"></div>
                                <span>Light</span>
                            </li>
                            <li data-theme="dark">
                                <div class="black"></div>
                                <span>Dark</span>
                            </li>
                        </ul>
                        <ul class="skin_selector" id="skin_selector">
                            <h2>Navbar Skins</h2>
                            <li data-theme="red">
                                <div class="red"></div>
                                <span>Red</span>
                            </li>
                            <li data-theme="pink">
                                <div class="pink"></div>
                                <span>Pink</span>
                            </li>
                            <li data-theme="purple">
                                <div class="purple"></div>
                                <span>Purple</span>
                            </li>
                            <li data-theme="indigo">
                                <div class="indigo"></div>
                                <span>Indigo</span>
                            </li>
                            <li data-theme="blue" class="active">
                                <div class="blue"></div>
                                <span>Blue</span>
                            </li>
                            <li data-theme="light-blue">
                                <div class="light-blue"></div>
                                <span>Light Blue</span>
                            </li>
                            <li data-theme="cyan">
                                <div class="cyan"></div>
                                <span>Cyan</span>
                            </li>
                            <li data-theme="teal">
                                <div class="teal"></div>
                                <span>Teal</span>
                            </li>
                            <li data-theme="green">
                                <div class="green"></div>
                                <span>Green</span>
                            </li>
                            <li data-theme="lime">
                                <div class="lime"></div>
                                <span>Lime</span>
                            </li>
                            <li data-theme="yellow">
                                <div class="yellow"></div>
                                <span>Yellow</span>
                            </li>
                            <li data-theme="orange">
                                <div class="orange"></div>
                                <span>Orange</span>
                            </li>
                            <li data-theme="brown">
                                <div class="brown"></div>
                                <span>Brown</span>
                            </li>
                            <li data-theme="grey">
                                <div class="grey"></div>
                                <span>Grey</span>
                            </li>
                        </ul>
                    </div>
                    <div id="app-settings" role="tabpanel" class="tab-pane fade">
                        <div class="demo-settings ">
                            <ul class="setting-list">
                                <h2>Layout Settings</h2>
                                <li>
                                    <span>Fixed</span>
                                    <div class="switch">
                                        <label><input id="chk-fixed" type="checkbox"  data-toggle-state="layout-fixed"><span class="lever switch-col-grey"></span></label>
                                    </div>
                                </li>
                                <li>
                                    <span>Boxed</span>
                                    <div class="switch">
                                        <label><input id="chk-boxed" type="checkbox" data-toggle-state="layout-boxed"><span class="lever switch-col-grey"></span></label>
                                    </div>
                                </li>
                                <li>
                                    <span>Collapsed</span>
                                    <div class="switch">
                                        <label><input id="chk-collapsed" type="checkbox" data-toggle-state="aside-collapsed"><span class="lever switch-col-grey"></span></label>
                                    </div>
                                </li>
                                <li>
                                    <span>Collapsed Text</span>
                                    <div class="switch">
                                        <label><input id="chk-collapsed-text" type="checkbox" data-toggle-state="aside-collapsed-text"><span class="lever switch-col-grey"></span></label>
                                    </div>
                                </li>
                                <li>
                                    <span>Float</span>
                                    <div class="switch">
                                        <label><input id="chk-float" type="checkbox" data-toggle-state="aside-float"><span class="lever switch-col-grey"></span></label>
                                    </div>
                                </li>
                                <li>
                                    <span>Show Scrollbar</span>
                                    <div class="switch">
                                        <label><input id="chk-hover" type="checkbox" data-toggle-state="show-scrollbar" data-target=".sidebar"><span class="lever switch-col-grey"></span></label>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </nav>
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
				<span > Designations</span>
				 </div>
				  </div>
				  

		
	         
	             <div class="col-md-6">
				 <div class="row pagetitle">
				<span class="pull-right" > 	 <button type="button" class="btn btn-primary btn-rounded waves-effect">Add New Designations </button> </span>
				 </div>
				  </div>
		
                </div>
			
				</div>
				</div>
					</div>
					
					<div class="col-md-12 card">
				<div class="custom_title">	
				<h2> Add Designations</h2>
				</div>
				<hr class="custom_line">	
                            <div class="body">
                        
					
			<form action="${contextRoot}/admin/empdesig/register" method="post">
			
						 		 <div class="col-md-6">
						      <div class="form-group">
                                                                <div class="input-group addon-line">
                                                                    <div class="form-line">
																	   <label>Designations Name</label>
                                                                        <input type="text" name="designationname" id="designationname" class="form-control" placeholder="Designations Name">
                                                                    </div>
                                                                    </div>
                                                            </div>
					
						 </div>
						 
					
						 <div class="clearfix"> </div>
						 <div style="text-align:center;">
					 <button type="submit" class="btn btn-primary btn-rounded waves-effect">Create Designations</button>
					 </div>
					 
					 </form>
					</div>
					
					</div>
					
					
                <div class="row clearfix">
                
				
		
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ">
                    
					

                        <!-- Table Kitchen Sink -->
                        <div class="card">
                        		
                            <div class="body">
                                <table class="tablesaw table-striped table-bordered table-hover">
                                    <thead class="tableheding">
                                    <tr>
                                        <th data-tablesaw-sortable-col data-tablesaw-sortable-default-col data-tablesaw-priority="persist">Id</th>
                                        <th data-tablesaw-sortable-col data-tablesaw-priority="3">Designation</th>
                               <th data-tablesaw-sortable-col data-tablesaw-priority="4">Department</th>
										<th data-tablesaw-sortable-col data-tablesaw-priority="1" class="actiontabel" >Action </th>
                                      
                                    </tr>
                                    </thead>
									<div class="clearfix"></div>
								
									<c:forEach items="${designations}" var="desig">
                                    <tbody>
									
									
                                    <tr>
                                 
                                        <td>01</td>
                                        <td>${desig.getDesignation()}</td>
                                 <td>Web Development</td>
									
										<td>
										<ul class="tabelaction">
                                    <li class="dropdown">
                                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                            <i class="material-icons">more_vert</i>
                                        </a>
                                        <ul class="dropdown-menu pull-right">
                      <li><a href="javascript:void(0);"><i class="material-icons">edit</i>Edit</a></li>
                                            <li><a href="${contextRoot}/${role}/designations/delete/${desig.getDesignationId()}"><i class="material-icons">delete</i>Delete</a></li>
                                       
                                        </ul>
                                    </li>
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