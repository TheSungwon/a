<%@ page contentType="text/html; charset=euc-kr"%>
<%@ page import = "java.net.URLEncoder" %>

<%
Cookie cookie = new Cookie("name",URLEncoder.encode("쿠키","euc-kr"));
response.addCookie(cookie);
%>

<html>
<head><title>쿠키생성</title></head>
<body>
<%= cookie.getName() %> 쿠키값 ="<%= cookie.getValue() %>
</body>
</html>