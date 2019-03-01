<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	


<!-- productupdate.jsp -->
<html>

	<head><title>商品更新画面</title></head>
	
	<body>
	
		<h1>商品更新画面</h1>
		
		管理者トップページ画面に戻る
		<p><a href="managertoppagejump">機能なし、管理者トップページ画面へ</a></p>
		
		<p><a href="logout">ログアウト機能、トップページ画面へ</a></p>
		
		<p>--------------------------------------------------------------------------</p>
		
		<p>商品更新機能、商品操作画面へ</p>
		<form method="post" action="productupdate">
			パラメーター1：<input type="text" name="parameter1"><br>
			パラメーター2：<input type="text" name="parameter2"><br>
			パラメーター3：<input type="text" name="parameter3"><br>
			パラメーター4：<input type="text" name="parameter4"><br>
			パラメーター5：<input type="text" name="parameter5"><br>
			<input type="submit" value="更新">
		</form>
		
		<p>--------------------------------------------------------------------------</p>
		
	</body>
	
</html>