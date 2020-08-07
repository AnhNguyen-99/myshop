$(document).ready(function () {
	$.ajax({
		url: "http://localhost:8080/MyShop/api/product",
		type: "GET",
		success: function (result) {
			console.log(result);
			result.forEach((item) =>{
				$('#listProduct').append(`<div class="col-lg-3 mb-4 text-center">
				<div class="product-entry border">
					<a href="#" class="prod-img">
						<img src="./resources/page/images/product/${item.productImage}" class="img-fluid" alt="Free html5 bootstrap 4 template">
					</a>
					<div class="desc">
						<h2><a href="./product-detail/${item.productId}">${item.producerName}</a></h2>
						<span class="price">$${item.productPrice}</span>
					</div>
				</div>
			</div>`);
			});
		}});
});