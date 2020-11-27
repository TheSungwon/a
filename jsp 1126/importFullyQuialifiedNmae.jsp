<%@ page contentType = "text/html; charset=euc-kr" %>
<html>
<head><title>클래스사용</title></head>

<body>
<%java.util.Calendar c = java.util.Calendar.getInstance(); %>
오늘은
<%= c.get(java.util.Calendar.YEAR) %>년
<%= c.get(java.util.Calendar.MONTH) %>월
<%= c.get(java.util.Calendar.DATE) %>일
<!-- import안하면 완전한 클래스 이름을 입력 -->
</body>
</html>