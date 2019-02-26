<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
	
	<head>
		<title>�g�b�v�y�[�W���</title>
		<link rel="stylesheet" href="../css/style.css">
	</head>
	
	<body>
		
		<h1>�g�b�v�y�[�W���</h1>
		
		�g�b�v�y�[�W��ʂɖ߂�
		<p><a href="toppagejump">�@�\�Ȃ��A�g�b�v�y�[�W��ʂ�</a></p><br>
		
		�J�[�g�\����ʂ֐i��
		<p><a href="cartdisplay">�J�[�g�\���@�\�A�J�[�g�\����ʂ�</a></p><br>
		
		<p>���i�����@�\�A�@���������i�\����ʂևA���s���g�b�v�y�[�W��ʂ�</p>
		<form method="post" action="productssearch">
			���i��:<input type="text" name="productword">
			<input type="submit" value="����">
		</form><br>
		
		<p>���i���בւ��@�\�A�g�b�v�y�[�W��ʂ�<p>
		<select name="sortparameter" form="productssort">
			<option value="name">���O��</option>
			<option value="cheap">������</option>
			<option value="expensive">������</option>
		</select><br>
		
		<form method="post" action="productssort" id="productssort">
			<input type="submit" value="���M">
		</form>
		
		<c:if test="${sessionScope.uname == null}">
			�񃍃O�C�����
			<p>����ɂ��̓Q�X�g����</p>
			<p><a href="emailentryjump">�@�\�Ȃ��A����\����ʂ�</a></p>
			<p><a href="loginjump">�@�\�Ȃ��A���O�C����ʂ�</a></p>
		</c:if>
		
		<c:if test="${sessionScope.uname != null}">
			���O�C�����
			<p>����ɂ���${sessionScope.uname}����<p>
			<p><a href="mypagejump">�@�\�Ȃ��A�}�C�y�[�W��ʂ�</a></p>
			<p><a href="logout">���O�A�E�g�@�\�A�g�b�v�y�[�W��ʂ�</a></p>
		</c:if>
		
		<p>--------------------------------------------------------------------------</p>
		<p>--------------------------------------------------------------------------</p>
		
		�J�e�S������T��
		
		���i�ڍו\���@�\�A���i�ڍו\����ʂ�
		<table border="1">
			<tr><th>�摜</th><th>���i��</th><th>���i</th></tr>
			<c:forEach var="product" items="${sessionScope.productlist}">
				<tr><td><a href="productdetaildisplay?pid=${product.pid}"><img src="<c:url value='${product.path}' />" alt="${product.name}" width="180px" height="150px"></a></td><td>${product.name}</td><td>${product.price}</td></tr>
			</c:forEach>
		</table>
		
	</body>
	
</html>