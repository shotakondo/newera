<%@ page language="java" contentType="text/html;charset=Windows-31J"
	pageEncoding="Windows-31J"%>

<!DOCTYPE ログイン>
<html lang="jp">
<head>
  <title>ログイン一覧</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%
		String err = request.getParameter("err");
		if ("1".equals(err)) {
			out.print("<h4 style=\"color: red;\">ユーザーIDかパスワード間違ってる</h4>");
		}
	%>
<div class="container">
  <h2>入力してください</h2>
  <form class="form-horizontal" action="LoginServlet" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">ID:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="email" name="email" placeholder="(例)sample@sample.jp">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">パスワード:</label>
      <div class="col-sm-10">          
        <input type="password" class="form-control" id="pwd" name="pass" placeholder="パスワードを入力">
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">ログイン</button><br/><br/>
        <p class="forgot"><a href="input.jsp">パスワードを忘れましたか？</a></p>
      </div>
    </div>
  </form>
</div>

</body>
</html>
