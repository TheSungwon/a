<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%@page import="DTO.Theme" %>
    <%@page import="DAO.ThemeManager" %>
    <%@page import ="Exception.ThemeManagerException" %>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<html>
<head>
<meta charset="EUC-KR">
<title>delete</title>
</head>
<body>

<% String themeId = request.getParameter("id");
ThemeManager manager=ThemeManager.getInstance();
Theme oldTheme = manager.select(Integer.parseInt(themeId));
%>

<c:set var="oldTheme" value="<%=oldTheme %>"/>
<c:choose>
<c:when test="${empty oldTheme }">
<script>
alert("글없음");
location.href="list.jsp";

</script>
</c:when>

<c:when test="${oldTheme.password != param.password }">
<script>
alert("암호없음");
history.go(-1);
</script> </c:when>

<c:when test="${oldTheme.password == param.password }">
<%manager.delete(oldTheme.getId()); %>
<script>
alert("글삭제");
location.href="list.jsp";

</script></c:when> </c:choose>
</body>
</html>