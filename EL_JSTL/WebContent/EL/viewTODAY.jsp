<%@page contentType="text/html; charset=euc-kr"%>
<%@page session="false"%>
<%@ taglib prefix="elfunc" uri="/WEB-INF/el-function.tld"%>

<%
java.util.Date today=new java.util.Date();
request.setAttribute("today", today);
%>

<html>
<head><title>el�Լ�ȣ��</title></head>
<body>
���� <b>${elfunc:dateFormat(today) }</b>
</body>
</html>