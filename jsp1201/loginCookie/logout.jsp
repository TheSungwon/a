<!-- �α��� ���δ� �α��� �� ������ ��Ű�� ���翩�η� �Ǵ�. �α׾ƿ� �����
�α��� �� �� ������ ��Ű�� �����ϴ� ��ɰ� ����. ��Ű�� ������ ��Ű�� ��ȿ�ð���
0���� �����ϸ� �ȴ�. LOGIN��Ű�� ID��Ű�� �����ϸ� �α׾ƿ� -->

<%@page contentType="text/html; charset=euc-kr"%>
<%@page import="javaCookie.javaCookieBox"%>

<%
response.addCookie(
javaCookieBox.createCookies("LOGIN","","/",0));


response.addCookie(
javaCookieBox.createCookies("ID","","/",0)); /* ��ȿ�ð�0 */
%>

<html>
<head><title>logout</title></head>
logout
</html>
