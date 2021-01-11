<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="color.jspf" %>



<html>
<head>
<meta charset="EUC-KR">
<title>게시판</title>
<link href="style.css"rel="stylesheet"type="text/css">
<script language ="javascript" src="script.js"></script>
</head>
<body bgcolor="${bodyc }">
<center><b>update</b>
<br>

<form method="post" name="writeform" action="/MVC_model2_signUp/mvc/updatePro.do?pageNum=${pageNum }" onsubmit="return writeSave()">
<table width="400" border="1"cellspacing="0"cellpadding="0" align="center">
<tr>
	<td width="70" bgcolor="${valuec }" align="center">name</td>
	<td align="left" width="330">
		<input type="text" size="10" maxlength="10" name="writer" value="${article.writer }">
		<input type="hidden" name="num" value="${article.num }"></td></tr>
		
<tr>
	<td width="70" bgcolor="${valuec }" align="center">title</td>
	<td align="left" width="330">
		<input type="text" size="40" maxlength="50" name="subject" value="${article.subject}"></td></tr>
		
		
<tr>
	<td width="70" bgcolor="${valuec }" align="center">email</td>
	<td align="left" width="330">
		<input type="text" size="40" maxlength="30" name="email" value="${article.email}"></td></tr>
		
<tr>
	<td width="70" bgcolor="${valuec }" align="center">content</td>
	<td align="left" width="330">
	<textarea rows="13" cols="40" name="content">${article.content }</textarea></td></tr>
	
<tr>
	<td width="70" bgcolor="${valuec }" align="center">password</td>
	<td align="left" width="330">
		<input type="password"size="8" maxlength="12"name="passwd"> </td></tr>
		
<tr>
	<td colspan="2" bgcolor="${valuec }" align="center">
	<input type="submit"value="update">
	<input type="reset"value="reset">
	<input type="button" value="list" onclick="document.location.href='/MVC_model2_signUp/mvc/list.do?pageNum=${pageNum }'"> </td></tr>
	
		
</table>
</form>

</body>
</html>