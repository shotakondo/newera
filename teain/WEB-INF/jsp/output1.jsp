<%@page import="beans.User"%>
<%@ page pageEncoding="Windows-31J"
contentType="text/html; charset=Windows-31J" %>

<html>
<head><title>���[������܂���</title>
<style>
.kotoba{margin: 20px;padding:20px}
</style>
</head>
<body>
<div style="margin:30px;padding: 20px; border: 10px inset #8FBC8F; word-wrap: break-word;">
		<h1>
		<%
    	User u =(User) session.getAttribute("user");
   		   if(u!=null){
    		out.print(u.getEmail());
    	  }
    	  %>�փp�X���[�h�m�F���[�����M����</h1>

<button class="btn btn-success"><a href="index.jsp">�z�[���y�[�W�֖߂�</a></button></div>

</html>