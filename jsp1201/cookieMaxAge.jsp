<%@ page contentType="text/html; charset=euc-kr"%>

<%
Cookie cookie = new Cookie("aa","5s");
cookie.setMaxAge(5*1);
response.addCookie(cookie); %>
<html>
<head><title>��ȿ�ð�</title></head>
<body>
5���� aa ��Ű����
</body>
</html>