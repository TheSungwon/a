<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=euc-kr"%>

<html>
<head><title>�ʱ�ȭ�Ķ���� �б�</title></head>
<body>
�ʱ�ȭ �Ķ���� ���-
<ul>
<%
Enumeration init = application.getInitParameterNames();
while (init.hasMoreElements()){
	String initName = (String)init.nextElement();
	out.println(initName);
	out.println(application.getInitParameter(initName));
}
%>

</ul>

</body>
</html>