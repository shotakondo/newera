<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
	

<!-- toppage.jsp -->


	<head>
		<title>�g�b�v�y�[�W���</title>
	</head>
	
	<body>
		
		<h1>�g�b�v�y�[�W���</h1>
		
		<c:if test="${sessionScope.ub == null}">
			<p><a href="loginjump">���O�C��/�V�K����o�^</a></p>
		</c:if>
		
		<c:if test="${sessionScope.ub != null}">
			���O�C�����
			<p><a href="mypagejump">�}�C�y�[�W</a></p>
			<p><a href="logout">���O�A�E�g</a></p>
		</c:if>
		
		<p><a href="toppagejump">�g�b�v�y�[�W��ʂɖ߂�</a></p>
		
		<form method="post" action="productssearch">
			���i��:<input type="text" name="productword">
			<input type="submit" value="����">
		</form>
		
		<p><a href="cartdisplay">�J�[�g</a></p>
		
		<select name="sortparameter" form="productssort">
			<option value="name">���O��</option>
			<option value="cheap">������</option>
			<option value="expensive">������</option>
		</select><br>
		
		<form method="post" action="productssort" id="productssort">
			<input type="submit" value="�\�[�g">
		</form>
		
		<p>--------------------------------------------------------------------------</p>
		
		<table border="1">
			<tr><th>ID</th><th>�摜</th><th>���i��</th><th>���i</th></tr>
			<c:forEach var="product" items="${sessionScope.productlist}">
				<tr><td>${product.pid}</td><td><a href="productdetaildisplay?pid=${product.pid}"><img src="<c:url value='${product.path}' />" alt="${product.name}" width="180px" height="150px"></a></td><td>${product.name}</td><td>${product.price}</td></tr>
			</c:forEach>
		</table>
		
		<p>--------------------------------------------------------------------------</p>
		
	</body>
	
</html>