<%@ page contentType="text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <c:set var="exceptionType" value="${updateException.class.simpleName}" /> --%>
<%
	Exception updateException = (Exception)request.getAttribute("updateException");
    String exceptionType = updateException.getClass().getSimpleName();
    request.setAttribute("exceptionType", exceptionType);
%>

 <html>
<head><title>update ����</title></head>
<body>
����: 
<c:choose> 
	<c:when test="${exceptionType == 'ArticleNotFoundException'}">
	update �Խñ��� �������� �ʽ��ϴ�.
	</c:when>
	<c:when test="${exceptionType == 'InvalidPasswordException'}">
	password error
	</c:when>
</c:choose>
<br/>
<a href="<c:url value='list.jsp?p=${param.p}'/>">��Ϻ���</a>
</body>
</html>
