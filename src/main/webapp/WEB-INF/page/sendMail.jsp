<!DOCTYPE HTML>
<html>
<head>
<title>Contact</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>

	<div class="colorlib-loader"></div>

		<jsp:include page="header.jsp"></jsp:include>

		<div class="breadcrumbs">
			<div class="container">
				<div class="row">
					<div class="col">
						<p class="bread">
							<span><a href="index.html">Home</a></span> / <span>Contact</span>
						</p>
					</div>
				</div>
			</div>
		</div>

		<div id="colorlib-contact">
			<div class="container">
				<div class="row">
					<div class="col-sm-12">
						<h3>Contact Information</h3>
						<div class="row contact-info-wrap">
							<div class="col-md-3">
								<p>
									<span><i class="icon-location"></i></span> 198 West 21th
									Street, <br> Suite 721 New York NY 10016
								</p>
							</div>
							<div class="col-md-3">
								<p>
									<span><i class="icon-phone3"></i></span> <a
										href="#">0987654321</a>
								</p>
							</div>
							<div class="col-md-3">
								<p>
									<span><i class="icon-paperplane"></i></span> <a
										href="mailto:myshop.com">myshop@gmail.com</a>
								</p>
							</div>
							<div class="col-md-3">
								<p>
									<span><i class="icon-globe"></i></span> <a href="#">myshop.com</a>
								</p>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<div class="contact-wrap">
							<h3>FeedBack</h3>
							<form action="${pageContext.request.contextPath}/sendMail" method="POST">
								<div class="row">

									<div class="col-sm-12">
										<div class="form-group">
											<label>Name</label>
											<input type="text" class="form-control" placeholder="Fullname" name="name"/>
										</div>
									</div>
									
									<div class="w-100"></div>
									
									<div class="col-sm-12">
										<div class="form-group">
											<label for="email">Email</label> 
											<input class="form-control" placeholder="Your email address" name="email"/>
										</div>
									</div>
									
									<div class="w-100"></div>
									
									<div class="col-sm-12">
										<div class="form-group">
											<label for="subject">Subject</label>
											<input class="form-control" placeholder="Subject" name="subject" />
										</div>
									</div>
									
									<div class="w-100"></div>
									
									<div class="col-sm-12">
										<div class="form-group">
											<label>Content</label>
											<textarea class="form-control" name="content" rows="5" cols="50" placeholder="Content"></textarea>
										</div>
									</div>
									
									<div class="col-sm-12">
										<div class="form-group">
											<input type="submit" value="Send FeedBack" class="btn btn-primary">
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<jsp:include page="footer.jsp"></jsp:include>
		
</body>
</html>

