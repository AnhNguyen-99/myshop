<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Karma</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/page/img/fav.png">
    </head>
    <body>
        <!-- Start Header Area -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- End Header Area -->

            <!-- Start Banner Area -->
            <section class="banner-area organic-breadcrumb">
                <div class="container">
                    <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                        <div class="col-first">
                            <h1>Infor Account</h1>
                            <nav class="d-flex align-items-center">
                                <a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
                                <a href="category.html">Infor Account</a>
                            </nav>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Thay đổi thông tin -->
                <div class="container">
                <div class="row">
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                        <div style="height: 50px;"></div>
                        <ul class="infomation">
                            <li style="background-color: rgb(255,140,0);"><a href="${pageContext.request.contextPath}/inforaccount.htm">Thông tin</a></li>
                            <li><a href="${pageContext.request.contextPath}/listOrders.htm">Lịch sử mua hàng</a></li>
                            <li><a href="${pageContext.request.contextPath}/changeInfor.htm">Thay đổi thông tin</a></li>
                            <li><a href="${pageContext.request.contextPath}/updatePass.htm">Thay đổi mật khẩu</a></li>
                        </ul>
                    </div>
                    <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1">
                    </div>
                    <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
                        <div style="height: 50px;"></div>
                        <h3>Thay đổi thông tin</h3>
                        <form:form action="${pageContext.request.contextPath}/changeInfor.htm" method="POST" modelAttribute="account">
                            <div class="form-group">
                                <form:input type="hidden" path="accountId"/>
                                <form:input type="hidden" path="accountName"/>
                                <form:input type="hidden" path="accountPass"/>
                                <label for="my-input5">Họ và tên</label>
                                <form:input id="my-input5" class="form-control disabled" type="text" path="fullName" disabled="disabled" required="true"/>
                                <label for="my-input1">SĐT</label>
                                <form:input id="my-input1" class="form-control" type="text" path="moblie" disabled="disabled" required="true"/>
                                <label for="my-input2">Email</label>
                                <form:input id="my-input2" class="form-control" type="text" path="accountMail" disabled="disabled" required="true"/>
                                <label for="my-input3">Địa chỉ</label>
                                <form:input id="my-input3" class="form-control" type="text" path="address" disabled="disabled" required="true"/>
                                <br>
                                <input type="submit" class="btn btn-primary mt-15" data-toggle="tooltip" value="Thay đổi">
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        <!--================End Login Box Area =================-->

        <!-- start footer Area -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
