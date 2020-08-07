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
	<title>Tạo sản phẩm mới</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/ckeditor/ckeditor.js"></script> 
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/ckfinder/ckfinder.js"></script>
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
							<div class="panel-heading">Tạo sản phẩm mới</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-lg-12">
										<!-- Form tạo danh mục -->
										<form:form action="${pageContext.request.contextPath}/manages/product/save" method="POST" modelAttribute="product" enctype="multipart/form-data">
											<!-- productId -->
											<form:input path="productId" readonly="true" type="hidden"/>
											
											<!-- Danh mục -->
											<div class="form-group">
												<label>Danh mục ${product.category.categoryId}</label>
	                                            <form:select path="category.categoryId" class="form-control">    
	                                                <option value="-1">Chọn một loại</option>
	                                                <c:forEach var="c" items="${listCategory}">
	                                                    <option value="${c.categoryId}" ${product.category.categoryId == c.categoryId ? 'selected=""' : ''}>${c.categoryName}</option>
	                                                </c:forEach>
	                                            </form:select>
											</div>
											
											<!-- NSX -->
											<div class="form-group">
												<label>NSX</label>
	                                            <form:select path="producer.producerId" class="form-control">    
	                                                <option value="-1">Chọn NSX</option>
	                                                <c:forEach var="p" items="${listProducer}">
	                                                    <option value="${p.producerId}" ${product.producer.producerId == p.producerId ? 'selected=""' : ''}>${p.producerName}</option>
	                                                </c:forEach>
	                                            </form:select>
											</div>
                                            
											<!-- Tên sản phẩm -->
											<div class="form-group">
												<label>Tên sản phẩm</label>
												 <form:input class="form-control" type="text" path="producerName"/>
											</div>
											
											<!-- Ảnh -->
											<div class="form-group">
												<label>Ảnh sản phẩm</label>
												 <form:input type="file" class="form-control" path="productImage"/>
											</div>
											
											<!-- Giá -->
											<div class="form-group">
												<label>Giá</label>
												 <form:input class="form-control" type="number" path="productPrice"/>
											</div>
											
											<!-- Khuyến mại -->
											<div class="form-group">
												<label>Khuyến mại</label>
												 <form:input class="form-control" type="text" path="productSale"/>
											</div>
											
											<!-- Nội dung -->
											<div class="form-group">
												<label>Nội dung</label>
												 <form:textarea id="content" class="form-control" path="content"/>
											</div>
											<script type="text/javascript">
                                                var editor = CKEDITOR.replace('content');
                                                CKFinder.setupCKEditor(editor, '${pageContext.request.contextPath}/resources/ckfinder/');
                                            </script>
											<!--  -->
											<div class="form-group">
												<label>Thông số</label>
												 <form:textarea id="productDescription" class="form-control" path="productDescription"/>
											</div>
											
											<script type="text/javascript">
                                                var editor = CKEDITOR.replace('productDescription');
                                                CKFinder.setupCKEditor(editor, 'resources/ckfinder/');
                                            </script>
                                            
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
