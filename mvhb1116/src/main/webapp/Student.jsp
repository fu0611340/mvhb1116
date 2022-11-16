<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hibernate Show Students</title>
</head>
<body>
<table border="1" style="width: 50%">
	<tr>
		<th>Student ID</th>
		<th>Name</th>
		<th>Age</th>
	</tr>
	<c:forEach var="st" items="${sts}">
	<tr>
		<td><c:out value="${st.sid}"></c:out></td>
		<td><c:out value="${st.sname}"></c:out></td>
		<td><c:out value="${st.age}"></c:out></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>