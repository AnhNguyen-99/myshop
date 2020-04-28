<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer</title>
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
                            <h1>Shopping Cart</h1>
                            <nav class="d-flex align-items-center">
                                <a href="${pageContext.request.contextPath}/home.htm">Home<span class="lnr lnr-arrow-right"></span></a>
                            <a href="category.html">Cart</a>
                        </nav>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Banner Area -->

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
                <div class="col-1">
                </div>
                <div class="col-8">
                    <div style="height: 50px;"></div>
                    <h4>Danh sách đơn hàng</h4>
                    <table class="table mt-15">
                        <thead>
                            <tr style="background-color: rgb(72, 78, 78); color: white;">
                                <th scope="col" style="text-align: center">Họ và tên</th>
                                <th scope="col" style="text-align: center">Mail</th>
                                <th scope="col" style="text-align: center">Tổng tiền</th>
                                <th scope="col" style="text-align: center">Ngày đặt</th>
                                <th scope="col" style="text-align: center">Xem chi tiết</th>
                            </tr>
                        </thead>
                        <c:forEach items="${listOrder}" var="item">
                            <tbody>
                            <td style="text-align: center">${item.orderName}</td>
                            <td style="text-align: center">${item.mail}</td>
                            <td style="text-align: center">${item.totalPrice}VNĐ</td>
                            <td style="text-align: center">${item.orderDate}</td>
                            <td style="text-align: center"><a href="${pageContext.request.contextPath}/detailOrder/${item.orderId}.htm">View</a></td>
                            </tbody>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <div style="height: 50px;"></div>
        </div>


        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
