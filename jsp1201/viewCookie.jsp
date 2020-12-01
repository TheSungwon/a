<%@page contentType="text/html; charset=euc-kr"%>
<%@ page import = "java.net.URLDecoder"%>
<html>
<head><title>쿠키목록</title></head>
<body>
쿠키목록 <br>

<%
Cookie[] cookies = request.getCookies();
if(cookies !=null && cookies.length > 0) {
	for(int i=0; i<cookies.length; i++){ %>
	<%= cookies[i].getName() %>=
	<%=URLDecoder.decode(cookies[i].getValue(), "euc-kr") %><br>
<%}
}else{
	%> 쿠키없음 <%} %>	
	

</body>
</html>