<%@ page contentType="text/html; charset=euc-kr"%>
<%
request.setCharacterEncoding("euc-kr");
%>

<html>
<head><title>jsp parameter</title></head>
<body>
include �� name �Ķ���Ͱ�
<%= request.getParameter("name") %>
<hr>

<jsp:include page="parameter1.jsp" flush="false">
	<jsp:param name="name" value="�ֹ���"/>
</jsp:include>

<hr/>

include�� name �Ķ���Ͱ�
<%= request.getParameter("name") %>
</body>
</html>