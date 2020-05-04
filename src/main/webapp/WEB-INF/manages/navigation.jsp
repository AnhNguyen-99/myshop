<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>navigation</title>
</head>
<body>

	<div class="sidebar-menu">
		<div class="logo">
			<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span>
			</a> <a href="#"> <span id="logo"></span> <!--<img id="logo" src="" alt="Logo"/>-->
			</a>
		</div>
		<div class="menu">
			<ul id="menu">
				<!--<li><a href="${pageContext.request.contextPath}/manages/home.htm"><i class="fa fa-home"></i><span>Trang chủ</span></a></li>-->
				<li><a href="${pageContext.request.contextPath}/manages/category/list"><i class="fa fa-tags"></i><span>Danh mục</span></a></li>
				<li><a href="${pageContext.request.contextPath}/manages/producer/list"><i class="fa fa-bank"></i><span>Nhà sản xuất</span></a></li>
				<li><a href="${pageContext.request.contextPath}/manages/product/list"><i class="fa fa-bars"></i><span>Sản phẩm</span></a></li>
				<li><a href="${pageContext.request.contextPath}/manages/order/list"><i class="fa fa-cart-plus"></i><span>Đơn hàng</span></a></li>
				<li><a href="${pageContext.request.contextPath}/manages/news/list"><i class="fa fa-book"></i><span>Tin tức</span></a></li>
				<li><a href="${pageContext.request.contextPath}/manages/account/list"><i class="fa fa-user"></i><span>Tài khoản</span></a></li>
			</ul>
		</div>
	</div>
	<div class="clearfix"></div>

	<!--slide bar menu end here-->
	<script>
          var toggle = true;

          $(".sidebar-icon").click(function () {
              if (toggle)
              {
                  $(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
                  $("#menu span").css({"position": "absolute"});
              } else
              {
                  $(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
                  setTimeout(function () {
                      $("#menu span").css({"position": "relative"});
                  }, 400);
              }
              toggle = !toggle;
          });
      </script>

</body>
</html>
