<%@ page contentType="text/html; charset=euc-kr" %>
<html>

<head><title> info</title></head>
<body>
<table width="100%" border="1" cellpadding="0" cellspacing="0">
<tr>
	<td>제품번호</td>
	<td>xx</td>
</tr>

<tr>
	<td>가격</td>
	<td>1000원</td>
</tr>
</table>

<jsp:include page="jspParam1.jsp" flush="false">
	<jsp:param name="type" value="A"/>
</jsp:include>

</body>
</html>