<%@ page language="java" contentType="text/html;charset=Windows-31J"
	pageEncoding="Windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>新規一覧</title></head>
<body>
<h1>新規一覧</h1>
<table border="1">
	<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>イメール</th><th>パスワード</th><th>携帯電話</th><th>郵便番号</th><th>住所</th><th>性別</th><th>誕生日</th><th><a href="jumpedituser">編集</a></th></tr>
	<c:forEach var="l" items="${data}">
		<tr><td>${l.id}</td><td>${l.firstName}</td><td>${l.lastName}</td><td>${l.email}</td><td>${l.pass}</td><td>${l.tel}</td><td>${l.postcode}</td><td>${l.address}</td><td>${l.sex}</td><td>${l.birthday}</td>
		</tr>
	</c:forEach>
	<form class="form-horizontal" action="create" method="post"><a href="logout">戻る</a></form>
						
</table>
</body>
</html>




