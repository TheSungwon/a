<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head><title>if tag</title>
</head>
<body>
<C:if test="true"> 무조건수행<br> </C:if>

<C:if test="${param.name ==  'bk'}">
name파라미터의 값이 ${param.name } <br>
</C:if>

<C:if test="${18<param.age }">
18세이상
</C:if>


</body>
</html>