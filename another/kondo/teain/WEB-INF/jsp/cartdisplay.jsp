<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
	
	<head><title>�J�[�g�\�����</title></head>
	
	<body>
		
		<h1>�J�[�g�\�����</h1>
		
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
		
		<form method="post" action="purchaseprocedure">
			<table border="1">
				<tr><th>ID</th><th>�摜</th><th>���i��</th><th>����</th><th>���i</th></tr>
				<c:forEach var="product" items="${sessionScope.cb.products}">
					<tr>
						<td>${product.pid}</td>
						<td><a href="productdetaildisplay?pid=${product.pid}"><img src="<c:url value='${product.path}' />" alt="${product.name}" width="180px" height="150px"></a></td>
						<td>${product.name}</td>
						<td>
							<input type="text" name="num" value="${product.num}">
						</td>
						<td>${product.price}</td>
						<td><a href="cartdelete?pid=${product.pid}">�폜</a></td>
					</tr>
				</c:forEach>
			</table>
		<input type="submit" value="�w���葱����">
		</form>
		
		<p><a href="cartalldelete">�J�[�g�S�폜�@�\�A�J�[�g�\����ʂ�</a></p>
		
		<p>--------------------------------------------------------------------------</p>
		
	</body>
	
</html>