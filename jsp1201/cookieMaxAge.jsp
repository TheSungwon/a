<%@ page contentType="text/html; charset=euc-kr"%>

<%
Cookie cookie = new Cookie("aa","5s");
cookie.setMaxAge(5*1);
response.addCookie(cookie); %>
<html>
<head><title>유효시간</title></head>
<body>
5초인 aa 쿠키생성
</body>
</html>