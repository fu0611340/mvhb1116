<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hibernate Show Employees</title>
</head>
<body>
<table border="1" style="width: 50%">
	<tr>
		<th>Employees No.</th>
		<th>First Name</th>
		<th>Extension</th>
		<th>Email</th>
	</tr>
	<c:forEach var="em" items="${emps}">
	<tr>
		<td>${em.employeeNumber}</td>
		<td>${em.firstName}</td>
		<td>${em.extension}</td>
		<td>${em.email}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>