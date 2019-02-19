<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
	
	<head><title>購入手続き画面</title></head>
	
	<body>
		
		<h1>購入手続き画面</h1>
		
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
		<p>ご注文主</p>
		${sessionScope.ub.getFirstname()}${sessionScope.ub.getLastname()}様</br>
		〒${sessionScope.ub.getPostcode()}</br>
		${sessionScope.ub.getAddress()}</br>
		TEL:${sessionScope.ub.getTel()}</br>
		<table border="1">
			<tr><th>ID</th><th>画像</th><th>商品名</th><th>数量</th><th>価格</th></tr>
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
		
		<form method="post" action="orderconfirm" id="orderconfirm">
			<p>配送希望日</p>
			<select name="deliverydate" form="orderconfirm">
				<option value="希望なし">希望なし</option>
				<option value="早く">早く</option>
				<option value="遅く">遅く</option>
			</select><br>
			
			<p>配送希望時間</p>
			<input type="radio" name="deliverytime" value="希望なし" checked>希望なし
			<input type="radio" name="deliverytime" value="8:00-12:00">8:00-12:00(午前中)
			<input type="radio" name="deliverytime" value="12:00-14:00">12:00-14:00
			<input type="radio" name="deliverytime" value="14:00-16:00">14:00-16:00
			<input type="radio" name="deliverytime" value="16:00-18:00">16:00-18:00
			<input type="radio" name="deliverytime" value="18:00-20:00">18:00-20:00
			<input type="radio" name="deliverytime" value="19:00-21:00">19:00-21:00(沖縄県は20:00-21:00)
			
			<p>クーポンコード</p>
			<input type="text" name="couponcode">
			
			<p>キャンペーンコード</p>
			<input type="text" name="campaigncode">
			
			<p>支払方法</p>
			<input type="radio" name="method" value="代金引換">代金引換
			<input type="radio" name="method" value="クレジットカード">クレジットカード
			<input type="radio" name="method" value="Amazon Pay">Amazon Pay
			<input type="radio" name="method" value="Paidy翌月払い(コンビニ/銀行)">Paidy翌月払い(コンビニ/銀行)
			
			<p>ラッピング</p>
			<input type="radio" name="wrapping" value="希望なし" checked>希望なし
			<input type="radio" name="wrapping" value="希望する">希望する
			
			<p>注文を確認する</p>
			<input type="submit" value="設定して注文の確認画面に進む">
			
		</form>
		
		<p>--------------------------------------------------------------------------</p>
		
	</body>
	
</html>