<%@page contentType="text/html; charset=euc-kr" %>
<%@ page import = "javaCookie.javaCookieBox" %>

<%
response.addCookie(javaCookieBox.createCookies("name","이름"));

response.addCookie(javaCookieBox.createCookies("id","madvirus","/WebPjt/jsp1201",-1)); %> <!-- 경로주의 -->

<html>
<head><title>cookie box</title></head>
<body> cookiebox</body>
</html>