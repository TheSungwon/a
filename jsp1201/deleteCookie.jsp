<%@ page contentType="text/html; charset=euc-kr"%>
<%
Cookie[] cookies = request.getCookies();
	if(cookies !=null && cookies.length >0){
		for(int i=0; i<cookies.length; i++){
			if(cookies[i].getName().equals("name")){
				Cookie cookie = new Cookie("name","");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
			}}} %>
			
<html>
<head><title>��Ű����</title></head>
<body>
��Ű���� <br>
��ȿ�ð���0���� ����</body>
</html>					