<%@ page contentType="text/html; charset=euc-kr"%>
<html>
<head><title> 서버정보</title></head>

<body>
서버정보<%= application.getServerInfo() %><br>
서블릿규약 메이저버전<%=application.getMajorVersion() %><br>
서블릿규약 마이너버전<%=application.getMinorVersion() %><br>
</body>
</html>