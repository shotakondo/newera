<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
	
	<head><title>���O�C�����</title></head>
	
	<body>
	
		<h1>���O�C�����</h1>
		
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
		
		<p>���O�C���@�\</p>
		<p>�@���[�U�[���O�C���������g�b�v�y�[�W��ʂ�</p>
		<p>�A�Ǘ��҃��O�C���������Ǘ��҃g�b�v�y�[�W��ʂ�</p>
		<p>�B���O�C�����s�����O�C����ʂ�</p>
		<form method="post" action="login">
			���[���A�h���X:<input type="text" name="email"><br>
			�p�X���[�h:<input type="text" name="pass">
			<input type="submit" value="�o�^">
		</form>
		
		<p><a href="passwardremindjump">�@�\�Ȃ��A�p�X���[�h���}�C���h��ʂ�</a></p>
		
		<p>--------------------------------------------------------------------------</p>
		
	</body>
	
</html>