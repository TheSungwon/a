<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <c:set var="exceptionType" value="${replyException.class.simpleName}"/> 
톰캣6버전이면 실행안됨
--%>
<%Exception replyException = (Exception)request.getAttribute("replyException");
String exceptionType = replyException.getClass().getSimpleName();
request.setAttribute("exceptionType", exceptionType);
%>

<html>
<head><title>실패</title></head>
<body>
error
<c:choose>
<c:when test="${exceptionType == 'ArticleNotFoundException' }">
답변등록 게시글없음 </c:when>
<c:when test="${exceptionType == 'CannotReplyArticleException' }">
답변 글 등록 할수없음 </c:when>
<c:when test="${exceptionType == 'LastChildAleadyExistsException'}">
답변개수초과 </c:when>
</c:choose> <br/>
<a href="c:url value='./list.jsp?p=${param.p }'/>"> 목록보기</a>

</body>
</html>