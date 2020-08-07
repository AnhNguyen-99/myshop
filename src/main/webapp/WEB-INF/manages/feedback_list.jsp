<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Phản hồi</title>
</head>

<body>

	<div id="wrapper">

		<jsp:include page="menu.jsp"></jsp:include>

		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Danh sách phản hồi của khách hàng</h1>
					</div>
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">Danh sách</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th>Tên người phản hồi</th>
												<th>SĐT</th>
												<th>Email</th>
												<th>Địa chỉ</th>
												<th>Nội dung phản hồi</th>
												<th>Ngày phản hồi</th>
												<th>Phản hồi</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${listFeedBack}" var="item">
												<tr>
													<td>${item.username}</td>
													<td>${item.mobile}</td>
													<td>${item.email}</td>
													<td>${item.address}</td>
													<td>${item.content}</td>
													<td>${item.createDate}</td>
													<td>
														<a class='btn btn-default' href="form_feedback.php?feedbackId=<?php echo $row['feedbackId'];?>"><i class='fa fa-edit'></i></a>
													</td>
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