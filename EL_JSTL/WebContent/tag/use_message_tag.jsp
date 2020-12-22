<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fmt:setLocale value="en"/> <!-- 영어브라우저변경 Ko한글변경 -->

<fmt:bundle basename="resource.message">
<fmt:message key="TITLE" var="title"/>
<html>
<head><title> ${title }</title></head>
<body>
<fmt:message key="GREETING"/>
<br>
<c:if test="${! empty param.id }"> <!--전송된 id없으면 or ?id=... 전송하기  -->
<fmt:message key="VISITOR">
<fmt:param value="${param.id }"/>
</fmt:message>
</c:if>
</body>
</html>
</fmt:bundle>