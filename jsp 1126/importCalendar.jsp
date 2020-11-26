<%@ page contentType = "text/html; charset=euc-kr"%>
<%@ page import = "java.util.Calendar"%>

<html>
<head>
<title> 클래스사용	</title>
</head>

<body>
<%Calendar c = Calendar.getInstance(); %> <!-- 스크립트릿 어디에선언하든 상관X -->

오늘은
<%= c.get(Calendar.YEAR) %>년
<%= c.get(Calendar.MONTH) %>월
<%= c.get(Calendar.DATE) %>일
입니다.

</body>
</html>
