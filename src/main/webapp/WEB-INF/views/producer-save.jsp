<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Form Producer</title>
</head>
<body>
	<a href="<c:url value="/list-producer" />" >List Producer</a><br />

	<h1>Add new Producer:</h1>
	<%-- <c:url value="/saveCustomer" var="saveCustomer"/> --%>
	<form:form action="${save}" method="POST"
		modelAttribute="producer">
    	Name: <form:input path="producerName"/> <br/>
    	<button type="submit">Submit</button>
	</form:form>

</body>
</html>