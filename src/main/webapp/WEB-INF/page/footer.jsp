<footer id="colorlib-footer" role="contentinfo">
	<div class="container">
		<div class="row row-pb-md">
			<div class="col footer-col colorlib-widget">
				<h4>About Footwear</h4>
				<p>Even the all-powerful Pointing has no control about the blind
					texts it is an almost unorthographic life</p>
				<ul class="colorlib-social-icons">
					<li><a href="#"><i class="icon-twitter"></i></a></li>
					<li><a href="#"><i class="icon-facebook"></i></a></li>
					<li><a href="#"><i class="icon-linkedin"></i></a></li>
					<li><a href="#"><i class="icon-dribbble"></i></a></li>
				</ul>
			</div>
			<div class="col footer-col colorlib-widget">
				<h4>Customer Care</h4>
				<!-- <p> -->
				<ul class="colorlib-footer-links">
					<li><a href="#">Contact</a></li>
					<li><a href="#">Returns/Exchange</a></li>
					<li><a href="#">Gift Voucher</a></li>
					<li><a href="#">Wishlist</a></li>
					<li><a href="#">Special</a></li>
					<li><a href="#">Customer Services</a></li>
					<li><a href="#">Site maps</a></li>
				</ul>
			</div>
			<div class="col footer-col colorlib-widget">
				<h4>Information</h4>
				<ul class="colorlib-footer-links">
					<li><a href="#">About us</a></li>
					<li><a href="#">Delivery Information</a></li>
					<li><a href="#">Privacy Policy</a></li>
					<li><a href="#">Support</a></li>
					<li><a href="#">Order Tracking</a></li>
				</ul>
			</div>

			<div class="col footer-col">
				<h4>News</h4>
				<ul class="colorlib-footer-links">
					<li><a href="blog.html">Blog</a></li>
					<li><a href="#">Press</a></li>
					<li><a href="#">Exhibitions</a></li>
				</ul>
			</div>

			<div class="col footer-col">
				<h4>Contact Information</h4>
				<ul class="colorlib-footer-links">
					<li>291 South 21th Street, <br> Suite 721 New York NY
						10016
					</li>
					<li><a href="tel://1234567920">+ 1235 2355 98</a></li>
					<li><a href="mailto:info@yoursite.com">info@yoursite.com</a></li>
					<li><a href="#">yoursite.com</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="copy">
		<div class="row">
			<div class="col-sm-12 text-center">
				<p>
					<span> Copyright &copy;<script>
						document.write(new Date().getFullYear());
					</script> All rights reserved | This template is made with <i
						class="icon-heart" aria-hidden="true"></i> by <a
						href="https://colorlib.com" target="_blank">Colorlib</a>
					</span> <span class="block">Demo Images: <a
						href="http://unsplash.co/" target="_blank">Unsplash</a> , <a
						href="http://pexels.com/" target="_blank">Pexels.com</a></span>
				</p>
			</div>
		</div>
	</div>
</footer>

<div class="gototop js-top">
	<a href="#" class="js-gotop"><i class="ion-ios-arrow-up"></i></a>
</div>

<script
	src="${pageContext.request.contextPath}/resources/page/js/jquery.min.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/page/js/popper.min.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/page/js/bootstrap.min.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/page/js/jquery.easing.1.3.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/page/js/jquery.waypoints.min.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/page/js/jquery.flexslider-min.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/page/js/owl.carousel.min.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/page/js/jquery.magnific-popup.min.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/page/js/magnific-popup-options.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/page/js/bootstrap-datepicker.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/page/js/jquery.stellar.min.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/page/js/main.js"></script>


<script>
$(document).ready(function() {
	var quantitiy = 0;
	$('.quantity-right-plus').click(function(e) {
		e.preventDefault();
		var quantity = parseInt($('#quantity').val());
		$('#quantity').val(quantity + 1);
	});

	$('.quantity-left-minus').click(function(e) {
		e.preventDefault();
		var quantity = parseInt($('#quantity').val());
		if (quantity > 0) {
			$('#quantity').val(quantity - 1);
		}
	});

});
</script>

