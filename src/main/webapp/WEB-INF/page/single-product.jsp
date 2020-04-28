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
                            <h1>Product Details Page</h1>
                            <nav class="d-flex align-items-center">
                                <a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
                                <a href="#">Shop<span class="lnr lnr-arrow-right"></span></a>
                                <a href="single-product.html">product-details</a>
                            </nav>
                        </div>
                    </div>
                </div>
            </section>
            <!-- End Banner Area -->

            <!--================Single Product Area =================-->
            <div class="product_image_area">
                <div class="container">
                    <div class="row s_product_inner">
                        <div class="col-lg-6">
                            <div class="s_Product_carousel">
                                <div class="single-prd-item">
                                    <img class="img-fluid" src="${pageContext.request.contextPath}/resources/page/img/product/${product.productImage}" alt="">
                            </div>
                            <div class="single-prd-item">
                                <img class="img-fluid" src="${pageContext.request.contextPath}/resources/page/img/product/${product.productImage2}" alt="">
                            </div>
                            <div class="single-prd-item">
                                <img class="img-fluid" src="${pageContext.request.contextPath}/resources/page/img/product/${product.productImage3}" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-5 offset-lg-1">
                        <div class="s_product_text">
                            <h3>${product.productName}</h3>
                            <h2>${product.productPrice}VNĐ</h2>
                            <ul class="list">
                                <li><span>Nhà sản xuất</span> : ADIDAS</li>
                                <%-- <li><span>Loại</span> : ${product.categoryId.categoryName}</li> --%>
                            </ul>
                            <p>${product.shortdescription}</p>

                            <div class="card_area d-flex align-items-center">
                                <a class="primary-btn" href="${pageContext.request.contextPath}/cart/add/${product.productId}">Thêm vào giỏ</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--================End Single Product Area =================-->

        <!--================Product Description Area =================-->
        <section class="product_description_area">
            <div class="container">
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Nội dung</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile"
                           aria-selected="false">Thông số</a>
                    </li>
                </ul>
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <p>${product.description}</p>
                    </div>
                    <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                        <div class="table-responsive">
                            <table class="table">
                                <tbody>
                                    <tr>
                                        <td>
                                            <h5>Rộng</h5>
                                        </td>
                                        <td>
                                            <h5>128mm</h5>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <h5>Chiều cao</h5>
                                        </td>
                                        <td>
                                            <h5>508mm</h5>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <h5>Chiều sâu</h5>
                                        </td>
                                        <td>
                                            <h5>85mm</h5>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <h5>Cân nặng</h5>
                                        </td>
                                        <td>
                                            <h5>52gm</h5>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <h5>Kiểm tra chất lượng</h5>
                                        </td>
                                        <td>
                                            <h5>Đúng</h5>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <h5>Thời gian</h5>
                                        </td>
                                        <td>
                                            <h5>03days</h5>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <h5>When packeting</h5>
                                        </td>
                                        <td>
                                            <h5>Without touch of hand</h5>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <h5>Mỗi hộp chứa</h5>
                                        </td>
                                        <td>
                                            <h5>60 chiếc</h5>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="comment_list">
                                    <div class="review_item">
                                        <div class="media">
                                            <div class="d-flex">
                                                <img src="img/product/review-1.png" alt="">
                                            </div>
                                            <div class="media-body">
                                                <h4>Blake Ruiz</h4>
                                                <h5>12th Feb, 2018 at 05:56 pm</h5>
                                                <a class="reply_btn" href="#">Reply</a>
                                            </div>
                                        </div>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                                            dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
                                            commodo</p>
                                    </div>
                                    <div class="review_item reply">
                                        <div class="media">
                                            <div class="d-flex">
                                                <img src="img/product/review-2.png" alt="">
                                            </div>
                                            <div class="media-body">
                                                <h4>Blake Ruiz</h4>
                                                <h5>12th Feb, 2018 at 05:56 pm</h5>
                                                <a class="reply_btn" href="#">Reply</a>
                                            </div>
                                        </div>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                                            dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
                                            commodo</p>
                                    </div>
                                    <div class="review_item">
                                        <div class="media">
                                            <div class="d-flex">
                                                <img src="img/product/review-3.png" alt="">
                                            </div>
                                            <div class="media-body">
                                                <h4>Blake Ruiz</h4>
                                                <h5>12th Feb, 2018 at 05:56 pm</h5>
                                                <a class="reply_btn" href="#">Reply</a>
                                            </div>
                                        </div>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                                            dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
                                            commodo</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="review_box">
                                    <h4>Post a comment</h4>
                                    <form class="row contact_form" action="contact_process.php" method="post" id="contactForm" novalidate="novalidate">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <input type="text" class="form-control" id="name" name="name" placeholder="Your Full name">
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <input type="email" class="form-control" id="email" name="email" placeholder="Email Address">
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <input type="text" class="form-control" id="number" name="number" placeholder="Phone Number">
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <textarea class="form-control" name="message" id="message" rows="1" placeholder="Message"></textarea>
                                            </div>
                                        </div>
                                        <div class="col-md-12 text-right">
                                            <button type="submit" value="submit" class="btn primary-btn">Submit Now</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
            
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <jsp:include page="footer.jsp"></jsp:include>

    </body>

</html>