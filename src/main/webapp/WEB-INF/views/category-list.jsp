<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>List Category</title>
<style>
table, th, td {
	border: 1px solid black;
}

td {
	padding-right: 30px;
}
</style>
</head>
<body>
	<h1>List Category:</h1>
	<br />
	<br />

	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Date</th>
		</tr>
		<c:forEach var="category" items="${listCategory}">
			<tr style="border: 1px black solid">
				<td>${category.categoryId}</td>
				<td>${category.categoryName}</td>
				<td>${category.createDate}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="<c:url value="/save-category" />" >Add Category</a><br />
</body>
</html>