<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/page/img/fav.png">
<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
	<!-- Start Header Area -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- End Header Area -->

	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div
				class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>Shopping Cart</h1>
					<nav class="d-flex align-items-center">
						<a href="${pageContext.request.contextPath}/home">Home<span
							class="lnr lnr-arrow-right"></span></a> <a href="category.html">Cart</a>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->

	<!--================Cart Area =================-->
	<section class="cart_area">
		<div class="container">
			<div class="cart_inner">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Sản phẩm</th>
								<th scope="col">Số lượng</th>
								<th scope="col">Giá</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${sessionScope.myCartItems}" var="map">
								<tr>
									<td>
										<div class="media">
											<div class="d-flex">
												<img
													src="${pageContext.request.contextPath}/resources/page/img/product/${map.value.product.productImage}"
													alt="" width="50px" height="50px" />
											</div>
											<div class="media-body" style="width: 400px;">
												<p>
													<c:out value="${map.value.product.productName}"></c:out>
												</p>
											</div>
										</div>
									</td>

									<td>
										<div class="product_count">
											<input type="number" value="${map.value.quantity}" min="1"
												class="input-text qty" name="quantity" id="quantity"
												data-toggle="modal"
												data-target="#b${map.value.product.productId}">
										</div>

										<div class="modal fade"
											id="b${map.value.product.productId}" tabindex="-1"
											role="dialog" aria-labelledby="exampleModalCenterTitle"
											aria-hidden="true">
											<div class="modal-dialog modal-dialog-centered"
												role="document">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="exampleModalLongTitle">Notify</h5>
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>
													</div>
													<form
														action="${pageContext.request.contextPath}/cart/updateCart/${map.value.product.productId}"
														method="GET">
														<div class="modal-body">
															<input type="number" value="${map.value.quantity}"
																min="1" class="input-text qty" name="quantity"
																id="quantity">
														</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">Hủy</button>
															 <%-- <span class="btn btn-primary">
															 	 <a style="color: white" href="${pageContext.request.contextPath}/cart/updateCart/${map.value.product.productId}">Cập nhật</a>
															</span> --%>
															<button type="submit" class="btn-primary">Cập nhật</button>
														</div>
													</form>
												</div>
											</div>
										</div>
									</td>

									<td style="width: 300px;">
										<h5>${map.value.product.productPrice * map.value.quantity}VNĐ</h5>
									</td>
									<td><a
										href="${pageContext.request.contextPath}/cart/remove/${map.value.product.productId}"
										class="ps-remove"></a> <%-- <button type="button" class="ps-remove" data-toggle="modal"
											data-target="#a${map.value.productSize.productSizeId}"></button> --%>
									</td>
								</tr>

							</c:forEach>

							<tr>
								<td></td>
								<td></td>
								<td>
									<h5>Tổng tiền</h5>
								</td>
								<td>
									<h5>${sessionScope.myCartTotal}VNĐ</h5>
								</td>
							</tr>

							<tr class="out_button_area">
								<td></td>
								<td></td>
								<td></td>
								<td>
									<div class="checkout_btn_inner d-flex align-items-center">
										<a class="gray_btn"
											href="${pageContext.request.contextPath}/home.htm">Tiếp
											tục mua</a> <a class="primary-btn"
											href="${pageContext.request.contextPath}/checkout.htm">Tiến
											hành thanh toán</a>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- 
				<div class="modal fade" id="a" tabindex="-1" role="dialog"
					aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLongTitle">Notify</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">Are you sure delete it !</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Hủy</button>
								<span class="btn btn-primary"> <a style="color: white"
									href="${pageContext.request.contextPath}/cart/remove/${map.value.productSize.productSizeId}.htm">Xóa</a>
								</span>
							</div>
						</div>
					</div>
				</div>
				<!-- -->
			</div>
		</div>
	</section>
	<!--================End Cart Area =================-->

	<!-- start footer Area -->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
