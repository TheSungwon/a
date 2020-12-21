<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head><title> choose tag</title>
<body>
<ul>
<C:choose>
  <C:when test="${param.name == 'bk'}" > 
<li>이름 ${param.name }
</li></C:when>

<C:when test="${param.age >= 20 }">
<li> 20세이상</li></C:when>

<C:otherwise>
<li> 'bk' 가아니고 20세이상아니다</li></C:otherwise>
</C:choose>
</ul>
</body>
</head>
</html>