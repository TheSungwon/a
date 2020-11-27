<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=euc-kr" %>

<html>

<head><title> 헤더목록</title></head>
<body>
<%
Enumeration header = request.getHeaderNames();
while(header.hasMoreElements()){
	String headerName = (String)header.nextElement();
	String headerValue = request.getHeader(headerName); %>
	
	<%= headerName %> = <%=headerValue %> <br>
<%} %>

</body>
</html>