<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <c:set var="exceptionType" value="${replyException.class.simpleName}"/> 
��Ĺ6�����̸� ����ȵ�
--%>
<%Exception replyException = (Exception)request.getAttribute("replyException");
String exceptionType = replyException.getClass().getSimpleName();
request.setAttribute("exceptionType", exceptionType);
%>

<html>
<head><title>����</title></head>
<body>
error
<c:choose>
<c:when test="${exceptionType == 'ArticleNotFoundException' }">
�亯��� �Խñ۾��� </c:when>
<c:when test="${exceptionType == 'CannotReplyArticleException' }">
�亯 �� ��� �Ҽ����� </c:when>
<c:when test="${exceptionType == 'LastChildAleadyExistsException'}">
�亯�����ʰ� </c:when>
</c:choose> <br/>
<a href="c:url value='./list.jsp?p=${param.p }'/>"> ��Ϻ���</a>

</body>
</html>