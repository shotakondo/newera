<%@ page language="java" contentType="text/html;charset=Windows-31J"
	pageEncoding="Windows-31J"%>

<!DOCTYPE ���O�C��>
<html lang="jp">
<head>
  <title>���O�C���ꗗ</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%
		String err = request.getParameter("err");
		if ("1".equals(err)) {
			out.print("<h4 style=\"color: red;\">���[�U�[ID���p�X���[�h�Ԉ���Ă�</h4>");
		}
	%>
<div class="container">
  <h2>���͂��Ă�������</h2>
  <form class="form-horizontal" action="LoginServlet" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">ID:</label>
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
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">���O�C��</button><br/><br/>
        <p class="forgot"><a href="input.jsp">�p�X���[�h��Y��܂������H</a></p>
      </div>
    </div>
  </form>
</div>

</body>
</html>
