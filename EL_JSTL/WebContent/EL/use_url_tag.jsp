<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<C:url value="http://search.daum.net/search" var="searchUrl">
<C:param name="��" value="blog"/>
<C:param name="��" value="������"/>
</C:url>

<ul>
<li>${searchUrl }</li>
<li><C:url value="/use_if_tag.jsp"/></li>
<li><C:url value="./use_if_tag.jsp"/></li>
</ul>

</body>
</html>