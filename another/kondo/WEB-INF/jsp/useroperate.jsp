<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
	
	<head><title>���[�U�[������</title></head>
	
	<body>
	
		<h1>���[�U�[������</h1>
		
		�Ǘ��҃g�b�v�y�[�W��ʂɖ߂�
		<p><a href="managertoppagejump">�@�\�Ȃ��A�Ǘ��҃g�b�v�y�[�W��ʂ�</a></p>
		
		<p><a href="logout">���O�A�E�g�@�\�A�g�b�v�y�[�W��ʂ�</a></p>
		
		<p>---------------------------------------------------------------------------</p>
		
		<p>���[�U�[�i�荞�݋@�\�A���[�U�[�����ʂ�</p>
		<form method="post" action="usersnarrow">
			�p�����[�^�[1�F<input type="text" name="parameter1"><br>
			�p�����[�^�[2�F<input type="text" name="parameter2"><br>
			�p�����[�^�[3�F<input type="text" name="parameter3"><br>
			�p�����[�^�[4�F<input type="text" name="parameter4"><br>
			�p�����[�^�[5�F<input type="text" name="parameter5"><br>
			<input type="submit" value="�i�荞��">
		</form>
		
		<p><a href="userssort">���[�U�[���בւ��@�\�A���[�U�[�����ʂ�</a></p>
		
		���[�U�[�\��
		<p><a href="nguseradd">NG���[�U�[�ǉ��@�\�A���[�U�[�����ʂ�</a></p>
		
		<p><a href="nguserrelease">NG���[�U�[�����@�\�A���[�U�[�����ʉ�ʂ�</a></p>
		
		<p>----------------------------------------------------------------------------</p>
		
	</body>
	
</html>