<%@ page contentType="text/html; charset=euc-kr"%>
<%
request.setCharacterEncoding("euc-kr");
%>

<html>
<head><title>jsp parameter</title></head>
<body>
include 전 name 파라미터값
<%= request.getParameter("name") %>
<hr>

<jsp:include page="parameter1.jsp" flush="false">
	<jsp:param name="name" value="최범균"/>
</jsp:include>

<hr/>

include후 name 파라미터값
<%= request.getParameter("name") %>
</body>
</html>