<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>


<!-- productadd.jsp -->


	<head><title>���i�ǉ����</title></head>
	
	<body>
	
		<h1>���i�ǉ����</h1>
		
		�Ǘ��҃g�b�v�y�[�W��ʂɖ߂�
		<p><a href="managertoppagejump">�@�\�Ȃ��A�Ǘ��҃g�b�v�y�[�W��ʂ�</a></p>
		
		<p><a href="logout">���O�A�E�g�@�\�A�g�b�v�y�[�W��ʂ�</a></p>
		
		<p>--------------------------------------------------------------------------</p>
		
		<p>���i�ǉ��@�\�A���i�����ʂ�</p>
		<form method="post" action="productadd">
			�p�����[�^�[1�F<input type="text" name="parameter1"><br>
			�p�����[�^�[2�F<input type="text" name="parameter2"><br>
			�p�����[�^�[3�F<input type="text" name="parameter3"><br>
			�p�����[�^�[4�F<input type="text" name="parameter4"><br>
			�p�����[�^�[5�F<input type="text" name="parameter5"><br>
			<input type="submit" value="�ǉ�">
		</form>
		
		<p>--------------------------------------------------------------------------</p>
		
	</body>
	
</html>