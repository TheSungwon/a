<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import = "javaCookie.javaCookieBox" %>

<%
String id = request.getParameter("id");
String password = request.getParameter("password");

if(id.equals(password)){ /* id�� password�� ������ �α��ο� ���� */
	response.addCookie(
			javaCookieBox.createCookies("LOGIN","SUCCESS","/",-1) );
/* �̸��� LOGIN�̰� ���� SUCCESS�� ��Ű�� ����. �α��� �������� ���θ� �Ǵ��Ҷ���� */
	response.addCookie(
			javaCookieBox.createCookies("ID",id,"/",-1));
/* �̸��� ID�̰� �Է��� ���̵� ������ ���� ��Ű�� ����. �α���� ������� ���̵� �����Ҷ� ��� */
%>

<html>
<head><title>�α��μ���</title></head>
<body>
����
</body>
</html>

<%
} else{ /* �α��ν��� */
%>
<script>
alert("����")
history.go(-1);
</script>
<%} %>




