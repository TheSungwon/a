<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file = "./color.jsp"%>

<html>

<head>
<title> login</title>
<link href="style.css" rel="stylesheet" type="text/css">
<!--  -->
<% String cookie="";
	Cookie[] cookies = request.getCookies(); //��Ű����
	if(cookies !=null && cookies.length >0)
		for(int i=0; i<cookies.length; i++){
			if(cookies[i].getName().equals("userId"))
				cookie=cookies[i].getValue();
		}
			
%>
<script language = "javascript">
function begin(){
	document.myform.id.focus();
}
function checkIt(){
	if(!document.myform.id.value){
		alert("���̵��Է�1");
		document.myform.id.focus();
		return false;
	}
	if(!document.myform.passwd.value){
		alert("����Է�");
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
<td width="110" bgcolor="<%=title_c%>" align=center> ���̵����� </td>
<td width="150" bgcolor="<%=value_c%>" align=center>
<input type="checkbox" name="checkbox" ></td></tr>


<tr height="30">
<td colspan="2" align="middle" bgcolor="<%=title_c %>">
<input type="submit" value="login">
<input type="reset" value="reset">
<input type="button" value="ȸ������" onclick="javascript:window.location='inputForm.jsp'"></td></tr>
</table>
</form>
</body>
</html>