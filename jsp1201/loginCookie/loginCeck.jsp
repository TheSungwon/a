<%@page contentType="text/html; charset=euc-kr"%>
<%@ page import ="javaCookie.javaCookieBox" %>

<% javaCookieBox cookieBox = new javaCookieBox(request);
boolean login = cookieBox.exists("LOGIN") &&
	cookieBox.getValue("LOGIN").equals("SUCCESS"); %>
	
<html>
<head><title>login check</title></head>
<body>
<% 
if(login){ out.println("���̵�" +"\\\""+cookieBox.getValue("ID")+"\\\""+ "�� �α����� ����");
	}else { out.println("�α���������������"); } %>
</body>
</html>
	
	<!-- LOGIN��Ű�� �����ϰ� LOGIN��Ű���� SUCCESS�� ��쿡 �α��� �ߴٰ� �Ǵ� -->