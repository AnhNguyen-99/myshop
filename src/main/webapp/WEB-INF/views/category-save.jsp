<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Form Category</title>
</head>
<body>
	<a href="<c:url value="/list-category" />" >List Category</a><br />

	<h1>Add new Customer:</h1>
	<%-- <c:url value="/saveCategory" var="saveCategoey"/> --%>
	<form:form action="${pageContext.request.contextPath}/saveCategory" method="POST" modelAttribute="category">
    	Id: <form:input path="categoryId" type="hidden"/> <br/> <br/>
    	Name: <form:input path="categoryName" /> <br/> <br/>
    	<button type="submit">Save</button>
	</form:form>

</body>
</html>