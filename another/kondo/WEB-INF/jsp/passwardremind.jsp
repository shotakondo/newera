<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
	
	<head><title>�p�X���[�h���}�C���h���</title></head>
	
	<body>
	
		<h1>�p�X���[�h���}�C���h���</h1>
		
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
		
		<p>�p�X���[�h���}�C���h�@�\�A�p�X���[�h���}�C���h������ʂ�</p>
		<form method="post" action="passwardremind">
			�d�b�ԍ�:<input type="text" name="tel"><br>
			���[���A�h���X:<input type="text" name="email"><br>
			<input type="submit" value="���M">
		</form>
		
		<p>--------------------------------------------------------------------------</p>
		
	</body>
	
</html>