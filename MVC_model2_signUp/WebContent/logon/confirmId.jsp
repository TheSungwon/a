<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="color.jspf" %>    

<html>
<head>
<meta charset="EUC-KR">
<title>�ߺ�Ȯ��</title>
<link href="style.css" rel="stylehseet" type="text/css">

</head>
<body bgcolor="${bodyc }">

<c:if test="${check ==1 }">
<table width="270" border="0" cellspacing="0" cellpadding="5">
<tr bgcolor="${titlec }">
	<td height="39">${id }������ξ��̵�</td> </tr>

</table>

<form name="checkForm" method="post" action="/MVC_model2_signUp/logon/confirmId.do">
<table width="270" border="0" cellspacing="0" cellpadding="5">
<tr>
	<td bgcolor="${valuec }" align="center">
	 �ٸ����̵�<p>
	 <input type="text" size="10" maxlength="12" name="id">
	 <input type="submit" value="�ߺ�"> </p></td></tr>
</table>
</form>
</c:if>

<c:if test="${check == -1 }">
<table width="270" border="0" cellspacing="0" cellpadding="5">
<tr bgcolor="${titlec }">
	<td align="center">
	<p> ${id } ��밡��	</p>
	<input type="button" value="close" onclick="setid()"> </td></tr>
</table> </c:if>
</body>
</html>

<script language="javascript">
function setid(){
	opener.document.userinput.id.value="${id}";
	self.close();
}
</script>