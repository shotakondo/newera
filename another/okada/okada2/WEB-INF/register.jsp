<%@ page language="java" contentType="text/html;charset=Windows-31J"
	pageEncoding="Windows-31J"%>
	
<!DOCTYPE 新規>
<html lang="jp">
<head>
  <title>新規一覧</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<img src="img/logo.png">
<body>
<input type="text" name="search" placeholder="キーワードを入力">
<div class="container">
  <center><img src="img/members1.png" style="padding:20px" /></center><br />
		<center><b>新規会員登録</center></b><br />
	<p>会員情報登録を行います。<img src="img/icon_hissu.gif">必須マークの箇所は、必ず入力してください。</p>
  <form class="form-horizontal" action="create" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="name">メールアドレス:</label>
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
      <label class="control-label col-sm-2" for="pwd">ID:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="pwd" name="id" placeholder="（例）abc123..">
      </div>
     </div>
      <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">[姓]</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="pwd" name="firstname" placeholder="姓">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">[名]</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="pwd" name="lastname" placeholder="名">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">連絡先電話番号</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="pwd" name="tel" placeholder="（例）091-2345-6789">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">生年月</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="pwd" name="birthday" placeholder="2001/02">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">郵便局</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="pwd" name="postcode" placeholder="111-2222">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">性別</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="pwd" name="sex" placeholder="１か２">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">住所</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="pwd" name="address" placeholder="１か２">
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
     // <button type="submit" class="btn btn-success">戻る</button>
        <button type="submit" class="btn btn-success">確認画面へ</button>
      </div>
    </div>
  </form>
</div>

</body>
</html>