<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
	
	<head><title>�����m�F���</title></head>
	
	<body>
		
		<h1>�����m����</h1>
		
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
		
		<table border="1">
			<tr><th>�z����]��</th><th>�z����]����</th><th>�N�[�|���R�[�h</th><th>�L�����y�[���R�[�h</th><th>�x�����@</th><th>���b�s���O</th></tr>
			<tr><td>${sessionScope.payb.deliverydate}</td><td>${sessionScope.payb.deliverytime}</td><td>${sessionScope.payb.couponcode}</td><td>${sessionScope.payb.campaigncode}</td><td>${sessionScope.payb.method}</td><td>${sessionScope.payb.wrapping}</td></tr>
		</table>
		
		<p>�������m�肷��</p>
		<p><a href="ordercomplete">�����m��@�\�A����������ʂ�</a><p>
		
		<p>--------------------------------------------------------------------------</p>
		
	</body>
	
</html>