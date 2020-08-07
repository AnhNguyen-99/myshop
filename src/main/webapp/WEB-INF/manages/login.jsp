<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>Login</title>

	<link href="./resources/manages/css/bootstrap.min.css" rel="stylesheet">

	<link href="./resources/manages/css/metisMenu.min.css" rel="stylesheet">

	<link href="./resources/manages/css/startmin.css" rel="stylesheet">

	<link href="./resources/manages/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please Sign In</h3>
					</div>
					<div class="panel-body">
						<form:form method="POST" action="${pageContext.request.contextPath}/login" modelAttribute="account">
								<div class="form-group">
									<form:input type="text" class="form-control" path="accountName" placeholder="Username"/>
								</div>
								<div class="form-group">
									<form:password class="form-control" placeholder="Password" path="accountPass" name="password"/>
								</div>
								<div class="checkbox">
									<label> <input name="remember" type="checkbox"	value="Remember Me">Remember Me</label>
								</div>
								<input type="submit" value="Login" class="btn btn-lg btn-success btn-block"/>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="./resources/manages/js/jquery.min.js"></script>

	<script src="./resources/manages/js/bootstrap.min.js"></script>

	<script src="./resources/manages/js/metisMenu.min.js"></script>

	<script src="./resources/manages/js/startmin.js"></script>

</body>
</html>
