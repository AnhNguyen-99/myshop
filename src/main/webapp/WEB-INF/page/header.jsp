<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700" rel="stylesheet">
	
	<link href="https://fonts.googleapis.com/css?family=Rokkitt:100,300,400,700" rel="stylesheet">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/page/css/animate.css">

	<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/page/css/icomoon.css"> --%>

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/page/css/ionicons.min.css">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/page/css/bootstrap.min.css">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/page/css/magnific-popup.css">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/page/css/flexslider.css">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/page/css/owl.carousel.min.css">
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/page/css/owl.theme.default.min.css">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/page/css/bootstrap-datepicker.css">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/page/fonts/flaticon/font/flaticon.css">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/page/css/style.css">
	
</head>
<body>

	<nav class="colorlib-nav" role="navigation">
		<div class="top-menu">
			<div class="container">
				<div class="row">
					<div class="col-sm-7 col-md-9">
						<div id="colorlib-logo"><a href="${pageContext.request.contextPath}/home">Footwear</a></div>
					</div>
					<!-- Tìm kiếm -->
					<div class="col-sm-5 col-md-3">
		            <form action="${pageContext.request.contextPath}/search" class="search-wrap" method="get">
		               <div class="form-group">
		                  <input type="search" class="form-control search" placeholder="Search" name="query">
		                  <button class="btn btn-primary submit-search text-center" type="submit"><i class="icon-search"></i></button>
		               </div>
		            </form>
		         </div>
	         </div>
				<div class="row">
					<div class="col-sm-12 text-left menu-1">
						<ul>
							<li class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>
							<li class="has-dropdown"><a href="${pageContext.request.contextPath}/shop">Shop</a></li>
							<li><a href="${pageContext.request.contextPath}/about">About</a></li>
							<li><a href="${pageContext.request.contextPath}/contact">Contact</a></li>
							<%-- <li><a href="${pageContext.request.contextPath}/intsendMail">SendMail</a></li> --%>
							<li class="cart"><a href="${pageContext.request.contextPath}/cart"><i class="icon-shopping-cart"></i> Cart [<c:out value="${sessionScope.myCartNum}"/>]</a></li>
							<li class="has-dropdown"><a href=""><i class="icon-user"><c:out value="${sessionScope.myLogin.accountName}"/></i></a>
								<ul class="dropdown">
									<li><a href="${pageContext.request.contextPath}/login">Login</a></li>
									<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="sale">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 offset-sm-2 text-center">
						<div class="row">
							<div class="owl-carousel2">
								<div class="item">
									<div class="col">
										<h3><a href="#">25% off (Almost) Everything! Use Code: Summer Sale</a></h3>
									</div>
								</div>
								<div class="item">
									<div class="col">
										<h3><a href="#">Our biggest sale yet 50% off all summer shoes</a></h3>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</nav>
		
</body>
</html>