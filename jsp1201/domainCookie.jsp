<%@page contentType="text/html; charset=euc-kr"%>
<%
Cookie cookie1 = new Cookie("id","aaa");
cookie1.setDomain(".aaa.net");

Cookie cookie2 = new Cookie("only","bbb");
response.addCookie(cookie2);

Cookie cookie3 = new Cookie("invalid","cccc");
cookie3.setDomain("cccc.com");
response.addCookie(cookie3); %>
<html>
<head><title>도메인생성</title></head>
<body>
같은 도메인을 사용하는 서버에 대해서 모두 쿠키를 보내고싶은경우

쿠키생성<br>
<%= cookie1.getName()%> = <%= cookie1.getValue() %>
[<%= cookie1.getDomain() %>]
<br>
<%= cookie2.getName()%> = <%= cookie2.getValue() %>
[<%= cookie2.getDomain() %>]
<br>
<%= cookie3.getName()%> = <%= cookie3.getValue() %>
[<%= cookie3.getDomain() %>]
<br>
</body>
</html>