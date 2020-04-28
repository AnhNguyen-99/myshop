<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Category</title>
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/page/img/fav.png">
</head>
<body>

	<div class="page-container">

		<div class="left-content">

			<div class="mother-grid-inner">

				<jsp:include page="header.jsp"></jsp:include>

				<div class="inner-block">
					<div class="inbox">
						<h2>Quản lý danh mục</h2>
						<h4>${status}</h4>
						<div class="col-md-12 mailbox-content  tab-content tab-content-in">
							<div class="tab-pane active text-style" id="tab1">
								<div class="mailbox-border">
									<div class="mail-toolbar clearfix">
										<div class="float-left">
											<div class="btn btn_1 btn-default mrg5R">
												<a href="${pageContext.request.contextPath}/manages/category/add"><i class="fa fa-plus">ADD</i></a>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<table class="table tab-border">
										<tbody>
											<tr>
												<td class="hidden-xs" style="width: 200px;"><b>Tên
														danh mục</b></td>
												<td class="hidden-xs" style="width: 250px;"><b>Ngày
														tạo</b></td>
												<td style="text-align: center; width: 150px;"><b>Option</b>
												</td>
											</tr>
											<c:forEach var="item" items="${listCategory}">
												<tr class="unread checked">
													<td class="hidden-xs" style="width: 200px;">
														${item.categoryName}</td>
													<td class="hidden-xs" style="width: 200px;">
														${item.createDate}</td>
													<td style="text-align: center; width: 150px;">
														<a class="btn btn-default" href="${pageContext.request.contextPath}/manages/category/edit/${item.categoryId}"><i class="fa fa-edit"></i></a>
														<a type="button"href="${pageContext.request.contextPath}/manages/category/delete/${item.categoryId}" onclick="return confirm('Bạn có muốn xóa?')"class="btn btn-default"><i class="fa fa-remove"></i></a>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
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
