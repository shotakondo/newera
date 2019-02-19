<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
	
	<head><title>登録情報表示・変更画面</title></head>
	
	<body>
		
		<h1>登録情報表示・変更画面</h1>
		
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
		
		<p>登録情報変更機能、登録情報表示画面へ</p>
		<form method="post" action="infoalter">
			メールアドレス：<input type="text" name="email" value=${data.getEmail()}><br>
			メールアドレス【確認用】：<input type="text" name="reemail" value=${data.getEmail()}><br>
			姓：<input type="text" name="firstname" value=${data.getFirstname()}><br>
			名：<input type="text" name="lastname" value=${data.getLastname()}><br>
			電話番号：<input type="text" name="tel" value=${data.getTel()}><br>
			郵便番号：<input type="text" name="postcode" value=${data.getPostcode()}><br>
			住所：<input type="text" name="address" value=${data.getAddress()}><br>
			性別：<input type="text" name="sex" value=${data.getSex()}><br>
			生年月日：${data.getBirthday()}<br>
			パスワード：<input type="text" name="pass"><br>
			パスワード【確認用】：<input type="text" name="repass"><br>
			<input type="hidden" name="nowpass" value=${data.getPass()}>
			<input type="submit" value="変更">
		</form>
		
		<p><a href="unsubscribejump">機能なし、退会申請画面へ</a></p>
		
		<p>--------------------------------------------------------------------------</p>
		
	</body>
	
</html>