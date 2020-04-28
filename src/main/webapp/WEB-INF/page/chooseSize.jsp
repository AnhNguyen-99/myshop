<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zxx" class="no-js">

    <head>
        <title>Cart</title>
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
                            <h1>Choose Size</h1>
                            <nav class="d-flex align-items-center">
                                <a href="${pageContext.request.contextPath}/home.htm">Home<span class="lnr lnr-arrow-right"></span></a>
                            <a href="category.html">Cart</a>
                        </nav>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Banner Area -->

        <!--================Cart Area =================-->
        <section class="cart_area">
            <div class="container">
                <h2>Mời bạn chọn size</h2>
                <div class="cart_inner">
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Sản phẩm</th>
                                    <th scope="col">Size</th>                        
                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <td>
                                        <div class="media">
                                            <div class="d-flex">
                                                <img src="${pageContext.request.contextPath}/resources/page/img/product/${product.productImage}" alt="" width="50px" height="50px"/> 
                                            </div> 
                                            <div class="media-body" style="width: 750px;">
                                                <p>${product.productName}</p>
                                            </div>
                                        </div>
                                    </td>
                                

                                
                                    <td>
                                        <div class="ps-widget__content">
                                            <ul class="ps-list--checked">
                                                <c:forEach items="${listProductSize}" var="item">
                                            <!--        <li class="filter-list"><a href="${pageContext.request.contextPath}/cart/add/${item.productSizeId}.htm" class="pixel-radio" type="radio"><label for="apple">${item.sizeId.sizeName}</label></a></li> -->
                                                    <li class="filter-list"><a href="${pageContext.request.contextPath}/cart/add/${item.productSizeId}.htm" class="pixel-radio" type="radio" id="apple" name="brand"></a><label for="apple">${item.sizeId.sizeName}</label></li>
                                                </c:forEach>
                                            </ul>
                                    </td>
                                    
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>
        <!--================End Cart Area =================-->

        <!-- start footer Area -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>

</html>