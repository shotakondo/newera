<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
	
	<head><title>���C�ɓ�����</title></head>
	
	<body>
	
		<h1>���C�ɓ�����</h1>
		
		<c:if test="${sessionScope.userBean.id == null}">
			�񃍃O�C�����
			<p><a href="jumplogin">���O�C��/�V�K����o�^</a></p>
		</c:if>
		
		<c:if test="${sessionScope.userBean.id != null}">
			���O�C�����
			<p><a href="jumpmypage">�}�C�y�[�W</a></p>
			<p><a href="logout">���O�A�E�g</a></p>
		</c:if>
		
		<p><a href="home">�g�b�v�y�[�W��ʂɖ߂�</a></p>
		
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
			<tr><th>ID</th><th>�摜</th><th>���i��</th><th>���i</th></tr>
			<c:forEach var="favorite" items="${data}">
				<tr>
					<td>${favorite.pid}</td>
					<td><img src="<c:url value='${favorite.path}' />" alt="${favorite.name}" width="180px" height="150px"></td>
					<td>${favorite.name}</td>
					<td>${favorite.price}</td>
					<td>${favorite.date}</td>
					<td>
						<from method="post" action="favoritealter?pid=${favorite.pid}">
							<input type="text" name="comment" value="${favorite.comment}">
							<input type="submit" value="�������X�V">
						</form>
					</td>
					<td><a href="favoritedelete?pid=${favorite.pid}">�폜</a></td>
				</tr>
			</c:forEach>
		</table>
		
		<p>--------------------------------------------------------------------------</p>
		
	</body>
	
</html>