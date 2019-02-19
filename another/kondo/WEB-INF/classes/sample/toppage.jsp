<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
	
	<head>
		<title>トップページ画面</title>
		<link rel="stylesheet" href="../css/style.css">
	</head>
	
	<body>
		
		<h1>トップページ画面</h1>
		
		トップページ画面に戻る
		<p><a href="toppagejump">機能なし、トップページ画面へ</a></p><br>
		
		カート表示画面へ進む
		<p><a href="cartdisplay">カート表示機能、カート表示画面へ</a></p><br>
		
		<p>商品検索機能、①成功→商品表示画面へ②失敗→トップページ画面へ</p>
		<form method="post" action="productssearch">
			商品名:<input type="text" name="productword">
			<input type="submit" value="検索">
		</form><br>
		
		<p>商品並べ替え機能、トップページ画面へ<p>
		<select name="sortparameter" form="productssort">
			<option value="name">名前順</option>
			<option value="cheap">安い順</option>
			<option value="expensive">高い順</option>
		</select><br>
		
		<form method="post" action="productssort" id="productssort">
			<input type="submit" value="送信">
		</form>
		
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
		<p>--------------------------------------------------------------------------</p>
		
		カテゴリから探す
		
		商品詳細表示機能、商品詳細表示画面へ
		<table border="1">
			<tr><th>画像</th><th>商品名</th><th>価格</th></tr>
			<c:forEach var="product" items="${sessionScope.productlist}">
				<tr><td><a href="productdetaildisplay?pid=${product.pid}"><img src="<c:url value='${product.path}' />" alt="${product.name}" width="180px" height="150px"></a></td><td>${product.name}</td><td>${product.price}</td></tr>
			</c:forEach>
		</table>
		
	</body>
	
</html>