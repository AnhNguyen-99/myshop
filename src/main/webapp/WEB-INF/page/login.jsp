<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="zxx" class="no-js">

    <head>
        <title>Karma Shop</title>
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
                                <a href="category.html">Login/Register</a>
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
                        <div class="col-lg-6">
                            <div class="login_box_img">
                                <img class="img-fluid" src="${pageContext.request.contextPath}/resources/page/img/login.jpg" alt="">
                            <div class="hover">
                                <h4>New to our website?</h4>
                                <p>There are advances being made in science and technology everyday, and a good example of this is the</p>
                                <a class="primary-btn" href="${pageContext.request.contextPath}/regist">Tạo tài khoản mới</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="login_form_inner">
                            <h3>Đăng nhập</h3>
                            <form:form class="row login_form" id="contactForm" method="POST" action="${pageContext.request.contextPath}/login.htm" modelAttribute="account">
                                <div class="col-md-12 form-group">
                                    <form:input type="text" class="form-control" path="accountName" placeholder="Tên đăng nhập"/>
                                </div>
                                <div class="col-md-12 form-group">
                                    <form:password class="form-control" path="accountPass" placeholder="Mật khẩu"/>
                                </div>
                                <div class="col-md-12 form-group">
                                    <div class="creat_account">
                                        <input type="checkbox" id="f-option2" name="selector">
                                        <label for="f-option2">Nhớ tài khoản</label>
                                    </div>
                                </div>
                                <div class="col-md-12 form-group">
                                    <!--<button type="submit" value="submit" class="primary-btn">Log In</button>-->
                                    <input class="primary-btn" type="submit" value="Đăng nhập">
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