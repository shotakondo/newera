<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
	
	<head><title>��������\�����</title></head>
	
	<body>
	
		<h1>��������\�����</h1>
		
		<c:if test="${sessionScope.ub == null}">
			�񃍃O�C�����
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
			<tr><th>������</th><th>�I�[�_�[ID</th><th>�������e</th><th>�������z���v</th><th>�x�����@</th></tr>
			<c:forEach var="orders" items="${data}">
				<tr>
					<td>${orders.date}</td>
					<td>${orders.oid}</td>
					<td>
						<c:forEach var="products" items="${orders.products}">
							���iID:${products.pid}
							<img src="<c:url value='${products.path}' />" alt="${products.name}" width="180px" height="150px">
							���i��:${products.name}
							���i:${products.price}
							��:${products.num}<br/>
						</c:forEach>
					</td>
					<td>${orders.total}</td>
					<td>${orders.method}</td>
				</tr>
			</c:forEach>
		</table>
		
		<p>--------------------------------------------------------------------------</p>
		
	</body>
	
</html>