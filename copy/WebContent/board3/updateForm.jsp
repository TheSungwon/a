<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import = "board.*"%>
<%@ include file="./color.jsp"%>
<html>
<head>
<title>BOARD</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script.js"></script>
</head>
<%
int num = Integer.parseInt(request.getParameter("num")); //�Ѿ�� ������ �ޱ�
String pageNum = request.getParameter("pageNum");
try{
	BoardDBBean dbPro = BoardDBBean.getInstance();
	BoardDataBean article = dbPro.updateGetArticle(num); //�ڹٺ�ü �� �� ������
%>

<body bgcolor="<%=bodyback_c %>">
<center>
<b>�������ۼ���������</b></center>
<br>
<form method="post" name="writeform" action="updatePro.jsp?pageNum=<%=pageNum %>" onsubmit="return writeSave()">
<table width="400" border="1" cellscpacing="0" cellpadding="0" bgcolor="<%=bodyback_c %>" align="center">

<tr>
	<td width="70" bgcolor="<%=value_c %>" align="center"> name@@</td>
	<td align="left" width="330">
	<input type="text" size="10" maxlength="10" name="writer" value="<%=article.getWriter() %>">
	<input type="hidden" name="num" value="<%=article.getNum() %>"> </td></tr> <!-- �۹�ȣ���ܼ������� -->
	
<tr>
	<td width="70" bgcolor="<%=value_c %>" align="center"> title@@</td>
	<td align="left" width="330">
	<input type="text" size="40" maxlength="50" name="subject" value="<%=article.getSubject() %>"></td></tr>
	
<tr>
<!--���� �� �̸��� null���Ⱥ��̰�  -->
	<td width="70" bgcolor="<%=value_c %>" align="center">email@@ </td>
	<td align="left" width="330">
    <%if(article.getEmail()==null){%>
<input type="text" size="40" maxlength="30" name="email">
<%}else{%>
<input type="text" size="40" maxlength="30" name="email" value="<%=article.getEmail() %>"></td></tr>
<%}%>
<!--  -->
	
<tr>
	<td width="70" bgcolor="<%=value_c %>" align="center">contents@@</td>
	<td align="left" width="330">
	<textarea name="content" rows="13" cols="40" ><%=article.getContent() %></textarea></td></tr>
	
<tr>
	<td width="70" bgcolor="<%=value_c %>" align="center">password@@</td>
	<td align="left" width="330">
	<input type="password" size="8" maxlength="12" name="passwd"> </td></tr> <!-- ����Է� -->
	
	<tr>
	<td colspan="2" bgcolor="<%=value_c %>" align="center">
	<input type="submit" value="����">
	<input type="reset" value="�ٽ�">
	<input type="button" value="���"onclick="document.location.href='list.jsp?pageNum=<%=pageNum%>'">
	</td></tr>
	
	

</table>
</center>
</form>
<%}catch(Exception e){} %>
</body>

</html>