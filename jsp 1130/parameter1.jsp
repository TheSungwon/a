<%@ page contentType="text/html; charset=euc-kr"%>
<html>
<head><title> sub</title></head>
<body>
parameter1���� name �Ķ���Ͱ�
<%= request.getParameter("name") %>
<br/>
name�Ķ���� ��
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