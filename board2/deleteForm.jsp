<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="./color.jsp" %>
<html>
<head>
<title> Å»Åð</title>

<link href = "style.css" rel="stylesheet"	 type="text/css	">
<script language="javascript">
function begin(){
	document.myform.passwd.focus();
}
function checkIt(){
	if(!document.myform.passwd.value){
		alert("ºñ¹øÀÔ·Â");
		document.myform.passwd.focus();
		return false;
	}
}

</script>
</head>

<body onload = "begin()" bgcolor="<%=bodyback_c%>">
<form name="myform" action="./deletePro.jsp" method="post" onsubmit="return checkIt()">
<table cellspacing=1 cellpadding=1 width="260" border=1 align="center">
<tr height="30">
<td colspan="2" align="middle" bgcolor="<%=title_c%>">
<font size="+1" ><b>È¸¿øÅ»Åð</b></font></td></tr>

<tr height="30">
<td width="110" bgcolor="<%=value_c%>" align=center> password</td>
<td width="150" align=center>
<input type="password" name="passwd" size="15" maxlength="12"></td></tr>
<tr height="30">
<td colspan="2" align="middle" bgcolor="<%=bodyback_c%>">
<input type=submit value="È¸¿øÅ»Åð">
<input type="button" value="Ãë¼Ò" onclick="javascript:window.location='./main.jsp'"></td></tr>

</table>
</form>
</body>
</html>