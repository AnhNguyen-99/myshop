<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mytag" uri="/WEB-INF/taglibs/newtag_library.tld" %>
<html lang="zxx" class="no-js">
    <head>
        <title>Karma Shop</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/page/img/fav.png">
    </head>

    <body id="category">

        <!-- Start Header Area -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- End Header Area -->

            <!-- Start Banner Area -->
            <section class="banner-area organic-breadcrumb">
                <div class="container">
                    <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                        <div class="col-first">
                            <h1>Shop Category page</h1>
                            <nav class="d-flex align-items-center">
                                <a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
                                <a href="#">Shop<span class="lnr lnr-arrow-right"></span></a>
                                <a href="category.html">Fashon Category</a>
                            </nav>
                        </div>
                    </div>
                </div>
            </section>
            <!-- End Banner Area -->
            <div class="container">
                <div class="row">
                    <div class="col-xl-3 col-lg-4 col-md-5">
                        <!-- Category -->
                        <div class="sidebar-categories">
                            <div class="head">Danh mục</div>
                            <ul class="main-categories">
                                <c:forEach items="${listCategory}" var="item">
                                    <li class="main-nav-list"><a href="${pageContext.request.contextPath}/findByCategoryId/${item.categoryId}" aria-expanded="false" >
                                            <span class="lnr lnr-arrow-right"></span>${item.categoryName}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <!-- Nhà sản xuất -->
                        <div class="sidebar-categories">
                            <div class="head">Nhà sản xuất</div>
                            <ul class="main-categories">
                                <c:forEach items="${listProducer}" var="item">
                                    <li class="main-nav-list"><a href="${pageContext.request.contextPath}/producer/${item.producerId}" aria-expanded="false" >
                                            <span class="lnr lnr-arrow-right"></span>${item.producerName}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="col-xl-9 col-lg-8 col-md-7">
                        <!-- Start Filter Bar -->
                        <div class="filter-bar d-flex flex-wrap align-items-center">
                            <mytag:PaginationTagHander count = "${count}" steps="${maxResult}" offset="${offset}" uri="${pageContext.request.contextPath}/shop" next="&raquo;" previous="&laquo;"/>
                        </div>
                        <section class="lattest-product-area pb-40 category-list">
                            <div class="row">
                                <!-- single product -->
                                <c:forEach items="${listProduct}" var="item">
                                    <div class="col-lg-4 col-md-6">
                                        <div class="single-product">
                                            <img src="${pageContext.request.contextPath}/resources/page/img/product/${item.productImage}" width="255px" height="255px" alt="">
                                            <div class="product-details">
                                                <a href="${pageContext.request.contextPath}/detailProduct/${item.productId}.htm"><h6>${item.productName}</h6></a>
                                                <div class="price">
                                                    <h6>${item.productPrice}</h6>
                                                <!--    <h6>${item.productSale}%</h6> -->
                                                    <h6>${(item.productPrice-(item.productPrice *(item.productSale/100)))}</h6>
                                                </div>
                                                <div class="prd-bottom">

                                                    <a href="${pageContext.request.contextPath}/initAdd/${item.productId}.htm" class="social-info">
                                                        <span class="ti-bag"></span>
                                                        <p class="hover-text">add to bag</p>
                                                    </a>
                                                    <a href="" class="social-info">
                                                        <span class="lnr lnr-heart"></span>
                                                        <p class="hover-text">Wishlist</p>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </section>
                        <!-- End Best Seller -->
                        <!-- Start Filter Bar -->
                        <div class="filter-bar d-flex flex-wrap align-items-center">
                            <mytag:PaginationTagHander count = "${count}" steps="${maxResult}" offset="${offset}" uri="${pageContext.request.contextPath}/shop.htm" next="&raquo;" previous="&laquo;"/>
                        </div>
                    </div>
            </div>
            <div>
                <br>
            </div>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>

    </body>

</html>