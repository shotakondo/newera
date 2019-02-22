<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
	
	<head><title>お気に入り画面</title></head>
	
	<body>
	
		<h1>お気に入り画面</h1>
		
		<c:if test="${sessionScope.userBean.id == null}">
			非ログイン状態
			<p><a href="jumplogin">ログイン/新規会員登録</a></p>
		</c:if>
		
		<c:if test="${sessionScope.userBean.id != null}">
			ログイン状態
			<p><a href="jumpmypage">マイページ</a></p>
			<p><a href="logout">ログアウト</a></p>
		</c:if>
		
		<p><a href="home">トップページ画面に戻る</a></p>
		
		<form method="post" action="productssearch">
			商品名:<input type="text" name="productword">
			<input type="submit" value="検索">
		</form>
		
		<p><a href="cartdisplay">カート</a></p>
		
		<select name="sortparameter" form="productssort">
			<option value="name">名前順</option>
			<option value="cheap">安い順</option>
			<option value="expensive">高い順</option>
		</select><br>
		
		<form method="post" action="productssort" id="productssort">
			<input type="submit" value="ソート">
		</form>
		
		<p>--------------------------------------------------------------------------</p>
		
		<table border="1">
			<tr><th>ID</th><th>画像</th><th>商品名</th><th>価格</th></tr>
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
							<input type="submit" value="メモを更新">
						</form>
					</td>
					<td><a href="favoritedelete?pid=${favorite.pid}">削除</a></td>
				</tr>
			</c:forEach>
		</table>
		
		<p>--------------------------------------------------------------------------</p>
		
	</body>
	
</html>