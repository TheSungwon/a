<%@page contentType="text/html; charset=euc-kr"%>
<%@ page import ="javaCookie.javaCookieBox" %>

<% javaCookieBox cookieBox = new javaCookieBox(request);
boolean login = cookieBox.exists("LOGIN") &&
	cookieBox.getValue("LOGIN").equals("SUCCESS"); %>
	
<html>
<head><title>login check</title></head>
<body>
<% 
if(login){ out.println("아이디" +"\\\""+cookieBox.getValue("ID")+"\\\""+ "로 로그인한 상태");
	}else { out.println("로그인하지않은상태"); } %>
</body>
</html>
	
	<!-- LOGIN쿠키가 존재하고 LOGIN쿠키값이 SUCCESS인 경우에 로그인 했다고 판단 -->