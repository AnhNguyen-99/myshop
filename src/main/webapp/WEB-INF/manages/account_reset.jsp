<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Reset tài khoản</title>
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
                                Reset mật khẩu tài khoản
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <!-- Form reset mật khẩu tài khoản  -->
                                        <form role="form" action="${pageContext.request.contextPath}/manages/account/reset" method="get">
                                            <div class="form-group">
                                                <label>Tên tài khoản</label>
                                                <input class="form-control" type="text" name="accountName"/>
                                            </div>

                                            <input class="btn btn-default" type="reset" name="xoa" value="Hủy">
                                            <input class="btn btn-primary" type="submit" name="btnReset" value="Đổi mật khẩu">

                                        </form>
                                
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