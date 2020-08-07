<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Tạo tài khoản quản trị</title>
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
                            <div class="panel-heading">
                                Tạo tài khoản quản trị
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <!-- Form tạo danh mục -->
                                        <form:form action="${pageContext.request.contextPath}/manages/account/save_manages" method="POST" modelAttribute="account">
                                            <!-- Chọn quyền -->
                                            <%-- <div class="form-group">
                                                <label for="my-input">Quyền</label>
                                                <form:select path="role.roleId" class="form-control">    
	                                                <option value="-1">Chọn quyền</option>
	                                                <c:forEach var="role" items="${listRole}">
	                                                    <option value="${role.roleId}" ${product.category.categoryId == c.categoryId ? 'selected=""' : ''}>${c.categoryName}</option>
	                                                </c:forEach>
	                                            </form:select>
                                            </div> --%>
                                            
                                            <!-- accountName -->
                                            <div class="form-group">
                                                <label>Tên tài khoản</label>
                                                <form:input class="form-control" type="text" name="accountName" path="accountName"/>
                                            </div>

                                            <!-- fullName -->
                                            <div class="form-group">
                                                <label>Họ và tên</label>
                                                <form:input class="form-control" type="text" name="fullName" path="fullName"/>
                                            </div>

                                            <!-- accountMail -->
                                            <div class="form-group">
                                                <label>Mail</label>
                                                <form:input class="form-control" type="email" name="accountMail" path="mail"/>
                                            </div>

                                            <!-- address -->
                                            <div class="form-group">
                                                <label>Địa chỉ</label>
                                                <form:input class="form-control" type="text" name="address" path="address"/>
                                            </div>

                                            <!-- SĐT -->
                                            <div class="form-group">
                                                <label>SĐT</label>
                                                <form:input class="form-control" type="text" name="moblie" path="mobile"/>
                                            </div>

                                            <div class="form-group">
                                               	<input type="reset" class="btn btn-default" name="xoa" value="Hủy">
                                                <input type="submit" class="btn btn-primary" name="create_account" value="Lưu">
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