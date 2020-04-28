<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>header</title>
	
	<script type="application/x-javascript">
		 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
	</script>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<link href="<c:url value="/resources/manages/css/bootstrap.css"/>"	rel='stylesheet' type='text/css' />
	<!-- Custom Theme files -->
	<link href="<c:url value="/resources/manages/css/style.css"/>" rel='stylesheet' type='text/css' />
	<!--js-->
	<script	src="<c:url value="/resources/manages/js/jquery-2.1.1.min.js" />"></script>
	<!--icons-css-->
	<link href="<c:url value="/resources/manages/css/font-awesome.css"/>" rel="stylesheet" type="text/css" />
	<!--Google Fonts-->
	<link href='//fonts.googleapis.com/css?family=Carrois+Gothic' rel='stylesheet' type='text/css'>
	<link href='//fonts.googleapis.com/css?family=Work+Sans:400,500,600' rel='stylesheet' type='text/css'>
	<!--static chart-->
	<script src="<c:url value="/resources/manages/js/Chart.min.js" />"></script>
	<!--//charts-->
	<!-- geo chart -->
	<script src="<c:url value="/resources/manages/js/modernizr.min.js" />" type="text/javascript"></script>
	<script>
		window.modernizr
				|| document
						.write('<script src="lib/modernizr/modernizr-custom.js"><\/script>')
	</script>
	<script src="lib/html5shiv/html5shiv.js"></script>
	<!-- Chartinator  -->
	<script src="<c:url value="/resources/manages/js/chartinator.js" />"></script>
	<script type="text/javascript">
		jQuery(function($) {
	
			var chart3 = $('#geoChart').chartinator(
					{
						tableSel : '.geoChart',
	
						columns : [ {
							role : 'tooltip',
							type : 'string'
						} ],
	
						colIndexes : [ 2 ],
	
						rows : [ [ 'China - 2015' ], [ 'Colombia - 2015' ],
								[ 'France - 2015' ], [ 'Italy - 2015' ],
								[ 'Japan - 2015' ], [ 'Kazakhstan - 2015' ],
								[ 'Mexico - 2015' ], [ 'Poland - 2015' ],
								[ 'Russia - 2015' ], [ 'Spain - 2015' ],
								[ 'Tanzania - 2015' ], [ 'Turkey - 2015' ] ],
	
						ignoreCol : [ 2 ],
	
						chartType : 'GeoChart',
	
						chartAspectRatio : 1.5,
	
						chartZoom : 1.75,
	
						chartOffset : [ -12, 0 ],
	
						chartOptions : {
	
							width : null,
	
							backgroundColor : '#fff',
	
							datalessRegionColor : '#F5F5F5',
	
							region : 'world',
	
							resolution : 'countries',
	
							legend : 'none',
	
							colorAxis : {
	
								colors : [ '#679CCA', '#337AB7' ]
							},
							tooltip : {
	
								trigger : 'focus',
	
								isHtml : true
							}
						}
	
					});
		});
	</script>
	
	<script src="<c:url value="/resources/manages/js/skycons.js" />" type="text/javascript"></script>
	<script	src="<c:url value="/resources/manages/js/jquery.nicescroll.js" />"></script>
	<script src="<c:url value="/resources/manages/js/scripts.js" />" type="text/javascript"></script>
	<script src="<c:url value="/resources/manages/js/bootstrap.js" />"></script>

</head>
<body>

	<div class="header-main">
		<div class="header-left">
			<div class="logo-name">
				<a href="index.htm">
					<h1>Karma</h1> <!--<img id="logo" src="" alt="Logo"/>-->
				</a>
			</div>
		</div>
		<div class="header-right">
			<!--notification menu end -->
			<div class="profile_details">
				<ul>
					<li class="dropdown profile_details_drop"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"
						aria-expanded="false">
							<div class="profile_img">
								<span class="prfil-img"><img src="images/p1.png" alt="">
								</span>
								<div class="user-name">
									<p>${sessionScope.myLogin.accountName}</p>
									<span>${sessionScope.myLogin.accountMail}</span>
								</div>
								<i class="fa fa-angle-down lnr"></i> <i
									class="fa fa-angle-up lnr"></i>
								<div class="clearfix"></div>
							</div>
					</a>
						<ul class="dropdown-menu drp-mnu">
							<li><a href="#"><i class="fa fa-cog"></i> Settings</a></li>
							<li><a href="#"><i class="fa fa-user"></i> Profile</a></li>
							<li><a href="${pageContext.request.contextPath}/logout.htm"><i
									class="fa fa-sign-out"></i> Logout</a></li>
						</ul></li>
				</ul>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
	</div>
	<!--heder end here-->
	<!-- script-for sticky-nav -->
	<script>
		$(document).ready(function() {
			var navoffeset = $(".header-main").offset().top;
			$(window).scroll(function() {
				var scrollpos = $(window).scrollTop();
				if (scrollpos >= navoffeset) {
					$(".header-main").addClass("fixed");
				} else {
					$(".header-main").removeClass("fixed");
				}
			});

		});
	</script>

</body>
</html>
