<%@ page contentType="text/html; charset=euc-kr"%>
<%@ page import="java.net.URLEncoder" %>
<%
Cookie cookie1 = new Cookie("path1",
		URLEncoder.encode("���:/jsp1201","euc-kr"));
cookie1.setPath("/WebPjt/jsp1201");
response.addCookie(cookie1);

Cookie cookie2 = new Cookie("path2",
		URLEncoder.encode("���:","euc-kr"));
response.addCookie(cookie2);

Cookie cookie3 = new Cookie("path3",
		URLEncoder.encode("���:/","euc-kr"));
cookie3.setPath("/");
response.addCookie(cookie3);

Cookie cookie4 = new Cookie("path4",
		URLEncoder.encode("���:/jsp1201/cookiePath2","euc-kr"));
cookie4.setPath("/jsp1201/CookiePath2");
response.addCookie(cookie4);
%>
<html>
<head><title>��Ű���</title></head>
<body> ��Ű����

<%= cookie1.getName() %> = <%= cookie1.getValue() %>
[<%= cookie1.getPath() %>]<br>

<%= cookie2.getName() %> = <%= cookie2.getValue() %>
[<%= cookie2.getPath() %>]<br>

<%= cookie3.getName() %> = <%= cookie3.getValue() %>
[<%= cookie3.getPath() %>]<br>

<%= cookie4.getName() %> = <%= cookie4.getValue() %>
[<%= cookie4.getPath() %>]<br>

��Ű�� ���<br>
��Ű�� ������ �� �ƴ϶� ��ε� ����. setPath()�޼��� ���<br>
��δ� URL���� ������ ������ �κ��� �ǹ�<br>
setPath�޼��带 ����Ͽ� ��Ű�� ��θ� �����ϰԵǸ� �� ��Ű��<br>
������ ��� �Ǵ� ������ο� ���ؼ��� ��Ű�� ����

</body>
</html>