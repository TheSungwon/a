<%@ page contentType="text/html; charset=euc-kr"%>
<html>
<head><title>1-10 ��</title></head>
<body>
<%
int sum=0;
for(int i=1; i<=10; i++){
	sum += i;
}
%>

���� <%=sum %>
</body>
</html>