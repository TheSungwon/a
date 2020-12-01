<!-- 로그아웃처리할 때는 session.invalidate()메서드를 사용하여 세션을 종료.
session.removeAttribute("속성값"); 도 가능 하지만
로그인할 때 session기본객체에 추가되는 속성이 늘어나게 되면
더불어 로그아웃 코드도 함께 변경해줘야 하므로 가급적이면
session.invalidate()메소드를 이용해서 로그아웃을 구현하는것이 편리 -->

<%@ page contentType="text/html; charset=euc-kr" %>
<%
session.invalidate();
%>

<html>
<head><title> 로그아웃</title></head>
<body>
로그아웃
</body>
</html>
