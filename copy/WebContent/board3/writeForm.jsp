<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="./color.jsp"%>

<html>
<head>
<title> board</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script.js"></script>
</head>
<%
int num = 0, ref =1, re_step=0, re_level=0;
try{ //답변글 이라면
	if(request.getParameter("num") != null){
		num = Integer.parseInt(request.getParameter("num"));
		ref = Integer.parseInt(request.getParameter("ref"));
		re_step = Integer.parseInt(request.getParameter("re_step"));
		re_level = Integer.parseInt(request.getParameter("re_level"));
	}
%>

<body bgcolor="<%=bodyback_c %>">
<center><b>write</b>
<br>
<form method="post" name="writeform" action="./writePro.jsp" onsubmit="return writeSave()">
<input type="hidden" name="num" value="<%=num %>"> <!-- //if문 변수들을 hidden -->
<input type="hidden" name="ref" value="<%=ref %>">
<input type="hidden" name="re_step" value="<%=re_step %>">
<input type="hidden" name="re_level" value="<%=re_level %>">

<table width="400" border="1" cellspacing="0" cellpadding="0" bgcolor="<%=bodyback_c %>" align="center">
<tr>
	 <td align="right" colspan="2" bgcolor="<%=value_c %>">
	 <a href="list.jsp"> Posting</a> </td></tr>
<tr>
	 <td width="70" bgcolor="<%=value_c %>" align="center">name</td>
	 <td width="330">
	 <input type="text" size="10" maxlength="10" name="writer"></td> </tr>
<tr>
	<td width="70" bgcolor="<%=value_c %>" align="center"> title</td>
	<td width="330"> <%if(request.getParameter("num")==null){ %>
	<input type="text" size="40" maxlength="50" name="subject"></td>
	<%}else{ %>
	<input type="text" size="40" maxlength="50" name="subject" value="reply"></tr><
<%} %>
<tr>
	<td width="70" bgcolor="<%=value_c %>" align="center"> email</td>
	<td width="330">
	<input type="text" size="40" maxlength="30" name="email"></td></tr>
<tr>
	<td width="70" bgcolor="<%=value_c %>" align="center">contents</td>
	<td width="330">
	<textarea name="content" rows="13" cols="40"></textarea></td></tr>
<tr>
	<td width="70" bgcolor="<%=value_c %>" align="center">password</td>
	<td width="330">
	<input type="password" size="8" maxlength="12" name="passwd">
	</td></tr>
<tr>
	<td colspan="2" bgcolor="<%=value_c %>" align="center">
	<input type="submit" value="writing">
	<input type="submit" value="reWriting">
	<input type="button" value="List,," onclick="window.location='list.jsp'">
	</td></tr>
	
</table>
<%} catch(Exception e){ }%>
</form>
</center>
</body>
</html>