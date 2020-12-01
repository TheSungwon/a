<%@ page contentType="text/html; charset=euc-kr"%>
<%@ page import="java.net.URLEncoder" %>
<%
Cookie cookie1 = new Cookie("path1",
		URLEncoder.encode("경로:/jsp1201","euc-kr"));
cookie1.setPath("/WebPjt/jsp1201");
response.addCookie(cookie1);

Cookie cookie2 = new Cookie("path2",
		URLEncoder.encode("경로:","euc-kr"));
response.addCookie(cookie2);

Cookie cookie3 = new Cookie("path3",
		URLEncoder.encode("경로:/","euc-kr"));
cookie3.setPath("/");
response.addCookie(cookie3);

Cookie cookie4 = new Cookie("path4",
		URLEncoder.encode("경로:/jsp1201/cookiePath2","euc-kr"));
cookie4.setPath("/jsp1201/CookiePath2");
response.addCookie(cookie4);
%>
<html>
<head><title>쿠키경로</title></head>
<body> 쿠키생성

<%= cookie1.getName() %> = <%= cookie1.getValue() %>
[<%= cookie1.getPath() %>]<br>

<%= cookie2.getName() %> = <%= cookie2.getValue() %>
[<%= cookie2.getPath() %>]<br>

<%= cookie3.getName() %> = <%= cookie3.getValue() %>
[<%= cookie3.getPath() %>]<br>

<%= cookie4.getName() %> = <%= cookie4.getValue() %>
[<%= cookie4.getPath() %>]<br>

쿠키의 경로<br>
쿠키는 도메인 뿐 아니라 경로도 지정. setPath()메서드 사용<br>
경로는 URL에서 도메인 이후의 부분을 의미<br>
setPath메서드를 사용하여 쿠키의 경로를 지정하게되면 그 쿠키는<br>
지정한 경로 또는 하위경로에 대해서만 쿠키를 전송

</body>
</html>