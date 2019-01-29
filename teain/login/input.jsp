<%@ page language="java" contentType="text/html; charset=windows-31J" pageEncoding="windows-31J"%>
<html>
	<head><title>ニューエラ公式オンラインストア/パスワードリマインダー</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<style> .a{margin: 50px;font-size:20px}

	</style>
	</head>
	<body><div class="a"><img src="img/logo.png">
<center><h2>パスワード再設定</h2>
<h5>会員情報の確認を行います。</h5>
<h5>会員情報登録を行った際のメールアドレスと連絡先電話番号を入力して送信ボタンをクリックしてください。</h5></center>
	<table border=0>
	<form method='post' action='SendMailServlet'>
		メールアドレス<img src="img/icon_hissu.gif" />：<input type='text' name = 'email'><br/><br/>
		連絡先電話番号<img src="img/icon_hissu.gif" />：<input type='text' name = 'tel'><br/><br/>
		<button class="btn btn-success"> <a href="index.jsp">戻る</a></button>
		<button type="submit" class="btn btn-success">送信</button>
	</form>
      </table>
      </div>
	</body>
</html>






