<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
	
	<head><title>�w���葱�����</title></head>
	
	<body>
		
		<h1>�w���葱�����</h1>
		
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
		<p>��������</p>
		${sessionScope.ub.getFirstname()}${sessionScope.ub.getLastname()}�l</br>
		��${sessionScope.ub.getPostcode()}</br>
		${sessionScope.ub.getAddress()}</br>
		TEL:${sessionScope.ub.getTel()}</br>
		<table border="1">
			<tr><th>ID</th><th>�摜</th><th>���i��</th><th>����</th><th>���i</th></tr>
			<c:forEach var="product" items="${sessionScope.cb.products}">
				<tr>
					<td>${product.pid}</td>
					<td><a href="productdetaildisplay?pid=${product.pid}"><img src="<c:url value='${product.path}' />" alt="${product.name}" width="180px" height="150px"></a></td>
					<td>${product.name}</td>
					<td>${product.num}</td>
					<td>${product.price}</td>
				</tr>
			</c:forEach>
		</table>
		
		<form method="post" action="orderconfirm" id="orderconfirm">
			<p>�z����]��</p>
			<select name="deliverydate" form="orderconfirm">
				<option value="��]�Ȃ�">��]�Ȃ�</option>
				<option value="����">����</option>
				<option value="�x��">�x��</option>
			</select><br>
			
			<p>�z����]����</p>
			<input type="radio" name="deliverytime" value="��]�Ȃ�" checked>��]�Ȃ�
			<input type="radio" name="deliverytime" value="8:00-12:00">8:00-12:00(�ߑO��)
			<input type="radio" name="deliverytime" value="12:00-14:00">12:00-14:00
			<input type="radio" name="deliverytime" value="14:00-16:00">14:00-16:00
			<input type="radio" name="deliverytime" value="16:00-18:00">16:00-18:00
			<input type="radio" name="deliverytime" value="18:00-20:00">18:00-20:00
			<input type="radio" name="deliverytime" value="19:00-21:00">19:00-21:00(���ꌧ��20:00-21:00)
			
			<p>�N�[�|���R�[�h</p>
			<input type="text" name="couponcode">
			
			<p>�L�����y�[���R�[�h</p>
			<input type="text" name="campaigncode">
			
			<p>�x�����@</p>
			<input type="radio" name="method" value="�������">�������
			<input type="radio" name="method" value="�N���W�b�g�J�[�h">�N���W�b�g�J�[�h
			<input type="radio" name="method" value="Amazon Pay">Amazon Pay
			<input type="radio" name="method" value="Paidy��������(�R���r�j/��s)">Paidy��������(�R���r�j/��s)
			
			<p>���b�s���O</p>
			<input type="radio" name="wrapping" value="��]�Ȃ�" checked>��]�Ȃ�
			<input type="radio" name="wrapping" value="��]����">��]����
			
			<p>�������m�F����</p>
			<input type="submit" value="�ݒ肵�Ē����̊m�F��ʂɐi��">
			
		</form>
		
		<p>--------------------------------------------------------------------------</p>
		
	</body>
	
</html>