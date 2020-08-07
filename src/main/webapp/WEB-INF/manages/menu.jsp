<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Menu</title>
	
	<link href="${pageContext.request.contextPath}/resources/manages/css/bootstrap.min.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/resources/manages/css/metisMenu.min.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/resources/manages/css/timeline.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/resources/manages/css/startmin.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/resources/manages/css/morris.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/resources/manages/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <link href="${pageContext.request.contextPath}/resources/manages/css/dataTables/dataTables.bootstrap.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/resources/manages/css/dataTables/dataTables.responsive.css" rel="stylesheet">

</head>
<body>

    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/manages/home">Admin</a>
        </div>

       <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>

        <ul class="nav navbar-nav navbar-left navbar-top-links">
            <li><a href="${pageContext.request.contextPath}/home"><i class="fa fa-home fa-fw"></i> Website</a></li>
        </ul>

        <ul class="nav navbar-right navbar-top-links">

            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i>${sessionScope.myLogin.accountName}<b class="caret"></b>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                    </li>
                    <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="${pageContext.request.contextPath}/logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                    </li>
                </ul>
            </li>
        </ul>

	<!-- Menu các chức năng -->
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="sidebar-search">
                        <div class="input-group custom-search-form">
                            <input type="text" class="form-control" placeholder="Search...">
                            <span class="input-group-btn">
                                <button class="btn btn-primary" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
	                        </span>
                        </div>
                    </li>
                    
                    <!-- Trang chủ -->
                    <li>
                        <a href="${pageContext.request.contextPath}/manages/home" class="active"><i class="fa fa-dashboard fa-fw"></i> Trang chủ</a>
                    </li>
                    
                    <!-- Danh mục -->
                    <li>
                        <a href="#"><i class="fa fa-bar-chart-o"></i> Danh mục<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="${pageContext.request.contextPath}/manages/category/list">Danh sách</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/manages/category/create">Tạo mới danh mục</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/manages/category/add">Tạo mới danh mục api</a>
                            </li>
                        </ul>
                    </li>
                    
                    <!-- NSX -->
                    <li>
	                    <a href="#"><i class="fa fa-bank fa-fw"></i> NSX<span class="fa arrow"></span></a>
	                    <ul class="nav nav-second-level">
	                        <li>
	                            <a href="${pageContext.request.contextPath}/manages/producer/list">Danh sách</a>
	                        </li>
	                        <li>
	                            <a href="${pageContext.request.contextPath}/manages/producer/create">Tạo NSX mới</a>
	                        </li>
	                    </ul>
	                </li>
                    
                    <!-- Sản phẩm -->
                    <li>
	                    <a href="#"><i class="fa fa-mobile fa-fw"></i> Sản phẩm<span class="fa arrow"></span></a>
	                    <ul class="nav nav-second-level">
	                        <li>
	                            <a href="${pageContext.request.contextPath}/manages/product/list">Danh sách sản phẩm</a>
	                        </li>
	                        <li>
	                            <a href="${pageContext.request.contextPath}/manages/product/create">Thêm sản phẩm mới</a>
	                        </li>
	                        <!-- <li>
	                            <a href="form_import_product.php">Nhập số lượng bằng excel</a>
	                        </li>
	                        <li>
	                            <a href="form_product_file.php">Nhập sản phẩm bằng Excel</a>
	                        </li> -->
	                    </ul>
	                </li>
	                
	                <!-- Màu -->
	                <li>
	                    <a href="#"><i class="fa fa-joomla fa-fw"></i> Color<span class="fa arrow"></span></a>
	                    <ul class="nav nav-second-level">
	                        <li>
	                            <a href="${pageContext.request.contextPath}/manages/color/list">Danh sách</a>
	                        </li>
	                        <li>
	                            <a href="${pageContext.request.contextPath}/manages/color/create">Tạo màu mới</a>
	                        </li>
	                    </ul>
	                </li>
	                
	                <!-- Size -->
	                <li>
	                    <a href="#"><i class="fa fa-joomla fa-fw"></i> Size<span class="fa arrow"></span></a>
	                    <ul class="nav nav-second-level">
	                        <li>
	                            <a href="${pageContext.request.contextPath}/manages/size/list">Danh sách</a>
	                        </li>
	                        <li>
	                            <a href="${pageContext.request.contextPath}/manages/size/create">Tạo size mới</a>
	                        </li>
	                    </ul>
	                </li>
	                
	                <!-- Đơn hàng -->
	                
	                <li>
	                    <a href="${pageContext.request.contextPath}/manages/order/list"><i class="fa fa-cart-plus fa-fw"></i> Đơn hàng</a>
	                </li>
	
	                <!-- Tin tức -->
	                <li>
	                    <a href="#"><i class="fa fa-edit fa-fw"></i> Tin tức<span class="fa arrow"></span></a>
	                    <ul class="nav nav-second-level">
	                        <li>
	                            <a href="list_news.php">Danh sách</a>
	                        </li>
	                        <li>
	                            <a href="form_news.php">Tạo tin tức mới</a>
	                        </li>
	                    </ul>
	                </li>
	
	                <!-- Danh sách tài khoản khách hàng -->
	                <li>
	                    <a href="#"><i class="fa fa-users fa-fw"></i> Người dùng<span class="fa arrow"></span></a>
	                    <ul class="nav nav-second-level">
	                        <li>
	                            <a href="${pageContext.request.contextPath}/manages/account/list_manages">Danh sách người quản trị</a>
	                        </li>
	                        <li>
	                            <a href="${pageContext.request.contextPath}/manages/account/list_customer">Danh sách người dùng</a>
	                        </li>
	                        <li>
	                            <a href="${pageContext.request.contextPath}/manages/account/create_manages">Tạo tài khoản quản trị</a>
	                        </li>
	                        <li>
	                            <a href="${pageContext.request.contextPath}/manages/account/reset_account">Reset mật khẩu tài khoản</a>
	                        </li>
	                    </ul>
	                </li>
	                
	                <!-- Phản hồi -->
	                <li>
	                    <a href="${pageContext.request.contextPath}/manages/feedback/list"><i class="fa fa-users fa-fw"></i> Phản hồi</a>
	                </li>
		                
                </ul>
                
            </div>
            
        </div>
        
    </nav>
    
</body>
</html>