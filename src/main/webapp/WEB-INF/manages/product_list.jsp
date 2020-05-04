<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="mytag" uri="/WEB-INF/taglibs/newtag_library.tld" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Product</title>
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/page/img/fav.png">
</head>
<body>

	<div class="page-container">

		<div class="left-content">

			<div class="mother-grid-inner">

				<jsp:include page="header.jsp"></jsp:include>

				<div class="inner-block">
					<div class="inbox">
						<h2>Quản lý sản phẩm</h2>
						<div class="col-md-12 mailbox-content  tab-content tab-content-in">
							<div class="tab-pane active text-style" id="tab1">
								<div class="mailbox-border">
									<div class="mail-toolbar clearfix">
										<div class="float-left">
											<div class="btn btn_1 btn-default mrg5R">
												<a href="${pageContext.request.contextPath}/manages/product/add"><i class="fa fa-plus">ADD</i></a>
											</div>
											<div class="clearfix"></div>
										</div>

									</div>
									<table class="table tab-border">
										<tbody>
											<tr>
												<td class="hidden-xs" style="text-align: center"><b>Tên
														sản phẩm</b></td>
												<td class="hidden-xs" style="width: 150px;"><b>Tên
														danh mục</b></td>
												<td style="text-align: center; width: 100px;"><b>Giá</b>
												</td>
												<td style="text-align: center; width: 100px;"><b>Khuyến
														mại</b></td>
												<td style="text-align: center; width: 150px;"><b>Option</b>
												</td>
											</tr>
											<c:forEach var="item" items="${listProduct}">
												<tr class="unread checked">
													<td class="hidden-xs" style="width: 200px">
														${item.productName}</td>
													<td class="hidden-xs" style="width: 150px;">
														${item.categoryId.categoryName}
													</td> 
													<td style="text-align: left; width: 100px;">
														${item.productPrice} VNĐ</td>
													<td style="text-align: center; width: 100px;">
														${item.productSale}%</td>
													<td style="text-align: center; width: 150px;">
													<a class="btn btn-default" href="${pageContext.request.contextPath}/edit/${item.productId}"><i class="fa fa-edit"></i></a>
													<a class="btn btn-default" href="${pageContext.request.contextPath}/manages/product/remove/${item.productId}" onclick=" return confirm('Bạn có muốn xóa?')"><i class="fa fa-remove"></i></a>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<mytag:PaginationTagHander count = "${count}" steps="${maxResult}" offset="${offset}" uri="${pageContext.request.contextPath}/manages/product/list" next="&raquo;" previous="&laquo;"/>
								</div>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>

				<jsp:include page="footer.jsp"></jsp:include>

			</div>

		</div>

		<jsp:include page="navigation.jsp"></jsp:include>

	</div>

</body>
</html>
