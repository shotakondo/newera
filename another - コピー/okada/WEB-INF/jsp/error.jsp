<%@ page language="java" contentType="text/html;charset=windows-31J"
	pageEncoding="windows-31J"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<html><head>  <title>�G���[�n���h��</title></head><body>
��ςł��B500 �G���[�y�[�W<p><table border=1>
<tr>
  <td><strong>�G���[���b�Z�[�W</strong></td>
  <td><%= exception.getMessage() %></td>
</tr>     
<tr>
  <td><strong>��O�𕶎���ɕϊ�</strong></td>
  <td><%= exception.toString() %></td>
</tr>
<tr>
  <td><strong>�X�^�b�N�g���[�X</strong></td>
  <td>
<%
  exception.printStackTrace(new java.io.PrintWriter(out));  
%>
</td></tr> 
</table></body></html>