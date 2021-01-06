<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="DTO.Theme" %>
<%@page import="DAO.ThemeManager" %>
<%@page import="Exception.ThemeManagerException" %>
<% String themeId=request.getParameter("id"); 
ThemeManager manager = ThemeManager.getInstance();
Theme theme = manager.select(Integer.parseInt(themeId));
%>
<c:set var="theme" value="<%=theme %>"/>
<c:if test="${empty theme }">
no theme </c:if>
<c:if test="${! empty theme }">
<table width="100%" border="1" cellpadding="1" cellspacing="0">
<tr>
	<td>title</td>
	<td>${theme.title }</td> </tr>

<tr>
	<td>writer</td>
	<td>${theme.name }
	<c:if test="${empty theme.email }">
	<a href="mailto:${theme.email }">email</a> </c:if></td>
</tr>

<c:if test="${! empty theme.image }">
<tr>
	<td colspan="2" align="center">
	<a href="javascript:viewLarge('/imageBoard/image/${theme.image }')">
	<img src="/imageBoard/image/${theme.image }" width="150" border="0">
	<br>크게보기
	</a></td></tr></c:if>
	
<tr>
	<td colspan="2">
	<a href="javascript:goReply()">reply</a>
	<a href="javascript:goModify()">modify</a>
	<a href="javascript:goDelete()">delete</a>
	<a href="javascript:goList()">list</a>
	</td></tr>

</table></c:if>

<script language="javascript">
function goReply(){
	document.move.action="writeForm.jsp";
	document.move.submit();
}

function goModify(){
	document.move.action="updateForm.jsp";
	document.move.submit();
}

function goList(){
	document.move.action="list.jsp";
	document.move.submit();
}
function viewLarge(imgUrl){
	
}
function goDelete() {
    document.move.action = "deleteForm.jsp";
    document.move.submit();
}

</script>

<form name="move" method="post">
	<input type="hidden" name="id" value="${theme.id }">
	<input type="hidden" name="parentId" value="${theme.id }">
	<input type="hidden" name="groupId" value="${theme.groupId }">
	<input type="hidden" name="page" value="${param.page }">
	
	<c:forEach var="searchCond" items="${paramValues.search_cond }">
		<c:if test="${searchCond == 'title' }">
		<input type="hidden" name="search_cond" value="title"> </c:if>
		
		<c:if test="${searchCond == 'name' }">
		<input type="hidden" name="search_cond" value="name"> </c:if></c:forEach>
		
		<c:if test="${! empty param.search_key }">
		<input type="hidden" name="search_key" value="${param.search_key }"> </c:if>
</form>