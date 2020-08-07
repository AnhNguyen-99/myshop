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
	<title>Tạo mới danh mục bằng api</title>
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
										<form:form role="form" action="#" method="POST" id="formCategory" modelAttribute="category">
											<form:input path="categoryId" type="hidden"/>
											<div class="form-group">
												<label>Tên danh mục</label>
												 <form:input class="form-control" type="text" id="categoryName" path="categoryName"/>
											</div>
											<form:input path="categoryStatus" type="hidden" name="categoryStatus"/>
											<%-- <form:input path="createDate" type="hidden" name="createDate"/> --%>
											<form:input path="accountId" type="hidden" name="accountId"/>
											<div class="form-group">
												<input type="reset" class="btn btn-default"	value="Hủy"> 
												<button class="btn btn-primary" id="btnAdd">Lưu</button>
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
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
	<%-- <script src="${pageContext.request.contextPath}/resources/manages/js/add_category"></script> --%>
	
	<script src="${pageContext.request.contextPath}/resources/manages/js/jquery.min.js"></script>

	<script src="${pageContext.request.contextPath}/resources/manages/js/bootstrap.min.js"></script>

	<script src="${pageContext.request.contextPath}/resources/manages/js/metisMenu.min.js"></script>

	<script src="${pageContext.request.contextPath}/resources/manages/js/startmin.js"></script>
	
	<script>
	$('#btnAdd').click(function (e) {
	    e.preventDefault();
	    console.log(1);
	    var data = {
	    	"categoryName": $("#categoryName").val(),
	    	"accountId": $("#accountId").val(),
	    	"categoryStatus": $("#categoryStatus").val()
	    };
	    console.log("data", data);
	    var formData = $('#formCategory').serializeArray();
	    /* $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        }); */
	    addCategory(data);
	});
	
	function addCategory(data) {
		$.ajax({
            url: 'http://localhost:8080/MyShop/api/category',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	alert("Thành công");
            },
            error: function (error) {
            	console.log(error);
            	alert("Thất bại");
            }
        });
	}
	
</script>

</body>
</html>
