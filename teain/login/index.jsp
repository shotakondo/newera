<%@page import="beans.User"%>
<%@ page language="java" contentType="text/html;charset=Windows-31J"
	pageEncoding="Windows-31J"%>

<!DOCTYPE �z�[���y�[�W>
<html lang="jp">
<head>
  <title>�j���[�G��</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">����ɂ��́A <%
    	User u =(User) session.getAttribute("user");
   		   if(u!=null){
    		out.print(u.getId());
    	  }
      %></a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">�z�[���y�[�W</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
      <li><a href="#">Page 2</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="register.jsp"><span class="glyphicon glyphicon-user"></span>�V�K</a></li>
      <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> ���O�C��</a></li>
      <li><a href="LogoutServlet"><span class="glyphicon glyphicon-user"></span> ���O�A�E�g</a></li>
    </ul>
  </div>
</nav>
  
<div class="container">
  <h3>���e</h3>
  
</div>

</body>
</html>

	
	
	