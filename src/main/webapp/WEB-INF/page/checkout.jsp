<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

    <head>
        <title>Checkout</title>
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
                            <h1>Checkout</h1>
                            <nav class="d-flex align-items-center">
                                <a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
                                <a href="single-product.html">Checkout</a>
                            </nav>
                        </div>
                    </div>
                </div>
            </section>
            <!-- End Banner Area -->

            <!--================Checkout Area =================-->
            <section class="checkout_area section_gap">
                <div class="container">
                    <div class="billing_details">
                        <div class="row">
                        <form:form class="row contact_form" action="${pageContext.request.contextPath}/cart/checkout" method="POST" novalidate="novalidate" modelAttribute="order">
                            <div class="col-lg-8">
                                <!-- Form checkout -->
                                <h3>Billing Details</h3>
                                <!-- Name -->
                                <form:input class="form-control" type="hidden" path="orderId"/>
                                
                                <div class="col-md-8 form-group p_star">
                                    <form:input type="text" class="form-control" id="first" path="orderName" placeholder="Họ và tên"/>
                                </div>
                                <!-- Mail -->
                                <div class="col-md-8 form-group p_star">
                                    <form:input type="text" class="form-control" path="mail" placeholder="Mail"/>
                                </div>
                                <!-- SĐT -->
                                <div class="col-md-8 form-group p_star">
                                    <form:input type="text" class="form-control" path="mobile" placeholder="SĐT"/>
                                </div>
                                <!-- Address -->
                                <div class="col-md-8 form-group p_star">
                                    <form:input type="text" class="form-control" path="address" placeholder="Địa chỉ"/>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="order_box">
                                    <h2>Your Order</h2>
                                    <table class="list">
                                        <tr>
                                            <th>Sản phẩm</th>
                                            <th>SL</th>
                                            <th>Giá</th> 
                                        </tr>
                                        <c:forEach items="${sessionScope.myCartItems}" var="map">
                                            <tr>
                                                <td><c:out value="${map.value.product.productName}"></c:out></td> 
                                                <td><c:out value="${map.value.quantity}"></c:out></td> 
                                                <td><c:out value="${map.value.product.productPrice * map.value.quantity}VNĐ"></c:out></td> 
                                                </tr>
                                        </c:forEach>
                                        <tr>
                                            <td>

                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Tổng tiền:</td>
                                            <td><c:out value="${sessionScope.myCartTotal}VNĐ"></c:out></td>
                                            </tr>
                                        </table>
                                        <input class="primary-btn"  type="submit" value="Thanh toán">
                                    </div>
                                </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </section>
        <!--================End Checkout Area =================-->

        <!-- start footer Area -->
        <jsp:include page="footer.jsp"></jsp:include>

    </body>

</html>