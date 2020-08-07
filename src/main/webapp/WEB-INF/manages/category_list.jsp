<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Danh sách danh mục</title>
</head>
<body>

	<div id="wrapper">

		<jsp:include page="menu.jsp"></jsp:include>

		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Danh sách danh mục</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">DataTables Advanced Tables</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th>Mã danh mục</th>
												<th>Tên danh mục</th>
												<th>Người tạo</th>
												<th>Ngày tạo</th>
												<th>Lựa chọn</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${listCategory}" var="item">
												<tr>
													<td>${item.categoryId}</td>
													<td>${item.categoryName}</td>
													<td>${item.account.fullName}</td>
													<td>${item.createDate}</td>
													<td><a class='btn btn-default'
														href='${pageContext.request.contextPath}/manages/category/edit/${item.categoryId}'><i
															class='fa fa-edit'></i></a>
														<p class='btn btn-default'
															onclick='checkdel(${item.categoryId})'>
															<i class='fa fa-trash'></i>
														</p></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>

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

	<script	src="${pageContext.request.contextPath}/resources/manages/js/metisMenu.min.js"></script>

	<script	src="${pageContext.request.contextPath}/resources/manages/js/dataTables/jquery.dataTables.min.js"></script>

	<script	src="${pageContext.request.contextPath}/resources/manages/js/dataTables/dataTables.bootstrap.min.js"></script>

	<script	src="${pageContext.request.contextPath}/resources/manages/js/startmin.js"></script>

	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>

	<script>
        function checkdel(categoryId) {
            var categoryId = categoryId;
            var link = "${pageContext.request.contextPath}/manages/category/delete/" + categoryId;
            if (confirm("Bạn có chắc chắn muốn xóa danh mục này?") == true)
                window.open(link, "_self", 1);
        }
    </script>

</body>
</html>
