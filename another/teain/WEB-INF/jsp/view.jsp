<%@ page language="java" contentType="text/html;charset=Windows-31J"
	pageEncoding="Windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>�V�K�ꗗ</title></head>
<body>
<h1>�V�K�ꗗ</h1>
<table border="1">
	<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>�C���[��</th><th>�p�X���[�h</th><th>�g�ѓd�b</th><th>�X�֔ԍ�</th><th>�Z��</th><th>����</th><th>�a����</th><th><a href="jumpedituser">�ҏW</a></th></tr>
	<c:forEach var="l" items="${data}">
		<tr><td>${l.id}</td><td>${l.firstName}</td><td>${l.lastName}</td><td>${l.email}</td><td>${l.pass}</td><td>${l.tel}</td><td>${l.postcode}</td><td>${l.address}</td><td>${l.sex}</td><td>${l.birthday}</td>
		</tr>
	</c:forEach>
	<form class="form-horizontal" action="create" method="post"><a href="logout">�߂�</a></form>
						
</table>
</body>
</html>




