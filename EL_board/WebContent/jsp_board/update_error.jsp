<%@ page contentType="text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <c:set var="exceptionType" value="${updateException.class.simpleName}" /> --%>
<%
	Exception updateException = (Exception)request.getAttribute("updateException");
    String exceptionType = updateException.getClass().getSimpleName();
    request.setAttribute("exceptionType", exceptionType);
%>

 <html>
<head><title>update 실패</title></head>
<body>
에러: 
<c:choose> 
	<c:when test="${exceptionType == 'ArticleNotFoundException'}">
	update 게시글이 존재하지 않습니다.
	</c:when>
	<c:when test="${exceptionType == 'InvalidPasswordException'}">
	password error
	</c:when>
</c:choose>
<br/>
<a href="<c:url value='list.jsp?p=${param.p}'/>">목록보기</a>
</body>
</html>
