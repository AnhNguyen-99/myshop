<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Karma Shop</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/page/img/fav.png">
    </head>
    <body id="category">

        <jsp:include page="header.jsp"></jsp:include>

            <section class="banner-area organic-breadcrumb">
                <div class="container">
                    <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                        <div class="col-first">
                            <h1>Shop Category page</h1>
                            <nav class="d-flex align-items-center">
                                <a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
                                <a href="#">Shop<span class="lnr lnr-arrow-right"></span></a>
                                <a href="category.html">Fashon Category</a>
                                <h3 style="color: red">${status}</h3>
                            </nav>
                        </div>
                    </div>
                </div>
            </section>
                    
            <div class="container">
                <div class="row">
                    <div class="col-xl-12 col-lg-8 col-md-7">
                    <!-- Start Filter Bar -->
                    
                    <!-- End Filter Bar -->
                    <!-- Start Best Seller -->
                    <section class="lattest-product-area pb-40 category-list">
                        <div class="row"> 
                            
                            <!-- single product -->
                            <c:forEach items="${listProduct}" var="item">
                                <div class="col-lg-3 col-md-6">
                                    <div class="single-product">
                                        <img src="${pageContext.request.contextPath}/resources/page/img/product/${item.productImage}" width="255px" height="255px" alt="">
                                        <div class="product-details">
                                            <a href="${pageContext.request.contextPath}/detailProduct/${item.productId}">
                                            	<h6>${item.productName}</h6></a>
                                            <div class="price">
                                                <h6>${item.productPrice}</h6>
                                            <!--    <h6>${item.productSale}%</h6> -->
                                                <h6>${(item.productPrice-(item.productPrice *(item.productSale/100)))}</h6>
                                            </div>
                                            <div class="prd-bottom">

                                                <a href="${pageContext.request.contextPath}/initAdd/${item.productId}" class="social-info">
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

                </div>
            </div>
            
        </div>
                    
        <jsp:include page="footer.jsp"></jsp:include>
        
    </body>
</html>
