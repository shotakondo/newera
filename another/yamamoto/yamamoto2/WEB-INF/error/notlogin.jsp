<%@ page pageEncoding="Windows-31J"
	isErrorPage="true"
	contentType="text/html; charset=Windows-31J" %>
	
	<html>
		<head>
			<title>エラーページ</title>
		</head>
	<body>
		
		
		
		<h1>例外メッセージ : ${pageContext.exception.message}</h1>
		<h1>例外タイプ : ${pageContext.exception.getClass().getName()}</h1>
		
		
		<a href="input">ログインする</a>
		
	</body>
	</html>