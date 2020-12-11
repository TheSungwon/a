<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ include file="./color.jsp"%>

<% int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum"); %>

<html>
<head><title> 게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="javascript">
function deleteSave(){
	if(document.delForm.passwd.value==''){
		alert("비번입력");
		document.delForm.passwd.focus();
		return false;
	}
}
</script>
</head>

<body bgcolor="<%=bodyback_c %>">
<center><b>글삭제###</b></center>
<br>
<form method="post" name="delForm" action="deletePro.jsp?pageNum=<%=pageNum %>" onsubmit="return deleteSave()">
<table border="1" align="center" cellspacing="0" cellpadding="0" width="360">
<tr height="30">
	<td align="center" bgcolor="<%=value_c %>">
	<b>비번입력</b></td></tr>
	
<tr height="30">
	<td align="center"> password:::::
	<input type="password" name="passwd" size="8" maxlength="12">
	<input type="hidden" name="num" value="<%=num %>"></td></tr> <!-- 글번호 비밀번호 페이지번호넘기기 -->
	
<tr height="30">
	<td align="center" bgcolor="<%=value_c %>">
	<input type="submit" value="글삭ㄱㄱ">
	<input type="button" value="글목록ㄱㄱ" onclick="document.location.href='list.jsp?pageNum=<%=pageNum %>'"></td></tr>
	
</table>
</form>
</body>
</html>

