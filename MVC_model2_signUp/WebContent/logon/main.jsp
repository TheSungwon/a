<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ include file="color.jspf" %>


<html>

<head>
<title> main</title>
<link href="style.css"	 rel="stylesheet" type="text/css">
</head>
<body bgcolor="${backc }">

<c:if test="${empty sessionScope.memId }">

<table width="500" cellpadding="0" cellspacing="0" align="center" border="1">
<tr>
	<td width="300" bgcolor="${backc}" height="20"> &nbsp; </td>
	
<form name="inform" method="post" action="/MVC_model2_signUp/logon/loginPro.do">

	<td bgcolor="${titlec }" width="100" align="right"> ID	</td>
	<td width="100" bgcolor="${valuec }">
	
	<input type="text" name="id"size="15"maxlength="10"></td>
	
<tr>	
	<td rowspan="2" bgcolor="${backc }" width="300">main</td>
	<td bgcolor="${titlec }" width="100" align="right">password</td>
	<td width="100" bgcolor="${valuec }">
		<input type="password" name="passwd" size="15" maxlength="10"></td>
</tr>		
<tr>		
	<td colspan="3" bgcolor="${titlec }" align="center">
	<input type="submit" name="Submit" value="logIN">
	<input type="button" value="signUP" onclick="document.location.href='/MVC_model2_signUp/logon/inputForm.do'"></td>
</form></tr>
	
</table>  </c:if>

<c:if test="${!empty sessionScope.memId }">
<table width="500" cellpadding="0" cellspacing="0" align="center" border="1">
<tr>
	<td width="300" bgcolor="${bodyc }" height="20"> ^_^ </td>
	
	<td rowspan="3" bgcolor="${valuec}" align="center">
	${sessionScope.memId }´Ô <br> ¹æ¹®
	
	<form method="post" action="/MVC_model2_signUp/logon/logout.do">
	<input type="submit" value="logout">
	<input type="button" value="change" onclick="document.location.href='/MVC_model2_signUp/logon/modify.do'">
	
	</form></td></tr>
	<tr>
		<td rowspan="2" bgcolor="${bodyc }" width="300" > main </td></tr>
</table> <br></c:if>

</body>
</html>