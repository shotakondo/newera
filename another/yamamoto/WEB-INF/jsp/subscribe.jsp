<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>

	<head><title>����o�^���</title></head>
	
	<body>
	
		<h1>����o�^���</h1>
		
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
		
		<p>-----------------------------------------------------------------------------------</p>
		<p>�V�K����o�^���s���܂��B</p>
		<p>���q�lID�i���[���A�h���X�j�F${sessionScope.email}</p>
		<p>����o�^�@�\�A�@�o�^�������g�b�v�y�[�W��ʂևA�o�^���s������o�^��ʂ�</p>
		<form method="post" action="subscribe">
			���F<input type="text" name="firstname"><br>
			���F<input type="text" name="lastname"><br>
			�d�b�ԍ��F<input type="text" name="tel"><br>
			�X�֔ԍ��F<input type="text" name="postcode"><br>
			�Z���F<input type="text" name="address"><br>
			���ʁF<input type="text" name="sex"><br>
			���N�����F<input type="text" name="birthday"><br>
			�p�X���[�h�F<input type="text" name="pass"><br>
			�p�X���[�h�y�m�F�z�F<input type="text" name="repass"><br>
			<input type='hidden' value='${sessionScope.email}' name = 'email'>
			<input type="submit" value="�o�^">
		</form>
		
		<p>------------------------------------------------------------------------------------</p>
		
	</body>
	
</html>