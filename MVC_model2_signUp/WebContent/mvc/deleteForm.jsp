<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="color.jspf" %>


<html>
<head>
<title>°Ô½ÃÆÇ</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="javascript">
function deleteSave(){
	if(document.delForm.passwd.value == ''){
		alert("password");
		document.delForm.passwd.focus();
		return false;
	}
}
</script>
</head>

<body bgcolor="${bodyC }">
<center><b>delete</b> <br>

<form method="post" name="delForm" action="/MVC_model2_signUp/mvc/deletePro.do?pageNum=${pageNum }" onsubmit="return deleteSave()">
<table border="1" align="center" cellspacing="0" cellpadding="0" width="360">
<tr>
	<td align="center" bgcolor="${valuec }">
		<b>password	</b></td> </tr>
		
<tr>
	<td align="center"> password :
	<input type="password" name="passwd" size="8" maxlength="12">
	<input type="hidden" name="num" value="${num }"></td></tr>
	
<tr>
	<td align="center" bgcolor="${valuec }">
	<input type="submit" value="delete">
	<input type="button" value="list" onclick="document.location.href='/MVC_model2_signUp/mvc/list.do?pageNum=${pageNum }'"> </td></tr>
	
	</table>
</form>
</body>
</html>