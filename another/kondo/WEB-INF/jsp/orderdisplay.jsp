<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
	
	<head><title>注文履歴表示画面</title></head>
	
	<body>
	
		<h1>注文履歴表示画面</h1>
		
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
			<tr><th>注文日</th><th>オーダーID</th><th>注文内容</th><th>注文金額合計</th><th>支払方法</th></tr>
			<c:forEach var="orders" items="${data}">
				<tr>
					<td>${orders.date}</td>
					<td>${orders.oid}</td>
					<td>
						<c:forEach var="products" items="${orders.products}">
							商品ID:${products.pid}
							<img src="<c:url value='${products.path}' />" alt="${products.name}" width="180px" height="150px">
							商品名:${products.name}
							価格:${products.price}
							個数:${products.num}<br/>
						</c:forEach>
					</td>
					<td>${orders.total}</td>
					<td>${orders.method}</td>
				</tr>
			</c:forEach>
		</table>
		
		<p>--------------------------------------------------------------------------</p>
		
	</body>
	
</html>