<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Favicon-->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/page/img/fav.png">
        <!-- Author Meta -->
        <meta name="author" content="CodePixar">
        <!-- Meta Description -->
        <meta name="description" content="">
        <!-- Meta Keyword -->
        <meta name="keywords" content="">
        <!-- meta character set -->
        <meta charset="UTF-8">
        <title>header</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/page/css/linearicons.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/page/css/font-awesome.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/page/css/themify-icons.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/page/css/bootstrap.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/page/css/owl.carousel.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/page/css/nice-select.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/page/css/nouislider.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/page/css/ion.rangeSlider.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/page/css/ion.rangeSlider.skinFlat.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/page/css/magnific-popup.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/page/css/main.css">
    </head>
    <body>

        <header class="header_area sticky-header">
            <div class="main_menu">
                <nav class="navbar navbar-expand-lg navbar-light main_box">
                    <div class="container">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <a class="navbar-brand logo_h" href="${pageContext.request.contextPath}/home.htm"><img src="${pageContext.request.contextPath}/resources/page/img/logo.png" alt=""></a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
                            <ul class="nav navbar-nav menu_nav ml-auto">
                                <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/home.htm">Trang chủ</a></li>
                                <li class="nav-item submenu dropdown">
                                    <a href="${pageContext.request.contextPath}/shop.htm" class="nav-link dropdown-toggle"  role="button" aria-haspopup="true">Shop</a>
                                </li>
                                <li class="nav-item submenu dropdown">
                                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                                       aria-expanded="false">
                                        <span class="ti-user"> ${sessionScope.myLogin.accountName}</span>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/${sessionScope.thuoctinh1}.htm">${sessionScope.thuoctinh1}</a></li>
                                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/${sessionScope.thuoctinh2}.htm">${sessionScope.thuoctinh2}</a></li>
                                    </ul> 
                                </li>
                                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/contact.htm">Liên hệ</a></li>
                                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/blog.htm">Blog</a></li>
                            </ul>
                            <ul class="nav navbar-nav navbar-right">
                                <li class="nav-item"><a href="${pageContext.request.contextPath}/cart/viewcart.htm" class="cart"><span class="ti-bag"><sup style="background:red;border-radious:20px;"><c:out value="${sessionScope.myCartNum}"/></sup></span></a></li>
                                <li class="nav-item">
                                    <button class="search"><span class="lnr lnr-magnifier" id="search"></span></button>
                                </li>
                            </ul> 
                        </div> 
                    </div>
                </nav>
            </div>
            <!-- Tìm kiếm -->
            <div class="search_input" id="search_input_box">
                <div class="container">
                    <form class="d-flex justify-content-between" action="${pageContext.request.contextPath}/search.htm" method="GET">
                        <input type="text" class="form-control" id="search_input" name="query" placeholder="Search Here">
                        <button type="submit" class="btn"></button>
                        <span class="lnr lnr-cross" id="close_search" title="Close Search"></span>
                    </form>
                </div>
            </div> 
            <!-- -->
        </header>
    </body>
</html>
