<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=euc-kr" %>

<html>
<head><title> application �⺻��ü�Ӽ�</title></head>
<body>
<%
Enumeration at = application.getAttributeNames();

while(at.hasMoreElements()){
	String a = (String)at.nextElement();
	Object b = application.getAttribute(a);
	
	out.println(a);
	out.println(b);
	
}

%>



</body>
</html>