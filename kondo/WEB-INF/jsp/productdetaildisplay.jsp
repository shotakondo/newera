<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
	
	<head><title>商品詳細表示画面</title></head>
	
	<body>
		
		<h1>商品詳細表示画面</h1>
		
		トップページ画面に戻る
		<p><a href="toppagejump">機能なし、トップページ画面へ</a></p><br>
		
		カート表示画面へ進む
		<p><a href="cartdisplay">カート表示機能、カート表示画面へ</a></p><br>
		
		<p>商品検索機能、①成功→商品表示画面へ②失敗→トップページ画面へ</p>
		<form method="post" action="productssearch">
			カテゴリー名：<input type="text" name="categoryname"><br>
			商品名:<input type="text" name="productward">
			<input type="submit" value="検索">
		</form><br>
		
		<c:if test="${sessionScope.uname == null}">
			非ログイン状態
			<p>こんにちはゲストさん</p>
			<p><a href="emailentryjump">機能なし、入会申請画面へ</a></p>
			<p><a href="loginjump">機能なし、ログイン画面へ</a></p>
		</c:if>
		
		<c:if test="${sessionScope.uname != null}">
			ログイン状態
			<p>こんにちは${sessionScope.uname}さん<p>
			<p><a href="mypagejump">機能なし、マイページ画面へ</a></p>
			<p><a href="logout">ログアウト機能、トップページ画面へ</a></p>
		</c:if>
		
		<p>--------------------------------------------------------------------------</p>
		
		<table border="1">
			<tr><th>画像</th><th>商品名</th><th>価格</th></tr>
			<tr><td><img src="<c:url value='${data.path}' />" alt="${data.name}" width="600px" height="500px"></td><td>${data.name}</td><td>${data.price}</td></tr>
		</table>
		
		<p>カート追加機能、商品詳細表示画面へ</p>
		<form method="post" action="cartadd">
			数量：<input type="text" name="num">
			<input type="submit" value="カートに入れる">
		</form>
		
		お気に入り追加機能
		<p><a href="favoriteadd">お気に入り追加機能、お気に入り表示画面へ</a></p>
		
		<p>--------------------------------------------------------------------------</p>
		
		カテゴリから探す
		<p><a href="productsdisplay">商品表示機能、商品表示画面へ</a></p>
		
	</body>
	
</html>