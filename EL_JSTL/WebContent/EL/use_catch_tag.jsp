<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title> catch tag</title>
</head>
<body>
<C:catch var="e">
name 파라미터값 =<%=request.getParameter("name") %><br>
<%if(request.getParameter("name").equals("test")){ %>
${param.name } 은 test
<%} %></C:catch>
<p>
<C:if test="${e != null }"> 예외<br>
${e }</C:if>

</body>
</html>