<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head><title> choose tag</title>
<body>
<ul>
<C:choose>
  <C:when test="${param.name == 'bk'}" > 
<li>�̸� ${param.name }
</li></C:when>

<C:when test="${param.age >= 20 }">
<li> 20���̻�</li></C:when>

<C:otherwise>
<li> 'bk' ���ƴϰ� 20���̻�ƴϴ�</li></C:otherwise>
</C:choose>
</ul>
</body>
</head>
</html>