<%@ page contentType = "text/html; charset=euc-kr" %>
<%
	String memberId = (String)session.getAttribute("id");
	String name = (String)session.getAttribute("name");
%>
<html>
<head><title>���ǿ��� ���� ��������</title></head>
<body>

���ǿ��� ������ ������<br>
memberId�� <%=memberId %><br>
name�� <%=name %>�Դϴ�.

</body>
</html>
