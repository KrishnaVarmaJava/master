<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<spring:url var="plugins" value="/resources/plugins" />
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>Material Admin Template ${title}</title>
<!-- Favicon-->
<link rel="icon" href="${images }favicon.png" type="image/x-icon">

<!--REQUIRED PLUGIN CSS-->
<link href="${plugins}/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="${plugins}/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${plugins}/node-waves/waves.css" rel="stylesheet" />
<link href="${plugins}/animate-css/animate.css" rel="stylesheet" />
<link href="${plugins}/spinkit/spinkit.css" rel="stylesheet">

<!--REQUIRED THEME CSS -->
<link href="${css}/style.css" rel="stylesheet">
<link href="${css}/layout.css" rel="stylesheet">
<link href="${css}/themes/main_theme.css" rel="stylesheet" />

<!--THIS PAGE LEVEL CSS-->
<link href="${plugins}/morrisjs/morris.css" rel="stylesheet" />
<!--Chat Css-->
<link href="${plugins}/wchat/assets/css/style-light.css"
	rel="stylesheet">
<link href="${plugins}/wchat/assets/css/mobile.css" rel="stylesheet"
	id="style">

<!-- EMOJI ONE JS -->
<link rel="stylesheet"
	href="${plugins}/wchat/smiley/assets/sprites/emojione.sprites.css" />
<script src="${plugins}/wchat/smiley/js/emojione.min.js"></script>

<script type="text/javascript">
	// #################################################
	// # Optional

	// default is PNG but you may also use SVG
	emojione.imageType = 'png';
	emojione.sprites = false;

	// default is ignore ASCII smileys like :) but you can easily turn them on
	emojione.ascii = true;

	// if you want to host the images somewhere else
	// you can easily change the default paths
	emojione.imagePathPNG = '${plugins}/wchat/smiley/assets/png/';
	emojione.imagePathSVG = '${plugins}/wchat/smiley/assets/svg/';

	// #################################################
</script>
<!--#End# Chat Css-->

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
			<%@include file="./shared/navbar.jsp"%>
		</header>
		<!-- sidebar-->
		<%@include file="./shared/slidebar.jsp"%>
		<!-- offsidebar-->
		<aside class="offsidebar hide">
			<!-- START Off Sidebar (right)-->
			<nav>
				<div role="tabpanel">
					<!-- Nav tabs-->
					<ul role="tablist"
						class="nav nav-tabs nav-tabs-inline nav-justified">
						<li role="presentation" class="active"><a href="#app-skins"
							aria-controls="app-settings" role="tab" data-toggle="tab"> <em
								class="material-icons">color_lens</em>
						</a></li>
						<li role="presentation"><a href="#app-settings"
							aria-controls="app-chat" role="tab" data-toggle="tab"> <em
								class="material-icons">settings</em>
						</a></li>
					</ul>
					<!-- Tab panes-->
					<div class="tab-content">
						<div id="app-skins" role="tabpanel"
							class="tab-pane fade in active">
							<ul class="skin_selector" id="sidebar_clr_selector">
								<h2>Sidebar Skins</h2>
								<li data-theme="light" class="active">
									<div class="grey"></div> <span>Light</span>
								</li>
								<li data-theme="dark">
									<div class="black"></div> <span>Dark</span>
								</li>
							</ul>
							<ul class="skin_selector" id="skin_selector">
								<h2>Navbar Skins</h2>
								<li data-theme="red">
									<div class="red"></div> <span>Red</span>
								</li>
								<li data-theme="pink">
									<div class="pink"></div> <span>Pink</span>
								</li>
								<li data-theme="purple">
									<div class="purple"></div> <span>Purple</span>
								</li>
								<li data-theme="indigo">
									<div class="indigo"></div> <span>Indigo</span>
								</li>
								<li data-theme="blue" class="active">
									<div class="blue"></div> <span>Blue</span>
								</li>
								<li data-theme="light-blue">
									<div class="light-blue"></div> <span>Light Blue</span>
								</li>
								<li data-theme="cyan">
									<div class="cyan"></div> <span>Cyan</span>
								</li>
								<li data-theme="teal">
									<div class="teal"></div> <span>Teal</span>
								</li>
								<li data-theme="green">
									<div class="green"></div> <span>Green</span>
								</li>
								<li data-theme="lime">
									<div class="lime"></div> <span>Lime</span>
								</li>
								<li data-theme="yellow">
									<div class="yellow"></div> <span>Yellow</span>
								</li>
								<li data-theme="orange">
									<div class="orange"></div> <span>Orange</span>
								</li>
								<li data-theme="brown">
									<div class="brown"></div> <span>Brown</span>
								</li>
								<li data-theme="grey">
									<div class="grey"></div> <span>Grey</span>
								</li>
							</ul>
						</div>
						<div id="app-settings" role="tabpanel" class="tab-pane fade">
							<div class="demo-settings ">
								<ul class="setting-list">
									<h2>Layout Settings</h2>
									<li><span>Fixed</span>
										<div class="switch">
											<label><input id="chk-fixed" type="checkbox"
												data-toggle-state="layout-fixed"><span
												class="lever switch-col-grey"></span></label>
										</div></li>
									<li><span>Boxed</span>
										<div class="switch">
											<label><input id="chk-boxed" type="checkbox"
												data-toggle-state="layout-boxed"><span
												class="lever switch-col-grey"></span></label>
										</div></li>
									<li><span>Collapsed</span>
										<div class="switch">
											<label><input id="chk-collapsed" type="checkbox"
												data-toggle-state="aside-collapsed"><span
												class="lever switch-col-grey"></span></label>
										</div></li>
									<li><span>Collapsed Text</span>
										<div class="switch">
											<label><input id="chk-collapsed-text" type="checkbox"
												data-toggle-state="aside-collapsed-text"><span
												class="lever switch-col-grey"></span></label>
										</div></li>
									<li><span>Float</span>
										<div class="switch">
											<label><input id="chk-float" type="checkbox"
												data-toggle-state="aside-float"><span
												class="lever switch-col-grey"></span></label>
										</div></li>
									<li><span>Show Scrollbar</span>
										<div class="switch">
											<label><input id="chk-hover" type="checkbox"
												data-toggle-state="show-scrollbar" data-target=".sidebar"><span
												class="lever switch-col-grey"></span></label>
										</div></li>
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
<c:if test="${userClickHome==true }">
			<%@include file="dashboard.jsp"%>
		</c:if>
		</section>
		<!-- FOOTER comes here-->
		<%@include file="./shared/footer.jsp"%>
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
	<script src="${plugins}/jquery-countto/jquery.countTo.js"></script>
	<script src="${plugins}/masonry/masonry.pkgd.min.js"></script>
	<script src="${plugins}/jquery-sparkline/jquery.sparkline.js"></script>
	<script src="${plugins}/morrisjs/morris.js"></script>
	<script src="${plugins}/raphael/raphael.min.js"></script>
	<script src="${plugins}/masonry/masonry.min.js"></script>

	<!--Chat js-->
	<script src="${plugins}/wchat/${js}/custom.js"></script>
	<script type="text/javascript"
		src="${plugins}/wchat/chatjs/lightbox.js"></script>
	<script type="text/javascript"
		src="${plugins}/wchat/chatjs/dashboard.js"></script>
	<script type="text/javascript" src="${plugins}/wchat/chatjs/custom.js"></script>
	<!-- #End# Chat js-->

	<script src="${js}/pages/index.js"></script>

	<!-- LAYOUT JS -->
	<script src="${js}/demo.js"></script>
	<script src="${js}/layout.js"></script>

</body>

</html>