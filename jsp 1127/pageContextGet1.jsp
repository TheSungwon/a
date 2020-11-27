<%@ page contentType="text/html; charset=euc-kr" %>

<html>
<head>
<title> pagecontext기본객체의 메소드</title>
<body>

<%
HttpServletRequest http = (HttpServletRequest)pageContext.getRequest();%>
<!-- request 기본객체 구하기 -->

request기본객체와 pageContext.getRequest()의 동일여부:

<%= request == http %>

<br>

pageContext.getOut()메소드를 사용한 데이터출력:
<%pageContext.getOut().println("hi"); %>
</body>

</head>
</html>