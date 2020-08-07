<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Checkout</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
						/ <span>Checkout</span>
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
						<div class="process text-center">
							<p>
								<span>03</span>
							</p>
							<h3>Order Complete</h3>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-8">
					<form:form method="post" class="colorlib-form"
						action="${pageContext.request.contextPath}/cart/checkout"
						modelAttribute="order">
						<h2>Billing Details</h2>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label>FullName</label>
									<form:input class="form-control" path="orderName"
										placeholder="Enter Your FullName" />
								</div>
							</div>

							<div class="col-md-12">
								<div class="form-group">
									<label>Email</label>
									<form:input class="form-control" path="mail"
										placeholder="Enter Your Email" />
								</div>
							</div>

							<div class="col-md-12">
								<div class="form-group">
									<label>Phone</label>
									<form:input class="form-control" path="phone"
										placeholder="Enter Your Phone" />
								</div>
							</div>

							<div class="col-md-12">
								<div class="form-group">
									<label>Address</label>
									<form:input class="form-control" path="address"
										placeholder="Enter Your Address" />
								</div>
							</div>
							
							<div class="form-group">
								<input class="btn btn-primary" type="submit" value="Place an order" style="float: right;"/>
							</div>
							
						</div>
					</form:form>
				</div>

				<div class="col-lg-4">
					<div class="row">
						<div class="col-md-12">
							<div class="cart-detail">
								<h2>Cart Total</h2>
								<ul>
									<li><span>Subtotal</span> <span>$100.00</span>
										<ul>
											<li><span>1 x Product Name</span> <span>$99.00</span></li>
											<li><span>1 x Product Name</span> <span>$78.00</span></li>
										</ul></li>
									<li><span>Shipping</span> <span>$0.00</span></li>
									<li><span>Order Total</span> <span>$${sessionScope.myCartTotal}</span></li>
								</ul>
							</div>
						</div>

						<div class="w-100"></div>

						<div class="col-md-12">
							<div class="cart-detail">
								<h2>Payment Method</h2>
								<div class="form-group">
									<div class="col-md-12">
										<div class="radio">
											<label><input type="radio" name="optradio">
												Direct Bank Tranfer</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-12">
										<div class="radio">
											<label><input type="radio" name="optradio">
												Check Payment</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-12">
										<div class="radio">
											<label><input type="radio" name="optradio">
												Paypal</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-12">
										<div class="checkbox">
											<label><input type="checkbox" value=""> I
												have read and accept the terms and conditions</label>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 text-center">
							<p>
								<%-- <a
									href="${pageContext.request.contextPath}/cart/checkout_complete"
									class="btn btn-primary">Place an order</a> --%>
							</p>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>

