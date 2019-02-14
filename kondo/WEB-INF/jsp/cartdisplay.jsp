<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
	
	<head><title>カート表示画面</title></head>
	
	<body>
		
		<h1>カート表示画面</h1>
		
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
		
		<form method="post" action="purchaseprocedure">
			<table border="1">
				<tr><th>ID</th><th>画像</th><th>商品名</th><th>数量</th><th>価格</th></tr>
				<c:forEach var="product" items="${sessionScope.cb.products}">
					<tr>
						<td>${product.pid}</td>
						<td><a href="productdetaildisplay?pid=${product.pid}"><img src="<c:url value='${product.path}' />" alt="${product.name}" width="180px" height="150px"></a></td>
						<td>${product.name}</td>
						<td>
							<input type="text" name="num" value="${product.num}">
						</td>
						<td>${product.price}</td>
						<td><a href="cartdelete?pid=${product.pid}">削除</a></td>
					</tr>
				</c:forEach>
			</table>
		<input type="submit" value="購入手続きへ">
		</form>
		
		<p><a href="cartalldelete">カート全削除機能、カート表示画面へ</a></p>
		
		<p>--------------------------------------------------------------------------</p>
		
	</body>
	
</html>