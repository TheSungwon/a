<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fmt:setLocale value="en"/> <!-- ������������� Ko�ѱۺ��� -->

<fmt:bundle basename="resource.message">
<fmt:message key="TITLE" var="title"/>
<html>
<head><title> ${title }</title></head>
<body>
<fmt:message key="GREETING"/>
<br>
<c:if test="${! empty param.id }"> <!--���۵� id������ or ?id=... �����ϱ�  -->
<fmt:message key="VISITOR">
<fmt:param value="${param.id }"/>
</fmt:message>
</c:if>
</body>
</html>
</fmt:bundle>