<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <c:set var="exceptionType" value="${replyException.class.simpleName}"/> 
��Ĺ6�����̸� ����ȵ�
--%>
<%Exception deleteException = (Exception)request.getAttribute("deleteException");
String exceptionType = deleteException.getClass().getSimpleName();
request.setAttribute("exceptionType", exceptionType);
%>

<html>
<head><title>����</title></head>
<body>
error
<c:choose>
<c:when test="${exceptionType == 'ArticleNotFoundException' }">
������ �Խñ۾��� </c:when>
<c:when test="${exceptionType == 'InvalidPasswordException' }">
��ȣ����</c:when>
</c:choose> <br/>
<a href="c:url value='./list.jsp?p=${param.p }'/>"> ��Ϻ���</a>

</body>
</html>