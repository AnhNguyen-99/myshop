<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Tạo mới danh mục</title>
</head>
<body>

	<div id="wrapper">

		<jsp:include page="menu.jsp"></jsp:include>
		
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Forms</h1>
					</div>

				</div>

				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">Tạo danh mục mới</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-lg-12">
										<!-- Form tạo danh mục -->
										<form:form action="${pageContext.request.contextPath}/manages/category/save" method="POST" modelAttribute="category">
											<div class="form-group">
												<label>Tên danh mục</label>
												 <form:input class="form-control" type="text" path="categoryName"/>
											</div>
											<div class="form-group">
												<input type="reset" class="btn btn-default"	value="Hủy"> 
												<input type="submit" class="btn btn-primary" value="Lưu">
											</div>
										</form:form>
									</div>

								</div>

							</div>

						</div>

					</div>

				</div>

			</div>

		</div>

	</div>

	<script src="${pageContext.request.contextPath}/resources/manages/js/jquery.min.js"></script>

	<script src="${pageContext.request.contextPath}/resources/manages/js/bootstrap.min.js"></script>

	<script src="${pageContext.request.contextPath}/resources/manages/js/metisMenu.min.js"></script>

	<script src="${pageContext.request.contextPath}/resources/manages/js/startmin.js"></script>

</body>
</html>
