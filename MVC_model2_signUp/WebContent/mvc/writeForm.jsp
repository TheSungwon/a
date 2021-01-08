<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="color.jspf" %>



<html>
<head>
<meta charset="EUC-KR">
<title>게시판</title>
<link href="style.css" rel="stylesheet"type="text/css">
<script language="javascript" src="script.js"></script>
</head>
<body bgcolor="${bodyc }">

<br>
<form method="post" name="writeForm" action="/MVC_model2_signUp/mvc/writePro.do" onsubmit="return writeSave()">

<input type="hidden"name="num"value="${num }">
<input type="hidden"name="ref"value="${ref }">
<input type="hidden"name="re_step"value="${re_step }">
<input type="hidden"name="re_level"value="${re_level }">

<table width="400"border="1"cellspacing="0"cellpadding="0" align="center">
<tr>
	<td align="right"colspan="2"bgcolor="${valuec }">
	<a href="/MVC_model2_signUp/mvc/list.do">LIST</a></td></tr>
	
<tr>
	<td width="70" bgcolor="${valuec }"align="center">name</td>
	<td width="330">
		<input type="text" size="10"maxlength="10"name="writer"></td></tr>
		
<tr>
	<td width="70"bgcolor="${valuec }"align="center">title</td>
	<td width="330">
	
<c:if test="${num == 0}">
       <input type="text" size="40" maxlength="50" name="subject"></td>
</c:if>
<c:if test="${num != 0}">
   <input type="text" size="40" maxlength="50" name="subject" value="[답변]"></td>
</c:if>
  </tr>


<tr>
	<td width="70"bgcolor="${valuec }"align="center">email</td>
	<td width="330">
	<input type="text"size="40"maxlength="30"name="email"></td></tr>
	
<tr>
	<td width="70"bgcolor="${valuec }"align="center">content</td>
	<td width="330">
	<textarea rows="13" cols="40" name="content"></textarea></td></tr>
	
<tr>
	<td width="70"bgcolor="${valuec }"align="center">password</td>
	<td width="330">
	<input type="password" size="8"maxlength="12" name="passwd"></td></tr>
	
<tr>
	<td colspan="2"bgcolor="${valuec }"align="center">
	<input type="submit" value="wirte">
	<input type="reset"value="reset">
	<input type="button" value="list" onclick="window.location='/MVC_model2_signUp/mvc/list.do'">
	</td></tr>
	
	
</table></form>

</body>
</html>