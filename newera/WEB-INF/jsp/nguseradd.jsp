<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
	
	<head><title>NGユーザー追加画面</title></head>
	
	<body>
	
		<h1>NGユーザー追加画面</h1>
		
		管理者トップページ画面に戻る
		<p><a href="managertoppagejump">機能なし、管理者トップページ画面へ</a></p>
		
		<p><a href="logout">ログアウト機能、トップページ画面へ</a></p>
		
		<p>--------------------------------------------------------------------------</p>
		
		<p>NGユーザー追加機能、NGユーザー追加画面へ</p>
		<form method="post" action="nguseradd">
			パラメーター1：<input type="text" name="parameter1"><br>
			パラメーター2：<input type="text" name="parameter2"><br>
			パラメーター3：<input type="text" name="parameter3"><br>
			パラメーター4：<input type="text" name="parameter4"><br>
			パラメーター5：<input type="text" name="parameter5"><br>
			<input type="submit" value="追加">
		</form>
		
		<p>--------------------------------------------------------------------------</p>
		
	</body>
	
</html>