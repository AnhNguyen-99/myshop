<!DOCTYPE HTML>
<html>
<head>
	<title>Checkout Complete</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>

	<div class="colorlib-loader"></div>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="breadcrumbs">
		<div class="container">
			<div class="row">
				<div class="col">
					<p class="bread">
						<span><a href="${pageContext.request.contextPath}/home">Home</a></span>
						/ <span>Purchase Complete</span>
					</p>
				</div>
			</div>
		</div>
	</div>

	<div class="colorlib-product">
		<div class="container">
			<div class="row row-pb-lg">
				<div class="col-sm-10 offset-md-1">
					<div class="process-wrap">
						<div class="process text-center active">
							<p>
								<span>01</span>
							</p>
							<h3>Shopping Cart</h3>
						</div>
						<div class="process text-center active">
							<p>
								<span>02</span>
							</p>
							<h3>Checkout</h3>
						</div>
						<div class="process text-center active">
							<p>
								<span>03</span>
							</p>
							<h3>Order Complete</h3>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-10 offset-sm-1 text-center">
					<p class="icon-addcart">
						<span><i class="icon-check"></i></span>
					</p>
					<h2 class="mb-4">Thank you for purchasing, Your order is
						complete</h2>
					<p>
						<a href="${pageContext.request.contextPath}/home" class="btn btn-primary btn-outline-primary">Home</a> 
						<a href="${pageContext.request.contextPath}/shop" class="btn btn-primary btn-outline-primary"><i class="icon-shopping-cart"></i> Continue Shopping</a>
					</p>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
