<%@page contentType="text/html; charset=euc-kr" %>
<%@ page import = "javaCookie.javaCookieBox" %>

<%
response.addCookie(javaCookieBox.createCookies("name","�̸�"));

response.addCookie(javaCookieBox.createCookies("id","madvirus","/WebPjt/jsp1201",-1)); %> <!-- ������� -->

<html>
<head><title>cookie box</title></head>
<body> cookiebox</body>
</html>