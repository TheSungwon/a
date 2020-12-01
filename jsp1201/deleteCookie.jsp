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
<head><title>쿠키삭제</title></head>
<body>
쿠키삭제 <br>
유효시간을0으로 지정</body>
</html>					