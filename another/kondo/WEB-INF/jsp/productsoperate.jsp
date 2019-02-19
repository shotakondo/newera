<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>

	<head><title>商品操作画面</title></head>
	
	<body>
	
		<h1>商品操作画面</h1>
		
		管理者トップページ画面に戻る
		<p><a href="managertoppagejump">機能なし、管理者トップページ画面へ</a></p>
		
		<p><a href="logout">ログアウト機能、トップページ画面へ</a></p>
		
		<p>--------------------------------------------------------------------------</p>
		<!--
		<p>商品絞り込み機能、商品操作画面へ</p>
		<form method="post" action="productsnarrow">
			<input type="submit" value="絞り込み">
		</form>
		
		並べ替え
		<p><a href="productssort">商品並べ替え機能、商品操作画面へ</a></p>
		--!>
		<p>新しく商品を追加する</p>
		<p><a href="productaddjump">機能なし、商品追加画面へ</a></p>
		
		商品詳細表示機能、商品詳細表示画面へ
		<table border="1">
			<tr><th>ID</th><th>画像</th><th>商品名</th><th>価格</th></tr>
			<c:forEach var="product" items="${sessionScope.productlist}">
				<tr><td>${product.pid}</td><td><a href="productalterdisplay?pid=${product.pid}"><img src="<c:url value='${product.path}' />" alt="${product.name}" width="180px" height="150px"></a></td><td>${product.name}</td><td>${product.price}</td></tr>
			</c:forEach>
		</table>
		
		<p><a href="productdelete">商品削除機能、商品操作画面へ</a></p>
		
		<p>--------------------------------------------------------------------------</p>
		
	</body>
	
</html>