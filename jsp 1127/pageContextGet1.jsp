<%@ page contentType="text/html; charset=euc-kr" %>

<html>
<head>
<title> pagecontext�⺻��ü�� �޼ҵ�</title>
<body>

<%
HttpServletRequest http = (HttpServletRequest)pageContext.getRequest();%>
<!-- request �⺻��ü ���ϱ� -->

request�⺻��ü�� pageContext.getRequest()�� ���Ͽ���:

<%= request == http %>

<br>

pageContext.getOut()�޼ҵ带 ����� ���������:
<%pageContext.getOut().println("hi"); %>
</body>

</head>
</html>