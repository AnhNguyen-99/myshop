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
                            <h1>Login/Register</h1>
                            <nav class="d-flex align-items-center">
                                <a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
                                <a href="category.html">Register</a>
                            </nav>
                        </div>
                    </div>
                </div>
            </section>
            <!-- End Banner Area -->

            <!--================Login Box Area =================-->
            <section class="login_box_area section_gap">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="login_form_inner">
                                <h3>Tạo tài khoản</h3>
                                <h3>${status}</h3>
                            <form:form class="row login_form" id="contactForm" method="POST" action="${pageContext.request.contextPath}/create.htm" modelAttribute="account">
                                <form:input type="hidden" path="accountId"/>
                                <div class="col-md-12 form-group">
                                    <form:input type="text" class="form-control" path="accountName" placeholder="Tên tài khoản" required="true"/>
                                </div>
                                <div class="col-md-12 form-group">
                                    <form:input type="text" class="form-control" path="fullName" placeholder="Họ và tên" required="true"/>
                                </div>
                                <div class="col-md-12 form-group">
                                    <form:password class="form-control" path="accountPass" placeholder="Mật khẩu" required="true"/>
                                </div>
                                <div class="col-md-12 form-group">
                                    <form:input class="form-control" path="accountMail" placeholder="Email" required="true"/>
                                </div>
                                <div class="col-md-12 form-group">
                                    <form:input class="form-control" path="moblie" placeholder="SĐT" required="true"/>
                                </div>
                                <div class="col-md-12 form-group">
                                    <form:input class="form-control" path="address" placeholder="Địa chỉ" required="true"/>
                                </div>

                                <div class="col-md-12 form-group">
                                    <input class="primary-btn" type="submit" value="Đăng ký">
                                </div>
                                
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </section> 
        <!--================End Login Box Area =================-->

        <!-- start footer Area -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
