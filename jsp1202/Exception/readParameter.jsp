<%@ page contentType="text/html; charset=euc-kr" %>
<%-- <%@ page errorPage = "./errorMessage.jsp"%> --%>

<html>
<head><title> parameter</title></head>
<body>
name �Ķ���� �� <%= request.getParameter("name").toUpperCase()%>
</body>
</html>

<!--
������ �߻��� ��� errorM~.jsp �������� �����ֵ��� ���� 2����

name �Ķ������ ���� �빮�ڷ� ��ȯ�Ͽ� ���. name�Ķ���Ͱ� �������� �������
���ܰ� �߻� -->