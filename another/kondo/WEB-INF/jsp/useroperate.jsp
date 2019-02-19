<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
	
	<head><title>ユーザー操作画面</title></head>
	
	<body>
	
		<h1>ユーザー操作画面</h1>
		
		管理者トップページ画面に戻る
		<p><a href="managertoppagejump">機能なし、管理者トップページ画面へ</a></p>
		
		<p><a href="logout">ログアウト機能、トップページ画面へ</a></p>
		
		<p>---------------------------------------------------------------------------</p>
		
		<p>ユーザー絞り込み機能、ユーザー操作画面へ</p>
		<form method="post" action="usersnarrow">
			パラメーター1：<input type="text" name="parameter1"><br>
			パラメーター2：<input type="text" name="parameter2"><br>
			パラメーター3：<input type="text" name="parameter3"><br>
			パラメーター4：<input type="text" name="parameter4"><br>
			パラメーター5：<input type="text" name="parameter5"><br>
			<input type="submit" value="絞り込み">
		</form>
		
		<p><a href="userssort">ユーザー並べ替え機能、ユーザー操作画面へ</a></p>
		
		ユーザー表示
		<p><a href="nguseradd">NGユーザー追加機能、ユーザー操作画面へ</a></p>
		
		<p><a href="nguserrelease">NGユーザー解除機能、ユーザー操作画面画面へ</a></p>
		
		<p>----------------------------------------------------------------------------</p>
		
	</body>
	
</html>