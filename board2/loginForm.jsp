<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file = "./color.jsp"%>

<html>

<head>
<title> login</title>
<link href="style.css" rel="stylesheet" type="text/css">
<!-- getCookies? -->
<% Cookie[] co = request.getCookies();
String ii = "";
if(co != null){
	for( Cookie coo : co){
		if(coo.getName().equals("cb"))
			ii= coo.getValue();
	}
}
			
%>
<script language = "javascript">
function begin(){
	document.myform.id.focus();
}
function checkIt(){
	if(!document.myform.id.value){
		alert("아이디입력1");
		document.myform.id.focus();
		return false;
	}
	if(!document.myform.passwd.value){
		alert("비번입력");
		document.myform.passwd.foucs();
		return false;
	}
}
</script>
</head>
<body onload = "begin()" bgcolor="<%=bodyback_c%>">
<form name="myform" action="./loginPro.jsp" method="post" onsubmit="return checkIt()">
<table cellsapcing=1 cellpadding=1 width="260" border=1 align="center">

<tr height="30">
<td colspan="2" align="middle" bgcolor="<%=title_c%>"> <strong>member login</strong></td></tr>

<tr height ="30">
<td width="110" bgcolor="<%=title_c%>" align=center> ID </td>
<td width="150" bgcolor="<%=value_c%>" align=center>
<input type="text" name="id" size="15" maxlength="12"></td></tr>

<tr height ="30">
<td width="110" bgcolor="<%=title_c%>" align=center> password </td>
<td width="150" bgcolor="<%=value_c%>" align=center>
<input type="text" name="passwd" size="15" maxlength="12"></td></tr>

<!--  -->
<tr height ="30">
<td width="110" bgcolor="<%=title_c%>" align=center> 아이디저장 </td>
<td width="150" bgcolor="<%=value_c%>" align=center>
<input type="checkbox" name="cb"  <%=ii!=""?"checked":"" %>></td></tr>


<tr height="30">
<td colspan="2" align="middle" bgcolor="<%=title_c %>">
<input type="submit" value="login">
<input type="reset" value="reset">
<input type="button" value="회원가입" onclick="javascript:window.location='inputForm.jsp'"></td></tr>
</table>
</form>
</body>
</html>