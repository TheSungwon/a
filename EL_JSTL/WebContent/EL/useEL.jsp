<%@ page contentType="text/html; charset=euc-kr"%>
<% request.setAttribute("a", "Expression Laguage");
%>

<html>
<head>
<title> EL</title>
<body>
��û URI ${pageContext.request.requestURI }<br>
request �� name ${requestScope.a } <br>
code�Ķ���� ${param.code }
</body>
</head>
</html>

