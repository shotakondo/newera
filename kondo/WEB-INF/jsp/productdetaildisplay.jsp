<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
	
	<head><title>���i�ڍו\�����</title></head>
	
	<body>
		
		<h1>���i�ڍו\�����</h1>
		
		�g�b�v�y�[�W��ʂɖ߂�
		<p><a href="toppagejump">�@�\�Ȃ��A�g�b�v�y�[�W��ʂ�</a></p><br>
		
		�J�[�g�\����ʂ֐i��
		<p><a href="cartdisplay">�J�[�g�\���@�\�A�J�[�g�\����ʂ�</a></p><br>
		
		<p>���i�����@�\�A�@���������i�\����ʂևA���s���g�b�v�y�[�W��ʂ�</p>
		<form method="post" action="productssearch">
			�J�e�S���[���F<input type="text" name="categoryname"><br>
			���i��:<input type="text" name="productward">
			<input type="submit" value="����">
		</form><br>
		
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
		
		<table border="1">
			<tr><th>�摜</th><th>���i��</th><th>���i</th></tr>
			<tr><td><img src="<c:url value='${data.path}' />" alt="${data.name}" width="600px" height="500px"></td><td>${data.name}</td><td>${data.price}</td></tr>
		</table>
		
		<p>�J�[�g�ǉ��@�\�A���i�ڍו\����ʂ�</p>
		<form method="post" action="cartadd">
			���ʁF<input type="text" name="num">
			<input type="submit" value="�J�[�g�ɓ����">
		</form>
		
		���C�ɓ���ǉ��@�\
		<p><a href="favoriteadd">���C�ɓ���ǉ��@�\�A���C�ɓ���\����ʂ�</a></p>
		
		<p>--------------------------------------------------------------------------</p>
		
		�J�e�S������T��
		<p><a href="productsdisplay">���i�\���@�\�A���i�\����ʂ�</a></p>
		
	</body>
	
</html>