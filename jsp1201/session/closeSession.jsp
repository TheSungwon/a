<%@page contentType="text/html; charset=euc-kr"%>
<%
session.invalidate();
%>

<html>
<head><title> close session</title></head>
<body>
close</body>
</html>

<!-- 세션이 종료되면 기존에 사용하던 세션기본객체가 삭제되고, 다음에 세션을 사용할 때는
새로운 세션기본객체가 사용된다. -->