<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
	
	<head><title>申し込み完了画面</title></head>
	
	<body>
		
		<h1>申し込み完了画面</h1>
		
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
		
		本人確認メール送信完了<br>
		ご入力されたメールアドレスに情報登録ページのURLが記載されたメールをお送りしました。<br>
		送信されたメールに記載されたURLをクリックすると、情報登録画面が表示されますので、ご入力をお願いいたします。<br>
		今回ご入力のメールアドレスは「お客様ID」として、ログインの際にパスワードと共に使用します。
		
		<p>--------------------------------------------------------------------------</p>
		
	</body>
	
</html>