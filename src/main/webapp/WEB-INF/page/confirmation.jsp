<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

    <head>
        <title>Success</title>
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
                            <h1>Confirmation</h1>
                            <nav class="d-flex align-items-center">
                                <a href="${pageContext.request.contextPath}/home">Home<span class="lnr lnr-arrow-right"></span></a>
                            <a href="category.html">Confirmation</a>
                        </nav>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Banner Area -->

        <!--================Order Details Area =================-->
        <section class="order_details section_gap">
            <div class="container">
                <h3 class="title_confirmation">Cảm ơn bạn ${sessionScope.myLogin.fullName} đã mua hàng.</h3>

                <div class="order_details_table">
                    <h2>Đơn hàng chi tiết</h2>
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Sản phẩm</th>
                                    <th scope="col">Số lượng</th>
                                    <th scope="col">Đơn giá</th>
                                    <th scope="col">Tổng giá</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listOrderItem}" var="item">
                                    <tr>
                                        <td>
                                            <p>${item.productId.productName}</p>
                                        </td>
                                        
                                        <td>
                                            <h5>${item.orderItemQuantity}</h5>
                                        </td>
                                        <td>
                                            <p>${item.productId.productPrice}</p>
                                        </td>
                                        <td>
                                            <p>${item.orderItemPrice}VNĐ</p>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div>
                    <br>
                    <a class="primary-btn" href="${pageContext.request.contextPath}/home">Tiếp tục mua</a>
                </div>
            </div>
        </section>
        <!--================End Order Details Area =================-->

        <!-- start footer Area -->
        <jsp:include page="footer.jsp"></jsp:include>

    </body>

</html>