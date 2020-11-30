<%@ page contentType="text/html; charset=euc-kr"%>
<html>
<head><title> sub</title></head>
<body>
parameter1에서 name 파라미터값
<%= request.getParameter("name") %>
<br/>
name파라미터 값
<ul>
<%
String[] names = request.getParameterValues("name");
	for(String name : names){
%>
	<li><%= name %> </li>
	<%} %>
</ul>
</body>
</html>