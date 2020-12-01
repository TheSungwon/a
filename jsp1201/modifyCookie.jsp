<%@ page contentType="text/html; charset=euc-kr"%>
<%@ page import = "java.net.URLEncoder"%>
<%
Cookie[] cookies = request.getCookies();
	if(cookies != null && cookies.length > 0){
		for(int i=0; i<cookies.length; i++){
			if(cookies[i].getName().equals("name")){
				Cookie cookie = new Cookie("name", URLEncoder.encode("쿠키이름변경","euc-kr"));
				response.addCookie(cookie);
			}
		}
	}
%>
<html>
<head><title>값변경</title></head>
<body>
name쿠키값 변경</body>
</html>