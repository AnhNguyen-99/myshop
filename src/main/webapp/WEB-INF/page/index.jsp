<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
	<title>MyShop</title>
	<meta charset="utf-8">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>

	<div class="colorlib-loader"></div>

	<!-- <div id="page"> -->
	
		<jsp:include page="header.jsp"></jsp:include>
		
		<aside id="colorlib-hero">
			<div class="flexslider">
				<ul class="slides">
					<li style="background-image: url(./resources/page/images/img_bg_1.jpg);">
						<div class="overlay"></div>
						<div class="container-fluid">
							<div class="row">
								<div class="col-sm-6 offset-sm-3 text-center slider-text">
									<div class="slider-text-inner">
										<div class="desc">
											<h1 class="head-1">Men's</h1>
											<h2 class="head-2">Shoes</h2>
											<h2 class="head-3">Collection</h2>
											<p class="category">
												<span>New trending shoes</span>
											</p>
											<p>
												<a href="#" class="btn btn-primary">Shop Collection</a>
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</li>
					<li style="background-image: url(./resources/page/images/img_bg_2.jpg);">
						<div class="overlay"></div>
						<div class="container-fluid">
							<div class="row">
								<div class="col-sm-6 offset-sm-3 text-center slider-text">
									<div class="slider-text-inner">
										<div class="desc">
											<h1 class="head-1">Huge</h1>
											<h2 class="head-2">Sale</h2>
											<h2 class="head-3">
												<strong class="font-weight-bold">50%</strong> Off
											</h2>
											<p class="category">
												<span>Big sale sandals</span>
											</p>
											<p>
												<a href="#" class="btn btn-primary">Shop Collection</a>
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</li>
					<li style="background-image: url(./resources/page/images/img_bg_3.jpg);">
						<div class="overlay"></div>
						<div class="container-fluid">
							<div class="row">
								<div class="col-sm-6 offset-sm-3 text-center slider-text">
									<div class="slider-text-inner">
										<div class="desc">
											<h1 class="head-1">New</h1>
											<h2 class="head-2">Arrival</h2>
											<h2 class="head-3">
												up to <strong class="font-weight-bold">30%</strong> off
											</h2>
											<p class="category">
												<span>New stylish shoes for men</span>
											</p>
											<p>
												<a href="#" class="btn btn-primary">Shop Collection</a>
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</aside>
		<div class="colorlib-intro">
			<div class="container">
				<div class="row">
					<div class="col-sm-12 text-center">
						<h2 class="intro">It started with a simple idea: Create
							quality, well-designed products that I wanted myself.</h2>
					</div>
				</div>
			</div>
		</div>
		<div class="colorlib-product">
			<div class="container-fluid">
				<div class="row">
					<div class="col-sm-6 text-center">
						<div class="featured">
							<a href="#" class="featured-img"
								style="background-image: url(./resources/page/images/men.jpg);"></a>
							<div class="desc">
								<h2>
									<a href="#">Shop Men's Collection</a>
								</h2>
							</div>
						</div>
					</div>
					<div class="col-sm-6 text-center">
						<div class="featured">
							<a href="#" class="featured-img"
								style="background-image: url(./resources/page/images/women.jpg);"></a>
							<div class="desc">
								<h2>
									<a href="#">Shop Women's Collection</a>
								</h2>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="colorlib-product">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 offset-sm-2 text-center colorlib-heading">
						<h2>Best Sellers</h2>
					</div>
				</div>
				<div class="row row-pb-md" id="listProduct">
					
				</div>
				<!--  -->
				<div class="row">
					<div class="col-md-12 text-center">
						<p>
							<a href="#" class="btn btn-primary btn-lg">Shop All Products</a>
						</p>
					</div>
				</div>
			</div>
		</div>

		<div class="colorlib-partner">
			<div class="container">
				<div class="row">
					<div
						class="col-sm-8 offset-sm-2 text-center colorlib-heading colorlib-heading-sm">
						<h2>Trusted Partners</h2>
					</div>
				</div>
				<div class="row">
					<div class="col partner-col text-center">
						<img src="./resources/page/images/brand-1.jpg" class="img-fluid"
							alt="Free html4 bootstrap 4 template">
					</div>
					<div class="col partner-col text-center">
						<img src="./resources/page/images/brand-2.jpg" class="img-fluid"
							alt="Free html4 bootstrap 4 template">
					</div>
					<div class="col partner-col text-center">
						<img src="./resources/page/images/brand-3.jpg" class="img-fluid"
							alt="Free html4 bootstrap 4 template">
					</div>
					<div class="col partner-col text-center">
						<img src="./resources/page/images/brand-4.jpg" class="img-fluid"
							alt="Free html4 bootstrap 4 template">
					</div>
					<div class="col partner-col text-center">
						<img src="./resources/page/images/brand-5.jpg" class="img-fluid"
							alt="Free html4 bootstrap 4 template">
					</div>
				</div>
			</div>
		</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/page/js/list-product.js"></script>
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>

