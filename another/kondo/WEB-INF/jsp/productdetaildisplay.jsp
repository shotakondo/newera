<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
	
	<head><title>���i�ڍו\�����</title></head>
	
	<body>
		
		<h1>���i�ڍו\�����</h1>
		
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
			<tr><th>�摜</th><th>���i��</th><th>���i</th></tr>
			<tr><td><img src="<c:url value='${data.path}' />" alt="${data.name}" width="600px" height="500px"></td><td>${data.name}</td><td>${data.price}</td></tr>
		</table>
		
		�J�[�g�ǉ��@�\
		<p><a href="cartadd?pid=${data.pid}">�J�[�g�ǉ��@�\�A�J�[�g�\����ʂ�</a></p>
		
		���C�ɓ���ǉ��@�\
		<p><a href="favoriteadd?pid=${data.pid}">���C�ɓ���ǉ��@�\�A���C�ɓ���\����ʂ�</a></p>
		
		<p>--------------------------------------------------------------------------</p>
		
	</body>
	
</html>