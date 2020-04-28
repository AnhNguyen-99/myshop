<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product form</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/page/img/fav.png">
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/ckeditor/ckeditor.js"></script> 
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/ckfinder/ckfinder.js"></script>
    </head>
    <body>

        <div class="page-container">	

            <div class="left-content">

                <div class="mother-grid-inner">

                    <jsp:include page="header.jsp"></jsp:include>

                        <div class="inner-block">
                            <div class="inbox">
                                <h2>Chi tiết sản phẩm</h2>
                                <div class="col-md-12 compose-right">
                                    <div class="inbox-details-default">
                                        <div class="inbox-details-heading">
                                            ${status}
                                        </div>
                                    <div class="inbox-details-body">
                                        <div class="alert alert-info">
                                            Vui lòng điền vào các trường
                                        </div>
                                        <form:form method="POST" modelAttribute="product" class="com-mail"
                                                   action="${pageContext.request.contextPath}/manages/product/save" enctype="multipart/form-data">

                                            <form:input path="productId" readonly="true" type="hidden"/>
                                            <label>Danh mục ${product.categoryId.categoryId}</label>
                                            <form:select path="categoryId.categoryId">    
                                                <option value="-1">Chọn một loại</option>
                                                <c:forEach var="c" items="${listCategory}">
                                                    <option value="${c.categoryId}" ${product.categoryId.categoryId == c.categoryId ? 'selected=""' : ''}>${c.categoryName}</option>
                                                </c:forEach>
                                            </form:select>
                                            <br/>
                                            <label>NSX</label>
                                            <form:select path="producerId.producerId">    
                                                <option value="-1">Chọn NSX</option>
                                                <c:forEach var="p" items="${listProducer}">
                                                    <option value="${p.producerId}" ${product.producerId.producerId == p.producerId ? 'selected=""' : ''}>${p.producerName}</option>
                                                </c:forEach>
                                            </form:select>
                                            <br/>                                            
                                            <label>Tên sản phẩm</label>
                                            <form:input path="productName"/>
                                            <label>Giá</label>
                                            <form:input path="productPrice"  />
                                            <label>Khuyến mại</label>
                                            <form:input path="productSale" />
                                            <label>Đơn vị</label>
                                            <form:input path="unit" />
                                            <label>Mô tả ngắn</label>
                                            <form:input path="shortdescription"/>
                                            <label>Mô tả chi tiết</label>
                                            <form:textarea id="productContentDetail" path="description" />
                                            <script type="text/javascript">
                                                var editor = CKEDITOR.replace('productContentDetail');
                                                CKFinder.setupCKEditor(editor, 'resources/ckfinder/');
                                                CKFinder.setupCKEditor(editor1, 'resources/ckfinder/');
                                            </script>
                                            <label>Ảnh 1</label>
                                            <div class="form-group">
                                                <form:input type="file" path="productImage" />
                                            </div>
                                            <label>Ảnh 2</label>
                                            <div class="form-group">
                                                <form:input type="file" path="productImage2"/>
                                            </div>
                                            <div class="form-group">
                                                <label>Ảnh 3</label>
                                                <form:input type="file" path="productImage3"/>
                                            </div>
                                            <input type="submit" value="Save"> 
                                        </form:form>
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix"> </div>  
                        </div>
                    </div>
                    <!-- -->
            <!--        <script type="text/javascript">
                        var editor = CKEDITOR.replace('productContentDetail');
                        var editor1 = CKEDITOR.replace('ProductContent');
                        CKFinder.setupCKEditor(editor, 'resources/js/ckfinder/');
                        CKFinder.setupCKEditor(editor1, 'resources/js/ckfinder/');
                    </script>    
                    <!-- -->
                    
                    <jsp:include page="footer.jsp"></jsp:include>
                    </div>
                </div>
            <jsp:include page="navigation.jsp"></jsp:include>
        </div>
    </body>
</html>
