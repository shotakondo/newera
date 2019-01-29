<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
	
	<head><title>お気に入り画面</title></head>
	
	<body>
	
		<h1>お気に入り画面</h1>
		
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
		
		<p>お気に入り削除機能、お気に入り画面へ</p>
		<form method="post" action="favoritedelete">
			パラメーター1：<input type="text" name="parameter1"><br>
			パラメーター2：<input type="text" name="parameter2"><br>
			パラメーター3：<input type="text" name="parameter3"><br>
			パラメーター4：<input type="text" name="parameter4"><br>
			パラメーター5：<input type="text" name="parameter5"><br>
			<input type="submit" value="削除">
		</form>
		
		<p>--------------------------------------------------------------------------</p>
		
		カテゴリから探す
		<p><a href="productsdisplay">商品表示機能、商品表示画面へ</a></p>
		
	</body>
	
</html>