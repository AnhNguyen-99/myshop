<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Danh sách khách hàng</title>
</head>

<body>

	<div id="wrapper">

		<jsp:include page="menu.jsp"></jsp:include>

		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Danh sách khách hàng</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								Danh sách người dùng
							</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover" id="dataTables-example">
										<thead>
											<tr>
												<th>Tên đăng nhập</th>
												<th>Tên khách hàng</th>
												<th>Địa chỉ</th>
												<th>SĐT</th>
												<th>Mail</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${listManages}" var="item">
												<tr>
													<td>${item.account.accountName}</td>
													<td>${item.account.fullName}</td>
													<td>${item.account.address}</td>
													<td>${item.account.mobile}</td>
													<td>${item.account.mail}</td>
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

</body>

</html>