<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Form Producer</title>
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/page/img/fav.png">
</head>
<body>

	<div class="page-container">

		<div class="left-content">

			<div class="mother-grid-inner">

				<jsp:include page="header.jsp"></jsp:include>

				<div class="inner-block">
					<div class="inbox">
						<h2>Nhà sản xuất</h2>
						<div class="col-md-12 compose-right">
							<div class="inbox-details-default">
								<div class="inbox-details-heading">${status}</div>
								<div class="inbox-details-body">
									<form:form method="POST" modelAttribute="producer"
										class="com-mail"
										action="${pageContext.request.contextPath}/manages/producer/save">
										<br />

										<form:input type="hidden" path="producerId" readonly="true" />
										<label>Tên nhà sản xuất</label>
										<form:input path="producerName" required="true" />
										<input type="submit" value="Save">
									</form:form>
								</div>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<jsp:include page="footer.jsp"></jsp:include>
			</div>
		</div>
		<jsp:include page="navigation.jsp"></jsp:include>
	</div>
	
</body>
</html>
