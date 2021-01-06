<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="DTO.Theme" %>
<%@page import="DAO.ThemeManager" %>
<%@page import="Exception.ThemeManagerException" %>

<% String parentId = request.getParameter("parentId"); 
String title="";
Theme theme = null;
if(parentId != null){
	ThemeManager manager = ThemeManager.getInstance();
	theme = manager.select(Integer.parseInt(parentId));
	if(theme != null){
		title = "re:"+theme.getTitle();
	}
	
}
	%>
	
<c:set var="theme" value="<%=theme %>"/>
<script language="javascript">
function validate(form){
	if(form.title.value == ""){
		alert("title");
		return false;
	}else if(form.name.value==""){
		alert("name");
		return false;
	}else if(form["parentId"] == null && form.imageFile.value ==""){
		alert("image");
		return false;
	}else if(form.content.value==""){
		alert("content");
		return false;
	}
}
</script>	

<form action="write.jsp" method="post" enctype="multipart/form-data" onsubmit="return validate(this)">
<input type="hidden" name="levels" value="${theme.levels +1 }" >
<c:if test="${! empty param.groupId }">
<input type="hidden" name="groupId" value="${param.groupId }"> </c:if>

<c:if test="${! empty param.parentId }">
<input type="hidden" name="parentId" value="${param.parentId }">
</c:if>

<table width="100%" border="1" cellpadding="1" cellspacing="0">
<tr>
	<td> title</td>
	<td> <input type="text" name="title" size="40" value="<%=title %>" ></td></tr>
	
<tr>
	<td>name</td>
	<td><input type="text" name="name" size="10" value=""></td></tr>
	
<tr>
	<td>email</td>
	<td><input type="text" name="email" size="10" value="" ></td></tr>
	
<tr>
	<td>password</td>
	<td><input type="password" name="password" size="10" value="" ></td>
	</tr>
<tr>
	<td>image</td>
	<td><input type="file" name="imageFile"></td></tr>
	
<tr>
	<td>content</td>
	<td><textarea rows="9" cols="4-" name="content"></textarea></td></tr>

<tr>
	<td colspan="2" ><input type="submit" value="µî·Ï" ></td></tr>
</table>

</form>