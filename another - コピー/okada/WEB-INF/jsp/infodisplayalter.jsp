<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
	
	<head><title>�o�^���\���E�ύX���</title></head>
	
	<body>
		
		<h1>�o�^���\���E�ύX���</h1>
		
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
		
		<p>�o�^���ύX�@�\�A�o�^���\����ʂ�</p>
		<form method="post" action="infoalter">
			���[���A�h���X�F<input type="text" name="email" value=${data.getEmail()}><br>
			���[���A�h���X�y�m�F�p�z�F<input type="text" name="reemail" value=${data.getEmail()}><br>
			���F<input type="text" name="firstname" value=${data.getFirstname()}><br>
			���F<input type="text" name="lastname" value=${data.getLastname()}><br>
			�d�b�ԍ��F<input type="text" name="tel" value=${data.getTel()}><br>
			�X�֔ԍ��F<input type="text" name="postcode" value=${data.getPostcode()}><br>
			�Z���F<input type="text" name="address" value=${data.getAddress()}><br>
			���ʁF<input type="text" name="sex" value=${data.getSex()}><br>
			���N�����F${data.getBirthday()}<br>
			�p�X���[�h�F<input type="text" name="pass"><br>
			�p�X���[�h�y�m�F�p�z�F<input type="text" name="repass"><br>
			<input type="hidden" name="nowpass" value=${data.getPass()}>
			<input type="submit" value="�ύX">
		</form>
		
		<p><a href="unsubscribejump">�@�\�Ȃ��A�މ�\����ʂ�</a></p>
		
		<p>--------------------------------------------------------------------------</p>
		
	</body>
	
</html>