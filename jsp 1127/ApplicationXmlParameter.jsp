<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=euc-kr"%>

<html>
<head><title>초기화파라미터 읽기</title></head>
<body>
초기화 파라미터 목록-
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