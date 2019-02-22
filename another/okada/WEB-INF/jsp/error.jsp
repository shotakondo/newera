<%@ page language="java" contentType="text/html;charset=windows-31J"
	pageEncoding="windows-31J"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<html><head>  <title>エラーハンドラ</title></head><body>
大変です。500 エラーページ<p><table border=1>
<tr>
  <td><strong>エラーメッセージ</strong></td>
  <td><%= exception.getMessage() %></td>
</tr>     
<tr>
  <td><strong>例外を文字列に変換</strong></td>
  <td><%= exception.toString() %></td>
</tr>
<tr>
  <td><strong>スタックトレース</strong></td>
  <td>
<%
  exception.printStackTrace(new java.io.PrintWriter(out));  
%>
</td></tr> 
</table></body></html>