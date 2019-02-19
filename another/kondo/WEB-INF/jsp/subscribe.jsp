<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>

	<head><title>会員登録画面</title></head>
	
	<body>
	
		<h1>会員登録画面</h1>
		
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
		
		<p>-----------------------------------------------------------------------------------</p>
		<p>新規会員登録を行います。</p>
		<p>お客様ID（メールアドレス）：${sessionScope.email}</p>
		<p>会員登録機能、①登録成功→トップページ画面へ②登録失敗→会員登録画面へ</p>
		<form method="post" action="subscribe">
			姓：<input type="text" name="firstname"><br>
			名：<input type="text" name="lastname"><br>
			電話番号：<input type="text" name="tel"><br>
			郵便番号：<input type="text" name="postcode"><br>
			住所：<input type="text" name="address"><br>
			性別：<input type="text" name="sex"><br>
			生年月日：<input type="text" name="birthday"><br>
			パスワード：<input type="text" name="pass"><br>
			パスワード【確認】：<input type="text" name="repass"><br>
			<input type='hidden' value='${sessionScope.email}' name = 'email'>
			<input type="submit" value="登録">
		</form>
		
		<p>------------------------------------------------------------------------------------</p>
		
	</body>
	
</html>