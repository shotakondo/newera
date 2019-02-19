<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
	
	<head><title>商品詳細表示画面</title></head>
	
	<body>
		
		<h1>商品詳細表示画面</h1>
		
		<c:if test="${sessionScope.ub == null}">
			非ログイン状態
			<p><a href="loginjump">ログイン/新規会員登録</a></p>
		</c:if>
		
		<c:if test="${sessionScope.ub != null}">
			ログイン状態
			<p><a href="mypagejump">マイページ</a></p>
			<p><a href="logout">ログアウト</a></p>
		</c:if>
		
		<p><a href="toppagejump">トップページ画面に戻る</a></p>
		
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
			<tr><th>画像</th><th>商品名</th><th>価格</th></tr>
			<tr><td><img src="<c:url value='${data.path}' />" alt="${data.name}" width="600px" height="500px"></td><td>${data.name}</td><td>${data.price}</td></tr>
		</table>
		
		カート追加機能
		<p><a href="cartadd?pid=${data.pid}">カート追加機能、カート表示画面へ</a></p>
		
		お気に入り追加機能
		<p><a href="favoriteadd?pid=${data.pid}">お気に入り追加機能、お気に入り表示画面へ</a></p>
		
		<p>--------------------------------------------------------------------------</p>
		
	</body>
	
</html>