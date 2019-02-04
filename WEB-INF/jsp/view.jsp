<%@ page language="java" contentType="text/html;charset=Windows-31J"
	pageEncoding="Windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>V‹Kˆê——</title></head>
<body>
<h1>V‹Kˆê——</h1>
<table border="1">
	<tr><th>¤•i–¼</th><th>‰¿Ši</th></tr>
	<c:forEach var="l" items="${result}">
		<tr><td>${l.id}</td><td>${l.firstName}</td><td>${l.lastName}</td><td>${l.email}</td><td>${l.pass}</td><td>${l.tel}</td><td>${l.postcode}</td><td>${l.address}</td><td>${l.sex}</td><td>${l.birthday}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>




