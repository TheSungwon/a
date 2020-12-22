<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fmt:setBundle basename="resource.message" var="message"/>
<!-- use message tag와 다른 점. 프로퍼티가 많을때 셋번들. 변수에 프로퍼티저장 -->

<fmt:message bundle="${message}" key="TITLE" var="title"/>
<html>
<head><title>${title }</title></head>
<body>

<fmt:message bundle="${message }" key="GREETING"/>
<br>
<c:if test="${! empty param.id }">
<fmt:message bundle="${message }" key="VISITOR">
<fmt:param value="${param.id }"/>
</fmt:message>
</c:if>
</body>
</html>