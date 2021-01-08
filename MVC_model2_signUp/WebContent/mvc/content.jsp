<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="color.jspf" %>

<html>
<head>
<meta charset="EUC-KR">
<title>게시판</title>
<link href="style.css"rel="stylesheet"type="text/css">
<style type="text/css">
@font-face {
	font-family:굴림; src:url();
}
</style>

</head>
<body bgcolor="${bodyc }">
<center><b>내용 보기</b> <br>
<form>
<table width="500"border="1" cellspacing="0" cellpadding="0" align="center">
<tr height="30">
	<td align="center"width="125" bgcolor="${valuec }">NO</td>
	<td align="center"width="125" align="center">${article.num }</td>
	<td align="center"width="125" bgcolor="${valuec }">views</td>
	<td align="center"width="125" align="center">${article.readcount }</td></tr>
	
<tr height="30">
	<td align="center"width="125" bgcolor="${valuec }">writer</td>
	<td align="center"width="125" align="center">${article.writer }</td>
	<td align="center"width="125" bgcolor="${valuec }">date</td>
	<td align="center"width="125" align="center">${article.reg_date }</td></tr>
	
<tr height="30">
	<td align="center"width="125" bgcolor="${valuec }">content</td>
	<td align="center"width="375" align="center">${article.content }</td>
	
<tr height="30">
	<td colspan="4" bgcolor="${valuec }" align="right">
	<input type="button" value="mody" 
	onclick="document.location.href='/MVC_model2_signUp/mvc/updateForm.do?num=${article.num }&pageNum=${pageNum }'">
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="delete" 
	onclick="document.location.href='/MVC_model2_signUp/mvc/deleteForm.do?num=${article.num }&pageNum=${pageNum }'">
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="reply" 
	onclick="document.location.href='/MVC_model2_signUp/mvc/writeForm.do?num=${article.num }&ref=${article.ref }&re_step=${article.re_step }&re_level=${article.re_level }'">
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="list" 
	onclick="document.location.href='/MVC_model2_signUp/mvc/list.do?pageNum=${pageNum }'">
	</td></tr>
</table>

</form>

</body>
</html>