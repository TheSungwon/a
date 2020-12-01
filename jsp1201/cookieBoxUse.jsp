<%@ page contentType="text/html; charset=euc-kr"%>
<%@ page import = "javaCookie.javaCookieBox" %>

<%
javaCookieBox cookieBox = new javaCookieBox(request);
%>

<html>
<head><title> cookie사용</title></head>
<body>
name = 쿠키 <%= cookieBox.getValue("name") %> <br>

<%if(cookieBox.exists("id")){	%>
id 쿠키= <%= cookieBox.getValue("id") %> <br>

<%} %>
</body>
</html>