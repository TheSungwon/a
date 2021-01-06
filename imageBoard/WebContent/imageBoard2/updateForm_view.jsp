<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="DTO.Theme" %>
<%@page import="DAO.ThemeManager" %>
<%@page import ="Exception.ThemeManagerException" %>
<%
String themeId=request.getParameter("id");
ThemeManager manager= ThemeManager.getInstance();
Theme theme = manager.select(Integer.parseInt(themeId));
%>

<c:set var="theme" value="<%=theme %>"/>
<c:if test="${!empty theme }">
<script language="javascript">
function validate(form){
	if(form.title.value == ""){
		alert("title");
		return false;
	}else if(form.name.value ==""){
		alert("name");
		return false;
	}else if(form.password.value==""){
		alert("password");
		return false;
	}else if(form.content.value ==""){
		alert("content");
		return false;
	}
}
</script>

<form action="update.jsp" method="post" enctype="multipart/form-data" onsubmit="return validate(this)">

<input type="hidden" name="id" value="${theme.id }">
<table width="100"%	 border="1" cellpadding="1" cellspacing="0">
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
	<td>content</td>
	<td><textarea rows="8" cols="40" name="content">${theme.content }</textarea></td>
	
<tr>
	<td colspan="2">
	<input type="submit" value="수정">
	<input type="button"value="cancel" onclick="javascript:history.go(-1)"></td></tr>
	
</table>

<input type="hidden" name="page"value="${param.page }">
<c:forEach var="searchCond" items="${paramValues.search_cond }">
	<c:if test="${searchCond == 'title' }">
	<input type="hidden" name="search_cond" value="title">
	</c:if>
	
	<c:if test="${searchCond == 'name' }">
	<input type="hidden" name="search_cond" value="name"> </c:if></c:forEach>
	
<c:if test="${!empty param.search_key }">
<input type="hidden" name="search_key" value="${param.search_key }"> </c:if>
</form></c:if>
<c:if test="${empty theme }"> 글 없음</c:if>
