<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head><title>if tag</title>
</head>
<body>
<C:if test="true"> �����Ǽ���<br> </C:if>

<C:if test="${param.name ==  'bk'}">
name�Ķ������ ���� ${param.name } <br>
</C:if>

<C:if test="${18<param.age }">
18���̻�
</C:if>


</body>
</html>