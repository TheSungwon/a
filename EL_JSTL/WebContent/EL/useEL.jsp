<%@ page contentType="text/html; charset=euc-kr"%>
<% request.setAttribute("a", "Expression Laguage");
%>

<html>
<head>
<title> EL</title>
<body>
요청 URI ${pageContext.request.requestURI }<br>
request 의 name ${requestScope.a } <br>
code파라미터 ${param.code }
</body>
</head>
</html>

