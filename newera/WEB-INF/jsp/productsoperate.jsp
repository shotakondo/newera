<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>

	<head><title>���i������</title></head>
	
	<body>
	
		<h1>���i������</h1>
		
		�Ǘ��҃g�b�v�y�[�W��ʂɖ߂�
		<p><a href="managertoppagejump">�@�\�Ȃ��A�Ǘ��҃g�b�v�y�[�W��ʂ�</a></p>
		
		<p><a href="logout">���O�A�E�g�@�\�A�g�b�v�y�[�W��ʂ�</a></p>
		
		<p>--------------------------------------------------------------------------</p>
		<!--
		<p>���i�i�荞�݋@�\�A���i�����ʂ�</p>
		<form method="post" action="productsnarrow">
			<input type="submit" value="�i�荞��">
		</form>
		
		���בւ�
		<p><a href="productssort">���i���בւ��@�\�A���i�����ʂ�</a></p>
		--!>
		<p>�V�������i��ǉ�����</p>
		<p><a href="productaddjump">�@�\�Ȃ��A���i�ǉ���ʂ�</a></p>
		
		���i�ڍו\���@�\�A���i�ڍו\����ʂ�
		<table border="1">
			<tr><th>ID</th><th>�摜</th><th>���i��</th><th>���i</th></tr>
			<c:forEach var="product" items="${sessionScope.productlist}">
				<tr><td>${product.pid}</td><td><a href="productalterdisplay?pid=${product.pid}"><img src="<c:url value='${product.path}' />" alt="${product.name}" width="180px" height="150px"></a></td><td>${product.name}</td><td>${product.price}</td></tr>
			</c:forEach>
		</table>
		
		<p><a href="productdelete">���i�폜�@�\�A���i�����ʂ�</a></p>
		
		<p>--------------------------------------------------------------------------</p>
		
	</body>
	
</html>