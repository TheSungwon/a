<!-- 로그인 여부는 로그인 시 생서된 쿠키의 존재여부로 판단. 로그아웃 기능은
로그인 할 때 생성한 쿠키를 삭제하는 기능과 동일. 쿠키의 삭제는 쿠키의 유효시간을
0으로 지정하면 된다. LOGIN쿠키와 ID쿠키를 삭제하면 로그아웃 -->

<%@page contentType="text/html; charset=euc-kr"%>
<%@page import="javaCookie.javaCookieBox"%>

<%
response.addCookie(
javaCookieBox.createCookies("LOGIN","","/",0));


response.addCookie(
javaCookieBox.createCookies("ID","","/",0)); /* 유효시간0 */
%>

<html>
<head><title>logout</title></head>
logout
</html>
