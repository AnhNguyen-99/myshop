<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blog</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/page/img/fav.png">
</head>

<body>

    <jsp:include page="header.jsp"></jsp:include>

    <!-- Start Banner Area -->
    <section class="banner-area organic-breadcrumb">
        <div class="container">
            <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                <div class="col-first">
                    <h1>Shopping Cart</h1>
                    <nav class="d-flex align-items-center">
                        <a href="${pageContext.request.contextPath}/home.htm">Home<span class="lnr lnr-arrow-right"></span></a>
                        <a href="category.html">Blog</a>
                    </nav>
                </div>
            </div>
        </div>
    </section>
    <!-- End Banner Area -->

    <!--================Blog Area =================-->
    <div class="blog_categorie_area">
    </div>
    <section class="blog_area">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="blog_left_sidebar">
                        <article class="row blog_item">
                            <c:forEach items="${listNews}" var="item">
                            <div class="col-md-3">
                                <div class="blog_info text-right">
                                    <ul class="blog_meta list">
                                        <li><a href="#">Nguyễn Lê Anh<i class="lnr lnr-user"></i></a></li>
                                        <li><a href="#">${item.createDate}<i class="lnr lnr-calendar-full"></i></a></li>
                                        <li><a href="#">1.2M Views<i class="lnr lnr-eye"></i></a></li>
                                        <li><a href="#">06 Comments<i class="lnr lnr-bubble"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-9">
                                <div class="blog_post">
                                    <img src="${pageContext.request.contextPath}/resources/page/img/news/${item.img}" alt="" height="273px" width="540px">
                                    <div class="blog_details">
                                        <a href="${pageContext.request.contextPath}/detailBlog/${item.newsId}.htm">
                                            <h2>${item.title}</h2>
                                        </a>

                                        <a href="${pageContext.request.contextPath}/detailBlog/${item.newsId}.htm" class="white_bg_btn">View More</a>
                                    </div>
                                </div>
                            </div>
                            </c:forEach>
                    </div>
                </div> 
            </div>
        </div>
    </section>
    <!--================Blog Area =================-->

    <!-- start footer Area -->
    <jsp:include page="footer.jsp"></jsp:include>
</body>

</html>