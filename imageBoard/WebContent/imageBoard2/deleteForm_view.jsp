<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@page import="DTO.Theme" %>
<%@page import="DAO.ThemeManager" %>
<%@page import="Exception.ThemeManagerException" %>

<% String themeId = request.getParameter("id");
ThemeManager manager = ThemeManager.getInstance();
Theme theme = manager.select(Integer.parseInt(themeId));%>

<c:set var="theme" value="<%=theme %>"/>
<c:if test="${!empty theme }">
<script language="javascript">
function validate(form){
	if(form.password.value==""){
		alert("password");
		return false;
	}
}
</script>

<form action="delete.jsp" method="post" onsubmit="return validate(this)">
<input type="hidden"name="id"value="${theme.id }">
<table width="100%"border="1"cellpadding="1"cellspacing="0">
<tr>
	<td>title</td>
	<td><input type="text" name="title"size="40"value="${theme.title }"></td></td>
	
<tr>
	<td>name</td>
	<td><input type="text"name="name"size="10"value="${theme.name }"></td></tr>
	
<tr>
	<td>email</td>
	<td><input type="text"name="email"size="10"value="${theme.email }"></td></tr>
<tr>
	<td>password</td>
	<td><input type="password"name="password"size="10"value=""></td></tr>
<tr>
	<td>image</td>
	<td><input type="file" name="imageFile">
	<c:if test="${!empty theme.image }">
	<br>
	<img src="/imageBoard/image/${theme.image }" width="150" border="0"></c:if></td></tr>
	
<tr>
	<td colspan="2">
	<input type="submit" value="delete">
	<input type="button"value="cancel" onclick="javascript:history.go(-1)"></td></tr>


</table>
</form>
</c:if>

<c:if test="${empty theme }">
±Û¾øÀ½M</c:if>

