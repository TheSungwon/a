<%@ page contentType="text/html; charset=euc-kr"%>

<html>
<head><title>��</title></head>
<body>
<% int sum=0;
for(int i=1; i<11; i++){
 sum += i;}%>
 
 ���� <%=sum %>
 
 <br>
<% int sum2=0;
for(int i=11; i<21; i++){
sum2 += i;}%>

����<%= sum2 %>
</body>
</html>