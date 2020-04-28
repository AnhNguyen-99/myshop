<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Category News</title>
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
						<h2>Danh mục</h2>
						<div class="col-md-12 compose-right">
							<div class="inbox-details-default">
								<div class="inbox-details-heading">${status}</div>
								<div class="inbox-details-body">
									<div class="alert alert-info">Vui lòng điền chi tiết thông tin vào trường bên dưới</div>
									<form:form method="POST" modelAttribute="category" class="com-mail"	action="${pageContext.request.contextPath}/manages/category/save">
										<br />
										<form:input type="hidden" path="categoryId" readonly="true"
											required="true" />
										<label>Tên danh mục</label>
										<form:input path="categoryName" required="true" />
										<input type="submit" value="Save">
									</form:form>
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
