<%@ page language="java" contentType="text/html;charset=Windows-31J"
	pageEncoding="Windows-31J"%>
	
<!DOCTYPE �V�K>
<html lang="jp">
<head>
  <title>�V�K�ꗗ</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<img src="img/logo.png">
<body>
<input type="text" name="search" placeholder="�L�[���[�h�����">
<div class="container">
  <center><img src="img/members1.png" style="padding:20px" /></center><br />
		<center><b>�V�K����o�^</center></b><br />
	<p>������o�^���s���܂��B<img src="img/icon_hissu.gif">�K�{�}�[�N�̉ӏ��́A�K�����͂��Ă��������B</p>
  <form class="form-horizontal" action="create" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="name">���[���A�h���X:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="email" name="email" placeholder="(��)sample@sample.jp">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">�p�X���[�h:</label>
      <div class="col-sm-10">          
        <input type="password" class="form-control" id="pwd" name="pass" placeholder="�p�X���[�h�����">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">ID:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="pwd" name="id" placeholder="�i��jabc123..">
      </div>
     </div>
      <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">[��]</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="pwd" name="firstname" placeholder="��">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">[��]</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="pwd" name="lastname" placeholder="��">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">�A����d�b�ԍ�</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="pwd" name="tel" placeholder="�i��j091-2345-6789">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">���N��</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="pwd" name="birthday" placeholder="2001/02">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">�X�֋�</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="pwd" name="postcode" placeholder="111-2222">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">����</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="pwd" name="sex" placeholder="�P���Q">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">�Z��</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="pwd" name="address" placeholder="�P���Q">
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
     // <button type="submit" class="btn btn-success">�߂�</button>
        <button type="submit" class="btn btn-success">�m�F��ʂ�</button>
      </div>
    </div>
  </form>
</div>

</body>
</html>