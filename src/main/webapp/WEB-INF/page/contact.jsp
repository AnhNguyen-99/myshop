<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
					<div class="col-md-6">
						<div class="contact-wrap">
							<h3>FeedBack</h3>
							<form:form action="${pageContext.request.contextPath}/save_feedback" modelAttribute="feedBack" method="POST">
								<div class="row">
									<form:input path="feedbackId" type="hidden"/>
									<div class="col-sm-12">
										<div class="form-group">
											<label>Name</label>
											<form:input type="text" class="form-control" placeholder="Fullname" path="username"/>
										</div>
									</div>
									
									<div class="w-100"></div>
									
									<div class="col-sm-12">
										<div class="form-group">
											<label for="email">Email</label> 
											<form:input class="form-control" placeholder="Your email address" path="email"/>
										</div>
									</div>
									
									<div class="w-100"></div>
									
									<div class="col-sm-12">
										<div class="form-group">
											<label for="subject">Phone</label>
											<form:input class="form-control" placeholder="Your phonenumber" path="mobile" />
										</div>
									</div>
									
									<div class="w-100"></div>
									
									<div class="col-sm-12">
										<div class="form-group">
											<label for="subject">Adderss</label>
											<form:input class="form-control" placeholder="Your Address" path="address" />
										</div>
									</div>
									
									<div class="w-100"></div>
									
									<div class="col-sm-12">
										<div class="form-group">
											<label for="message">Content</label>
											<form:textarea name="message" path="content" cols="30" rows="10" class="form-control" placeholder="Content"/>
										</div>
									</div>
									<div class="w-100"></div>
									<div class="col-sm-12">
										<div class="form-group">
											<input type="submit" value="Send FeedBack" class="btn btn-primary">
										</div>
									</div>
								</div>
							</form:form>
							
						</div>
					</div>
					<div class="col-md-6">
						<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3723.533015535477!2d105.79900461440776!3d21.051363292383446!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ab23c03cd9db%3A0x74afa04dd6e787e5!2sApartment%20Ecolife%20Tay%20Ho!5e0!3m2!1sen!2s!4v1595168832428!5m2!1sen!2s" width="600" height="800"  style="border:0;"  aria-hidden="false" tabindex="0"></iframe>
					</div>
				</div>
			</div>
		</div>

		<jsp:include page="footer.jsp"></jsp:include>
		
</body>
</html>

