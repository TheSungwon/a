<%@page contentType="text/html; charset=euc-kr"%>
<%@page import = "java.util.Calendar"%>
<html>
<head><title> 시간</title></head>
<body>
<%
Calendar cal = (Calendar) request.getAttribute("time");
%>
 현재시간
 <%=cal.get(Calendar.HOUR) %>시
 <%=cal.get(Calendar.MINUTE) %>분
 <%=cal.get(Calendar.SECOND) %>초
 
</body>
</html>