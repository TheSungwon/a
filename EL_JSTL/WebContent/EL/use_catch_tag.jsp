<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title> catch tag</title>
</head>
<body>
<C:catch var="e">
name �Ķ���Ͱ� =<%=request.getParameter("name") %><br>
<%if(request.getParameter("name").equals("test")){ %>
${param.name } �� test
<%} %></C:catch>
<p>
<C:if test="${e != null }"> ����<br>
${e }</C:if>

</body>
</html>