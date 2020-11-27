<%@ page contetnType="text/hrml; charset=euc-kr"%>
<%! public int add(int a, int b){
int c = a+b;
return c; }
	
	public int subtract(int a, int b){
	int c = a-b;
	return c; } %>
	
<html><head>
<title>선언부를 스크립트릿에서 사용</title></head>
<body>
<%
	int value1= 3;
	int value2= 9;
	
	int addResult = add(value1,value2);
	int subtractResult = subtract(value1,value2);%>
	
	<%= value1 %> + <%=value2 %> =<%=addResult %>
	<%= value1 %> = <%=value2 %> =<%=subtractResult %>
</body>
</html>